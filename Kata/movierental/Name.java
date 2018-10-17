package kata.movierental;

public final class Name {
    String name;

    public static Name name(final String value) {
        return new Name(value);
    }

    private Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
