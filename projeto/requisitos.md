
# Projeto: benchmark para avaliação de desempenho de módulos avaliadores de expressões matemáticas definidas em tempo de execução

Uma expressão matemática será fornecida em tempo de execução,
juntamente com valores para as variáveis empregadas pela expressão, para que o resultado correspondente possa ser produzido
por um ou mais módulos que implementam esta funcionalidade. 

O presente módulo, por outro lado, tem como

> **Objetivo**: avaliar o desempenho de módulos que implementam avaliações de expressões matemáticas conhecidas em tempo de execução.

Noutras palavras, o presente módulo é um _benchmark_ para avaliação de expressões matemáticas conhecidas em tempo de execução.

Além dos dados, este benchmark inclui a infraestrutura necessária para execução de potenciais implementações. 
Benchmark para avaliação de expressões matemáticas definidas em tempo de execução com foco em: 
- desempenho;
- consumo de memória;
- latência;
- precisão superior a 0.0001 e
- carga.

Os requisitos preliminares são fornecidos abaixo.

## Requisitos 

- R1 O benchmark deverá avaliar o desempenho de módulos que avaliam expressões matemáticas conhecidos apenas em tempo de execução.
Ou seja, o _benchmark_ não conhece previamente as implementações destes módulos. 
- R2 O benchmark deve definir uma interface a ser implementada por cada um dos módulos que avaliam expressões matemáticas e fará
sua avaliação sobre o desempenho (comportamento observável) de cada módulo que implementa esta interface. 
