package rs.ac.bg.fon.server;

import rs.ac.bg.fon.thread.ClientHandler;

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
                handleClient(socket);
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

    private void handleClient(Socket socket) {
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.start();
    }

}

