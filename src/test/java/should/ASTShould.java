package should;

import kata.arbreAST.Solution2.ASTCalculation;
import kata.arbreAST.Solution2.ASTLiteral;
import kata.arbreAST.Solution2.ASTOperator;
import org.junit.Test;

public class ASTShould {


    @Test
    public void test(){

        ASTLiteral FD = new ASTLiteral("3");


        ASTLiteral FGG = new ASTLiteral("4");
        ASTLiteral FDD = new ASTLiteral("7");
        ASTOperator astOperatorG = new ASTOperator(FGG, FDD, "-");


        ASTOperator ast = new ASTOperator(astOperatorG, FD,"+");


        ASTCalculation.compute(ast);
    }
}
