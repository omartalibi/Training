package kata.arbreAST.Correction;

final class Literal implements AST {

    private String value;

    Literal(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
