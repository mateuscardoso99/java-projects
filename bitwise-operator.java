/*Os operadores bit a bit são usados ​​para realizar a manipulação de bits 
individuais de um número. Eles podem ser usados ​​com qualquer tipo integral 
(char, short, int, etc.). Eles são usados ​​ao realizar operações de atualização 
e consulta das árvores indexadas Binárias*/

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
 
        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));
        //Retorna bit a bit AND dos valores de entrada, ou seja, se ambos os bits são 1, dá 1, senão mostra 0

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));
        //Retorna bit a bit OR dos valores de entrada, ou seja, se algum dos bits for 1, dá 1, senão mostra 0

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));
        //Retorna bit a bit XOR dos valores de entrada, ou seja, se os bits correspondentes forem diferentes, dá 1, senão mostra 0
 
        // bitwise not
        // ~00000000 00000000 00000000 00000101=11111111 11111111 11111111 11111010
        // will give 1's complement (32 bit) of 5 = -6
        System.out.println("~a = " + ~a);
        //retorna a representação do complemento de um do valor de entrada, ou seja, com todos os bits invertidos, o que significa que faz a cada 0 a 1, e a cada 1 a 0
    }
}
