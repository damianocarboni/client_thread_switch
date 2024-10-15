package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("il client è partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));
        String messaggio;
        do {
            System.out.print("Inserisci il tuo messaggio: ");
            messaggio = inTastiera.readLine();
            if (messaggio.equals("exit")) {
                out.writeBytes("!\n");
                break;
            }
            out.writeBytes(messaggio + "\n");
            System.out.println("scegliere l'operazione da eseguire: M = maiuscolo, m = minuscolo, R = al contrario, C = lunghezza \n");
            messaggio = inTastiera.readLine();
            out.writeBytes(messaggio + "\n");
            String stringaElaborata = in.readLine();
            System.out.println(stringaElaborata);

        } while (true);
        
    }
}