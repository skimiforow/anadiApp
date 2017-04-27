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
