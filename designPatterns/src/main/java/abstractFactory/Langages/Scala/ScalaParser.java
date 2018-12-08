package abstractFactory.Langages.Scala;

import abstractFactory.AbstractLangages.ParserAbstract;

public class ScalaParser extends ParserAbstract {
    @Override
    public void parse() {
        System.out.println("Parsing scala ");
    }

    @Override
    public String getName() {
        return "Scala";
    }
}
