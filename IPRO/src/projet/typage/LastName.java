package projet.typage;

public class LastName {
    private String lastName;

    public static LastName LastName(final String value) {
        return new LastName(value);
    }

    public LastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
