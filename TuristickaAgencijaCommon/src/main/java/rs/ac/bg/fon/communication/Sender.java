package rs.ac.bg.fon.communication;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
    private final Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(object);
            out.flush();
//            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error sending object!\n" + ex.getMessage());
        }
    }
}
