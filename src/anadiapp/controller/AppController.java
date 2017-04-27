package anadiapp.controller;

import anadiapp.model.*;
import anadiapp.ui.SendToTxt;
import java.io.IOException;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Created by skimi on 25/04/2017.
 */
public class AppController
{

    private List<Result> results = null;
    JTextArea txtResults = null;

    public AppController(JTextArea txtResults){
        this.txtResults = txtResults;
    }

    //ExecuteTest without Threads
//    public boolean executeTest(ConnectData data) {
//        Testing testExecuter = new Testing(data);
//        result = testExecuter.execute();
//        return (result != null);
//    }
    public void export()
    {
        // ATENCAO: O export deve ser feito quando a lista de resultados estiver preenchida pelas threads.
        // Podes segregar a exportacao para uma ExportDispatcher para realizar a tarefa ou simplesmente mantendo como esta no controller
        for (Result r : results) {
            try {
                SendToTxt io = new SendToTxt(r);
                io.export();
                txtResults.setText(txtResults.getText() + "Exportação com sucesso." + "\n");
            } catch (IOException ex) {
                txtResults.setText(txtResults.getText() + "Exportação sem sucesso." + ex.getMessage() + "\n");
            }
        }
    }

    public boolean executeTest(JTextArea resultsStatus, List<ConnectData> connectdata)
    {
        this.txtResults = resultsStatus;
        // ATENCAO: O job launcher faz todo o controlo de fluxo das threads lançadas
        try {
            JobLauncher job = new JobLauncher(this.txtResults, connectdata);
            txtResults.setText(txtResults.getText() + "A preparar as instâncias." + "\n");
            this.results = job.launch();
            return (this.results.size() > 0);
        } catch (InterruptedException ex) {
            txtResults.setText(txtResults.getText() + "Erro na preparação dos processos de recolha!" + "\n");
            return false;
        }
    }
}
