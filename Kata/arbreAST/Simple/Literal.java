package kata.arbreAST.Simple;


final class Literal implements AST {

    private String value;

    Literal(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    @Override
    public String render(AST ast) {
        return null;
    }

    @Override
    public int compute(AST ast) {
        switch (((BinaryOperator) ast).getSymbole()){
            case "+" : return compute(((BinaryOperator) ast).getFG()) + compute(((BinaryOperator) ast).getFD());
            case "*" : return compute(((BinaryOperator) ast).getFG()) * compute(((BinaryOperator) ast).getFD());
            case "/" : return compute(((BinaryOperator) ast).getFG()) / compute(((BinaryOperator) ast).getFD());
            case "-" : return compute(((BinaryOperator) ast).getFG()) - compute(((BinaryOperator) ast).getFD());
        }
        return 0;
    }
}
