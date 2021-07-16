# Sobre
Esse projeto é um simples gerenciador de tarefas.

# Build
Para compilar e rodar o projeto é necessário ter o maven instalado. Rode o comando:
```sh
maven install
```
Isso irá gerar um arquivo `.war` no diretório `target`. O deploy pode ser feito em um servidor tomcat ou glassfish. O código não foi testado em outros servidores

# Banco de dados
Esse projeto utiliza banco de dados Postgresql. Para se conectar com o bando de dados crie um arquivo `persistence.xml` no diretório `src/main/resources/META-INF` com os dados do seu banco de dados.

Também será necessário rodar o script `init_db.sql` para criar a tabela utilizada.

# Deploy
Para fazer deploy no heroku rode o seguinte comando:
```sh
heroku war:deploy target/SigTarefas.war --app enthousiaste-monsieur-99455
```

