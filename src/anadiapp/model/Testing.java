package anadiapp.model;

import anadiapp.ui.AppUi;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import javax.swing.JTextArea;

/**
 * Created by skimi on 25/04/2017.
 */
public class Testing implements Runnable {

    private final ConnectData data;
    private Result result;
    AppUi AppUi = null;

    public Testing(AppUi AppUi, ConnectData data) {
        this.data = data;
        this.AppUi = AppUi;

    }

    private Result execute() {
        int samplings = 0;
        int testes = 1;
        int numberSuccess = 0;
        boolean success = false;
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = null;
        Instant before = null;
        Instant after = null;
        float limit = data.getDurationInMilli();
        float difference = 0;
        before = Instant.now();

        do {
            AppUi.setText("Ligação: " + testes + " de " + data.getNode() + "\n");
            Connection c = new Connection(AppUi, data);
            success = c.connected();
            int countFails = 0;
            if (success) {
                AppUi.setText("Sucesso em establecer ligação a " + data.getNode() + "\n");
                numberSuccess++;
            } else {
                do {
                    countFails++;
                    AppUi.setText(" |X| Falha na resposta de " + data.getNode() + "\n");
                    AppUi.setText("Repetição: " + testes + " de " + data.getNode() + "\n");
                    c = new Connection(AppUi, data);
                    success = c.connected();
                    after = Instant.now();
                    difference = Duration.between(before, after).toMillis();
                } while (!success && (difference <= limit) && (countFails < 3));
            }
            samplings++;
            testes++;

            awaitNextTry();
            after = Instant.now();
            difference = Duration.between(before, after).toMillis();

        } while (difference <= limit);

        // generate results based on the test executed
        endTime = Calendar.getInstance();
        return new Result(data, startTime, endTime, samplings, numberSuccess);
    }

    private void awaitNextTry() {
        Instant before = Instant.now();
        float limit = data.getIntervalInMilii();
        float difference = 0;

        do {
            Instant after = Instant.now();
            difference = Duration.between(before, after).toMillis();
        } while (difference <= limit);
    }

    public Result getResult() {
        return result;
    }

    @Override
    public void run() {
        this.result = execute();
    }

}
