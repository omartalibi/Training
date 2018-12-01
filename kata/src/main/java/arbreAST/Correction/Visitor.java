package arbreAST.Correction;

public interface Visitor {
    String visit(BinaryOperator binaryOperator);
    String visit(Literal literal);
}
