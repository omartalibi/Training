package abstractFactory.Langages.Scala;

import abstractFactory.AbstractLangages.LexerAbstract;

public class ScalaLexer extends LexerAbstract {
    @Override
    public void scan() {
        System.out.println("Scanning Scala ");
    }

    @Override
    public String getName() {
        return "Scala";
    }
}
