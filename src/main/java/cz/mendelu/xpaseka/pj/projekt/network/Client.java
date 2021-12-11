package cz.mendelu.xpaseka.pj.projekt.network;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String ipAddressOpponent;
    private int port;

    public Client(String ipAddress) {
        this.ipAddressOpponent = ipAddress;
        this.port = Network.getServer().getPort();
        if (ipAddressOpponent.length() == 0) {
            System.out.println("localhost");
            ipAddressOpponent = "127.0.0.1";
            this.port = (Network.getServer().getPort() == 4444) ? 4445 : 4444;
        }
    }

    public void sent() {
        try {
            Socket s = new Socket(ipAddressOpponent, port);
            try (var out = new ObjectOutputStream(s.getOutputStream())) {
                out.writeObject(Game.getGameInstance());
                out.flush();
            }
            s.close();
        } catch (IOException e) {
            System.out.println("cant connect to " + ipAddressOpponent);
            e.printStackTrace();
        }
    }
}
