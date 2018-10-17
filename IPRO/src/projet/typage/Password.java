package projet.typage;

public class Password {
    private String password;

    public static Password Password(final String value) {
        return new Password(value);
    }

    public Password(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return password;
    }

    public String getPassword() {
        return password;
    }
}
