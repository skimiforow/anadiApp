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
package anadiapp.controller;

import anadiapp.model.*;
import anadiapp.ui.AppUi;
import anadiapp.ui.SendToTxt;
import java.io.IOException;

import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Created by skimi on 25/04/2017.
 */
public class AppController {

    private List<Result> results = null;
    AppUi AppUi = null;

    public AppController(AppUi aThis) {
        AppUi = aThis;
    }

    //ExecuteTest without Threads
//    public boolean executeTest(ConnectData data) {
//        Testing testExecuter = new Testing(data);
//        result = testExecuter.execute();
//        return (result != null);
//    }
    public void export(JTextArea txtResults) {
        // ATENCAO: O export deve ser feito quando a lista de resultados estiver preenchida pelas threads.
        // Podes segregar a exportacao para uma ExportDispatcher para realizar a tarefa ou simplesmente mantendo como esta no controller
        for (Result r : results) {
            try {
                SendToTxt io = new SendToTxt(r);
                io.export();
                AppUi.setText("Exportação com sucesso." + "\n");
            } catch (IOException ex) {
                AppUi.setText("Exportação sem sucesso." + ex.getMessage() + "\n");
            }
            AppUi.enableForm();
            AppUi.clearForm();
        }
    }

    public boolean executeTest(List<ConnectData> connectdata) {
        // ATENCAO: O job launcher faz todo o controlo de fluxo das threads lançadas
        try {
            JobLauncher job = new JobLauncher(AppUi, connectdata);
            AppUi.setText("A preparar as instâncias." + "\n");
            this.results = job.launch();
            return (this.results.size() > 0);
        } catch (InterruptedException ex) {
            AppUi.setText("Erro na preparação dos processos de recolha!" + "\n");
            return false;
        }
    }

    public void stopThreads() {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        for (Thread thread : threadArray) {
            thread.interrupt();
            AppUi.setText("Processo terminado à força!" + "\n");
        }
    }
}
