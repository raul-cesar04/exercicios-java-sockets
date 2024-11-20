package br.ufms.sockets.Exercicio3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 1234);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(System.in));

        String message = inFromClient.readLine();
        outToServer.writeBytes(message + "\n");

        String response = inFromServer.readLine();

        System.out.println(response);
        socket.close();
    }
}
