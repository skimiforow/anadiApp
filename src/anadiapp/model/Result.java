package model;

import java.time.Duration;
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
    private final float mtbf;
    private float mttf;

    Result(ConnectData config, Calendar start, Calendar end, int sampling, int numberSucess) {
        this.config = config;
        this.start = start;
        this.end = end;
        this.sampling = sampling;
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

    private float calculateMTBF(int numberSucess){
        float operationTime = Duration.between(this.start.toInstant(), this.end.toInstant()).toHours();
        float numFailures = this.sampling - numberSucess;
        if(numFailures !=0){
            mttf = operationTime / numFailures;
        } else {
            mttf = 0;
        }
        return mttf / this.availability;
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
