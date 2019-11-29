/**
 * O código abaixo é uma ilustração do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na construção do software em si, não tendo portanto o intuito de servir como código final
 * implementável.
 *
 */

import avaliadores.Avaliador;
import avaliadores.ConsumoMemoria;

import java.util.List;

public class Aplicativo {

        private Avaliador avaliador;
        private List<String> resultados;

        /**
         * Este método recebe um arquivo.txt com 3 informações, respectivamente:
         *      (a) nome da classe do Avaliador de Expressão que irá instanciar um Adapter;
         *      (b) caminho com o nome do arquivo.csv contendo testes;
         *      (c) código de um dos três tipos de avaliação desejado:
         *              (1) Desempenho;
         *              (2) Consumo de memória;
         *              (3) Latência.
         *      (d) caminho do diretório onde o relatorioResultado.txt deve ser escrito.
         *
         */
        public void insereEntrada() {

                String nomeDaClasse;
                String caminhoArquivoCsv;
                String codigoTipoAvaliacao;
                String caminhoRelatorioResultado;

        };

        public static void main(String[] args) {

        }


}
