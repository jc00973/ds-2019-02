/**
 * O código abaixo é uma ilustração do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na construção do software em si, não tendo portanto o intuito de servir como código final
 * implementável.
 *
 */

import avaliadores.Avaliador;
import avaliadores.ConsumoMemoria;
import avaliadores.Desempenho;
import avaliadores.Latencia;

import java.util.List;
import java.util.Map;

public class Aplicativo {

        private Avaliador avaliador;
        private List<String> resultados;
        String nomeDaClasse;
        String caminhoArquivoCsv;
        String codigoTipoAvaliacao;
        String caminhoRelatorioResultado;

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
        public void insereEntrada() {};


        /**
         * O método vai instanciar o strategy concreto de acordo com o codigoTipoAvaliacao informado e acessar o método
         * avaliar().
         *
         * @param codigoTipoAvaliacao O tipo de avaliação que será efetuada.
         */
        public void selecionarTipoAvaliacao(String codigoTipoAvaliacao) {

                if(codigoTipoAvaliacao == "1") {
                        avaliador = new Desempenho();
                } else if(codigoTipoAvaliacao == "2") {
                        avaliador = new ConsumoMemoria();
                } else if(codigoTipoAvaliacao == "3") {
                        avaliador = new Latencia();
                }

        }

}
