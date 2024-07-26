package com.example;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;


public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.US).format(LocalDateTime.now().atZone(ZoneId.of("GMT")))); 
        //Fri, 26 Jul 2024 09:36:46 GMT -> está em UTC, mas também podemos representar a hora em fusos horários locais especificando o deslocamento (OFFSET) do UTC.
        //usar Locale.US faz com que mostre o nome do dia em inglês
    
        System.out.println(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz").format(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")))); //sex., 26 jul. 2024 09:40:04 BRT
        System.out.println(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz").format(LocalDateTime.now().atZone(ZoneId.of("UTC-3")))); 
        //sex., 26 jul. 2024 09:40:04 BRT
        //'BRT' é uma abreviação do fuso-horário brasileiro, essas abrevições não são únicas
        //diferentes locais usam a mesma abreviação, "IST" por exemplo é usado na Irlanda, Índia e Israel
        //nem sempre (na verdade quase nunca) será possível determinar o timezone a partir da abreviação.


        /*
        offset:
            o valor -03:00 por exemplo, é o offset (a diferença com relação a UTC - então neste caso seriam "3 horas a menos que UTC"), 
            e segundo a documentação, basta usar o pattern X para exibi-lo. 
            No caso, para ter horas e minutos separados por dois-pontos, basta usar 3 letras X:
            Lembrando que o valor do offset depende do timezone default que está configurado na JVM. 
            No meu caso, o default (que pode ser consultado com TimeZone.getDefault()) é America/Sao_Paulo, que corresponde ao Horário de Brasília.

            Mudando o timezone default para o fuso da Alemanha aparecerá +01:00 na data
        */




        /*
        CONVERTENDO DATAS DE FUSO-HORÁRIOS DIFERENTES:
         - converter de (UTC+8:00) Asia/Singapore - Singapore Time Date : 22-1-2015 10:15:55 AM (22/01/2015 10:15:55)
         - para (UTC-5:00) America/New_York - Eastern Standard Time Date : 21-1-2015 09:15:55 PM (21/01/2015 21:15:55)

        evitar usar java.util.Date e java.util.Calendar, usar joda time ou java.time.*
        */

        //Sempre use java.time.ZonedDateTime para representar uma data e hora contendo fuso horário.

        String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

        String dateInString = "22-1-2015 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId); //TimeZone : Asia/Singapore

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime);//Date (Singapore) : 2015-01-22T10:15:55+08:00[Asia/Singapore]

        ZoneId newYokZoneId = ZoneId.of("America/New_York");
        System.out.println("TimeZone : " + newYokZoneId);//TimeZone : America/New_York

        ZonedDateTime nyDateTime = asiaZonedDateTime.withZoneSameInstant(newYokZoneId);
        System.out.println("Date (New York) : " + nyDateTime);//Date (New York) : 2015-01-21T21:15:55-05:00[America/New_York]

        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        System.out.println("\n---DateTimeFormatter---");
        System.out.println("Date (Singapore) : " + format.format(asiaZonedDateTime));//Date (Singapore) : 22-1-2015 10:15:55 AM
        System.out.println("Date (New York) : " + format.format(nyDateTime));//Date (New York) : 21-1-2015 09:15:55 PM




        //SEM AM PM, USANDO HORA FORMATO 24hrs
        String DATE_FORMAT_SEM_AM_PM = "dd-M-yyyy HH:mm:ss";
        String date2 = "22-1-2015 10:15:55";
        LocalDateTime ldt2 = LocalDateTime.parse(date2, DateTimeFormatter.ofPattern(DATE_FORMAT_SEM_AM_PM));

        ZoneId singaporeZoneId2 = ZoneId.of("Asia/Singapore");
        System.out.println("\n\nTimeZone : " + singaporeZoneId2); //TimeZone : Asia/Singapore

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime2 = ldt2.atZone(singaporeZoneId2);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime2);//Date (Singapore) : 2015-01-22T10:15:55+08:00[Asia/Singapore]

        ZoneId newYokZoneId2 = ZoneId.of("America/New_York");
        System.out.println("TimeZone : " + newYokZoneId2);//TimeZone : America/New_York

        ZonedDateTime nyDateTime2 = asiaZonedDateTime.withZoneSameInstant(newYokZoneId2);
        System.out.println("Date (New York) : " + nyDateTime2);//Date (New York) : 2015-01-21T21:15:55-05:00[America/New_York]

        DateTimeFormatter format2 = DateTimeFormatter.ofPattern(DATE_FORMAT_SEM_AM_PM);
        System.out.println("\n---DateTimeFormatter---");
        System.out.println("Date (Singapore) : " + format2.format(asiaZonedDateTime2));//Date (Singapore) : 22-1-2015 10:15:55
        System.out.println("Date (New York) : " + format2.format(nyDateTime2));//Date (New York) : 21-1-2015 21:15:55









        //USANDO JAVA.UTIL.DATE
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        String dateString = "22-01-2015 10:15:55 AM";
        Date date = formatter.parse(dateString);
        TimeZone tz = TimeZone.getTimeZone("Asia/Singapore");

        // From TimeZone Asia/Singapore
        System.out.println("\n\n\nTimeZone : " + tz.getID() + " - " + tz.getDisplayName());
        System.out.println("TimeZone : " + tz);
        System.out.println("Date (Singapore) : " + formatter.format(date));

        // To TimeZone America/New_York
        SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        String sDateInAmerica = sdfAmerica.format(date); // Convert to String first
        Date dateInAmerica = formatter.parse(sDateInAmerica); // Create a new Date object

        System.out.println("\nTimeZone : " + tzInAmerica.getID() + " - " + tzInAmerica.getDisplayName());
        System.out.println("TimeZone : " + tzInAmerica);
        System.out.println("Date (New York) (String) : " + sDateInAmerica);
        System.out.println("Date (New York) (Object) : " + formatter.format(dateInAmerica));
    }
}
