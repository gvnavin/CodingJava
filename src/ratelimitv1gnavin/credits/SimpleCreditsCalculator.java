package ratelimitv1gnavin.credits;

public class SimpleCreditsCalculator implements CreditsCalculator {

    private long windowDurationInSeconds;
    private int maxCreditsPerWindow;

    public SimpleCreditsCalculator(long windowDurationInSeconds, int maxCreditsPerWindow) {
        this.windowDurationInSeconds = windowDurationInSeconds;
        this.maxCreditsPerWindow = maxCreditsPerWindow;
    }

    public int calculateCredits(long previousTimeStampInSeconds, long currentTimeStampInSeconds) {
        long diffOfCurrentTimestampAndLastWindowStartTimestamp = currentTimeStampInSeconds - previousTimeStampInSeconds;
        long noOfWindow = diffOfCurrentTimestampAndLastWindowStartTimestamp/windowDurationInSeconds;

        return (int) (noOfWindow * maxCreditsPerWindow);
    }
}
