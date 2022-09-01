//Collections Framework é um conjunto de interfaces e classes para representar e 
//tratar grupos de dados como uma única unidade, que pode ser chamada coleção, ou collection
//conjunto de interfaces e classes denominado Collections Framework para manipular arrays

//Collection – está no topo da hierarquia. Não existe implementação direta dessa interface, 
//mas ela define as operações básicas para as coleções, como adicionar, remover, esvaziar, etc.;
//ela é diferente de Collections;

//Set – interface que define uma coleção que não permite elementos duplicados. 
//A interface SortedSet, que estende Set, possibilita a classificação natural dos elementos, 
//tal como a ordem alfabética;

//List – define uma coleção ordenada, podendo conter elementos duplicados. 
//Em geral, o usuário tem controle total sobre a posição onde cada elemento é inserido e pode 
//recuperá-los através de seus índices. Prefira esta interface quando precisar de acesso aleatório, 
//através do índice do elemento;

//Queue – um tipo de coleção para manter uma lista de prioridades, onde a ordem dos seus elementos, 
//definida pela implementação de Comparable ou Comparator, determina essa prioridade. 
//Com a interface fila pode-se criar filas e pilhas;

//Map – mapeia chaves para valores. Cada elemento tem na verdade dois objetos: uma chave e um valor. 
//Valores podem ser duplicados, mas chaves não. SortedMap é uma interface que estende Map, 
//e permite classificação ascendente das chaves. Uma aplicação dessa interface é a classe Properties, 
//que é usada para persistir propriedades/configurações de um sistema, por exemplo.



//A API de coleções oferece também interfaces que permitem percorrer uma coleção derivada de Collection:
//Iterator – possibilita percorrer uma coleção e remover seus elementos;
//ListIterator – estende Iterator e suporta acesso bidirecional em uma lista, modificando e/ou 
//removendo elementos.



/* SET normalmente implementa HashSet, TreeSet, LinkedHashSet */
/* LIST normalmente implementa ArrayList e LinkedList */
/* MAP normalmente implementa HashMap, TreeMap, LinkedHashMap */


/*
ArrayList – é como um array cujo tamanho pode crescer. A busca de um elemento é rápida, 
mas inserções e exclusões não são. Podemos afirmar que as inserções e exclusões são lineares, 
o tempo cresce com o aumento do tamanho da estrutura. Esta implementação é preferível quando se 
deseja acesso mais rápido aos elementos. Por exemplo, se você quiser criar um catálogo com os 
livros de sua biblioteca pessoal e cada obra inserida receber um número sequencial 
(que será usado para acesso) a partir de zero;

LinkedList – implementa uma lista ligada, ou seja, cada nó contém o dado e uma referência para o 
próximo nó. Ao contrário do ArrayList, a busca é linear e inserções e exclusões são rápidas. 
Portanto, prefira LinkedList quando a aplicação exigir grande quantidade de inserções e exclusões. 
Um pequeno sistema para gerenciar suas compras mensais de supermercado pode ser uma boa aplicação, 
dada a necessidade de constantes inclusões e exclusões de produtos;

HashSet – o acesso aos dados é mais rápido que em um TreeSet, mas nada garante que os dados estarão 
ordenados. Escolha este conjunto quando a solução exigir elementos únicos e a ordem não for importante. 
Poderíamos usar esta implementação para criar um catálogo pessoal das canções da nossa discografia;

TreeSet – os dados são classificados, mas o acesso é mais lento que em um HashSet. 
Se a necessidade for um conjunto com elementos não duplicados e acesso em ordem natural, prefira o 
TreeSet. É recomendado utilizar esta coleção para as mesmas aplicações de HashSet, com a vantagem dos 
objetos estarem em ordem natural;

LinkedHashSet – é derivada de HashSet, mas mantém uma lista duplamente ligada através de seus itens. 
Seus elementos são iterados na ordem em que foram inseridos. Opcionalmente é possível criar um 
LinkedHashSet que seja percorrido na ordem em que os elementos foram acessados na última iteração. 
Poderíamos usar esta implementação para registrar a chegada dos corredores de uma maratona;

HashMap – baseada em tabela de espalhamento, permite chaves e valores null. Não existe garantia que os 
dados ficarão ordenados. Escolha esta implementação se a ordenação não for importante e desejar uma 
estrutura onde seja necessário um ID (identificador). Um exemplo de aplicação é o catálogo da 
biblioteca pessoal, onde a chave poderia ser o ISBN (International Standard Book Number);

TreeMap – implementa a interface SortedMap. Há garantia que o mapa estará classificado em ordem 
ascendente das chaves. Mas existe a opção de especificar uma ordem diferente. Use esta implementação 
para um mapa ordenado. Aplicação semelhante a HashMap, com a diferença que TreeMap perde no quesito 
desempenho;

LinkedHashMap – mantém uma lista duplamente ligada através de seus itens. A ordem de iteração é a 
ordem em que as chaves são inseridas no mapa. Se for necessário um mapa onde os elementos são iterados 
na ordem em que foram inseridos, use esta implementação. O registro dos corredores de uma maratona, 
onde a chave seria o número que cada um recebe no ato da inscrição, é um exemplo de aplicação desta 
coleção;
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main{

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); //list do tipo string
        list.add("joao");
        list.add("carlos");
        System.out.println(list);
        Collections.sort(list);//ordenacao da list
        System.out.println(list);

        List<Aluno> alunos = new ArrayList<Aluno>();
        Aluno a = new Aluno("jonas", "curso 1", 10);
        Aluno b = new Aluno("joao", "curso 2", 5);
        Aluno c = new Aluno("carlos", "curso 3", 6);
        alunos.add(a);
        alunos.add(b);
        alunos.add(c);
        System.out.println(alunos);

        ComparaAluno ca = new ComparaAluno();
        Collections.sort(alunos,ca);//ordena alunos
        System.out.println(alunos);

        //Iterator percorre uma collection:
        Aluno aluno;
        Iterator<Aluno> it = alunos.iterator();
        while(it.hasNext()){
            aluno = it.next();//retorna o objeto atual
            System.out.println(aluno.getNome());
        }


        //SET não permite elementos duplicados
        Set<Aluno> conjunto = new HashSet<Aluno>();
        Aluno al1 = new Aluno("João da Silva", "Linux básico", 0);
        Aluno al2 = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno al3 = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno al4 = new Aluno("Antonio Sousa", "OpenOffice", 0);
        conjunto.add(al1);
        conjunto.add(al2);
        conjunto.add(al3);
        conjunto.add(al4);
        System.out.println(conjunto);
        /*
        Note que forçamos a inserção de um objeto duplicado, mas quando executamos a aplicação 
        constatamos que o objeto foi inserido. Se um Set não permite elementos duplicados, onde está o 
        erro? Como HashSet determina que dois objetos estão duplicados?
        HashSet usa o código hash do objeto – dado pelo método hashCode() – para saber onde deve por e 
        onde buscar o mesmo no conjunto (Set). Antes ele verifica se não existe outro objeto no Set 
        com o mesmo código hash. Se não há código hash igual, então ele sabe que o objeto a ser inserido 
        não está duplicado. Dessa forma, classes cujas instâncias são elementos de HashSet devem 
        implementar o método hashCode(). Como consequência disso, a classe Aluno, no nosso exemplo, 
        deve sobrescrever o método hashCode().
        objetos que retornam o mesmo código hash não são necessariamente iguais. Assim, quando 
        encontra no conjunto um objeto com o mesmo código hash do objeto a ser inserido, HashSet faz
        uma chamada ao método equals() para verificar se os dois objetos são iguais. Dessa forma, a 
        classe Aluno deve sobrescrever o método equals() também

        Definimos que um aluno terá o código hash igual ao hash do seu nome – que é String. 
        Sendo assim, precisamos apenas retornar o código hash do nome do aluno no método hashCode(). 
        Ficou definido também que dois alunos são iguais quando têm nomes iguais, por isso no método 
        equals() é retornada a comparação entre os nomes de dois aluno
        */


        //MAP:
        /*
        Vamos supor que agora queremos uma estrutura onde possamos recuperar os dados de um aluno 
        passando apenas o seu nome como argumento de um método. Ou seja, informamos o nome do aluno e o 
        objeto correspondente a esse nome é devolvido. Para isso vamos usar a interface Map, que não 
        estende Collection. Isso causa uma mudança profunda na aplicação, visto que os métodos usados 
        anteriormente não poderão ser usados. Map tem seus próprios métodos para inserir/buscar/remover 
        elementos na estrutura.
        Esta interface mapeia chaves para valores. Considerando a nova proposta do problema, a chave 
        será o nome do aluno e o valor será o objeto aluno.
        Para usar uma classe que implementa Map, quaisquer classes que forem utilizadas como chave 
        devem sobrescrever os métodos hashCode() e equals(). Isso é necessário porque em um Map as 
        chaves não podem ser duplicadas, apesar dos valores poderem ser
        */

        Map<String, Aluno> mapa = new TreeMap<String, Aluno>();
        //na declaração do collection informamos dois tipos: String e Aluno. 
        //O primeiro refere-se à chave e o segundo ao valor.

        Aluno a1 = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b1 = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c1 = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d1 = new Aluno("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a1);
        mapa.put("Antonio Sousa", b1);
        mapa.put("Lúcia Ferreira", c1);
        mapa.put("Benedito Silva", d1);
        System.out.println(mapa);
        System.out.println(mapa.get("Lúcia Ferreira"));

        //O método para inserir na estrutura é put(), que recebe dois objetos (chave e valor). 
        //Para recuperar um objeto específico utilizamos o método get() passando a chave como parâmetro.
        //Como Map não estende Collection, não tem os métodos iterator() e listIterator(). 
        //Entretanto, existe o método keySet() que retorna um Set com as chaves do mapa, e o 
        //método values() que retorna um Collection com os valores associados às chaves. 
        //Assim, podemos percorrer o mapa partindo desses métodos e usando enhanced-for.

        Collection<Aluno> con = mapa.values();
        for (Aluno e : con) {
            System.out.println("valor: "+e);
        }

        HashMap<String, String> cc = new HashMap<String, String>();
        ArrayList<Float> f = new ArrayList<Float>();
        //declarar arraylist ou outras classes dessa forma sem usar List ou outra interface diminui a abstração
        
        f.add((float)4.77);
        System.out.println(f);

        Map<String, Map<String, String>> employeeMap = new HashMap<>();
        Map<String, String> addressMap = new HashMap<>();
        addressMap.put("Permanent", "Florida");
        addressMap.put("Postal", "Canada");

        employeeMap.put("Alex", addressMap);
        //adicionando elemento numa chave ja existente
        employeeMap.get("Alex").put("Hideout", "UAE");




        //list de mapas
        List<Map<String,String>> errors = new ArrayList<>();

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "ola");
        errorResponse.put("ola", "this");
        errors.add(errorResponse);
        Map<String, String> errorResponse2 = new HashMap<>();
        errorResponse2.put("error2", "ola2");
        errorResponse2.put("ola2", "this2");
        errors.add(errorResponse2);
        System.out.println("errors:"+errors);//saida: [{ola=this, error=ola}, {ola2=this2, error2=ola2}]


        //list de mapas em que cada mapa contem um arraylist dentro
        List<Map<String,ArrayList<String>>> errors9 = new ArrayList<>();
        Map<String,ArrayList<String>> errorResponse9 = new HashMap<>();
        ArrayList<String> h = new ArrayList<>();
        h.add("e");
        h.add("hh");
        errorResponse9.put("error", h);
        errors9.add(errorResponse9);
        Map<String,ArrayList<String>> errorResponse99 = new HashMap<>();
        ArrayList<String> h2 = new ArrayList<>();
        h2.add("e2");
        h2.add("hh22");
        errorResponse99.put("error2", h2);
        errors9.add(errorResponse99);
        for(Map<String,ArrayList<String>> t: errors9){
            System.out.println(t);//saida: {error=[e, hh]}, {error2=[e2, hh22]}
        }
        System.out.println("errors9:"+errors9);//saida: [{error=[e, hh]}, {error2=[e2, hh22]}]



        //usando diferentes tipos de colections
        List<Map<String,Object>> listErrors = new ArrayList<>();
        Map<String,ArrayList<String>> error = new HashMap<>();

        // for(FieldError field : e.getFieldErrors()){
        //     ArrayList<String> msg;

        //     if(error.containsKey(field.getField())){
        //         msg = error.get(field.getField());
        //         msg.add(field.getField() + " " + field.getDefaultMessage());
        //     }
        //     else{
        //         msg = new ArrayList<String>();
        //         msg.add(field.getField() + " " + field.getDefaultMessage());
        //     }
            
        //     //msg.add(f.getDefaultMessage());
        //     error.put(field.getField(),msg);
        // }

        Map<String,Object> m = new HashMap<>();
        m.put("errors",error);

        listErrors.add(m);
        System.out.println(listErrors);
        /*
            ex. de saída:
            [
                {
                    "errors": {
                        "nome": [
                            "nome não deve estar em branco",
                            "nome não deve estar vazio"
                        ],
                        "descricao": [
                            "descricao não deve estar vazio",
                            "descricao não deve estar em branco"
                        ]
                    }
                }
            ]
        */
    }
}