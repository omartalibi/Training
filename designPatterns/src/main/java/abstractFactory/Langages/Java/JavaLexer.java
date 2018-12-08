package abstractFactory.Langages.Java;

import abstractFactory.AbstractLangages.LexerAbstract;

public class JavaLexer extends LexerAbstract {
    @Override
    public void scan() {
        System.out.println("Scanning Scala ");
    }

    @Override
    public String getName() {
        return "Java";
    }
}
