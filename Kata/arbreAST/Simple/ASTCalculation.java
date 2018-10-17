package kata.arbreAST.Simple;

import java.util.List;

public class ASTCalculation {
    static List<Integer> operands;

    public static String render(AST ast) {
        if (ast != null) {
            if (ast instanceof Literal) {
                return ((Literal) ast).getValue();

            }

            if (ast instanceof BinaryOperator) {
                return "(" + render(((BinaryOperator) ast).getFG()) + " " +
                        ((BinaryOperator) ast).getSymbole() + " " +
                        render(((BinaryOperator) ast).getFD()) + ")";
            }
        }
        return "";
    }

    public static int compute(AST ast) {
        if (ast != null) {
            if (ast instanceof Literal) {
                return Integer.valueOf(((Literal) ast).getValue());

            }

            if (ast instanceof BinaryOperator) {
                    switch (((BinaryOperator) ast).getSymbole()){
                        case "+" : return compute(((BinaryOperator) ast).getFG()) + compute(((BinaryOperator) ast).getFD());
                        case "*" : return compute(((BinaryOperator) ast).getFG()) * compute(((BinaryOperator) ast).getFD());
                        case "/" : return compute(((BinaryOperator) ast).getFG()) / compute(((BinaryOperator) ast).getFD());
                        case "-" : return compute(((BinaryOperator) ast).getFG()) - compute(((BinaryOperator) ast).getFD());
                    }
            }
        }
        return 0;


    }

    public static void compute(String str) {
        //TODO : PARSING STRING AND EXTRACT VALUE FROM IT


    }
}
