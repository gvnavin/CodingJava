package ratelimit;

public class Window {
    private long startTimestamp;
    private int noOfRequestsServed;
    private long availableCredits;

    @Override
    public String toString() {
        return "Window{" +
                "startTimestamp=" + startTimestamp +
                ", noOfRequestsServed=" + noOfRequestsServed +
                ", availableCredits=" + availableCredits +
                '}';
    }

    public Window(long startTimestamp, int noOfRequestsServed, long availableCredits) {
        this.startTimestamp = startTimestamp;
        this.noOfRequestsServed = noOfRequestsServed;
        this.availableCredits = availableCredits;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(int startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public int getNoOfRequestsServed() {
        return noOfRequestsServed;
    }

    public void setNoOfRequestsServed(int noOfRequestsServed) {
        this.noOfRequestsServed = noOfRequestsServed;
    }

    public long getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(int availableCredits) {
        this.availableCredits = availableCredits;
    }
}
