/*
 * Principalmente, o desempenho é a questão chave durante o desenvolvimento de software e a criação de objetos, 
 * o que pode ser uma etapa dispendiosa.
 * O Object Pool Pattern diz que "reutilizar objetos cuja criação é cara".
 * Basicamente, um pool de objetos é um contêiner que contém uma quantidade especificada de objetos. 
 * Quando um objeto é retirado do conjunto, ele não fica disponível no conjunto até que seja colocado de volta. 
 * Os objetos no pool têm um ciclo de vida: criação, validação e destruição.
 * Um pool ajuda a gerenciar melhor os recursos disponíveis. Existem muitos exemplos de uso: 
 * especialmente em servidores de aplicativos, existem pools de fontes de dados, pools de threads, etc.
 * 
 * 
 * Vantagem do padrão de design Object Pool:
 * Aumenta significativamente o desempenho do aplicativo.
 * É mais eficaz em uma situação em que a taxa de inicialização de uma instância de classe é alta.
 * Ele gerencia as conexões e fornece uma maneira de reutilizá-las e compartilhá-las.
 * Também pode fornecer o limite para o número máximo de objetos que podem ser criados.
 * 
 * 
 * Uso:
 * Quando um aplicativo requer objetos cuja criação é cara. Ex: há necessidade de abrir muitas conexões para o banco de dados, então demora muito mais para criar uma nova e o servidor de banco de dados ficará sobrecarregado.
 * Quando existem vários clientes que necessitam do mesmo recurso em momentos diferentes.
 * 
 * 
 * NOTA: 
 * O padrão de design do pool de objetos é essencialmente usado no Web Container do servidor para criar pools de threads e pools de fontes de dados para processar as solicitações.
 */



import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;



//classe ObjectPool usada para criar o número de objetos.
public abstract class ObjectPool_ExecutorService<T> {  
    /* 
    a implementação do pool é baseada em ConcurrentLinkedQueue do pacote java.util.concurrent. 
    ConcurrentLinkedQueue é uma fila thread-safe baseada em nós vinculados.  
    Porque a fila segue a técnica FIFO (primeiro a entrar, primeiro a sair). 
    */             
    private ConcurrentLinkedQueue<T> pool;  
             
    /*  
    ScheduledExecutorService inicia uma tarefa especial em um thread separado e observa 
    o número mínimo e máximo de objetos no pool periodicamente em um determinado time (com parâmetro validaçãoInterval).  
    Quando o número de objetos for menor que o mínimo, serão criadas instâncias ausentes.  
    Quando o número de objetos for maior que o máximo, muitas instâncias serão removidas.  
    Às vezes, isso é útil para equilibrar os objetos que consomem memória no pool. 
    */   
    private ScheduledExecutorService executorService;  
    
    
    /* 
     * Creates the pool. 
     * 
     * @param minObjects: o número mínimo de objetos residentes no pool 
     */         
    public ObjectPool_ExecutorService(final int minObjects){  
        // initialize pool        
        initialize(minObjects);          
    }  
          
    /* 
      Cria o pool. 
      @param minObjects: número mínimo de objetos residentes no pool. 
      @param maxObjects: número máximo de objetos residentes no pool. 
      @param validaçãoInterval: tempo em segundos para verificação periódica de Condições minObjects / maxObjects em um thread separado. 
      Quando o número de objetos for menor que minObjects, serão criadas instâncias ausentes. 
      Quando o número de objetos for maior que maxObjects, muitas instâncias serão removidas. 
    */   
    public ObjectPool_ExecutorService(final int minObjects, final int maxObjects, final long validationInterval) {  
        // initialize pool  
        initialize(minObjects);  

        // verifica as condições do pool em um thread separado  
        executorService = Executors.newSingleThreadScheduledExecutor();  
        executorService.scheduleWithFixedDelay(new Runnable(){ // annonymous class  
            @Override  
            public void run() {  
                int size = pool.size();  
                     
                if (size < minObjects) {  
                    int sizeToBeAdded = minObjects + size;  
                    for (int i = 0; i < sizeToBeAdded; i++) {  
                        pool.add(createObject());  
                    }  
                } else if (size > maxObjects) {  
                    int sizeToBeRemoved = size - maxObjects;  
                    for (int i = 0; i < sizeToBeRemoved; i++) {  
                        pool.poll();  
                    }  
                }  
            }  
        }, validationInterval, validationInterval, TimeUnit.SECONDS);  
    }  
          
    /* 
      Obtém o próximo objeto livre do pool. Se o pool não contiver nenhum objeto, 
      um novo objeto será criado e devolvido ao chamador deste método. 
      
      @return T objeto emprestado 
    */    
    public T emprestarObject() {  
        T object;  
        if ((object = pool.poll()) == null){  
            object = createObject();
        }  
        return object;  
    }  
    
    /* 
      Retorna o objeto de volta ao pool. 
      @param object objeto a ser retornado 
    */  
    public void returnObject(T object) {  
        if (object == null) {  
            return;  
        }  
        this.pool.offer(object);  
    }  
    
    /* 
        Desligue este pool. 
    */  
    public void shutdown(){  
        if (executorService != null){  
            executorService.shutdown();  
        }  
    }  
    
    /* 
      Cria um novo objeto. 
      @return T novo objeto 
    */ 
    protected abstract T createObject();  
      
    private void initialize(final int minObjects)  {  
        pool = new ConcurrentLinkedQueue<T>();  
        for (int i = 0; i < minObjects; i++) {  
            pool.add(createObject());  
        }  
    }  
}


//classe ExportingProcess que será usada pela classe ExportingTask.
class ExportingProcess {  
    private long processNumber;  
     
    public ExportingProcess(long processNumber)  {  
        this.processNumber = processNumber;  
        // do some  expensive calls / tasks here in future  
        // .........  
        System.out.println("Object with process no. " + processNumber + " was created");  
    }  
      
    public long getProcessNumber() {  
        return processNumber;
    }  
}


//classe ExportingTask que usará as classes ExportingProcess e ObjectPool.
class ExportingTask implements Runnable {  
    private ObjectPool_ExecutorService<ExportingProcess> pool;  
    private int threadNumber;  
    
    public ExportingTask(ObjectPool_ExecutorService<ExportingProcess> pool, int threadNumber){  
        this.pool = pool;  
        this.threadNumber = threadNumber;  
    }  
  
    public void run() {  
        // pega um objeto do pool  
        ExportingProcess exportingProcess = pool.emprestarObject();  
        System.out.println("Thread " + threadNumber + ": Object with process number. " + exportingProcess.getProcessNumber() + " foi emprestado");  

        //você pode fazer algo aqui no futuro  
        // .........  
  
        // retorna a instância ExportingProcess de volta ao pool  
        pool.returnObject(exportingProcess);  

        System.out.println("Thread " + threadNumber +": Object with process number. " + exportingProcess.getProcessNumber() + " foi devolvido");  
    }  
}



class ObjectPoolDemo{  
    private ObjectPool_ExecutorService<ExportingProcess> pool;  
    private AtomicLong processNumber = new AtomicLong(0);

    public void setUp() {  
        // Cria um pool de objetos do tipo ExportingProcess.  
        
        /*Parâmetros: 
            1) Número mínimo de instâncias especiais de ExportingProcess residentes no pool = 4 
            2) Número máximo de instâncias especiais de ExportingProcess residentes no pool = 10 
            3) Tempo em segundos para verificação periódica das condições minObjects/maxObjects em um thread separado = 5. 
            
            -> Quando o número de instâncias de ExportingProcess é menor que minObjects, instâncias ausentes serão criadas. 
            -> Quando o número de instâncias de ExportingProcess é maior que maxObjects, muitas instâncias serão removidas. 
            
            -->Se o intervalo de validação for negativo, nenhuma verificação periódica das condições de minObjects e maxObjects ocorrem em um thread separado. Esses limites são então ignorados. 
        */    
        pool = new ObjectPool_ExecutorService<ExportingProcess>(4, 10, 5) {  
            protected ExportingProcess createObject()  
            {  
                // cria um objeto de teste que leva algum tempo para ser criado  
                return new ExportingProcess(processNumber.incrementAndGet());  
            }  
        };  
    }

    public void tearDown() {  
        pool.shutdown();  
    }

    public void testObjectPool() {  
        ExecutorService executor = Executors.newFixedThreadPool(8);  

        //executa 8 tarefas em threads separadas
            
        executor.execute(new ExportingTask(pool, 1));  
        executor.execute(new ExportingTask(pool, 2));  
        executor.execute(new ExportingTask(pool, 3));  
        executor.execute(new ExportingTask(pool, 4));  
        executor.execute(new ExportingTask(pool, 5));  
        executor.execute(new ExportingTask(pool, 6));  
        executor.execute(new ExportingTask(pool, 7));  
        executor.execute(new ExportingTask(pool, 8));  

        executor.shutdown();  
        try {  
            executor.awaitTermination(30, TimeUnit.SECONDS);  
        } catch (InterruptedException e){  
            e.printStackTrace();  
        }
    }  
    public static void main(String args[])  {   
        ObjectPoolDemo op = new ObjectPoolDemo();  
        op.setUp();  
        op.tearDown();  
        op.testObjectPool();  
    }   
}