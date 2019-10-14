public interface ExpEvaluator {

    exp define(String exp);

    double eval(Exp exp, Map...);

}