package rs.ac.bg.fon.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(9999);
    }

    @Override
    public void run() {
        try {

            while (!isInterrupted()) {
                System.out.println("Cekanje na konekciju");
                Socket socket = serverSocket.accept();
//                TODO: izbrisati komentar
//                handleClient(socket);
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    //TODO: izbrisati komentar
//    private void handleClient(Socket socket) {
//        ClientHandler clientHandler = new ClientHandler(socket);
//        clientHandler.start();
//    }

}

