# Framework de testes automatizados de APIs (Portifolio)

**Esse projeto entrega, uma estrutura completa para automação para testes para APIs, usando os melhores frameworks e práticas.**
Esse framework possui exemplos de testes que precisam ser autenticados, então usei algumas bibliotecas como lombok jakson para criar a class de autenticação.


## Linguagens e Frameworks utilizados

O projeto utiliza as seguintes linguagens e frameworks:

* [Java 17](https://openjdk.java.net/projects/jdk/17/) linguagem usada para desenvolver o projeto
* [JavaFaker](https://github.com/DiUS/java-faker) utilizado para a geração de massas randômicas
* [Owner](http://owner.aeonbits.org/) utilizado para minimizar a quantidade de código necessário para usar os arquivos .properties
* [Junit5](https://junit.org/junit5/) Junit5
* [Allure report](https://github.com/allure-framework/allure-maven) framework usado para gerar o nosso report dos testes
  
## Arquitetura dos Testes

Esse projeto tem o intuito de acelerar e facilitar a criação de uma boa arquitetura para seus testes automatizados.
Ele deve ser usado como abordagem inicial, para a construção de testes automatizados com entregas mais rápidas, simples e eficiente.

Nesse projeto você verá as seguintes arquiteturas e design patterns:

* [Pojo pattern](#pojo-pattern)
* [Allure-reports](#allure-report)
* [Lombok](#lombok)
* [Jakson](#jakson)
  
### Pojo Pattern
Resumidamente:
O padrão POJO (Plain Old Java Object) é uma abordagem de design em programação Java que enfatiza a simplicidade e a clareza do código. O objetivo do padrão POJO é criar classes simples e independentes de estruturas complexas ou frameworks, facilitando a manutenção, reutilização e teste do código. Em essência, um POJO é uma classe Java com as seguintes características

###Allure Report
Allure Report que é um framework que permite a geração de relatórios automáticos de teste

###Lombok
O Lombok é uma biblioteca Java focada em produtividade e redução de código boilerplate

###Jakson
Jackson é uma excelente biblioteca para lidar com a transformação de texto em código.

### Execução

Clonando o projeto e instalando as dependências necessárias, o projeto pode ser executado via terminal mvn test para execução dos testes e allure serve target/allure-results para exibir o relatório, neste framework não optei por usar cucumber e sim por usar displayname mas para adicionar o cucumber é bem simples.

developed by Bonfatti




