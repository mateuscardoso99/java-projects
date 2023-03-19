//map não estende de Collection por isso nao tem metodos add, remove etc..
//é implementado pelas classes HashMap, TreeMap, HashTable, LinkedHashMap
//baseado em chave e valor
//permite valores repetidos mas não repetição de chaves
//pode ser ordenado
//permite busca por chave e valor


//HashMap
//nao mantem ordem de inserção
//nao pode ter chaves nulas

//LinkedHashMap
//mantem ordem de insercao
//nao pode ter chaves nulas

//treemap bom para ordenação
//pode ser reordenado
//quando as chaves forem string faz ordem alfabética, quando numeros ordem crescente
//pode ter chaves nulas


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Maps {
    public static void main(String[] args) {
        Map<String,Integer> campeoes = new HashMap<>();
        campeoes.put("Brasil", 5);
        campeoes.put("italia", 4);
        campeoes.put("alemanha", 4);
        System.out.println(campeoes);
        campeoes.put("Brasil", 6);//atualiza valor na chave Brasil
        System.out.println(campeoes.get("alemanha"));//retorna valor da chave alemanha
        System.out.println(campeoes.containsKey("uruguai"));//verifica se chave existe
        campeoes.remove("italia");//remove chave
        System.out.println(campeoes.containsValue(6));//verifica se valor existe

        System.out.println("Exibindo chaves: ");
        Set<String> keys = campeoes.keySet();//retorna as chaves
        System.out.println(keys);

        System.out.println("Exibindo valores: ");
        Collection<?> valores = campeoes.values();//retorna os valores
        System.out.println(valores);

        Set<Map.Entry<String, Integer>> entries = campeoes.entrySet();
        System.out.println("set com chaves e valores "+entries);
    
        //percorrendo
        for(Map.Entry<String,Integer> entry : campeoes.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    
        for(String key:campeoes.keySet()){
            System.out.println(key +"-"+campeoes.get(key));
        }

        Iterator<Integer> iterator = campeoes.values().iterator();
        while(iterator.hasNext()){//percorrendo valores
            System.out.println("value: "+iterator.next());
        }

        System.out.println(campeoes.size());//tamanho


        //menor valor
        System.out.println("menor valor: " );

        int menor = Collections.min(campeoes.values());
        String chaveMenorValor = "";
        for (Map.Entry<String, Integer> entry: campeoes.entrySet()) {
            if(entry.getValue().equals(menor)) {
                chaveMenorValor = entry.getKey();
                System.out.println("menor valor: " + chaveMenorValor + " - " + menor);
            }
        }


        //TREE MAP 
        TreeMap<String,String> treeCapitais = new TreeMap<>();
        treeCapitais.put("SC", "florianopolis");
        treeCapitais.put("RS", "porto alegre");
        System.out.println(treeCapitais.firstKey());//retorna capital do topo da arvore
        //lastKey() retorna capital do final da arvore
        //lowerKey("SC") retorna capital abaixo do parametro passado
        //higherKey("SC") retorna capital acima do parametro passado
        System.out.println(treeCapitais);
        System.out.println(treeCapitais.firstEntry().getKey()+"-"+treeCapitais.firstEntry().getValue());//retorna valores do topo
        System.out.println(treeCapitais.lowerEntry("SC").getKey()+"-"+treeCapitais.lowerEntry("SC").getValue());//retorna valores abaixo do parametro passado

        //pollLastEntry() retorna e remove ultimo elemento da arvore
        //pollFirstEntry() retorna e remove o primeiro elemento da arvore

        //percorrendo
        for(String capital:treeCapitais.keySet()){
            System.out.println(capital+"-"+treeCapitais.get(capital));
        }
        for(Map.Entry<String,String> c:treeCapitais.entrySet()){
            System.out.println(c.getKey()+"-"+c.getValue());
        }


        //HASH TABLE bom para usar com threads
        Hashtable<String,Integer> ests = new Hashtable<>();
        ests.put("joao", 12);
        ests.put("maria", 45);
        System.out.println(ests);
        ests.put("carlos", 44);
        ests.remove("carlos");
        //percorrendo
        for(String e:ests.keySet()){
            System.out.println(e+"-"+ests.get(e));
        }
        for(Map.Entry<String,Integer> c:ests.entrySet()){
            System.out.println(c.getKey()+"-"+c.getValue());
        }


        //LINKED HASH MAP
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());//mantem ordem de inserção

        System.out.println("Exiba o dicionário ordenado pelo modelo dos carros: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

    }
}
