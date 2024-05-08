package companies.atlassian.ratelimitv1gnavin.credits;

public class CreditsCalculatorFactory {
    static public class InstanceHolder {
        public static CreditsCalculatorFactory instance = new CreditsCalculatorFactory();
    }

    public static CreditsCalculatorFactory getInstance() {
        return InstanceHolder.instance;
    }

    public CreditsCalculator get(long windowDurationInSeconds, int maxCreditsPerWindow) {
        return new SimpleCreditsCalculator(windowDurationInSeconds, maxCreditsPerWindow);
    }
}
