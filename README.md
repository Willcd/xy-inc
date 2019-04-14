
# PoIsApplication 
>Essa api disponibiliza os  serviços descritos .

* Serviço para cadastrar pontos de interesse com 3 atributos:
	- Nome do POI.
	- Coordenada X.
	- Coordenada Y. 

* Serviço para listar todos os POIs cadastrados.

* Serviço para listar POIs por proximidade. 

	* Este serviço recebe uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço retorna todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

> Os cálculos são baseados no Sistema de coordenadas cartesiano, considerando apenas valores inteiros não-negativos para registro de pontos.

## Começando 

Essas instruções farão com que você tenha uma cópia do projeto em execução na sua máquina local para fins de desenvolvimento e teste.

### Pré-requisitos 

-   [     JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

-   [Spring Tool Suite](https://spring.io/guides/gs/sts/) - IDE baseada em Eclipse - [Eclipse IDE](http://www.eclipse.org/downloads/eclipse-packages/)

-   [Apache Maven](https://maven.apache.org/download.cgi) - Gerenciamento de Dependência

-   [Spring Tools 4 - Spring Framework](https://spring.io/tools) - O framework utilizado no desenvolvimento

-   [MySQL](https://www.mysql.com/)

-   [Git](https://git-scm.com/downloads)

### Etapas para a instalação

**1. Clone o aplicativo**

``
git clone https://github.com/Willcd/xy-inc.git
``

**2. Crie o banco de dados Mysql**

``
create database xyPOIs;
``

**3. Altere o nome de usuário e a senha do mysql conforme sua instalação**

-   abrir ``src/main/resources/application.properties``

-   mudar ``spring.datasource.username`` e  ``spring.datasource.password`` conforme sua instalação do mysql

- repetir o processo em  ``src/test/resources/test.properties``

**4. Execute o aplicativo**

#### *Construa e execute o aplicativo usando maven*

Abra a pasta do projeto no terminal e use os seguintes comandos:

`` package mvn ``

`` cd target/``

``java -jar POIs-0.0.1-SNAPSHOT.jar``

O aplicativo começará a ser executado em [http://localhost:8080](http://localhost:8080/).

#### *Executando a partir de um IDE*

Importe o projeto. Os usuários do Eclipse ou STS podem selecionar 

``
File -> Import... -> General -> Projects from Folder or Archive.
``

Após a importação do projeto, clique com o botão direito do mouse sobre o projeto e então selecione

``
Run As -> Spring Boot App
``

##

### É possível executar/testar os serviços utilizando um client HTTP.  

POST -`` localhost:8080/xypois``
 
	{
	 "name": "< String >",
	 "x": < int >,
	 "y": < int >
	 }
* ##### Durante a implementação do aplicativo, foi utilizado Postman para teste e inserção dos dados.
##
#### Os serviços GET podem ser testados com uso de navegador web.
GET - `` localhost:8080/xypois/all``

***`` localhost:8080/xypois/all``***
##

GET - ``localhost:8080/xypois/?x=< int >&y=< int >&d-max=< int >``

***``localhost:8080/xypois/?x=20&y=10&d-max=10``***

##