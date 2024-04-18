package practice.ratelimit.algo;

import practice.ratelimit.AlgoType;
import practice.ratelimit.Config;

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
