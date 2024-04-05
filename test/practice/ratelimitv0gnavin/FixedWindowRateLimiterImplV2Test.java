package practice.ratelimitv0gnavin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedWindowRateLimiterImplV2Test {

    @Test
    void ratelimit() throws InterruptedException {

        FixedWindowRateLimiterImplV2 fixedWindowRateLimiterImplV2 = new FixedWindowRateLimiterImplV2(1, 1, 1);

        //new customer
        assertTrue(fixedWindowRateLimiterImplV2.ratelimit(1));
        //existing customer, second request should fail based on no of allowed requests
        //but credits are available, so it should work
        assertTrue(fixedWindowRateLimiterImplV2.ratelimit(1));
        //existing customer, third request should fail based on no of allowed requests
        //used all the allowed requests and no credits
        assertFalse(fixedWindowRateLimiterImplV2.ratelimit(1));

        Thread.sleep(1500);

        assertTrue(fixedWindowRateLimiterImplV2.ratelimit(2));

    }
}