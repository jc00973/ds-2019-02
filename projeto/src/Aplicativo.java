/**
 * O c�digo abaixo � uma ilustra��o do design planejado. Ou seja, por se tratar de design, ele serve para orientar e
 * direcionar o desenvolvedor na constru��o do software em si, n�o tendo portanto o intuito de servir como c�digo final
 * implement�vel.
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
         * Este m�todo recebe um arquivo.txt com 3 informa��es, respectivamente:
         *      (a) nome da classe do Avaliador de Express�o que ir� instanciar um Adapter;
         *      (b) caminho com o nome do arquivo.csv contendo testes;
         *      (c) c�digo de um dos tr�s tipos de avalia��o desejado:
         *              (1) Desempenho;
         *              (2) Consumo de mem�ria;
         *              (3) Lat�ncia.
         *      (d) caminho do diret�rio onde o relatorioResultado.txt deve ser escrito.
         *
         */
        public void insereEntrada() {};


        /**
         * O m�todo vai instanciar o strategy concreto de acordo com o codigoTipoAvaliacao informado e acessar o m�todo
         * avaliar().
         *
         * @param codigoTipoAvaliacao O tipo de avalia��o que ser� efetuada.
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
