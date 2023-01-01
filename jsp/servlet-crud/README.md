## configuraçao tomcat netbeans:
foi preciso adicionar a permissao de leitura +r na pasta /etc/tomcat9
-sudo chmod +r -R /etc/tomcat9
foi preciso criar um link simbolico na pasta onde o tomcat estava instalado com /etc/tomcat9/conf
-sudo ln -s /etc/tomcat9/ /usr/share/tomcat9/conf
foi preciso tambem mudar as permissoes das pastas /etc/tomcat /usr/share/tomcat9 pra habilitar leitura e execucao e tambem trocar o dono pra $USER ao inves de ROOT
no arquivo tomcat-users.xml foi preciso adicionar as permissoes manager-script pro usuario do tomcat pra poder usalo no netbeans

depois o tomcat voltou a dar erros e foi apagado e instalado do zero

## instalacao apache tomcat
depois de instalar o java
- wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.27/bin/apache-tomcat-10.0.27.tar.gz
criar pasta pro tomcat
-sudo mkdir -p /opt/tomcat
extrair os arquivos
-sudo tar xzvf apache-tomcat-*tar.gz -C /opt/tomcat --strip-components=1
criando usuario e adicionando no grupo tomcat
- sudo groupadd tomcat
- sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
dando permissoes pro usuario criado
-sudo chown -R tomcat: /opt/tomcat
-sudo sh -c 'chmod +x /opt/tomcat/bin/*.sh'

criando servico no systemd pra que seja possivel usar comandos como systemd restart tomcat

foi preciso remover service da instalacao anterior:
systemctl stop tomcat
systemctl disable tomcat
rm /etc/systemd/system/tomcat // and symlinks that might be related
rm /usr/lib/systemd/system/tomcat // and symlinks that might be related
systemctl daemon-reload
systemctl reset-failed

-sudo nano /etc/systemd/system/tomcat.service
conteudo:
[Unit]
Description=Tomcat webs servlet container
After=network.target

[Service]
Type=forking

User=tomcat
Group=tomcat
RestartSec=10
Restart=always 
Environment="JAVA_HOME=/usr/lib/jvm/java-1.11.0-openjdk-amd64"
Environment="JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

Environment="CATALINA_BASE=/opt/tomcat"
Environment="CATALINA_HOME=/opt/tomcat"
Environment="CATALINA_PID=/opt/tomcat/temp/tomcat.pid"
Environment="CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC"

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

[Install]
WantedBy=multi-user.target

habilitando tomcat
-sudo systemctl daemon-reload
-sudo systemctl start tomcat
-sudo systemctl enable tomcat

status
-systemctl status tomcat --no-pager -l

adicionando permissoes ao usuario
-sudo nano /opt/tomcat/conf/tomcat-users.xml

dentro do arquivo:
<role rolename="admin"/>
<role rolename="admin-gui"/>
<role rolename="manager"/>
<role rolename="manager-gui"/>

<user username="h2s" password="pwd" roles="admin,admin-gui,manager,manager-gui"/>

restart
- sudo systemctl restart tomcat

liberando porta 8080
- sudo ufw allow 8080


## JSP objetos acessiveis em qualquer pagina de modo implicito (9 ao todo):
Objeto              Tipo
out                 JspWriter
request             HttpServletRequest
response            HttpServletResponse
config              ServletConfig
application         ServletContext
session             HttpSession
pageContext         PageContext
page                Object
exception           Throwable


## servlets
O nome “servlet” vem do inglês e dá uma ideia de servidor pequeno cujo objetivo basicamente é receber requisições HTTP, 
processá-las e responder ao cliente, essa resposta pode ser um HTML, uma imagem etc.

O funcionamento se dá da seguinte forma:

Cliente (navegador) faz uma requisição HTTP ao servidor.
O servlet responsável trata a requisição e responde ao cliente de acordo.
O cliente recebe os dados e exibe.
Para esse artigo abordaremos os comportamentos de servlet que foram definidos na classe 
HttpServlet do pacote javax.servlet, que é usada em quase em quase 99% dos casos.

Servlet definido, mas como acessá-lo pelo navegador? Para uma página HTML basta passarmos a url e pronto, 
ela é interpretada pelo navegador, mas acessar a nossa classe pela url seria muito complexo.

Para solucionar a questão, mapearemos nossa classe em URL’s dentro do arquivo web.xml que é criado 
dentro da pasta WEB-INF automaticamente pela ide que você esteja usando. No próximo tópico veremos a estrutura de diretórios.

Para mapearmos, usaremos as tags <servlet> e <servlert-mapping>.

Primeiro definiremos o nome do servlet e qual a classe dele. Depois diremos qual será a o caminho que ele ficará acessível. Vejam:

<servlet>
    <servlet-name>olaServlet</servlet-name>
    <servlet-class>br.servlets.OlaMundo</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>olaServlet</servlet-name>
    <url-pattern>/olaMundo</url-pattern>
</servlet-mapping>


## servlets vs jsp
no jsp o codigo fica misturadods no HTML e usando servlets os codigos ficam separados em arquivos
e o jsp apenas exibe a informaçao