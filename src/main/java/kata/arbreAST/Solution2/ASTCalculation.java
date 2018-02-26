package kata.arbreAST.Solution2;

import java.util.List;

public class ASTCalculation {
    static StringBuilder res;
    static List<Integer> operands;

    public static void render(IAST ast){
        if(ast != null) {
            if (ast instanceof ILiteral) {
                System.out.print(((ILiteral) ast).getValue());
            }

            if (ast instanceof IOperator) {
                render(((IOperator) ast).getFD());
                System.out.print(((IOperator) ast).getSymbole());
                render(((IOperator) ast).getFG());
            }
        }
    }
    public static void compute(IAST ast){
        if(ast != null) {

            if(ast instanceof ILiteral){
                operands.add(Integer.valueOf(((ILiteral) ast).getValue()));
            }

            if(ast instanceof IOperator){
                if(((IOperator) ast).getSymbole() == "+" && operands.size() >= 2)
                    System.out.println(operands.get(0) + operands.get(1));
                    render(((IOperator) ast).getFD());
                    render(((IOperator) ast).getFG());
            }


        }

    }
    public static void compute(String str){
        

    }
}
