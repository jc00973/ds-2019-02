
# Design detalhado: Benchmark para avaliadores de expressões matemáticas

Além de permitir validar uma implementação de um avaliador de expressões, 
o presente _benchmark_ também considera relevante outros aspectos, quem devem
ser abordados em cinco módulos distintos:

- Desempenho: Tempo gasto para avaliação de uma expressão.

- Memória: Consumo de memória incorrido ao avaliar expressões.

- Latência: Tempo gasto para pré-processamento de uma expressão, caso  exista esta opção, sem incluir o tempo consumido
 na avaliação da expressão.
 
- Carga: Tempo gasto para avaliação de diversas expressões, simulando a utilização extrema do avaliador para observar 
o seu comportamento em situações de estresse.

- Precisão: Se a precisão do resultado obtido pelo avaliador de expressões atende ao epsilon exigido como precisão. 

 ### Conceitos fundamentais

  #### Avaliador  
  - Biblioteca ou serviço que implementa a avaliação de expressões matemáticas. 

  #### Adaptador
  - Código responsável por requisitar a avaliação de expressões matemáticas pelo Avaliador. Deve ser produzido um 
  adaptador para cada Avaliador. 

 ### Fluxo principal de funcionamento:

  ##### 01
   - A partir do nome da classe é obtida uma instância de _Adapter_. 
    
  ##### 02   
   - Para cada linha de teste do arquivo de entrada, um instância de _BancadaDeTestes_ é criada. 
    
  ##### 03
   - Convém observar que para cada _Teste_ retornado pela instância de _BancadaDeTestes_, por meio do método _get_, 
   obtém-se a expressão correspondente, a partir da qual, por meio da instância de _Adapter_ obtém-se a instância de 
   _Expressao_ correspondente. 
    
  ##### 04
  - Este último objeto recebe a mensagem _avaliacao_ cujo argumento é o conjunto de valores. O retorno é verificado
    com aquele do teste. 
    
  - Se o valor retornado difere do esperado, então o _benchmark_ é interrompido. 
    
  - Caso contrário, o tempo gasto será acumulado.  

### Validação da correção

A validação da correção de uma implementação será fornecida por meio de um arquivo CSV contendo três colunas, na ordem 
descrita abaixo:

- Expressão: Por exemplo, 2*(3-x).

- Variáveis. Valores das variáveis a serem utilizadas na avaliação da expressão  serão fornecidas separadas por vírgula.
 Por exemplo, para a expressão acima podemos ter x=10. Se a expressão faz uso de mais de uma variável, então os valores
 devem ser separados por vírgula. Por exemplo, para a expressão "a + b", os valores das variáveis podem ser 
 "a=1,b=3.4", por exemplo.
 
- Resultado. O valor da expressão. Por exemplo, para a expressão acima e o  valor de x igual a 10 (x=10), o resultado 
é -14. Caso a expressão seja inválida, então o resultado deve ser a  sequência "ERRO". Por exemplo, se a  expressão 
fornecida é "2*)", então o resultado deve ser "ERRO", pois não se trata de uma expressão válida. 

- Exemplo de conteúdo do arquivo de validação da correção: 
  
  |   Expressão   |  Variáveis  |    Resultado    |
  |     :---:     |     :---:   |       :---:     |
  | 2*(3-x)       |      x=5    |         -4      |
  | x+y/2         | x=2,y=10    |          7      |
  | (x-z)*(y-x/z) | x=5,y=6,z=2 |         10,5    |
  | x^x           |      x=3    |         27      |
  | x^x/2         |      x=2    |         2       |
 
 

### Classes esperadas

- Toda implementação a ser avaliada pelo presente _benchmark_ deve incluir as classes/interfaces identificadas abaixo. 

#### [Aplicativo](src/Aplicativo.java) (classe)
Ponto de entrada para execução do _benchmark_. Este aplicativo recebe como entrada um arquivo txt indicando o que 
deverá ser executado pelo _benchmark_.

- Nome da classe que implementa o adaptador
- Nome de arquivo CSV contendo testes seguida da quantidade de vezes em que deverá ser executado. 
- Repete zero ou mais vezes o item anterior. 

O retorno será um relatório indicando o tempo gasto na execução de cada um dos testes (linha de teste do arquivo de 
entrada).

#### [Expressao](src/adaptador/Expressao.java) (interface)
Esta interface deve possuir o método _avaliar_. Essa interface deve ser implementada pelo Avaliador.

#### [Adapter](src/adaptador/Adapter.java) (interface)
Esta interface possui o método _Expressao getExpressaoFor(String expressao)_. A execução deste método inclui a 
preparação da expressão fornecida, caso exista, antes que seja executada. Essa interface deve ser implementada pelo 
Avaliador.

#### [FactoryAdapter](src/adaptador/FactoryAdapter.java) (classe)
Produz uma instância de _Adapter_ por meio do método _newInstance(String nomeDaClasse)_.

#### [Teste](src/test/Teste.java) (classe)
Uma instância desta classe possui uma expressão (String), um valor para cada uma das variáveis empregadas na expressão 
e o resultado correspondente. 

#### [BancadaDeTestes](src/adaptador/Expressao.java) implements Supplier<Teste>
O construtor recebe como argumento o nome de um arquivo CSV cujas três colunas são, nesta ordem: 

(a) expressão; 
(b) valores para as variáveis empregadas pela expressão (se for o caso); 
(c) o resultado da avaliação da expressão com os valores fornecidos. 

O método _get_ será empregado para recuperar, um por um, na ordem em que aparecem no arquivo CSV, os testes contidos 
neste arquivo. 

#### [AvaliadorCarga](src/avaliadores/AvaliadorCarga.java) (classe)
Classe que avalia o desempenho de uma implementação de um avaliador de expressões em situação de carga.

#### [AvaliadorConsumoMemoria](src/avaliadores/AvaliadorConsumoMemoria.java) (classe)
Classe que avalia o consumo de memória de uma implementação de um avaliador de expressões.

#### [AvaliadorDesempenho](src/avaliadores/AvaliadorDesempenho.java) (classe)
Classe que avalia o desempenho de uma implementação de um avaliador de expressões.

#### [AvaliadorLatencia](src/avaliadores/AvaliadorLatencia.java) (classe)
Classe que avalia a latência de uma implementação de um avaliador de expressões.

#### [AvaliadorPrecisao](src/avaliadores/AvaliadorPrecisao.java) (classe)
Classe que avalia a precisão dos resultado obtidos por uma implementação de um avaliador de expressões.

#### Cenários

##### 1 Constante 1
A expressão formada apenas deste dígito 1 é executada 10, 100, 1000, 10.000, 100.000 e 1.000.000 de vezes, produzindo 
seis valores. 

##### 2 Constante -12.45678

Idem do anterior. 



