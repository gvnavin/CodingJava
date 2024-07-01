package coupang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowRateLimiterTest {

    public static final String CLIENT_1 = "client_1";
    private static final String CLIENT_2 = "client_2";

    @Test
    void isAllowed() throws InterruptedException {
        Config config = new Config(1);
        RateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(config);

        boolean ret;
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertFalse(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertFalse(ret);
        Thread.sleep(1000);

        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertTrue(ret);
    }

    @Test
    void isAllowedWithDuration() throws InterruptedException {
        Config config = new Config(1, 1);
        RateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(config);

        boolean ret;
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertFalse(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertFalse(ret);
        Thread.sleep(1000);

        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertTrue(ret);
    }

    @Test
    void isAllowedWithDurationMoreThan1Seconds() throws InterruptedException {
        Config config = new Config(1, 3);
        RateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(config);

        boolean ret;
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertTrue(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertFalse(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertFalse(ret);
        Thread.sleep(1000);

        ret = slidingWindowRateLimiter.isAllowed(CLIENT_1);
        Assertions.assertFalse(ret);
        ret = slidingWindowRateLimiter.isAllowed(CLIENT_2);
        Assertions.assertFalse(ret);
    }
}
