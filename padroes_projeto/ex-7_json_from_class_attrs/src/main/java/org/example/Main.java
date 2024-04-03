package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Desenvolva um framework que converte objetos de qualquer classe para uma representação JSON
 * Cada atributo que fará parte do JSON deverá ter um método GET com uma anotação especial "@JSON".
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, IllegalArgumentException, NoSuchMethodException, SecurityException {
        ClasseA teste = new ClasseA();
        teste.setNome("joao");
        teste.setIdade(19);
        teste.setEndereco("rua das couves");
        teste.setIdColuna(Double.valueOf(234));
        teste.setArrayClassePrimitiveInteger(new Integer[]{1,2,5,9,6});
        teste.setNumerosCollection(List.of(2,4,6,4,0));
        teste.setArrayPrimitive(new long[]{8, 5, 9});
        teste.setArrayClassePrimitiveString(new String[]{"casa","avião","sapato"});
        teste.setInnerClasse(new ClasseA.InnerClasse("ola","ola"));
        teste.setClasseB(
            new ClasseB(1, "olá", 
                new ClasseC("46-DF3", LocalDate.now(), 
                    new ClasseD(Long.valueOf(54), "fechado")
                )
            )
        );

        teste.setCollectionInnerClasse(
            Set.of(
                new ClasseA.InnerClasse("oi", "bla bla"),
                new ClasseA.InnerClasse("teste", "throw new Exception"),
                new ClasseA.InnerClasse("this", "Assim mesmo, a mobilidade dos capitais internacionais estimula a padronização do orçamento setorial.")
            )
        );

        teste.setMapa1(Map.of("key","value", "k2", "v2", "k3", "v3"));
        teste.setMapa2(
            Map.of(
                Long.valueOf(590), 
                new ClasseB(
                    643, 
                    "mapa",
                    new ClasseC(
                        "54-d358", 
                        LocalDate.now(), 
                        new ClasseD(
                            1289l,
                            "abcdefgh"
                        )
                    )
                )
            )
        );

        teste.setMapa3(
            Map.of(
                new ClasseC(
                    "tr987", 
                    LocalDate.now(), 
                    new ClasseD(
                        45l, "sit"
                    )
                ),
                new ClasseC(
                    "7809", 
                    LocalDate.now(), 
                    new ClasseD(
                        123l, "aberto"
                    )
                )
            )
        );

        new Main().convert(teste);        
    }

    public <T> void convert(T object) throws IllegalAccessException, InvocationTargetException, IllegalArgumentException, NoSuchMethodException, SecurityException{
        Class<?> classe = object.getClass();

        StringBuilder json = new StringBuilder("{");

        Method[] metodos = classe.getMethods();

        geraJsonRecursivamente(json, metodos, object);

        json.deleteCharAt(json.lastIndexOf(",")).append("}");

        System.out.println("\n\n"+json);
    }


    private String ajeitaNomePropriedade(String nome){
        nome = nome.substring(3);
        return Character.toLowerCase(nome.charAt(0)) + nome.substring(1);
    }

    
    /**
     * recebe um objeto de uma classe, os métodos dessa classe e o json que será montado
     * percorre cada um dos métodos verificando se tem a anotação @JSON e se começa com 'get'
     * se existir um método assim, adiciona no json como sendo o nome da propriedade o nome do método,
     * depois invoca ele e pega o valor de retorno.
     * depois verifica se o valor de retorno é uma string pra adicionar no json o valor com aspas duplas
     * 
     * se não for string, então verifica o tipo de retorno do método:
     * 
     * - se for um array de tipo primitivo (boolean, byte, char, short, int, long, float, and double) percorre-o e adiciona cada valor no json
     
     * - se for uma Collection (List, ArrayList, Set etc..), verifica se é uma coleção de alguma classe criada (que está dentro de org.example)
     *   se sim, então chama denovo a função recursiva pra percorrer os métodos das classes de cada posição da Collection 
     *   pra achar a anotação @JSON em cada um dos elementos da Collection e adicionar no json
     *   se dentro dessa collection existir outra Collection aninhada, faz o mesmo processo recursivamente
     *   em cada chamada recursiva (empilhamento) vai adicionando as propriedades no json
     *   e quando a execução é encerrada (desempilhar), volta pra execução anterior e continua processando os próximos elementos
     * 
     * - se for uma Collection de tipo primitivo, apenas adiciona os valores no json não chamando a recursão
     *   porque o objetivo da recursão é percorrer os objetos e coleções aninhadas pra encontrar métodos com @JSON
     *   e um objeto ou Collection de tipo primitivo não vai ter nenhum método com essa anotação
     * 
     * - se for um objeto aninhado, chama a função recursiva pra procurar nos métodos desse objeto algum com anotação @JSON
     *   pra adicionar no json
     * 
     * - se for um Mapa, verifica se a chave e valor são de alguma classe criada (org.example), se sim inicia recursão
     *   passando a chave ou o valor em busca de métodos com @JSON e vai criando o json recusivamente, se tiver objetos
     *   aninhados na chave ou valor, vai adicionando as propriedades no json até chegar ao último nível, quando
     *   desempilha uma execução passa pra próxima propriedade do objeto que está na chave ou no valor em busca de um método
     *   anotado com @JSON pra então adicionar no json a propriedade e se tiver algum objeto/coleção aninhado entra na recursão denovo.
     *  
     * @param <T>
     * @param json
     * @param metodos
     * @param object
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    private <T> void geraJsonRecursivamente(StringBuilder json, Method[] metodos, T object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
        for(Method metodo : metodos){
            Annotation[] anotacoesDoMetodo = metodo.getDeclaredAnnotations();

            /*for(Annotation a : anotacoesDoMetodo){
                System.out.println(a.toString());
            }*/

            if(Arrays.stream(anotacoesDoMetodo).anyMatch(a -> a.annotationType().equals(JSON.class)) && metodo.getName().startsWith("get")){
                String nomePropriedade = this.ajeitaNomePropriedade(metodo.getName());

                Object valorPropriedade = metodo.invoke(object);

                json.append("\"" + nomePropriedade + "\"");
                json.append(":");

                Class<?> retornoMetodo = metodo.getReturnType();

                System.out.println(
                    "\n\nMETODO: " + metodo.getName() +
                    ", TIPO RETORNO: "+ retornoMetodo.getTypeName() +
                    ", IS PRIMITIVE: "+ retornoMetodo.isPrimitive() +
                    ", IS ARRAY: "+ retornoMetodo.isArray() +
                    ", IS COLLECTION: "+ Collection.class.isAssignableFrom(retornoMetodo) +
                    ", QTD FIELDS TIPO RETORNO: " + retornoMetodo.getFields().length +
                    ", CLASS LOADER RETURN TYPE: "+ ((retornoMetodo.getClassLoader() != null) ? retornoMetodo.getClassLoader() : null)
                );

                System.out.print("\nFIELDS: ");
                Stream.of(retornoMetodo.getFields()).map(Field::getName).forEach(System.out::println);
                
                System.out.print("\nDECLARED FIELDS: ");
                Stream.of(retornoMetodo.getDeclaredFields()).map(Field::getName).forEach(System.out::println);

                System.out.print("\nMETHODS: ");
                Stream.of(retornoMetodo.getMethods()).map(Method::getName).forEach(System.out::println);
                
                System.out.print("\nDECLARED METHODS: ");
                Stream.of(retornoMetodo.getDeclaredMethods()).map(Method::getName).forEach(System.out::println);

                if(valorPropriedade instanceof String){
                    json.append("\"" + valorPropriedade + "\"");
                    json.append(",");
                }
                else if(retornoMetodo.isArray()){//se for array de tipo primitivo, ou se for array de uma classe que manipula um tipo primitivo, entra aqui
                    json.append('[');

                    int length = Array.getLength(valorPropriedade);

                    for(int i=0; i < length; i++){

                        Object valor = Array.get(valorPropriedade, i);

                        if(valor instanceof String)
                            json.append("\""+valor+"\"");
                        else
                            json.append(valor);

                        if((i + 1) < length){
                            json.append(",");
                        }
                    }

                    json.append("],");
                }
                else if(Collection.class.isAssignableFrom(retornoMetodo)){//se o tipo extende Collection, (List, ArrayList, Set etc..)
                    json.append('[');

                    Collection<Object> collection = (Collection<Object>) valorPropriedade;

                    for(Object element : collection){
                        if(element.getClass().getPackageName().startsWith("org.example")){
                            json.append("{");
                            Method[] metodosClasseAninhada = element.getClass().getDeclaredMethods();
                            geraJsonRecursivamente(json, metodosClasseAninhada, element);
                            json.deleteCharAt(json.lastIndexOf(",")).append("},");
                        }
                        else
                            json.append(element.toString()).append(",");
                    }
                    
                    json.deleteCharAt(json.lastIndexOf(",")).append("],");
                }
                else if(Map.class.isAssignableFrom(retornoMetodo)){
                    Map<Object, Object> mapa = (Map<Object, Object>) valorPropriedade;

                    for(Object key : mapa.keySet()){
                        json.append("{");

                        if(key.getClass().getPackageName().startsWith("org.example")){
                            Object value = mapa.get(key);
                            Method[] methods = mapa.get(key).getClass().getDeclaredMethods();
                            json.append("{");
                            geraJsonRecursivamente(json, methods, value);
                            json.append("}");
                        }
                        else{
                            json.append("\"" + key + "\"");
                        }

                        json.append(":");

                        if(mapa.get(key).getClass().getPackageName().startsWith("org.example")){
                            Object value = mapa.get(key);
                            Method[] methods = mapa.get(key).getClass().getDeclaredMethods();
                            json.append("{");
                            geraJsonRecursivamente(json, methods, value);
                            json.append("}");
                        }
                        else{
                            json.append("\"" + mapa.get(key) + "\"");
                        }
                        json.append("},");
                    }

                    json.deleteCharAt(json.lastIndexOf(",")).append("},");                    
                }
                else if(retornoMetodo.getPackageName().startsWith("org.example")){
                    json.append("{");

                    Method[] metodosClasseAninhada = retornoMetodo.getDeclaredMethods();

                    geraJsonRecursivamente(json, metodosClasseAninhada, valorPropriedade);

                    /*for(Method metodo : metodosClasseAninhada){
                        if(metodo.getAnnotation(JSON.class) != null && metodo.getName().startsWith("get")){
                            String nomePropriedadeAninhada = this.ajeitaNomePropriedade(metodo.getName());
                            Object valorPropriedadeAninhada = metodo.invoke(valorPropriedade);

                            json.append("\"" + nomePropriedadeAninhada + "\"");
                            json.append(":");
                            json.append("\"" + valorPropriedadeAninhada + "\"");
                            json.append(",");
                        }
                    }*/

                    json.deleteCharAt(json.lastIndexOf(",")).append("},");
                    json.append(",");
                }
                else{
                    json.append("\"" + valorPropriedade.toString() + "\"");
                    json.append(",");
                }

                //System.out.println(m.getName() + " " + m.getReturnType().isPrimitive());
                //System.out.println(m.getName() + " " + m.getReturnType().isArray());
                //System.out.println(Collection.class.isAssignableFrom(m.getReturnType()));

            }

        }
    }
}
