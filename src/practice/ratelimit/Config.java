package practice.ratelimit;

public class Config {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    private int noOfRequests;
    private int duration;

    private int durationUnits;

    private AlgoType algoType;

    public Config() {
    }

    public Config(int noOfRequests, int duration, int durationUnits, AlgoType algoType) {
        this.noOfRequests = noOfRequests;
        this.duration = duration;
        this.durationUnits = durationUnits;
        this.algoType = algoType;
    }

    public int getNoOfRequests() {
        return noOfRequests;
    }

    public void setNoOfRequests(int noOfRequests) {
        this.noOfRequests = noOfRequests;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDurationUnits() {
        return durationUnits;
    }

    public void setDurationUnits(int durationUnits) {
        this.durationUnits = durationUnits;
    }

    public AlgoType getAlgo() {
        return algoType;
    }

    public void setAlgo(AlgoType algoType) {
        this.algoType = algoType;
    }
}
