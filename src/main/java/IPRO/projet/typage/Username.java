package IPRO.projet.typage;

public class Username {
    private String username;

    public static Username Username(final String value) {
        return new Username(value);
    }

    public Username(String username){
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }
}
