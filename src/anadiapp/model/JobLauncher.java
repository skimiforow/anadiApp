/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anadiapp.model;

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
    private JTextArea txtResults = null;
    
    public JobLauncher(JTextArea txtResults, List<ConnectData> connectdata)
    {
        this.data = connectdata;
        this.txtResults = txtResults;
    }
    
    public List<Result> launch() throws InterruptedException
    {
        int numberJobs = this.data.size();
        this.jobs = new Thread[numberJobs];
        this.tests = new Testing[numberJobs];
        
        int i = 0;
        for (ConnectData cd : this.data) {
            txtResults.setText(txtResults.getText() + "A tratar recolha: " +  cd.getNode() + "\n");
            this.tests[i] = new Testing(txtResults, cd);
            this.jobs[i] = new Thread(this.tests[i]);
            this.jobs[i].start();
            i++;
        }
        
        List<Result> list = new ArrayList<>();
        for (i = 0; i < numberJobs; i++) {
            this.jobs[i].join();
        }
        
        for (i = 0; i < numberJobs; i++) {
            txtResults.setText(txtResults.getText() + "A processar resultados " + i + "\n");
            list.add(this.tests[i].getResult());
        }
        
        return list;
    }
}
