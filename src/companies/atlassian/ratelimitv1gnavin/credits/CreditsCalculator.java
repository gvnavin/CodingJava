package companies.atlassian.ratelimitv1gnavin.credits;

public interface CreditsCalculator {
    int calculateCredits(long previousTimeStampInSeconds, long currentTimeStampInSeconds);
}
