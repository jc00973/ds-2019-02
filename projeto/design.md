
# Design detalhado: Benchmark para avaliadores de express�es matem�ticas

Al�m de permitir validar uma implementa��o de um avaliador de express�es, 
o presente _benchmark_ tamb�m considera relevante outros aspectos:

- Desempenho: Tempo gasto para avalia��o de uma express�o.
- Mem�ria: Consumo de mem�ria incorrido ao avaliar express�es.
- Lat�ncia: Tempo gasto para pr�-processamento de uma express�o, caso  exista esta op��o, sem incluir o tempo consumido
 na avalia��o da express�o.
- Carga: Tempo gasto para avalia��o de diversas express�es, simulando a utiliza��o extrema do avaliador para observar 
o seu comportamento em situa��es de estresse.
- Precis�o: Se a precis�o do resultado obtido pelo avaliador de express�es atende ao epsilon exigido como precis�o. 

Este benchmark foi pensado para abordar os cincos crit�rios de avalia��o por meio do padr�o de projeto Strategy, havendo
uma interface _Avaliador_ e as tr�s classes que a implementam: _ConsumoMemoria_, _Desempenho_ e _Latencia_.

Os crit�rios de carga e precis�o foram definidos como preliminares a qualquer um dos tr�s tipos de crit�rios de avalia��o
acima. 

A precis�o � abordada como um par�metro que deve ser informado juntamente com a pr�pria express�o, os valores de
suas vari�veis e o resultado. A compara��o do resultado obtido com o esperado � realizada considerando o intervalo de 
precis�o informado.

O crit�rio de carga tamb�m � abordado de maneira integrada aos demais crit�rios. Justamente com os quatro par�metros
citados acima, a quantidade de repeti��es tamb�m deve ser informada a cada caso de teste inserido. Com isso, o intuito
� dar autonomia ao Avaliador devido a possibilidade de personalizar a avalia��o da carga.

Ao decorrer do documento, todos esse pontos s�o explicados detalhadamente, com [exemplos de implementa��o](projeto/).

 ### Conceitos fundamentais

  #### Avaliador de Express�o  
  - Biblioteca ou servi�o que implementa a avalia��o de express�es matem�ticas. 

  #### Adaptador
  - C�digo respons�vel por requisitar a avalia��o de express�es matem�ticas pelo Avaliador. Deve ser produzido um 
  adaptador para cada Avaliador de Express�o. 

 ### Fluxo principal de funcionamento:

  ##### 01
   - A partir do nome da classe � obtida uma inst�ncia de _Adapter_. 
    
  ##### 02   
   - Para cada linha de teste do arquivo de entrada, um inst�ncia de _Teste_ � criada em _BancadaDeTestes_. 
    
  ##### 03
   - Para cada _Teste_ retornado pela inst�ncia de _BancadaDeTestes_, por meio do m�todo _get_, 
   obt�m-se a express�o correspondente, a partir da qual, por meio da inst�ncia de _Adapter_ obt�m-se a inst�ncia de 
   _Expressao_ correspondente. 
    
  ##### 04
  - Este �ltimo objeto recebe a mensagem _avaliacao_ cujo argumento � o conjunto de valores. O retorno � verificado
    com aquele do teste. 
  - Se o valor retornado difere do esperado, ent�o o caso de teste retorna um valor correspondete ao erro.    
  - Ao final, o benchmark retorna um arquivo txt contendo o relat�rio da avalia��o realizada.  

### Valida��o da corre��o

A valida��o da corre��o de uma implementa��o ser� fornecida por meio de um arquivo CSV contendo cinco colunas, na ordem 
descrita abaixo:

- Vari�veis: Valores das vari�veis a serem utilizadas na avalia��o da express�o  ser�o fornecidas separadas por v�rgula.
 Por exemplo, para a express�o acima podemos ter x=10. Se a express�o faz uso de mais de uma vari�vel, ent�o os valores
 devem ser separados por v�rgula. Por exemplo, para a express�o "a + b", os valores das vari�veis podem ser 
 "a=1,b=3.4", por exemplo.
 
- Express�o: Por exemplo, 2*(3-x).

- Resultado: O valor da express�o. Por exemplo, para a express�o acima e o  valor de x igual a 10 (x=10), o resultado 
� -14. Caso a express�o seja inv�lida, ent�o o resultado deve ser a  sequ�ncia "ERRO". Por exemplo, se a  express�o 
fornecida � "2*)", ent�o o resultado deve ser "ERRO", pois n�o se trata de uma express�o v�lida. 

- Quantidade de repeti��es: A quantidade de vezes que o mesmo caso de teste deve ser efetuado. � necess�rio que o valor
m�nimo seja 1, caso contr�rio, a avaliadar n�o ser� executada e o valor retornado para o teste em quest�o ser� 
-1, que indica que a avalia��o n�o foi executada.

- Intervalo de precis�o: Deve-se especificar qual o intervalo m�ximo toler�vel de diverg�ncia entre a resposta dada pelo
Avaliador de Express�o e o resultado esperado.


#### Exemplo do conte�do do arquivo CSV com os casos de teste: 
  
<!--
  |   Express�o   |  Vari�veis  |    Resultado    |    Repeti��es   |     Precis�o    |
  |     :---:     |     :---:   |       :---:     |       :---:     |       :---:     |
  | 2*(3-x)       |      x=5    |         -4      |          1      |         0.1     |
  | x+y/2         | x=2,y=10    |          7      |          3      |         0.1     |
  | (x-z)*(y-x/z) | x=5,y=6,z=2 |         10,5    |          1      |         0.1     |
  | x^x           |      x=3    |         27      |          1      |         0.1     |
  | x^x/2         |      x=2    |         2       |          500    |         0.1     |
--> 

  |               |             |                 |                 |                 |
  |     :---:     |     :---:   |       :---:     |       :---:     |       :---:     |
  | 2*(3-x)       |      x=5    |         -4      |          1      |         0.1     |
  | x+y/2         | x=2,y=10    |          7      |          3      |         0.1     |
  | (x-z)*(y-x/z) | x=5,y=6,z=2 |         10,5    |          1      |         0.1     |
  | x^x           |      x=3    |         27      |          1      |         0.1     |
  | x^x/2         |      x=2    |         2       |          500    |         0.1     |


### Classes esperadas

- Toda implementa��o a ser avaliada pelo presente _benchmark_ deve incluir as classes/interfaces identificadas abaixo.

- Foi adotado o padr�o de projeto Strategy para abordar os tr�s tipos poss�veis de avalia��o (desempenho, consumo de 
mem�ria e lat�ncia), conforme o diagrama de classes abaixo:

![Diagrama de classes Strategy](diagramas/png/strategy.png)

- O benchmark deve ser implementado de acordo com o diagrama de sequ�ncia e demais instru��es abaixo:

![Diagrama de sequ�ncia](diagramas/png/sequencia.png)

#### [Aplicativo](src/Aplicativo.java) (classe)
Ponto de entrada para execu��o do _benchmark_. A classe deve ser implementada seguindo o fluxo esperado abaixo:

1) Esta classe recebe como entrada um arquivo txt indicando o que dever� ser executado pelo _benchmark_. Cada uma 
das informa��es abaixo deve contar em uma linha distinta.

- Nome da classe que implementa o adaptador (String nomeDaClasse)
- Caminho do diret�rio contendo o nome do arquivo CSV que cont�m os testes (String caminhoArquivoCsv;).
- C�digo de um dos tr�s tipos de avalia��o desejado (String codigoTipoAvaliacao):
    (1) Desempenho;
    (2) Consumo de mem�ria;
    (3) Lat�ncia.
- Caminho do diret�rio onde o relatorioResultado.txt deve ser escrito (String caminhoRelatorioResultado).

##### Exemplo de arquivo txt de entrada:
        
        /home/argos/Desktop/AvaliadorMatematico/src/AdapterInstantiator.java
        testes.csv
        3
        /home/argos/Desktop/        
        
2) Em seguida, a classe Aplicativo dever� acessar o arquivo.csv e converter cada linha em par�metros que ser�o enviados
para _BancadaDeTestes_ para que ela crie e armazene uma inst�ncia de _Teste_. 

3) Ao final das instancia��es dos testes, a classe _BancadaDeTestes_ retorna um List<Teste> testes.

4) O Aplicativo ent�o, de acordo com o codigoTipoAvaliacao, acessa a implementa��o da interface _Avaliador_ 
correspondente, e executa o m�todo avaliar() da implementa��o.

5) A implementa��o do _Avaliador_ ir� realizar as opera��es de instancia��o conforme o diagrama de sequ�ncias contido
acima. No final de cada utiliza��o do m�todo avaliar(), ela retorna o resultado da avalia��o.

6) Cada resultado retornado � armazenado na List<String> resultados, indexando os resultados na ordem que aparecem no
arquivo.csv.

7) Ao final dos acessos ao m�todo avalia(), a lista de resultados � convertida em um arquivo relatorioAvaliacao.txt,
que � escrito no caminho informado pelo Avaliador de Express�o.

Detalhes do relatorioAvaliacao.txt: O resultado de cada teste � dado na mesma linha em que o teste aparece no arquivo 
CSV. Este resultado deve indicar, respectivamente ao tipo de avalia��o:
    (1) Desempenho: o tempo gasto na execu��o de cada um dos testes (linha de teste do arquivo de entrada);
    (2) Consumo de mem�ria: a mem�ria gasta na execu��o de cada um dos testes;
    (3) Lat�ncia: a lat�ncia (tempo de execu��o do m�todo getExpressaoFor) antes da execu��o de cada teste.
    
##### Exemplo de arquivo txt de sa�da no caso de teste de desempenho:
        
        TESTE DE DESEMPENHO
        
        1. 116 ms
        2. 34 ms
        3. 42 ms
        4. 35 ms
        5. 41 ms
        6. 33 ms   
        
##### Exemplo de arquivo txt de sa�da no caso de teste de lat�ncia:
        
        TESTE DE DESEMPENHO
        
        1. 416 ms
        2. 334 ms
        3. 422 ms
        4. 345 ms
        5. 451 ms
        6. 363 ms   
        
##### Exemplo de arquivo txt de sa�da no caso de teste de consumo de mem�ria:
        
        TESTE DE DESEMPENHO
        
        1. 45454 bytes
        2. 22234 bytes
        3. 12233 bytes
        4. 23423 bytes
        5. 55443 bytes
        6. 9894 bytes  
        

#### [Expressao](src/adaptador/Expressao.java) (interface)
Esta interface deve possuir o m�todo _avaliar_. Essa interface deve ser implementada pelo Avaliador de Express�o.

#### [Adapter](src/adaptador/Adapter.java) (interface)
Esta interface possui o m�todo _Expressao getExpressaoFor(String expressao)_. A execu��o deste m�todo inclui a 
prepara��o da express�o fornecida, caso exista, antes que seja executada. Essa interface deve ser implementada pelo 
Avaliador de Express�o.

#### [FactoryAdapter](src/adaptador/FactoryAdapter.java) (classe)
Produz uma inst�ncia de _Adapter_ por meio do m�todo _newInstance(String nomeDaClasse)_.

#### [Teste](src/test/Teste.java) (classe)
Uma inst�ncia desta classe possui uma express�o (String), um valor para cada uma das vari�veis empregadas na express�o, 
o resultado correspondente, a quantidade de repeti��es e o intervalo de precis�o exigido. 

#### [BancadaDeTestes](src/test/BancadaDeTestes.java) implements Supplier<Teste>
O construtor recebe como argumento o nome de um arquivo CSV cujas cinco colunas s�o, nesta ordem: 

 (a) Vari�veis.
 (b) Express�o.
 (c) Resultado.
 (d) Quantidade de repeti��es.
 (e) Intervalo de precis�o.

O m�todo _get_ ser� empregado para recuperar, um por um, na ordem em que aparecem no arquivo CSV, os testes contidos 
neste arquivo. 

#### [AvaliadorConsumoMemoria](src/avaliadores/ConsumoMemoria.java) (classe)
- Classe que verifica o consumo de mem�ria da implementa��o do Avaliador de Express�o durante a avalia��o de uma express�o. A
ferramenta utilizada na verifica��o do consumo de mem�ria s�o as fun��es _totalMemory()_ e _freeMemory()_, ambas da 
classe [Runtime](https://docs.oracle.com/javase/7/docs/api/java/lang/Runtime.html) (clique para abrir a documenta��o da 
classe). As fun��es podem ser usadas como abaixo:

    ````java
    Runtime runtime = Runtime.getRuntime();
    
    long memoriaUtilizadaAntes = runtime.totalMemory() - runtime.freeMemory();  
    double resposta = exp.avaliar(variaveis);
    long memoriaUtilizadaDepois = runtime.totalMemory() - runtime.freeMemory(); 
    long memoriaUtilizada = memoriaUtilizadaDepois - memoriaUtilizadaAntes;
    ```` 

#### [AvaliadorDesempenho](src/avaliadores/Desempenho.java) (classe)
- Classe que avalia o desempenho da implementa��o do Avaliador de Express�o durante a avalia��o de uma express�o. O desempenho 
consiste no intervalo de tempo entre o in�cio e o final da avalia��o a express�o, e s� � considerado caso a resposta
seja compat�vel com o resultado esperado. A ferramenta utilizada na avalia��o ser� o m�todo _CurrentTimeMillis()_, da
classe [System](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html) (clique para abrir a documenta��o da 
classe), conforme o exemplo abaixo:

    ````java
    long inicio = System.currentTimeMillis();
    double resposta = exp.avaliar(variaveis);
    long termino = System.currentTimeMillis();
    long tempoEmMilissegundo = termino - inicio;
    ````

#### [AvaliadorLatencia](src/avaliadores/Latencia.java) (classe)
- Classe que avalia a lat�ncia do Avaliador de Express�o antes a avalia��o de uma express�o. A lat�ncia se caracteriza como o per�odo
de tempo gasto na execu��o do m�todo _preparar()_ que deve estar presente na interface Adapter. A forma de verifica��o
desse intervalo de tempo tamb�m pode ser o m�todo _CurrentTimeMillis()_, da classe System.

<!--

#### Cen�rios

##### 1 Constante 1
A express�o formada apenas deste d�gito 1 � executada 10, 100, 1000, 10.000, 100.000 e 1.000.000 de vezes, produzindo 
seis valores. 

##### 2 Constante -12.45678

Idem do anterior. 

-->

