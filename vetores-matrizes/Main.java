import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //int[] vet = new int[10];
        int vet[] = new int[10];//outra forma de declarar
        char[] array = {'S','i','l','v','a'};//pode ser declarado assim, mas desde que seja inicializado
        
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<vet.length;i++){     
            System.out.print("vet["+(i+1)+"]=");

            while(!scanner.hasNextInt()){
                System.out.print("valor invalido, vet["+(i+1)+"]=");
                scanner.nextLine();
            }

            vet[i] = scanner.nextInt();
        }

        for(int i=0;i<vet.length;i++){
            System.out.println(vet[i]);
        }


        //matriz
        int mat[][] = new int[2][2];
        //int[][] mat = new int[2][2];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print("mat["+i+"]["+j+"]=");
                mat[i][j]=scanner.nextInt();
            }
        }

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
