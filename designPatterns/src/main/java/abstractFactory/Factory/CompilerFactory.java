package abstractFactory.Factory;

import abstractFactory.AbstractLangages.GeneratorAbstract;
import abstractFactory.AbstractLangages.LexerAbstract;
import abstractFactory.AbstractLangages.ParserAbstract;
import abstractFactory.Saver.Saver;


public class CompilerFactory {

    public static Compiler getCompiler(String langage){
        GeneratorAbstract generatorAbstract = Saver.getGeneratorAbstract(langage) ;
        LexerAbstract lexerAbstract = Saver.getLexerAbstract(langage);
        ParserAbstract parserAbstract = Saver.getParserAbstract(langage);

        if(generatorAbstract == null || lexerAbstract == null || parserAbstract == null)
            throw new IllegalArgumentException(langage + " Compiler not found");

        return new Compiler(generatorAbstract,lexerAbstract,parserAbstract);

    }
}
