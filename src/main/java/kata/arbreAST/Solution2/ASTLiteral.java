package kata.arbreAST.Solution2;

public class ASTLiteral implements ILiteral {

    private String value;

    public ASTLiteral(String value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return this.value;
    }

}
