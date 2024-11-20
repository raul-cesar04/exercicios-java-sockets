package br.ufms.sockets.Exercicio2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class ClientHandler implements Runnable{
    private final Random rand = new Random();
    private final String[] messages = {
            "Eu gosto de ", "Passei o dia pensando em ", "Meu cachorro morreu de ",
            "Vendi a alma em troca de um ", "Meu pai me trocou por um ", "Vou vender droga e com o dinheiro vou comprar um "
    };

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

            String response = getMessage() + message + "\n";
            out.writeBytes(response);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getMessage(){
        return messages[rand.nextInt(0, messages.length)];
    }
}
