// comparable permite comparar uma collection com base em um unico elemento como id por exemplo
// Comparable afeta a classe original, ou seja, a classe real eh modificada
// Comparable fornece o metodo compareTo() para classificar elementos.
// Podemos classificar os elementos da lista do tipo Comparable pelo metodo Collections.sort(List).
// comparator permite comparar baseado em varios elementos
// comparator nao afeta a classe original, ou seja, a classe real nao eh modificada.
// Comparator fornece metodo compare() para classificar elementos
// Podemos classificar os elementos da lista do tipo Comparator pelo metodo Collections.sort(List, Comparator).

//a interface Comparable compara a instancia atual (this) com o objeto especificado e o Comparator em Java compara dois objetos de classe diferentes fornecidos.
//Para resumir, se a classificação de objetos precisa ser baseada na ordem natural, use Comparable, enquanto se a classificação precisar ser feita em atributos de objetos diferentes, use Comparator em Java.
import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{  
    int rollno;  
    String name;  
    int age;  
    Student(int rollno,String name,int age){  
        this.rollno=rollno;  
        this.name=name;  
        this.age=age;  
    } 
    //Se qualquer classe implementar a interface Comparable em Java, a coleção desse objeto, List ou Array, pode ser classificada automaticamente usando o 
    //método Collections.sort() ou Arrays.sort() e os objetos serão classificados com base na ordem natural definida pelo método compareTo.
    public int compareTo(Student st){  
        if(age==st.age)  
            return 0;  
        else if(age>st.age)  
            return 1;  
        else  
            return -1;  
    }  
}

//usando comparator, com classe pra cada comparacao, pois com comparable só pode fazer um tipo de comparação pois é o método é sobrecrito na classe
//se quiser comparar mais campos o a solução é o comparator
//Comparator é externo ao tipo de elemento que estamos comparando. Criamos várias classes separadas (que implementam o Comparator) para comparar por diferentes membros.
class Student2{  
    int rollno;  
    String name;  
    int age;  
    Student2(int rollno,String name,int age){  
        this.rollno=rollno;  
        this.name=name;  
        this.age=age;  
    }  
}  

class AgeComparator implements Comparator<Student2>{
    @Override
    public int compare(Student2 s1,Student2 s2){  
        if(s1.age==s2.age)  
            return 0;  
        else if(s1.age>s2.age)  
            return 1;  
        else  
            return -1;  
    }  
}  

class NameComparator implements Comparator<Student2>{  
    @Override
    public int compare(Student2 s1,Student2 s2){  
        return s1.name.compareTo(s2.name);  
    }  
}

class Main{  
    public static void main(String args[]){  
        //comparable
        ArrayList<Student> al=new ArrayList<Student>();  
        al.add(new Student(101,"Vijay",23));  
        al.add(new Student(106,"Ajay",27));  
        al.add(new Student(105,"Jai",21));  
          
        Collections.sort(al);  
        for(Student st:al){  
            System.out.println(st.rollno+" "+st.name+" "+st.age+"\n");  
        }  
        
        //comparator
        ArrayList<Student2> al2=new ArrayList<Student2>();  
        al2.add(new Student2(101,"Vijay",23));  
        al2.add(new Student2(106,"Ajay",27));  
        al2.add(new Student2(105,"Jai",21));  
          
        System.out.println("Sorting by Name");  
        //Using NameComparator to sort the elements  
        Collections.sort(al2,new NameComparator());  
        //Traversing the elements of list  
        for(Student2 st: al2){  
            System.out.println(st.rollno+" "+st.name+" "+st.age+"\n");  
        }  
          
        System.out.println("sorting by Age");  
        //Using AgeComparator to sort the elements  
        Collections.sort(al2,new AgeComparator());  
        //Travering the list again  
        for(Student2 st: al2){  
            System.out.println(st.rollno+" "+st.name+" "+st.age+"\n");  
        }  
        
    }  
}  
