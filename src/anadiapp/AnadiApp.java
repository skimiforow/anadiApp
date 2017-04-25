/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anadiapp;

import anadiapp.ui.AppUi;
import java.io.IOException;

/**
 *
 * @author skimi
 */
public class AnadiApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        AppUi app = new AppUi();
        app.setVisible(true);
    }
    
}
