package projet.typage;

public class Email {
    private String email;

    public static Email Email(final String value) {
        return new Email(value);
    }

    public Email(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

    public String getEmail() {
        return email;
    }
}
