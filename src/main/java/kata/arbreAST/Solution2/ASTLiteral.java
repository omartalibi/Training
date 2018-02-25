package kata.arbreAST.Solution2;

public class ASTLiteral implements ILiteral {
    private String value;

    @Override
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
