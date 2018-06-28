package IPRO.projet.typage;

public class Name {
    private String name;

    public static Name Name(final String value) {
        return new Name(value);
    }

    public Name(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
