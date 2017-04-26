package controller;

import model.ConnectData;
import model.Result;
import model.Testing;
import ui.SendToTxt;

import java.io.IOException;

/**
 * Created by skimi on 25/04/2017.
 */
public class AppController {

    private Result result = null;

    public AppController()
    {
    }

    public boolean executeTest(ConnectData data)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
        Testing testExecuter = new Testing(data);
        result = testExecuter.execute();
       ;
            }
        });
        return (result != null);
    }

    public boolean export()
    {
        try {
            SendToTxt io = new SendToTxt(result);
            io.export();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
