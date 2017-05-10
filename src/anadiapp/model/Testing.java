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
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;

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
