package br.ufms.sockets.Exercicio2;

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

            new Thread(new ClientHandler(connectionSocket)).start();
        }
    }
}
