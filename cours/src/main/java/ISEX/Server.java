package ISEX;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 9090);

        Thread t = new Thread(new Runnable(){

            @Override
            public void run() {
                try {
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("connexion reussie, nouveau client");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}