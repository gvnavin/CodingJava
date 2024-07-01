package coupang;

// uber level config, so that we can extend
public class Config {

    //can extend

    private int numberOfRequestsAllowed;
    private int numberOfSeconds;

    public Config(int numberOfRequestsAllowed) {
        this.numberOfRequestsAllowed = numberOfRequestsAllowed;
        this.numberOfSeconds = 1;
    }

    //duration in weeks or days etc., can be extended
    public Config(int numberOfRequestsAllowed, int durationInSeconds) {
        this.numberOfRequestsAllowed = numberOfRequestsAllowed;
        this.numberOfSeconds = durationInSeconds;
    }

    public int getNumberOfRequestsAllowed() {
        return numberOfRequestsAllowed;
    }

    public int getNumberOfSeconds() {
        return numberOfSeconds;
    }
}
