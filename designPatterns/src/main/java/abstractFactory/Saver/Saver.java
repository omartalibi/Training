package abstractFactory.Saver;

import abstractFactory.AbstractLangages.GeneratorAbstract;
import abstractFactory.AbstractLangages.LexerAbstract;
import abstractFactory.AbstractLangages.ParserAbstract;

import java.util.HashMap;

public class Saver {
    private static HashMap<String,LexerAbstract> lexerAbstracts= new HashMap<>();
    private static HashMap<String,ParserAbstract> parserAbstracts = new HashMap<>();
    private static HashMap<String,GeneratorAbstract> generatorAbstracts= new HashMap<>();

    public static void saveLexer(String name, LexerAbstract lexerAbstract){
        lexerAbstracts.put(name,lexerAbstract);
    }

    public static void saveParser(String name,ParserAbstract parserAbstract){
        parserAbstracts.put(name,parserAbstract);
    }

    public static void saveGeneretor(String name,GeneratorAbstract generatorAbstract){
        generatorAbstracts.put(name,generatorAbstract);
    }

    public static LexerAbstract getLexerAbstract(String name){
        return lexerAbstracts.getOrDefault(name, null);
    }

    public static ParserAbstract getParserAbstract(String name){
        return parserAbstracts.getOrDefault(name, null);
    }

    public static GeneratorAbstract getGeneratorAbstract(String name){
        return generatorAbstracts.getOrDefault(name, null);
    }
}
