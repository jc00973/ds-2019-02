public interface Expression {

   private String expression;

   private Map<String, Double> values;

   public double avalia(Map<String, Double> valores, String expressao);

}

