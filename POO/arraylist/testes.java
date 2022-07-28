package arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class testes{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        ArrayList <Aluno> arrayA=new ArrayList();
        ArrayList <Professor> arrayP=new ArrayList();
        
        short resp = 0;
        
        String n,data;
        float nota,sal;
        
        do{
            System.out.println("1-novo aluno\n2-novo professor\n3-excluir aluno\n"
                    + "4-excluir professor\n5-listar alunos\n6-listar professores\n0-sair");  
            resp=s.nextShort();
            
            switch(resp){
                case 1:
                    System.out.println("nome do aluno: ");
                    n=s.next();
                    System.out.println("data de nascimento: ");
                    data=s.next();
                    System.out.println("nota: ");
                    nota=s.nextFloat();
                    
                    Aluno a=new Aluno(n,data,nota);
                    arrayA.add(a);
                    
                    break;
                    default:
                    break;
                    
                    
                case 2:
                    System.out.println("nome do professor: ");
                    n=s.next();
                    System.out.println("data de nascimento: ");
                    data=s.next();
                    System.out.println("salario: ");
                    sal=s.nextFloat();
                    
                    Professor p=new Professor(n,data,sal);
                    arrayP.add(p);
                    
                    break;
                    
                    
                case 3:
                    System.out.println("informe o nome do aluno que deseja excluir: ");
                    String nomeA=s.next();
                    
                    for(int i=0;i<arrayA.size();i++){
                        if(arrayA.get(i).getNome().equals(nomeA))
                            arrayA.remove(arrayA.get(i));
                    }
            
                    break;
                    
                    
                case 4:
                    System.out.println("informe o nome do professor que deseja excluir: ");
                    String nomeP=s.next();
                    
                    for(int i=0;i<arrayP.size();i++){
                        if(arrayP.get(i).getNome().equals(nomeP))
                            arrayP.remove(arrayP.get(i));
                    }
            
                    break;
            
            
                case 5:
                    for(int i=0;i<arrayA.size();i++){
                        System.out.println("nome: "+arrayA.get(i).getNome());
                        System.out.println("data de nascimento: "+arrayA.get(i).getDataNascimento());
                        System.out.println("nota: "+arrayA.get(i).getNota());
                        System.out.println("\n\n");
                    }
                    
                    break;
                  
                    
                case 6:
                    for(int i=0;i<arrayP.size();i++){
                        System.out.println("nome: "+arrayP.get(i).getNome());
                        System.out.println("data de nascimento: "+arrayP.get(i).getDataNascimento());
                        System.out.println("nota: "+arrayP.get(i).getSalario());
                        System.out.println("\n\n");
                    }
                    
                    break;        
            
                }
                       
        }while(resp!=0);
               
    }
}
