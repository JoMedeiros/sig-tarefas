# Sobre
Esse projeto é um sistema de gerenciamento de tarefas.

# Build
Para compilar e rodar o projeto é necessário ter o maven instalado. 
Execute o comando:

```sh
maven clean install
```
Isso irá gerar um arquivo `.war` no diretório `target`. O deploy pode ser feito em um servidor tomcat ou glassfish. O código não foi testado em outros servidores

# Banco de dados
Esse projeto utiliza banco de dados Postgresql. Para se conectar com o bando de dados crie um arquivo `persistence.xml` no diretório `src/main/resources/META-INF` com os dados do seu banco de dados.

É importante registrar as entidades no aquivo 
`persistence.xml` adicionando as seguintes linhas:

```xml
<?xml ... >
<persistence ... >
...
	<persistence-unit ... >
...
		<class>br.com.esig.sigtar.model.Tarefa</class>
		<class>br.com.esig.sigtar.model.Usuario</class>
...
```

Um arquivo `persistence.xml` de exemplo conectando-se a um database
 `sigtarefa` servindo em `locahost` na porta `5432`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2"
	xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
	<persistence-unit name="dev_sigtar">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<class>br.com.esig.sigtar.model.Tarefa</class>
		<class>br.com.esig.sigtar.model.Usuario</class>
		<properties>
			<property name="javax.persistence.jdbc.driver"
				value="org.postgresql.Driver" />
			<property name="javax.persistence.jdbc.url"
				value="jdbc:postgresql://localhost/sigtarefa" />
			<property name="javax.persistence.jdbc.user"
				value="postgres" />
			<property name="javax.persistence.jdbc.password"
				value="123456" />
			<property name="hibernate.dialect"
				value="org.hibernate.dialect.PostgreSQLDialect" />
			<property name="hibernate.hbm2dll.auto" value="update" />
		</properties>
	</persistence-unit>
</persistence>
```

Também será necessário rodar o script `init_db.sql` para criar as tabelas.

# Deploy
Para fazer deploy no heroku rode o seguinte comando:

```sh
heroku war:deploy target/SigTarefas.war --app nome-do-seu-app-criado-no-heroku
```
