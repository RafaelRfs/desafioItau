sistema:

API REST que recebe Transações e dá estatísticas sob essas transações.
criada em Java com SpringBoot; O seguinte programa calcula as estatisticas 
das transações enviadas e faz a manutenção das mesmas e exclusão;

- O metódo de armazenamento dos dados escolhido foi
o uso de dados da memória JVM, pois o requisito era 
que não fosse utilizado nenhuma base de dados e armazenamento
em arquivo;

Documento da Collection na rais do projeto:


EndPoints:

Inserir transação:
Metodo   URL
POST http://13.59.158.37:8080/v1/transacao

{
    "valor": 100,
    "dataHora": "2020-08-07T10:11:12.000Z"
 }

Regras de negócio:
Uma transação aceita DEVE gerar uma resposta 201 Created sem nenhum corpo;
Uma transação recusada DEVE gerar uma resposta 422 Unprocessable Entity sem nenhum corpo;

valor: escolhido o tipo de dados BigDecimal
pela precisão exata dos dados em comparação 
a valores como Double e long;

dataHora: LocalDateTime
valor: escolhido por causa da precisão e conversão
de tempo;


Obter Estatisticas:
Metodo   URL
GET http://13.59.158.37:8080/v1/desafio/estatistica

retorna-se as estatisticas com os dados semelhante a esta:
{
    "count": 10,
    "sum": 8192,
    "avg": 820,
    "min": 100,
    "max": 999
}


Excluir Estatisticas:
Metodo   URL
DELETE 13.59.158.37:8080/v1/desafio/

Exclui-se todos os dados das estatisticas
armazenadas na memoria JVM;


Caracteristicas do sistema:
- Testes unitarios/integrados com EvoSuite;
- Java 8;
- Springboot;
- Clean Architecture;

Regras :
Este sistema NÃO DEVE utilizar nenhum outro sistema ou biblioteca de amazenamento de dados (por exemplo: H2, SQLite, MongoDB, etc.) ou Cache (Redis, Infinispan, Memcached, Ehcache, etc.); - OK , usando JVM
Esta API DEVE aceitar e responder apenas com JSON; - OK
Esta API DEVE ser Thread-safe. Isso signfica que todos os endpoints poderão estar sendo chamados a qualquer momento e em qualquer ordem e não devem quebrar por isso; - OK
Este sistema DEVE ter testes unitários (em coisas como Services, por exemplo); - OK
Lembre de usar uma arquitetura Hexagonal ou Clean Code - OK


Esta sessão apresenta desafios extras para que você teste seus conhecimentos ao máximo, ou simplesmente queira fazer uma API com uma qualidade excepcional! São pontos desejáveis, mas não são obrigatórios.
    1. Testes para a Thread-safety do seu código: Você consegue testar se seu código realmente é thread-safe?
		Sim, utilizei os Streams para fazer processamento dos dados, sendo o principal de processamento, o Parallel Stream do Java 8;

    2. Tratamento de erros: Você consegue tratar erros de validação e entrada inválida usando recursos do Spring Boot?
	Sim, estou usando o Log4j para armazenamento dos logs e o Amazon Cloud Watch para a Cloud publica;

    3. Performance 1: Quantas transações por segundo você consegue processar? Como você calculou isso? Você consegue melhorar esse número?
	Sim, estou usando o Actuator para Springboot, e o mesmo gera métricas que são possiveis verificar a quantidade de requisições:
		Link: http://13.59.158.37:8080/actuator/metrics/http.server.requests


    4. Performance 2: O endpoint GET /estatistica pode retornar em tempo constante (também conhecido como O(1)). Você consegue fazer isso?
	Sim

    5. Modernização: Você consegue containerizar sua API?
	Sim, foi criado- se um Dockerfile para criação de imagens Docker

    6. Observabilidade: Sua aplicação tem um endpoint de checagem de saúde da API (healthcheck)? Você publica métricas do sistema?
	Sim, pelo Actuator há um Endpoint de métricas:
		Link: http://13.59.158.37:8080/actuator/health

    7. Documentação: Sua aplicação está documentada? Há informações de como executá-la, como construí-la, etc.
	Sim, a mesma está documentada pelo Swagger:
		Link: http://13.59.158.37:8080/swagger-ui.html


Adicionais:
	Testes unitarios e de Integração com Junit;
	
	Esteira de CI/CD com Git, AWS Elastic Beanstalk, AWS CodePipeline e CodeDeploy, EC2, e Cloud Watch;







