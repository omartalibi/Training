package arbreAST.Simple;

public class ASTFactory {
    /**
     * Creates a literal AST
     * @param value
     * @return
     */
    public static AST literal(String value) {
        return new Literal(value);
    }

    /**
     * Creates an addition.
     * @param left
     * @param right
     * @return
     */
    public static AST add(AST left, AST right) {
        return new BinaryOperator("+", left, right);
    }

    public static AST sub(AST left, AST right) {
        return new BinaryOperator("-", left, right);
    }

    public static AST mul(AST left, AST right) {
        return new BinaryOperator("*", left, right);
    }

    public static AST div(AST left, AST right) {
        return new BinaryOperator("/", left, right);
    }
}
