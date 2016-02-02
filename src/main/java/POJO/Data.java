package POJO;

/**
 * Created by Guardeec on 01.02.16.
 */
public class Data {
    private static Data ourInstance = new Data();

    public static Data getInstance() {
        return ourInstance;
    }

    private String sourceIP;

    public String getNetworkInteface() {
        return networkInteface;
    }

    public void setNetworkInteface(String networkInteface) {
        this.networkInteface = networkInteface;
    }

    private String targetIP;
    private String networkInteface;

    public String getSourceIP() {
        return sourceIP;
    }

    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }

    public String getTargetIP() {
        return targetIP;
    }

    public void setTargetIP(String targetIP) {
        this.targetIP = targetIP;
    }

    private Data() {
    }
}
