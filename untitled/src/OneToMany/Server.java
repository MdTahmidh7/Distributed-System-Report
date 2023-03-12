package OneToMany;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while (true) {
                // Wait for a client to connect
                System.out.println("Wait for a client to connect");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                System.out.println("Client Port = "+socket.getPort());

                // Read the request from the client
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String tokens = reader.readLine();
                String client = tokens.substring(0,1);
                int length = tokens.length();
                String message = tokens.substring(1,length);
                System.out.println("Client Connected successfully.");

                // Process the request and send a response to the client
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

//
                System.out.println("Response form "+ client +"= "+message);
                // Close the connection
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
