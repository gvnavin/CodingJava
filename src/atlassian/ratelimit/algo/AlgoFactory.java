package atlassian.ratelimit.algo;

import atlassian.ratelimit.AlgoType;
import atlassian.ratelimit.Config;

public class AlgoFactory {

    public static class Holder {
        public static AlgoFactory INSTANCE = new AlgoFactory();
    }

    public static AlgoFactory getInstance() {
        return Holder.INSTANCE;
    }

    public RateLimitAlgo getAlgo(Config config) {
        if (config.getAlgo() == AlgoType.SLIDING_WINDOW) {
            return new SlidingWindowAlgo(config);
        }

        throw new IllegalArgumentException();
    }

}
