package IPRO.client;

public class Client {

    private static int nextIdentifier = 0;

    private String name;
    private String email;
    private final int id;


    public Client(String name, String email){
        this.name = name;
        this.email = email;
        this.id = nextIdentifier++;
    }


    public int getIdentifier(){
        return this.id;
    }
}
