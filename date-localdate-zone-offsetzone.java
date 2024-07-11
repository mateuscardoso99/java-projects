@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") //este é um padrão de data que é retornado em JSON, por exemplo 2024-07-11T15:01:11.4994383-03:00,  2023-09-23T15:50:51.04Z
private Date date;

yyyy-MM-dd'T'HH:mm:ss.SSSZ a data será 2020-02-28T05:50:24.000+02:00

significado dos símbolos no pattern

‘y’: year
‘M’: month (in number form, e.g. “1” for January)
‘MMM’: month abbreviation (e.g. “Jan”)
‘MMMM’: full month name (e.g. “January”)
‘d’: day of the month
‘E’: day of week abbreviation (e.g. “Mon”)
‘EEEE’: full day of week name (e.g. “Monday”)
‘h’: hour (in 1-12 form)
‘H’: hour (in 0-23 form)
‘m’: minute
‘s’: second
‘S’: fração de segundo
‘a’: AM/PM marker
‘z’: fuso horário abreviação (ex: “Pacific Standard Time; PST”)
‘Z’: fuso horário offset (deslocamento) (e.g. “-0800”) ex: brasília será -03:00 // Este formata o offset com base no número de letras do padrão. Uma, duas ou três (ZZZ por exemplo) letras produzem a hora e o minuto, sem dois pontos, como '+0130'
'X': semelhante ao 'Z'
 
'V': time-zone ID, ex: America/Los_Angeles; Z; -08:30
DateTimeFormatter zdtFormatter = DateTimeFormatter.ofPattern("uuuuMMdd HH:mm:ss.SSSSSS VV ZZZZZ",Locale.ENGLISH); 
System.out.println(ZonedDateTime.now().format(zdtFormatter)); //20221013 20:55:13.468847 Europe/London +01:00 //pega o id da zona (Europe/London) baseado no Locale e o fuso-horário de londres que é GMT +1


 
exemplos:
//yyyy-MM-dd (ISO)	 ->   “2018-07-14”
//dd-MMM-yyyy	  ->   “14-Jul-2018”
//dd/MM/yyyy	 ->   “14/07/2018”
//E, MMM dd yyyy   ->  	“Sat, Jul 14 2018”
//h:mm a	 ->   “12:08 PM”
//EEEE, MMM dd, yyyy HH:mm:ss a	  ->   “Saturday, Jul 14, 2018 14:31:06 PM”
//yyyy-MM-dd'T'HH:mm:ssZ	->   “2018-07-14T14:31:30+0530”
//hh 'o''clock' a, zzzz	   ->   “12 o’clock PM, Pacific Daylight Time”
//K:mm a, z	   ->   “0:08 PM, PDT”



ZONE: se refere ao nome do continente, país, cidade
OffsetDateTime: é uma representação imutável de uma data-hora com um deslocamento de UTC/Greenwich no sistema de calendário ISO-8601, como 2007-12-03T10:15:30+01:00 . Em outras palavras, ele armazena todos os campos de data e hora, com uma precisão de nanossegundos, bem como o deslocamento de GMT/UTC .
//Vamos obter o  OffsetDateTime  atual com um deslocamento de duas horas de GMT/UTC:
ZoneOffset zoneOffSet= ZoneOffset.of("+02:00");
OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffSet);

ZonedDateTime: é uma representação imutável de uma data-hora com um fuso horário no sistema de calendário ISO-8601, como 2007-12-03T10:15:30+01:00 Europe/Paris. Ele contém o estado equivalente a três objetos separados: um LocalDateTime , um ZoneId e o ZoneOffset resolvido . 
Aqui, o ZoneId determina como e quando o deslocamento muda. Então, o deslocamento não pode ser definido livremente, pois a zona controla quais deslocamentos são válidos.
//Para obter o ZonedDateTime atual para uma região específica, usaremos:
ZoneId zone = ZoneId.of("Europe/Berlin");
ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);

//A classe ZonedDateTime também fornece métodos integrados para converter uma determinada data de um fuso horário para outro:
ZonedDateTime destZonedDateTime = origemDateTime.withZoneSameInstant(destinoZoneId);
//Por fim, ele é totalmente compatível com DST e lida com ajustes de horário de verão. Ele geralmente é útil quando queremos exibir um campo de data e hora em um fuso horário específico.


não faz sentido (sem conversões) comparar diretamente duas datas com informações completas de fuso horário. Portanto, devemos sempre preferir armazenar OffsetDateTime no banco de dados em vez de ZonedDateTime , 
pois datas com um deslocamento de horário local sempre representam os mesmos instantes no tempo.



 /*
 ZoneDateTime:
  -armazena todos os campos de data e hora, com uma precisão de nanossegundos, e um fuso horário, com um deslocamento de zona usado para lidar com datas e horas locais ambíguas
  -não é possível definir deslocamentos livremente, pois a zona controla os valores de deslocamento válidos
  -é totalmente compatível com o horário de verão e lida com ajustes de horário de verão
  -é útil para exibir campos de data e hora em um fuso horário específico do usuário

 OffsetDateTime:
   -armazena todos os campos de data e hora, com uma precisão de nanossegundos, bem como o deslocamento de GMT/UTC (sem informações de fuso horário)
   -deve ser usado para armazenar uma data no banco de dados ou comunicá-la por meio de uma rede
 */ 
  
  
OLHAR:
https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

