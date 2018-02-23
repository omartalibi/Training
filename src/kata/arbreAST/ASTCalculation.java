package kata.arbreAST;

public class ASTCalculation {

    public StringBuilder render(AST ast){
        StringBuilder res = new StringBuilder();

        if(ast instanceof ILiteral)
            res.append(((ILiteral) ast).getValue());
        if(ast instanceof IOperator) {

            res.append(((IOperator) ast).getSymbole());
            render((AST) ((IOperator) ast).getFD());
            render((AST) ((IOperator) ast).getFG());

        }
        return null;
    }
}
