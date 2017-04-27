package anadiapp.model;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;

/**
 * Created by skimi on 25/04/2017.
 */
public class Result {
    private final ConnectData config;
    private final Calendar start;
    private final Calendar end;
    private final int sampling;
    private final float availability;
    private final int sucess;
    private final float mtbf;
    private float mttf;

    Result(ConnectData config, Calendar start, Calendar end, int numberSampling, int numberSucess) {
        this.config = config;
        this.start = start;
        this.end = end;
        this.sampling = numberSampling;
        this.sucess = numberSucess;
        this.availability = (float) numberSucess / sampling;
        this.mtbf = calculateMTBF(numberSucess);
    }

    public ConnectData getConfig() {
        return config;
    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    public int getSampling() {
        return sampling;
    }

    public float getAvailability() {
        return availability;
    }

    public float getMtbf() {
        return mtbf;
    }

    public float getMttf() {
        return mttf;
    }

    public int getSucess() {
        return sucess;
    }

//    private float calculateMTBF(int numberSucess){
//        Instant instantStart = this.start.toInstant();
//        Instant instantEnd = this.end.toInstant();
//        Duration between = Duration.between(instantStart, instantEnd);
//        float operationTime = between.toHours();
//        float numFailures = this.sampling - numberSucess;
//        if(numFailures !=0){
//            mttf = operationTime / numFailures;
//        } else {
//            mttf = 0;
//        }
//        if (mttf == 0) {
//            return 0;
//        }
//        return mttf / this.availability;
//    }

    private float calculateMTBF(int numberSucess){
        float numFailures = this.sampling - numberSucess;
        int interval = this.config.getInterval();
        if(numFailures >0){
            mttf = (numberSucess * interval) / numFailures;
        } else {
            mttf = 0;
        }
        if (mttf == 0) {
            return 0;
        }
        return (mttf / this.availability)*3600;
    }
    
    public int getTotalSampling() {
        return sampling;
    }

    public Calendar getTestEnd() {
        return end;
    }

    public Calendar getTestInit() {
        return start;
    }
}
