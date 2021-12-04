package cz.mendelu.xpaseka.pj.projekt.network;

public class Network {
    private static Client client;
    private static Server server;

    public static void createClient(String ipAddress) {
        client = new Client(ipAddress);
    }

    public static void createServer() {
        server = new Server();
        server.start();
    }

    public static Client getClient() {
        return client;
    }

    public static Server getServer() {
        return server;
    }
}
