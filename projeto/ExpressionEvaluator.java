public interface ExpressionEvaluator {

    Expression define(String exp);

    double eval(Expression exp, Map...);

}
