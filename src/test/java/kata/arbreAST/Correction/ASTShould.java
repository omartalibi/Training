package kata.arbreAST.Correction;

import org.junit.Test;

import static kata.arbreAST.Correction.ASTCalculation.compute;
import static kata.arbreAST.Correction.ASTCalculation.render;
import static kata.arbreAST.Correction.ASTFactory.*;
import static org.junit.Assert.assertEquals;

public class ASTShould {

    @Test
    public void test() {
        AST ast = add(sub(literal("4"), literal("7")), literal("3"));
        System.out.println(render(ast));
        System.out.println(compute(ast));
    }

    @Test
    public void test_add() {
        assertEquals(7, compute(add(literal("4"), literal("3"))));
    }

    @Test
    public void test_sub() {
        assertEquals(1, compute(sub(literal("4"), literal("3"))));
    }

    @Test
    public void test_mul() {
        assertEquals(12, compute(mul(literal("4"), literal("3"))));
    }

    @Test
    public void test_div() {
        assertEquals(2, compute(div(literal("4"), literal("2"))));
    }

    @Test
    public void test_deep_expression() {
        AST ast = add(sub(literal("4"), literal("7")), literal("3"));
        assertEquals(0, compute(ast));
    }

    @Test
    public void test_render_deep_expression() {
        AST ast = add(sub(literal("4"), literal("7")), literal("3"));
        assertEquals("((4 - 7) + 3)", render(ast));
    }
}
