package IPRO.projet.typage;

public class FirstName {
    private String firstName;

    public static FirstName FirstName(final String value) {
        return new FirstName(value);
    }

    public FirstName(String firstName){
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName;
    }
}
