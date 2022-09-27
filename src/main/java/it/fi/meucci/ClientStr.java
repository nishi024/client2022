package it.fi.meucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientStr {
    String nomeServer = "localhost";
    int portaServer = 6789;
    Socket miosocket;
    BufferedReader tastiera;
    String stringUtente;
    String stringRicevutaDalServer;
    DataOutputStream outVersoServer;
    BufferedReader inDalServer;

    public Socket connetti() throws UnknownHostException, IOException {
        try {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            miosocket = new Socket(nomeServer, portaServer);

            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("host sconosciuta");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return miosocket;
    }

    public void comunica() {
        try {
            System.out.println("" + '\n');
            stringUtente = tastiera.readLine();
            System.out.println("" + '\n');
            outVersoServer.writeBytes(stringUtente + '\n');

            stringRicevutaDalServer = inDalServer.readLine();
            System.out.println("" + '\n' + stringRicevutaDalServer);
            System.out.println("");// chiudo la connessione
            miosocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore connessione");
            System.exit(1);

        }
    }

}
