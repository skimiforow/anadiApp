package model;

import java.io.Console;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * Created by skimi on 25/04/2017.
 */
public class Testing {

    private final ConnectData data;

    public Testing(ConnectData data) {
        this.data = data;
    }

    public Result execute(){
        int samplings = 0;
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
            /*Console.print("Testing -> "+ (samplings + 1));*/
            Connection c = new Connection(data);
            success = c.connected();

            if (success) {
                numberSuccess++;
            }
            samplings++;

            awaitNextTry();
            after = Instant.now();
            difference = Duration.between(before, after).toMillis();

        } while (difference <= limit);
        
        // generate results based on the test executed
        endTime = Calendar.getInstance();
        JOptionPane.showMessageDialog(null, "Cheguei à cricao do result.");
        return new Result(data, startTime, endTime, samplings, numberSuccess);
    }

    private void awaitNextTry()
    {
        Instant before = Instant.now();
        float limit = data.getIntervalInMilii();
        float difference = 0;

        do {
            Instant after = Instant.now();
            difference = Duration.between(before, after).toMillis();
        } while (difference <= limit);
    }


}
