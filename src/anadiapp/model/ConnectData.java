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

    public ConnectData(int timeInterval, int port, String node, int timeout, float duration) {
        this.timeInterval = timeInterval;
        this.port = port;
        this.node = node;
        this.timeout = timeout;
        this.duration = duration;
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

    public int getTimeoutMilli() {
        return timeout * 1000;
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

    @Override
    public String toString() {
        return "ConnectData - {" + "timeInterval=" + timeInterval + " seg" + ", port=" + port + ", node=" + node + ", timeout=" + timeout + " seg" + ", duration=" + duration + " min" + '}';
    }

    int getInterval() {
        return timeInterval;
    }

}
