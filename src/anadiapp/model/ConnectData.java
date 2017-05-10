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

/**
 * Created by Sérgio Silva e José Caldeira - TP2 ANADI on 25/04/2017.
 */
public class ConnectData {

    private final int timeInterval;
    private final int port;
    private final String node;
    private final int timeout;
    private final float duration;
    private final String address;

    public ConnectData(int timeInterval, int port, String node, int timeout, float duration) {
        this.timeInterval = timeInterval;
        this.port = port;
        this.node = node;
        this.timeout = timeout;
        this.duration = duration;
        this.address = node.replace('/', '\\');
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public int getPort() {
        return port;
    }

    public String getNode() {
        return node;
    }

    public int getTimeout() {
        return timeout;
    }

    public float getDuration() {
        return duration;
    }

    public float getDurationInMilli() {
        return duration * 60000;
    }

    public float getIntervalInMilii() {
        return timeInterval * 1000;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ConnectData - {" + "timeInterval=" + timeInterval + " seg" + ", port=" + port + ", node=" + node + ", timeout=" + timeout + " miliseg" + ", duration=" + duration + " min" + '}';
    }

    public float getTimeIntervalHour() {
        return (float) this.timeInterval / 3600;
    }

}
