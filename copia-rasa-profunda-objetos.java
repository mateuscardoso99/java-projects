
/*
 * cópia profunda constrói uma cópia completamente independente de um objeto, enquanto uma cópia superficial cria uma cópia que depende do objeto original.
 * 
 * Para suportar a clonagem em Java, uma classe deve implementar a interface Cloneable e substituir o método clone() . A interface Cloneable é uma interface marcadora, o que significa que não contém nenhum método e apenas indica que uma classe é clonável.
  
 * Podemos criar uma cópia superficial com o método clone() , definido na classe Object. Por padrão, clone() cria uma cópia superficial do objeto, copiando todos os seus campos para o novo objeto
 * Porém, se os campos do objeto forem referências a outros objetos, as referências serão copiadas, mas os próprios objetos não, portanto o novo objeto depende do objeto original.
 * 
 * 
 * 
 * 
 * 
 * 
 * Uma cópia superficial é útil quando os campos do objeto são de tipos simples (por exemplo, inteiros, strings, etc.) e não possuem nenhuma referência a outros objetos. 
 * Isso ocorre porque uma cópia superficial cria um novo objeto com os mesmos valores para os campos simples, mas os próprios campos ainda são referências aos mesmos objetos. 
 * Como resultado, o novo objeto depende do original.
 * 
 * Por outro lado, uma cópia profunda cria uma cópia completamente independente do objeto original com campos. 
 * Isto é útil quando os campos do objeto são referências a outros objetos e quando queremos que o novo objeto seja completamente independente. 
 * Como resultado, a alteração da cópia não afetará o original.
 */

//EXEMPLO CÓPIA RASA

import java.lang.reflect.Field;

class Department{
    public long id;
    public String nome;

    public Department(long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Department(Department d){
        this.id = d.id;
        this.nome = d.nome;
    }

    public Department(){}
}

class User implements Cloneable {

    public String name;
    public Department department;
    
    public User(){}

    public User(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public User(User u){
        this.name = u.name;
        this.department = new Department(u.department);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    //CÓPIA PROFUNDA
    /*
     * Por outro lado, uma cópia profunda cria uma cópia completamente independente do objeto original e de todos os seus campos. 
     * Normalmente é implementado substituindo manualmente o método clone() e criando um novo objeto copiando os valores de cada campo do objeto original para o novo objeto.
     */
    protected Object cloneProfundo(){
        return new User(this.name, new Department(this.department.id, this.department.nome));
    }
}

//Se criarmos uma cópia superficial de um objeto User usando o método clone(), o novo objeto terá os mesmos valores para os campos de nome e departamento, mas os próprios campos ainda serão referências aos mesmos objetos:
public class Main{
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("John", new Department(1111L, "test"));
        User shallowCopyUser = (User) user.clone();

        System.out.println(user.department == shallowCopyUser.department); //true, pois não é criado um novo objeto departamento mas apenas o endereço é copiado para a cópia
        System.out.println(user.department);
        System.out.println(shallowCopyUser.department);
        user.department.nome = "w";
        System.out.println(shallowCopyUser.department.nome);//w pois a cópia aponta pro mesmo endereço de memória
        shallowCopyUser.department.nome ="222";
        System.out.println(user.department.nome);//222 pois tanto clone como original apontam pra mesma instancia, não são objetos independentes
        user.name ="maria";
        System.out.println(shallowCopyUser.name);//aqui permance como John pois Strings são imutáveis, qualquer alteração resultará na criação de um novo objeto String
        

        //CÓPIA PROFUNDA
        //Uma cópia profunda do objeto Usuário criaria um novo objeto com uma nova cópia do campo departamento e não estaria mais vinculada ao objeto original:
        User user2 = new User("John", new Department(1111L, "test"));
        User deepCopyUser = (User) user2.cloneProfundo();

        System.out.println(user2.department == deepCopyUser.department); // false, pois é criado um novo objeto departamento com os valores copiados
        user2.department.nome = "23333";
        System.out.println(deepCopyUser.department.nome);//test pois foi criado um novo objeto independente


        //OUTRA FORMA DE FAZER CÓPIA PROFUNDA, 
        //cria-se m construtor que pega um objeto da mesma classe como entrada e retorna um novo objeto com os mesmos valores, mas com novas referências 
        User user3 = new User("maria", new Department(22l, "depto 1"));
        User copiaProfunda = new User(user3);

        System.out.println(user3.department == copiaProfunda.department); // false, pois é criado um novo objeto departamento com os valores copiados
        user3.department.nome = "depto 11111";
        System.out.println(copiaProfunda.department.nome);//depto 1 pois foi criado um novo objeto independente


        //CÓPIA PROFUNDA REFLEXÃO
        User copiaProfundaReflexao = copiaProfunda(user3);
        user3.name = "carlos";
        System.out.println("copia profunda reflexão: nome user: " + copiaProfundaReflexao.name);
        System.out.println("copia profunda reflexão: nome depto: " + copiaProfundaReflexao.department.nome);//depto 11111
        user3.department.nome = "depto 99";
        System.out.println("copia profunda reflexão: nome depto: " + copiaProfundaReflexao.department.nome);//depto 11111 pois foi criado um novo objeto independente
    }



    //CÓPIA PROFUNDA COM REFLEXÃO
    private static <T> T copiaProfunda(T object){
        try{
            T copia = (T) object.getClass().getDeclaredConstructor().newInstance();

            Field[] fields = object.getClass().getDeclaredFields();

            for(Field f : fields){
                f.setAccessible(true);
                Object valorField = f.get(object);

                //usar getPackageName().startsWith("org.example...")
                if(valorField.getClass().getName().equals("Department")){
                    f.set(copia, copiaProfunda(valorField));//dessa forma vai criar uma instancia tbm do objeto aninhado, senão ia apenas usar a referencia ao objeto original o que criaria uma cópia rasa
                }
                else{
                    f.set(copia, valorField);
                }
            }

            return copia;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}



