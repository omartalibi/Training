package kata.arbreAST.Correction;

import static kata.arbreAST.Correction.ASTFactory.add;
import static kata.arbreAST.Correction.ASTFactory.literal;
import static kata.arbreAST.Correction.ASTFactory.sub;

public class VisitorTest {
    public static void main(String[] args) {
        VisitorAST visitorAST = new VisitorAST();
        AST ast = add(sub(literal("4"), literal("7")), literal("3"));


        ast.accept(visitorAST);
    }
}
