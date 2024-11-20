package br.ufms.sockets.Exercicio1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        ServerSocket welcomeSocket = new ServerSocket(1234);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();

            System.out.println("Socket connected: "+connectionSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());

            String message = in.readLine();

            String response = message.toUpperCase() + " - ENVIADO POR BABILONIA\n";
            System.out.println(response);
            out.writeBytes(response);
        }
    }
}
