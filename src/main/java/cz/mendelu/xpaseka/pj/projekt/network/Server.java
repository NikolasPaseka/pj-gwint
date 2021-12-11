package cz.mendelu.xpaseka.pj.projekt.network;

import cz.mendelu.xpaseka.pj.projekt.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private boolean opponentConnected = false;
    private boolean serverRunning = false;

    private int port = 4444;

    @Override
    public void run() {
        assignPort();
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server run on port " + port);
            serverRunning = true;
            while (!isInterrupted()) {
                Socket cs = ss.accept();
                System.out.println("Client accepted: " + cs);
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
            serverRunning = false;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean getConnected() {
        return opponentConnected;
    }

    public boolean isServerRunning() {
        return serverRunning;
    }

    public int getPort() {
        return port;
    }

    public void assignPort() {
        try {
            ServerSocket ss = new ServerSocket(4444);
            ss.close();
        } catch (IOException e) {
            port = 4445;
        }
    }
}
