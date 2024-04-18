package practice.ratelimit.algo;

import practice.ratelimit.RequestStatus;

public interface RateLimitAlgo {

    RequestStatus isAllowed(String id);

}
