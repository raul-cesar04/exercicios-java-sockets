package br.ufms.sockets.Exercicio3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class ClientHandler implements Runnable{
    private Socket connectionSocket;

    public ClientHandler(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }


    @Override
    public void run(){
        try{
            System.out.println("Socket connected: "+connectionSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());

            String message = in.readLine();

            String response = (CPFChecker.check(message))?"CPF Válido":"CPF Não Válido";

            out.writeBytes(response+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
