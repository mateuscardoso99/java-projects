import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.ByteBuffer;
import java.text.Normalizer;

class BuCaracteresArquivoMovimentacao {
    public static void main(String[] args) throws IOException{
        List<List<String>> r = new ArrayList<>();

        FileInputStream fis = new FileInputStream("/home/Downloads/Extraca_PARTE_2.csv");
        InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.ISO_8859_1);
      
        System.out.println("Character Encoding: "+isr.getEncoding());

        try(BufferedReader br = new BufferedReader(isr)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                //System.out.println((int) values[5].charAt(2));
                //System.out.println((int) values[5].charAt(8));
                r.add(Arrays.asList(values));
            }
        }
        String s = r.get(1).get(5);
        System.out.println((int)s.charAt(2));
        byte[] sss = s.getBytes(StandardCharsets.ISO_8859_1);
        String asc = new String(sss,StandardCharsets.ISO_8859_1);
        System.out.println(asc); //funciona caracteres certos

//         ByteBuffer buffer = StandardCharsets.UTF_8.encode(s); 
//         String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
//         System.out.println(utf8EncodedString);

//         String textwithaccent="Thís ís a text with accent";
// String textwithletter="Ñandú";

// String text1 = new String(textwithaccent.getBytes(UTF_8), UTF_8);
// String text2 = new String(textwithletter.getBytes(UTF_8),"Windows-1252");
// System.out.println(text1+text2);

// String a = Normalizer.normalize(s, Normalizer.Form.NFC);
// byte[] ttt = a.getBytes();
//         String ggg = new String(ttt,System.getProperty("file.encoding"));
//         System.out.println(ggg);
// System.out.println(a.replaceAll("[^\\p{ASCII}]", ""));


// Reader in = new InputStreamReader(new FileInputStream("/home/mateus/Downloads/suino.csv"), "Windows-1252");
// BufferedReader bufferedReader = new BufferedReader(in);
// String l;
// while ((l = bufferedReader.readLine()) != null) {
//     String[] v = l.split(",");
//    // System.out.println(v[5].charAt(2));
// }


// FileReader fr = new FileReader("/home/mateus/Downloads/suino.csv","UTF8");
//    int i;    
//           while((i=fr.read())!=-1)    
//           System.out.print((char)i);    
//           fr.close();    
//     }
// BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("/home/mateus/Downloads/suino.csv"), "UTF8"));
// String linha = myBuffer.readLine();
// FileReader f = new FileReader("/home/mateus/Downloads/suino.csv");
// System.out.println(f.getEncoding());
// while (linha != null) {
//     System.out.println(linha);
//     linha = myBuffer.readLine();
// }

// myBuffer.close();
//     }
    
    
             //    File convFile = new File("/home/mateus/Downloads/SdaExtracao0040_10236_20230603202024_PARTE_2_editado.csv");
    // FileOutputStream fos = new FileOutputStream( convFile );
    // fos.write( file.getBytes() );
    // fos.close();

    // BufferedReader reader = new BufferedReader(new InputStreamReader(convFile, "ISO-8859-1"));
    //         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos,StandardCharsets.UTF_8));
    //         char[] buffer = new char[16384];
    //         int read;
    //         while ((read = csvReader.read(buffer)) != -1)
    //             writer.write(buffer, 0, read);
                     
    //         writer.close();
    
     //InputStream fis = new FileInputStream("/home/mateus/Downloads/SdaExtracao0040_10236_20230603202024_PARTE_22.csv");
    //     InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
    //     Reader in = new BufferedReader(isr);
    //     FileOutputStream fos = new FileOutputStream("/home/mateus/Downloads/vvvvv.csv");
    //     OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
    //     Writer out = new BufferedWriter(osw);

    //     int ch;
    //     while ((ch = in.read()) > -1) {
    //         out.write(ch);
    //     }

    //     out.close();
    //     in.close();
    
//     try (BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.ISO_8859_1));
//              BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(convFile),
//                      StandardCharsets.ISO_8859_1))) {
//             char[] buffer = new char[16384];
//             int read;
//             while ((read = reader.read(buffer)) != -1)
//                 writer.write(buffer, 0, read);
//         }
}
    
    
}
