package abstractFactory.AbstractLangages;

import abstractFactory.Saver.Saver;

abstract  public class LexerAbstract {
    abstract public void scan();
    abstract public String getName();

    public void save(){
        Saver.saveLexer(getName(), this);
    }

    {
        this.save();
    }
}
