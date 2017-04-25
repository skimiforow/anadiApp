package model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by skimi on 25/04/2017.
 */
public class Connection {

    private final ConnectData data;
    private final InetSocketAddress socketAdd;
    private boolean connected;
    Socket sock;

    public Connection(ConnectData data) {
        this.data = data;
        this.connected = false;
        this.sock = null;
        this.socketAdd= new InetSocketAddress(data.getNode(),data.getPort());
    }

    public boolean connected(){
        int timeout  = this.data.getTimeoutMilli();
        try{
            sock = new Socket();
            sock.connect(socketAdd,timeout);
            connected = sock.isConnected();
        } catch (IOException e) {
            connected = false;
            e.printStackTrace();
        }
        return connected;
    }

}
