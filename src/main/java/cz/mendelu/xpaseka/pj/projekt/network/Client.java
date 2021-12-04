package cz.mendelu.xpaseka.pj.projekt.network;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    String ipAddressOpponent;

    public Client(String ipAddress) {
        this.ipAddressOpponent = ipAddress;
    }

    public void sent() {
        try {
            Socket s = new Socket(ipAddressOpponent, 4444);
//            var dout = new DataOutputStream(s.getOutputStream());
//            dout.writeUTF("Hello server");
//            dout.flush();
//            dout.close();
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
