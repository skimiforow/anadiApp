package anadiapp.model;

import java.time.Duration;
import java.util.Calendar;

/**
 * Created by skimi on 25/04/2017.
 */
public final class Result {

    private final ConnectData config;
    private final Calendar start;
    private final Calendar end;
    private final int sampling;
    private final float availability;
    private final int sucess;
    private final int fails;
    private final float mtbf;
    private float mttf;
    private float mttr;
    private final float intervalHour;

    Result(ConnectData config, Calendar start, Calendar end, int numberSampling, int numberSucess) {
        this.config = config;
        this.start = start;
        this.end = end;
        this.intervalHour = this.config.getTimeIntervalHour();
        this.sampling = numberSampling;
        this.sucess = numberSucess;
        this.fails = getFails();
        this.mttr = getMttr();
        this.mttf = getMttf(numberSucess);
        this.mtbf = getMtbfCalc();
        this.availability = getAvailability(numberSucess);
    }

    public float getAvailability() {
        return availability;
    }

    public float getMtbf() {
        return mtbf;
    }

    public float getMttr() {
        float totalTime = getDuracaoTotalHoras();
        mttr = (totalTime - (this.sucess * this.intervalHour)) / (this.sampling - this.sucess);
        return mttr;
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

    public float getAvailability(int numberSucess) {
        if (this.fails == 0) {
            return 1;
        } else {
            return (float) this.mttf / ((this.mttf + this.mttr));
        }
    }

    public float getMttf(int numberSucess) {
        if (this.fails == 0) {
            return 0;
        } else {
            mttf = (float) ((numberSucess * this.intervalHour) / this.fails);
            return mttf;
        }
    }

    public int getSucess() {
        return sucess;
    }

    private float getMtbfCalc() {
        return this.mttf + this.mttr;
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

    public float getDuracaoTotalHoras() {
        return (float) this.config.getDuration() / 60;
    }

    public int getFails() {
        return this.sampling - this.sucess;
    }

}