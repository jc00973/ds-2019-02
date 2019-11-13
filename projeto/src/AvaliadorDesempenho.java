package projeto.src;

public interface AvaliadorDesempenho {

    private Adapter adapter;

    AvaliadorDesempenho() {

        adapter = FactoryAdapter.getInstance();

    }

    double avaliarDesempenho(Map<String, Double> valores, String expressao) {

        Expressao expr = adapter.getExpessaoFor("x + y");
        Map<String, Double> variaveis = new HashMap<>();
        variaveis.put(x, 10);
        variaveis.put(y, 20);
        long inicio = System.getCurrentTime();
        double resposta = expr.avalia(variaveis);
        long termino = System.getCurrentTime();

        if (Double.compare(resposta, 30) == 0) {

        }

        long tempoEmMilissegundo = termino - inicio;

        return intervaloDeTempo;

    }

}
