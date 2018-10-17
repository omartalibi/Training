package kata.arbreAST.Solution2;

import java.util.List;

public class ASTCalculation {
    static List<Integer> operands;

    public static String render(IAST ast) {
        if (ast != null) {
            if (ast instanceof ILiteral) {
                return ((ILiteral) ast).getValue();

            }

            if (ast instanceof IOperator) {
                return "(" + render(((IOperator) ast).getFG()) + " " +
                        ((IOperator) ast).getSymbole() + " " +
                        render(((IOperator) ast).getFD()) + ")";
            }
        }
        return "";
    }

    public static int compute(IAST ast) {
        if (ast != null) {
            if (ast instanceof ILiteral) {
                return Integer.valueOf(((ILiteral) ast).getValue());

            }

            if (ast instanceof IOperator) {
                    switch (((IOperator) ast).getSymbole()){
                        case "+" : return compute(((IOperator) ast).getFG()) + compute(((IOperator) ast).getFD());
                        case "*" : return compute(((IOperator) ast).getFG()) * compute(((IOperator) ast).getFD());
                        case "/" : return compute(((IOperator) ast).getFG()) / compute(((IOperator) ast).getFD());
                        case "-" : return compute(((IOperator) ast).getFG()) - compute(((IOperator) ast).getFD());
                    }
            }
        }
        return 0;


    }

    public static void compute(String str) {
        //TODO : PARSING STRING AND EXTRACT VALUE FROM IT


    }
}
