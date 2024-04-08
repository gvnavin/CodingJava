package atlassian.ratelimit.algo;

import atlassian.ratelimit.RequestStatus;

public interface RateLimitAlgo {

    RequestStatus isAllowed(String id);

}
