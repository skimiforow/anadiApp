package anadiapp.model;

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
    private JTextArea txtResults = null;


    public Connection(JTextArea txtResults, ConnectData data) {
        this.data = data;
        this.connected = false;
        this.sock = null;
        this.socketAdd= new InetSocketAddress(data.getNode(),data.getPort());
        this.txtResults = txtResults;
    }

    public boolean connected(){
        int timeout  = this.data.getTimeoutMilli();
        try{
            sock = new Socket();
            sock.connect(socketAdd,timeout);
            connected = sock.isConnected();
            txtResults.setText(txtResults.getText() + "Sucesso na resposta de " + data.getNode() + "\n");
        } catch (IOException e) {
            txtResults.setText(txtResults.getText() + "Falha na resposta de " + data.getNode() + " - " + e.getMessage() +"\n");
            connected = false;
            e.printStackTrace();
        }
        return connected;
    }

}
