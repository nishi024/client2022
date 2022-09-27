package it.fi.meucci;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String args[]) throws UnknownHostException, IOException {
        ClientStr client = new ClientStr();
        client.connetti();
        client.comunica();

    }

}
