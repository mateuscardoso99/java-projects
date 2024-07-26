/*
Manipular data e hora em um formato padronizado é crucial ao trabalhar com aplicativos que lidam com diferentes fusos horários ou ao trocar dados entre sistemas.
Neste tutorial, exploraremos várias técnicas para formatar um LocalDate para o formato ISO 8601. Este formato inclui o separador ' T ' e o ' Z ' indicando a hora UTC.

LocalDate é uma parte da API moderna de data e hora introduzida no Java 8 sob o pacote java.time . É imutável, o que significa que, uma vez que uma instância é criada, seu valor não pode ser alterado. 
Ele representa uma data sem considerar a hora ou o fuso horário, focando somente no ano, mês e dia do mês. LocalDate facilita a manipulação e interação convenientes com informações de data.


--------------------

DICA:
Evite depender do sistema operacional host ou da JVM para o fuso horário padrão
Recomendo que você escreva todo o seu código para declarar explicitamente o fuso horário desejado/esperado. 
Você não precisa depender do fuso horário padrão atual da JVM. E esteja ciente de que o fuso horário padrão atual da JVM pode mudar a qualquer momento durante o tempo de execução, 
com qualquer código em qualquer thread de qualquer aplicativo chamando TimeZone.setDefault(). 
Tal chamada afeta todos os aplicativos dentro dessa JVM imediatamente.


-----------------------


SimpleDateFormat vs DateTimeFormatter:
SimpleDateFormat é uma classe que faz parte da API Java há muito tempo, e é usada para analisar e formatar datas de acordo com uma determinada string de formato. 
Ela é baseada na classe java.util.Calendar, que é uma API de data e hora legada.
SimpleDateFormat não é thread-safe, enquanto DateTimeFormatter é thread-safe. Isso significa que você pode usar com segurança um objeto DateTimeFormatter de vários threads, 
mas precisa ter cuidado ao usar SimpleDateFormat de vários threads.

DateTimeFormatter, por outro lado, é uma classe mais nova que foi introduzida no Java 8 como parte do pacote java.time. 
É um formatador imutável que pode ser usado para analisar e formatar datas e horas de uma forma mais moderna e flexível. 
DateTimeFormatter é baseado na API java.time mais nova, que é a forma recomendada de trabalhar com datas e horas em Java.
é recomendado usar DateTimeFormatter


------------------------------------



ISO 8601 é um padrão internacional para representar datas e horas em um formato claro, inequívoco e universalmente aceito. 
Ele fornece uma maneira padronizada de expressar datas e horas, o que é essencial para uma ampla gama de aplicações. 
Isso inclui intercâmbio de dados, comunicação internacional e sistemas de computador.

O formato ISO 8601 inclui vários componentes, sendo o formato mais comum: AAAA-MM-DDThh:mm:ss.sssZ.

Aqui está uma análise dos componentes:

AAAA : Representa o ano com quatro dígitos (por exemplo, 2023)
MM : Representa o mês com dois dígitos (por exemplo, 03 para março)
DD : Representa o dia do mês com dois dígitos (por exemplo, 15)
'T': Um caractere ' T ' literal que separa a data da hora
hh : representa a hora do dia no formato de 24 horas (por exemplo, 14 para 14h)
mm : Representa os minutos (por exemplo, 30)
ss : Representa os segundos (por exemplo, 45)
sss : representa milissegundos (opcional e pode variar em duração)
' Z ': Um caractere ' Z ' literal que indica que a hora está no Tempo Universal Coordenado (UTC)

A ISO 8601 permite vários componentes opcionais, tornando-a um padrão versátil para representar informações de data e hora. Por exemplo, podemos incluir deslocamentos de fuso horário ou omitir segundos e milissegundos quando não forem relevantes.
O caractere ' Z ' indica que a hora está em UTC, mas também podemos representar a hora em fusos horários locais especificando o deslocamento do UTC.

Java fornece uma maneira flexível de formatar objetos de data e hora, incluindo LocalDate, usando a classe DateTimeFormatter .

Instâncias de DateTimeFormatter são seguras para threads, o que as torna adequadas para uso em ambientes multithread sem a necessidade de sincronização externa.

exemplo formatando padrão ISO 8601
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
String formattedDate = localDate.atStartOfDay().atOffset(ZoneOffset.UTC).format(formatter);
return formattedDate;

outro exemplo
Date utilDate = Date.from(date.atStartOfDay(ZoneOffset.UTC).toInstant());
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
String formattedDate = dateFormat.format(utilDate);

SimpleDateFormat não é thread-safe. O uso simultâneo por vários threads pode levar a resultados inesperados ou exceções. 
Para resolver essa preocupação, os desenvolvedores geralmente usam ThreadLocal, garantindo que cada thread possua sua instância dedicada de SimpleDateFormat. 
Isso ajuda a prevenir efetivamente potenciais problemas de segurança de thread.

A abordagem DateTimeFormatter é mais flexível e adequada para lidar com vários requisitos de formatação, enquanto os outros métodos fornecem soluções mais simples para cenários específicos.
*/

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") //este é um padrão de data que é retornado em JSON, por exemplo 2024-07-11T15:01:11.4994383-03:00,  2023-09-23T15:50:51.04Z
private Date date;

yyyy-MM-dd'T'HH:mm:ss.SSSZ a data será 2020-02-28T05:50:24.000+02:00

/*
O que +02:00 está no final não é um fuso horário. Esse texto representa um mero deslocamento do UTC. Um deslocamento é apenas um número de horas-minutos-segundos, positivo ou negativo. 
Um fuso horário é muito mais. Um fuso horário é um histórico das mudanças passadas, presentes e futuras no deslocamento usado pelas pessoas de uma região específica. 
Um fuso horário tem um nome no formato de Continent/Region, como Europe/Brusselsou Africa/Cairo. 
Você pode ajustar de um mero deslocamento para um fuso horário específico. Aplique um ZoneIdpara obter um ZonedDateTime.
*/

convertendo data nesse formato pra localDateTime: LocalDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME); //pode testar com outros tbm não só com ISO_OFFSET_DATE_TIME

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
'XXX': exibe o offset nesse formtato: '-03:00'
 
'V': time-zone ID, ex: America/Los_Angeles; Z; -08:30
DateTimeFormatter zdtFormatter = DateTimeFormatter.ofPattern("uuuuMMdd HH:mm:ss.SSSSSS VV ZZZZZ",Locale.ENGLISH); 
System.out.println(ZonedDateTime.now().format(zdtFormatter)); //20221013 20:55:13.468847 Europe/London +01:00 //pega o id da zona (Europe/London) baseado no Locale e o fuso-horário de londres que é GMT +1


 
exemplos:
//yyyy-MM-dd (ISO)	 ->   “2018-07-14”
//dd-MMM-yyyy	  ->   “14-Jul-2018”
//dd/MM/yyyy	 ->   “14/07/2018”
//E, MMM dd yyyy   ->  	“Sat, Jul 14 2018”
//h:mm a	 ->   “12:08 PM”, 'a' mostra 'AM' ou 'PM'
//EEEE, MMM dd, yyyy HH:mm:ss a	  ->   “Saturday, Jul 14, 2018 14:31:06 PM”
//yyyy-MM-dd'T'HH:mm:ssZ	->   “2018-07-14T14:31:30+0530”
//hh 'o''clock' a, zzzz	   ->   “12 o’clock PM, Pacific Daylight Time”
//K:mm a, z	   ->   “0:08 PM, PDT”

DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.getDefault());
formatter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
System.out.println(formatter.format(now)); //Wed, 24 Jul 2024 14:48:46 BRT

TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
System.out.println(new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").format(now));//Wed, 24 Jul 2024 17:48:46 GMT


ZONE: se refere ao nome do continente, país, cidade
OffsetDateTime: é uma representação imutável de uma data-hora com um deslocamento de UTC/Greenwich no sistema de calendário ISO-8601, como '2007-12-03T10:15:30+01:00' . 
Em outras palavras, ele armazena todos os campos de data e hora, com uma precisão de nanossegundos, bem como o deslocamento de GMT/UTC .
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



//LIDANDO COM FUSO HORÁRIO:
//você precisa armazenar o nome/id do fuso horário inteiro. Por exemplo, eu moro em Oslo, onde meu deslocamento atual é +02:00, mas no inverno (devido ao horário de verão) é +01:00. 
//A mudança exata entre o horário padrão e o horário de verão depende de fatores que você não quer explorar.
//Então, em vez de armazenar + 02:00(ou deveria ser + 01:00?) eu armazeno "Europe/Oslo" no meu banco de dados. Agora eu posso restaurar a configuração completa usando:
TimeZone tz = TimeZone.getTimeZone("Europe/Oslo")
//Quer saber qual é o meu fuso horário hoje?
tz.getOffset(new Date().getTime()) / 1000 / 60   //yields +120 minutes

//Porém o mesmo em dezembro:
Calendar christmas = new GregorianCalendar(2012, DECEMBER, 25);
tz.getOffset(christmas.getTimeInMillis()) / 1000 / 60   //yields +60 minutes
//Basta dizer: armazene o nome ou id do fuso horário e toda vez que quiser exibir uma data, verifique qual é o deslocamento atual (hoje) em vez de armazenar valor fixo. 
//Você pode usar TimeZone.getAvailableIDs() para enumerar todos os IDs de fuso horário suportados.
 


 /*
 ZoneDateTime:
  -armazena todos os campos de data e hora, com uma precisão de nanossegundos, e um fuso horário, com um deslocamento de zona usado para lidar com datas e horas locais ambíguas
  -não é possível definir deslocamentos livremente, pois a zona controla os valores de deslocamento válidos
  -é totalmente compatível com o horário de verão e lida com ajustes de horário de verão
  -é útil para exibir campos de data e hora em um fuso horário específico do usuário
  -Pense ZonedDateTime conceitualmente como um Instant com um atribuído ZoneId.
  
  - Para capturar o momento atual conforme visto no relógio de parede usado pelas pessoas de uma região específica (um fuso horário):
    ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of( "Europe/Paris" )); se não passar parametro se baseia no Locale padrão




 OffsetDateTime:
   -armazena todos os campos de data e hora, com uma precisão de nanossegundos, bem como o deslocamento de GMT/UTC (sem informações de fuso horário)
   
   -deve ser usado para armazenar uma data no banco de dados ou comunicá-la por meio de uma rede
   
   -A classe OffsetDateTime representa um momento como uma data e hora com um contexto de algum número de horas-minutos-segundos à frente ou atrás do UTC. 
    A quantidade de deslocamento, o número de horas-minutos-segundos, é representada pela ZoneOffset. Se o número de horas-minutos-segundos for zero, um OffsetDateTime representa um momento em UTC, o mesmo que um Instant.



ZoneOffset:
    -representa um deslocamento do UTC , um número de horas-minutos-segundos à frente do UTC ou atrás do UTC. 
     é meramente um número de horas-minutos-segundos, nada mais. Uma zona é muito mais, tendo um nome e um histórico de mudanças para deslocamento. 
     Então usar uma zona é sempre preferível a usar um mero deslocamento.



 Instant:
   -instant é um momento na linha do tempo em UTC , uma contagem de nanossegundos desde a época do primeiro momento de 1970 UTC (basicamente, veja a documentação da classe para detalhes essenciais). 
    Como a maior parte da sua lógica de negócios, armazenamento de dados e troca de dados deve estar em UTC, esta é uma classe útil para ser usada com frequência.

   -Instant instant = Instant.now() ;  // Capture the current moment in UTC.



ZoneId:
   - Um fuso horário é representado pela classe ZoneId.
   
   - Um novo dia amanhece mais cedo em Paris do que em Montreal , por exemplo. 
     Então, precisamos mover os ponteiros do relógio para refletir melhor o meio-dia (quando o Sol está diretamente acima) para uma determinada região. 
     Quanto mais longe para leste/oeste da linha UTC na Europa Ocidental/África, maior o deslocamento.
     
   - Um fuso horário é um conjunto de regras para lidar com ajustes e anomalias conforme praticado por uma comunidade ou região local. 
     A anomalia mais comum é a loucura muito popular conhecida como Daylight Saving Time (DST) .

   - Especifique um nome de fuso horário apropriado para o construtor no formato de Continent/Region, como America/Montreal, Africa/Casablanca, America/Sao_Paulo
     ZoneId z = ZoneId.of( “Africa/Tunis” ) ; 



LocalDate, LocalTime, LocalDateTime:
    - As classes de data e hora "locais", LocalDateTime, LocalDate, LocalTime, não estão vinculadas a nenhuma localidade ou fuso horário. 
      Elas não estão vinculadas à linha do tempo. Elas não têm significado real até que você as aplique a uma localidade para encontrar um ponto na linha do tempo.
      
    - A palavra “Local” nesses nomes de classe pode ser contraintuitiva para os não iniciados. A palavra significa qualquer localidade, ou toda localidade, mas não uma localidade em particular.
    
    - Então, para aplicativos de negócios, os tipos "Local" não são usados ​​com frequência, pois representam apenas a ideia geral de uma possível data ou hora, não um momento específico na linha do tempo. 
      Os aplicativos de negócios tendem a se importar com o momento exato em que uma fatura chegou, um produto foi enviado para transporte, um funcionário foi contratado ou o táxi saiu da garagem. 
      Então, os desenvolvedores de aplicativos de negócios usam classes Instante ZonedDateTimemais comumente.

    - Então quando usaríamos LocalDateTime? Em três situações:
      - Queremos aplicar uma determinada data e hora do dia em vários locais.
      - Estamos agendando consultas.
      - Temos um fuso horário pretendido, mas indeterminado.
      Observe que nenhum desses três casos envolve um único ponto específico na linha do tempo, nenhum deles é um momento.

    - Às vezes, queremos representar uma determinada hora do dia em uma determinada data, mas queremos aplicar isso a diversas localidades em diferentes fusos horários.
    - Por exemplo, "O Natal começa à meia-noite de 25 de dezembro de 2015" é um LocalDateTime. 
      A meia-noite bate em momentos diferentes em Paris e em Montreal, e diferente novamente em Seattle e em Auckland .

    Agendamento de consultas
    Outra situação a ser usada LocalDateTimeé para agendar eventos futuros (ex: consultas odontológicas). 
    Essas consultas podem ser muito distantes no futuro para que você corra o risco de políticos redefinirem o fuso horário. 
    Os políticos geralmente dão pouco aviso prévio, ou mesmo nenhum aviso. Se você quer dizer "15h do próximo dia 23 de janeiro", 
    independentemente de como os políticos podem brincar com o relógio, então você não pode registrar um momento – isso faria com que 15h se transformassem em 14h ou 16h se aquela região 
    adotasse ou abandonasse o Horário de Verão, por exemplo.
    
    Para compromissos, armazene a LocalDateTimee a ZoneId, mantidos separadamente. Mais tarde, ao gerar uma agenda, determine um momento imediatamente chamando 
    LocalDateTime::atZone(ZoneId)para gerar um objeto ZonedDateTime.




MAPEANDO PARA SQL:
   java.util.Instant -> TIMESTAMP COM TIME ZONE
   java.time.OffsetDateTime -> TIMESTAMP COM TIME ZONE
   java.time.ZonedDateTime -> TIMESTAMP COM TIME ZONE
   java.time.LocalDateTime -> TIMESTAMP SEM TIME ZONE
   java.time.LocalDate -> DATE
   java.time.LocalTime -> TIME SEM TIME ZONE
   java.time.OffsetTime -> TIME COM TIME ZONE
 */ 
  
  
OLHAR:
https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
