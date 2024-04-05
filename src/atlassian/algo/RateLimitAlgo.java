package atlassian.algo;

import atlassian.RequestStatus;

public interface RateLimitAlgo {

    RequestStatus isAllowed(String id);

}
