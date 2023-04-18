# Projeto-Java-Web-Coordenador
Projeto Java Web referente a matéria Programação Web 
Tecnlogias Utilizadas:
- JSP
- PostgreSql
- JavaScript
- Java
- Css
- Apache TomCat versão 9.0

Para utilizar a aplicação no WINDOWS é necessário baixar os seguintes programas:

. Eclipse ide for Enterprise java and web, onde você encontra o download no seguinte link:
(https://www.eclipse.org/downloads/packages/release/2023-03/r/eclipse-ide-enterprise-java-and-web-developers)
. Apache Tomcat versão 9.0, disponível no seguinte link: (https://tomcat.apache.org)

. PostgreSQL, disponível também no seguinte link: ( https://www.postgresql.org/download/ )

—-------------------------------------------------------------------------------------------------

Para utilizar a aplicação no LINUX é necessário baixar os seguintes programas:

JDK

O primeiro passo para criar uma plataforma de desenvolvimento Java é a instalação do JDK (Java Development Kit), como veremos no passo a passo a seguir: ( pode ser utilizado no Ubuntu ).

Abra o terminal e execute o comando sudo add-apt-repository ppa:webupd8team/java e dê enter.
Atualize a lista de pacotes disponíveis com o comando sudo apt-get update.
Digite o comando sudo apt-get install oracle-java7-installer para a instalação do JDK. Em seguida, aparecerá uma mensagem perguntando se você deseja continuar. Digite S e dê enter.
Aparecerá outra mensagem. Dê enter novamente.
A próxima mensagem é para aceitar os termos de licença do Oracle Binary Code. Escolha a opção “Sim”.
Aguarde o download terminar e confira a mensagem de instalação com sucesso do JDK.
Execute o comando java -version e, em seguida, javac -version para verificar a versão do JDK instalada e do compilador.
______________________________________________

Java EE

Para iniciar sua instalação, é necessário baixar a versão mais recente no site do próprio Eclipse, selecionando a arquitetura de seu sistema (32 ou 64 bit) e clicar na opção download. Depois, siga o passo a passo:


Abra o terminal e descompacte o arquivo tar.gz, executando o comando tar -xvzf eclipse-jee-mars-R-linux-gtk-x86_64.tar.gz;
Depois de descompactado, mova o Eclipse para o diretório /opt, com o comando sudo mv eclipse /opt;
Execute o comando sudo nano /usr/share/applications/eclipse.desktop para criar o Link do Eclipse em seu Desktop;
Cole o bloco de código abaixo, com o arquivo aberto:
[Desktop Entry]
Name=Eclipse Luna
Type=Application
Exec=/opt/eclipse/eclipse
Terminal=false
Icon=/opt/eclipse/icon.xpm
Comment=Integrated Development Environment
NoDisplay=false
Categories=Development;IDE;
Name[en]=Eclipse

- Por fim, para salvar as alterações feitas, dê um Ctrl + O e Enter. Para sair, Ctrl + X. Agora, já é possível visualizar o icone.

__________________________________________________

Tomcat

O Tomcat é um container de servelets e deve ser instalado para criar um ambiente Java ee em seu Linux. Veja os 4 passos para a instalação:

Faça o download do Tomcat no site oficial do servidor, clicando na opção “tar.gz”, em Binary Distributions, e salve em um diretório;
Abra o terminal para descompactar o Tomcat no diretório escolhido, com o comando tar -zxvf apache-tomcat-8.0.26.tar.gz;
Agora, mova o Tomcat para a pasta /etc, com o comando sudo mv apache-tomcat-8.0.26 /etc;
Por fim, é necessário dar permissão na pasta para quando for executar o Eclipse. Use o comando sudo chmod 775 /etc/apache-tomcat-8.0.26/ no terminal.
______________________________________________




Configurações do Tomcat no Eclipse
Depois de seguir os passos acima, é hora de configurar a execução do Tomcat pelo Eclipse:
Abra o Eclipse e selecione a pasta onde você salvará seus projetos;
Clique na opção “Workbench”, disposta no lado direito da tela;
Abra a aba Server e clique na opção “No servers are available. Click this link to create a new server para adicionar o Tomcat”;
Em seguida, basta selecionar o Tomcat na pasta Apache e clicar em “Next”;
Em Browser, selecione o diretório do Tomcat e clique em “Finish”.
______________________________________________
PostgreSQL
Lembre-se: antes de começar os passos abaixo, você precisa acessar a sua VPS pelo SSH. Dê uma olhada nesse tutorial Putty para saber como fazer isso.
Para começar a usar a aplicação, faça a atualização do índice do pacote local:
sudo apt update
Então, instale o PostgreSQL e o pacote contrib, que fornece recursos adicionais. Para esta tarefa, use o comando abaixo:
sudo apt install postgresql postgresql-contrib
Este comando instala o PostgreSQl. Para usá-lo, agora você vai precisar fazer algumas configurações básicas.


Verificação do PostgreSQL
Agora que você completou a instalação do Postgres no Ubuntu, os serviços vão ser executados automaticamente.
Como um primeiro passo, verifique a instalação conectando ao banco de dados PostgreSQL com psql.
O psql é uma linha de comando usada para interagir com o servidor PostgreSQL. Isso vai mostrar a versão do servidor.


sudo -u postgres psql -c "SELECT version();"


Para logar no PostgreeSQL como um usuário postgre, você pode usar o psql. Isso pode ser feito como mostrado abaixo:


sudo su – postgres


Para usar o Postgre, digite no terminal:


psql


Isso vai garantir o acesso ao PostgreSQl. Se você quiser sair da sessão, basta usar: 


\q
___________________________________________________________________________
