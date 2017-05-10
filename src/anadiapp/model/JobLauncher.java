/* 
 * Copyright (c) 2017, Sergio
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
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
        int status = 0;
        for (i = 0; i < numberJobs; i++) {
            status = i +1;
            AppUi.setText("A processar resultados " + status + "\n");
            list.add(this.tests[i].getResult());
        }
        return list;
    }
}
