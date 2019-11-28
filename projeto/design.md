
# Design detalhado: Benchmark para avaliadores de express�es matem�ticas

Al�m de permitir validar uma implementa��o de um avaliador de express�es, 
o presente _benchmark_ tamb�m considera relevante outros aspectos, quem devem
ser abordados em cinco m�dulos distintos:
- Desempenho: Tempo gasto para avalia��o de uma express�o.
- Mem�ria: Consumo de mem�ria incorrido ao avaliar express�es.
- Lat�ncia: Tempo gasto para pr�-processamento de uma express�o, caso
 exista esta op��o, sem incluir o tempo consumido na avalia��o da express�o.
- Carga: Tempo gasto para avalia��o de diversas express�es, simulando a utiliza��o extrema do avaliador para observar 
o seu comportamento em situa��es de estresse.
- Precis�o: Se a precis�o do resultado obtido pelo avaliador de express�es atende ao epsilon exigido como precis�o.  

#### Funcionamento b�sico

1. A partir do nome da classe � obtida uma inst�ncia de _Adapter_. 

2. Para cada linha de teste do arquivo de entrada, um inst�ncia de _BancadaDeTestes_ � criada. 

3. Conv�m observar que para cada _Teste_ retornado pela inst�ncia de _BancadaDeTestes_, por meio do m�todo _get_, 
obt�m-se a express�o correspondente, a partir da qual, por meio da inst�ncia de _Adapter_ obt�m-se a inst�ncia de 
_Expressao_ correspondente. 

4. Este �ltimo objeto recebe a mensagem _avaliacao_ cujo argumento � o conjunto de valores. O retorno � verificado
com aquele do teste. 

5. Se o valor retornado difere do esperado, ent�o o _benchmark_ � interrompido. 

6. Caso contr�rio, o tempo gasto ser� acumulado.  


# Valida��o da corre��o

A valida��o da corre��o de uma implementa��o ser� fornecida por meio de um arquivo CSV contendo tr�s colunas, na ordem 
descrita abaixo:

- Express�o: Por exemplo, 2*(3-x).

- Vari�veis. Valores das vari�veis a serem utilizadas na avalia��o da express�o  ser�o fornecidas separadas por v�rgula.
 Por exemplo, para a express�o acima podemos ter x=10. Se a express�o faz uso de mais de uma vari�vel, ent�o os valores
 devem ser separados por v�rgula. Por exemplo, para a express�o "a + b", os valores das vari�veis podem ser 
 "a=1,b=3.4", por exemplo.
 
- Resultado. O valor da express�o. Por exemplo, para a express�o acima e o  valor de x igual a 10 (x=10), o resultado 
� -14. Caso a express�o seja inv�lida, ent�o o resultado deve ser a  sequ�ncia "ERRO". Por exemplo, se a  express�o 
fornecida � "2*)", ent�o o resultado deve ser "ERRO", pois n�o se trata de uma express�o v�lida. 
  
  |   Express�o   |  Vari�veis  |    Resultado    |
  |     :---:     |     :---:   |       :---:     |
  | 2*(3-x)       |      x=5    |         -4      |
 
# Conceitos

#### Avaliador  
Biblioteca ou servi�o que implementa a avalia��o de express�es matem�ticas. 

#### Adaptador
C�digo respons�vel por requisitar a avalia��o de express�es matem�ticas pelo Avaliador. Deve ser produzido um adaptador 
para cada Avaliador. 

# Classes esperadas

- Toda implementa��o a ser avaliada pelo presente _benchmark_ deve incluir as classes/interfaces identificadas abaixo. 

#### Aplicativo (classe)
Ponto de entrada para execu��o do _benchmark_. Este aplicativo recebe como entrada um arquivo txt indicando o que 
dever� ser executado pelo _benchmark_.

- Nome da classe que implementa o adaptador
- Nome de arquivo CSV contendo testes seguida da quantidade de vezes em que dever� ser executado. 
- Repete zero ou mais vezes o item anterior. 

O retorno ser� um relat�rio indicando o tempo gasto na execu��o de cada um dos testes (linha de teste do arquivo de 
entrada).

#### Expressao (interface)
Esta interface deve possuir o m�todo _avaliacao_.

#### Adapter (interface)
Esta interface possui o m�todo _Expressao getExpressaoPara(String expressao)_. A execu��o deste m�todo inclui a 
prepara��o da express�o fornecida, caso exista, antes que seja executada. 

#### AdapterFactory (classe)
Produz uma inst�ncia de _Adapter_ por meio do m�todo _newInstance(String nomeDaClasse)_.

### Teste (classe)
Uma inst�ncia desta classe possui uma express�o (String), um valor para cada uma das vari�veis empregadas na express�o 
e o resultado correspondente. 

### BancadaDeTestes implements Supplier<Teste>
O construtor recebe como argumento o nome de um arquivo CSV cujas tr�s colunas s�o, nesta ordem: 
(a) express�o; 
(b) valores para as vari�veis empregadas pela express�o (se for o caso); 
(c) o resultado da avalia��o da express�o com os valores fornecidos. 

O m�todo _get_ ser� empregado para recuperar, um por um, na ordem em que aparecem no arquivo CSV, os testes contidos 
neste arquivo. 

#### - [AvaliadorCarga](projeto/src/avaliadores/AvaliadorCarga.java)
Classe que avalia o desempenho de uma implementa��o de um avaliador de express�es em situa��o de carga.

#### AvaliadorConsumoMemoria (classe)
Classe que avalia o consumo de mem�ria de uma implementa��o de um avaliador de express�es.

#### AvaliadorDesempenho (classe)
Classe que avalia o desempenho de uma implementa��o de um avaliador de express�es.

#### AvaliadorDesempenho (classe)
Classe que avalia a lat�ncia de uma implementa��o de um avaliador de express�es.

#### AvaliadorDesempenho (classe)
Classe que avalia a precis�o dos resultado obtidos por uma implementa��o de um avaliador de express�es.

## Cen�rios

### 1 Constante 1
A express�o formada apenas deste d�gito 1 � executada 10, 100, 1000, 10.000, 100.000 e 1.000.000 de vezes, produzindo 
seis valores. 

### 2 Constante -12.45678

Idem do anterior. 



