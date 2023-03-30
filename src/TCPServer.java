import java.io.*;
import java.net.*;

import static java.lang.Integer.parseInt;

class TCPServer {
    public static void main(String argv[]) throws Exception {

        String clientSentence;

        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizedSentence = parseInt(clientSentence) * parseInt(clientSentence)+"\n";
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}