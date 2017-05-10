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