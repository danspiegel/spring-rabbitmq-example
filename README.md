## Processo para rodar a aplicação local

- Tenha o Docker instalado na máquina.
- Faça um clone do projeto para a sua máquina.
- Na raiz da projeto rode o comando "mvn clean install".
- Navegue até o diretório "rabbitmq" do projeto e rode o comando "docker-compose up" para subir o container do RabbitMQ e as filas.
- Para testar a aplicação coloque um JSON na fila "events.business.produtos" no mesmo formato do JSON "produto_exemplo.json" da pasta "json" do projeto.
