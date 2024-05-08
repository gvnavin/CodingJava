package companies.atlassian.ratelimit.algo;

import companies.atlassian.ratelimit.RequestStatus;

public interface RateLimitAlgo {

    RequestStatus isAllowed(String id);

}
