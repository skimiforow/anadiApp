package controller;

import model.ConnectData;
import model.Result;
import model.Testing;
import ui.SendToTxt;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Created by skimi on 25/04/2017.
 */
public class AppController {

    private Result result = null;

    public AppController() {
    }
    //ExecuteTest without Threads
//    public boolean executeTest(ConnectData data) {
//        Testing testExecuter = new Testing(data);
//        result = testExecuter.execute();
//        return (result != null);
//    }

    //ExecuteTest with Threads
    public boolean executeTest(ConnectData data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Testing testExecuter = new Testing(data);
                JOptionPane.showMessageDialog(null, "Cheguei aqui!");
                result = testExecuter.execute();
                ;
            }
        });
        return (result != null);
    }

    public boolean export() {
        try {
            SendToTxt io = new SendToTxt(result);
            io.export();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
