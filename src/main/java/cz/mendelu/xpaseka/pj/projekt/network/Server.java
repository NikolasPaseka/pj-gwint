package cz.mendelu.xpaseka.pj.projekt.network;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private boolean opponentConnected = false;

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(4444);
            System.out.println("Server run on port 4444");
            while (!isInterrupted()) {
                Socket cs = ss.accept();
                System.out.println("Client accepted: " + cs);
//                var dis = new DataInputStream(cs.getInputStream());
//                String str = dis.readUTF();
//                System.out.println(str);
                try (var in = new ObjectInputStream(cs.getInputStream())) {
                    var game = (Game) in.readObject();

                    // change players
                    var opponent = game.getPlayer();
                    var player = game.getOpponent();
                    var weatherBoard = game.getWeatherBoard();
                    Game.getGameInstance().reloadOpponent(opponent);
                    if (opponentConnected) {
                        if (!Game.getGameInstance().getPlayer().getFinishedRound()) {
                            Game.getGameInstance().switchPlayerOnMove();
                        }
                        Game.getGameInstance().reloadPlayer(player);
                        Game.getGameInstance().reloadWeatherBoard(weatherBoard);
                    } else opponentConnected = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean getConnected() {
        return opponentConnected;
    }
}
