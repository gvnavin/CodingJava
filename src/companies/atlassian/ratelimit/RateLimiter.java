package companies.atlassian.ratelimit;

public interface RateLimiter {

    ConfigRegistrationStatus register(Config config);

    RequestStatus isRequestAllowed(Request req);

}
