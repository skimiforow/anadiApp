/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anadiapp.model;

import anadiapp.ui.AppUi;
import java.util.*;
import javax.swing.JTextArea;

/**
 *
 * @author
 */
public class JobLauncher
{
    
    private List<ConnectData> data = null;
    private Thread[] jobs = null;
    private Testing[] tests = null;
    private AppUi AppUi = null;
    
    public JobLauncher(AppUi aThis, List<ConnectData> connectdata)
    {
        this.data = connectdata;
        this.AppUi = aThis;
    }
    
    public List<Result> launch() throws InterruptedException
    {
        int numberJobs = this.data.size();
        this.jobs = new Thread[numberJobs];
        this.tests = new Testing[numberJobs];
        
        int i = 0;
        for (ConnectData cd : this.data) {
            AppUi.setText("A tratar recolha: " +  cd.getNode() + "\n");
            this.tests[i] = new Testing(AppUi, cd);
            this.jobs[i] = new Thread(this.tests[i]);
            this.jobs[i].start();
            i++;
        }
        
        List<Result> list = new ArrayList<>();
        for (i = 0; i < numberJobs; i++) {
            this.jobs[i].join();
        }
        
        for (i = 0; i < numberJobs; i++) {
            AppUi.setText("A processar resultados " + i+1 + "\n");
            list.add(this.tests[i].getResult());
        }
        return list;
    }
}
