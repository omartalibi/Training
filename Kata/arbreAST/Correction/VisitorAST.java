package kata.arbreAST.Correction;

public class VisitorAST implements Visitor {
    @Override
    public String visit(BinaryOperator ast) {
        return "(" + visit((BinaryOperator) ast.getFG()) + " " +
                ast.getSymbole() + " " +
                visit((BinaryOperator) ast.getFD()) + ")";

    }

    @Override
    public String visit(Literal literal) {
        return literal.getValue();
    }
}
