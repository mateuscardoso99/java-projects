import java.nio.charset.StandardCharsets;

/*
Em Java, os bytes são representados com sinal porque a linguagem utiliza a representação de 
números inteiros com sinal para o tipo byte. O tipo byte em Java ocupa 8 bits e pode 
representar valores de -128 a 127. 

A razão para isso é principalmente a conveniência e a consistência com outros tipos de dados 
inteiros na linguagem, como short, int e long, que também são representados com sinal.

Representação em Números Binários
Os números com sinal em Java (e na maioria das linguagens de programação) são geralmente 
representados usando a técnica de complemento de dois. 
Isso permite que um único conjunto de bits seja usado para representar tanto números 
positivos quanto negativos. No caso de um byte:

O bit mais à esquerda (o bit mais significativo) é conhecido como o bit de sinal:
Se o bit de sinal é 0, o número é positivo ou zero.
Se o bit de sinal é 1, o número é negativo.
*/
public class Main
{
	public static void main(String[] args) {
	    byte[] b1 = { 79, 76, 65, 32, 77, 85, 78, 68, 79 };
		print(b1);//SAÍDA: OLA MUNDO
		//cada numero desses representa uma letra na tabela ascii
		//então ao converter pra string, cada numero é convertido para o seu caractere correspondente
		
		byte[] b2 = {
		    (byte) 0x4f, 
		    (byte) 0x4c, 
		    (byte) 0x41, 
		    (byte) 0x20, 
		    (byte) 0x4d, 
		    (byte) 0x55, 
		    (byte) 0x4e, 
		    (byte) 0x44, 
		    (byte) 0x4f
		};
		print(b2);//SAÍDA: OLA MUNDO
		//ao converter pra string, cada numero hexadecimal é convertido para o seu caractere correspondente na tabela ascii

        /*
            -um bit tem 2 possibilidades apenas (0 ou 1)
            -um byte tem 8 bits
            -então um byte pode ter 2^8 combinações possíveis de bits, que vai dar 256 bytes possíveis
            
            -em java bytes são representados por numeros inteiros
            são usados 7 bits para representar um numero e 1 bit para o sinal
            então é possível ter até 2^7 combinações = 128 bytes possíveis
            a faixa então fica de -128 até 127 positivo
            
            -se não usasse um bit para o sinal seria possível representar 256 combinações
        */
        
        byte[] b3 = {(byte) 0x78};
        print(b3);//saída: x. "78" em hexadecimal é representado por "x" na tabela ascii
        System.out.println(b3[0]);//saída: 120. em java os bytes são representados por numeros, "78" em hexadecimal é representado pelo 120 na tabela ascii
	
	    
	    
	    
	    
	    /*
	        numeros até 255 podem ser representados com 1 byte só.
	        mas numeros maiores que isso vão precisar de mais bytes
	    */
	    //representado número 256:
	    //Usa-se 2 bytes (ou 16 bits) para representar o número 256
	    //256 em hexadecimal é 01 00
	    //a representação do número 256 em bytes seria 00 01 (big-endian) ou 01 00 (little-endian).
	    byte[] b4 = { (byte) 0x01, (byte) 0x00};
	    
	    //bytes para int
	    //Ao converter uma matriz de bytes em um valor int , usamos o operador << (deslocamento para a esquerda):
	    //Normalmente, o comprimento do array b4 no trecho de código acima deve ser igual ou menor que quatro. Isso porque um valor int ocupa quatro bytes. Caso contrário, isso levará ao estouro do intervalo int .
	    int value = 0;
        for (byte b : b4) {
            value = (value << 8) + (b & 0xFF);  //equivalente a 1 * 256^1 + 0 * 256^0 = 256.
        }
	    System.out.println(value);//256
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //representado 129:
	    value = 0;
	    byte[] b5 = {(byte) 0x81};//armazenando o valor hexadecimal 0x81, que em decimal é 129, mas ao armazená-lo como byte, ele se torna -127 devido ao overflow de representação. (só vai até 127)
	    
	    //percorre itera sobre o array b5. O b & 0xFF é uma operação que transforma o byte em um valor inteiro sem sinal (0 a 255), essencialmente convertendo o byte negativo em um valor positivo correspondente.
	    //O value = (value << 8) + (b & 0xFF); desloca value para a esquerda em 8 bits e adiciona o valor do byte
	    for (byte b : b5) {
            value = (value << 8) + (b & 0xFF);
        }
	    System.out.println(value);//129
	    
	    
	    
	    
	    
	    
	    
	    /*
	    Para recuperar o número, cada byte é tratado como um número inteiro (usando & 0xFF para assegurar que estamos considerando apenas os bits válidos em uma operação byte para evitar resultados negativos).
        O byte mais significativo (bytes[1]) é deslocado 8 bits para a esquerda e, em seguida, combinado com o byte menos significativo (bytes[0]) usando o operador OR (|).
	    */
	    int numero = 256;
        byte[] bytes = new byte[2];
        
        bytes[0] = (byte) (numero & 0xFF);          // Pega os 8 bits menos significativos
        bytes[1] = (byte) ((numero >> 8) & 0xFF);   // Pega os 8 bits mais significativos
        
        value = ((bytes[1] & 0xFF) << 8) | (bytes[0] & 0xFF);
	    System.out.println(value);//256
	    
	    //outra forma: (como o byte mais significativo está no final, o loop tem que ser de trás pra frente para que o byte mais significativo seja calculado primeiro)
	    /*
	        esse for não funciona pois o byte mais significativo está no inicio (0x01)
	        só funcionaria se o byte menos significativo tivesse na posição [0]
	        
	        byte[] b4 = { (byte) 0x01, (byte) 0x00};
    	    int value = 0;
            for (byte b : bytes) {
                value = (value << 8) + (b & 0xFF);  //equivalente a 1 * 256^1 + 0 * 256^0 = 256.
            }
	    */
	    
	    
	    value = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            value = (value << 8) + (bytes[i] & 0xFF);
        }
        System.out.println(value);//256
	}

	public static void print(byte[] b){
	    System.out.println(new String(b, StandardCharsets.UTF_8));
	    //bytes são numeros em java, mas aqui queremos mostrar em formato de caractere
	    //então o que será representado é a coluna "char" da tabela ascii
	}
	
	/*
	
	Endianness se refere ao arranjo de bytes na memória do computador. 
	Ele vem em duas formas: Little Endian e Big Endian .
	
	    - O Big Endian armazena o byte mais significativo no menor endereço de memória.
	    - Por outro lado, o Little Endian armazena o byte menos significativo no menor endereço de memória .

	
	Big-endian é uma ordem na qual o "big end" (valor mais significativo na sequência) é 
	armazenado primeiro (no endereço de armazenamento mais baixo). 
	Little-endian é uma ordem na qual o "little end" (valor menos significativo na sequência) é 
	armazenado primeiro. 
	Por exemplo, em um computador big-endian, os dois bytes necessários para o 
	número hexadecimal 4F52 seriam armazenados como 4F52 no armazenamento 
	(se 4F for armazenado no endereço de memória 1000, por exemplo, 52 estará no endereço 1001). 
	Em um sistema little-endian, ele seria armazenado como 524F (52 no endereço 1000, 4F em 1001).
	
	
	
	*/
}
