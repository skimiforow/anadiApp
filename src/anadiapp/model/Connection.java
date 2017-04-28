package anadiapp.model;

import anadiapp.ui.AppUi;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 * Created by skimi on 25/04/2017.
 */
public class Connection {

    private final ConnectData data;
    private final InetSocketAddress socketAdd;
    private boolean connected;
    Socket sock;
    private AppUi AppUi = null;


    public Connection(AppUi AppUi, ConnectData data) {
        this.data = data;
        this.connected = false;
        this.sock = null;
        this.socketAdd= new InetSocketAddress(data.getNode(),data.getPort());
        this.AppUi = AppUi;
    }

    public boolean connected(){
        //int timeout  = this.data.getTimeoutMilli();
        int timeout  = this.data.getTimeout();
        try{
            sock = new Socket();
            sock.connect(socketAdd,timeout);
            connected = sock.isConnected();
        } catch (IOException e) {
            AppUi.setText("Falha de " + data.getNode() + ", tipo - " + e.getMessage() +"\n");
            connected = false;
            e.printStackTrace();
        }
        return connected;
    }

}
