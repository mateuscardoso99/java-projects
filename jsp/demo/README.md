## pasta WEB-INF/lib onde ficam as dependencias do projeto é preciso apontar a pasta WEB-INF/lib no classpath do seu projeto, se usar o maven por exemplo não precisa dela

## mavem-tomcat-plugin: levanta servidor tomcat no projeto mvn clean install, mvn tomcat7:run

## jstl (JavaServer Pages Standard Template Library)
# é uma forma diferente de escrever código no html a forma tradicional seria:
<%
  for(int j=1;j<=10;j++) { %>
<% j %>
<%
  }
%>

# com jstl
<c:forEach var="i" begin="1" end="10" step="1">
    <c:out value="${i}" />
</c:forEach>

## pode escrever código java no html dentro de <% %> ou se usar jstl com c:out <c:out value = "${'ola'}" />