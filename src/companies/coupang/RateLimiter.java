package companies.coupang;

public interface RateLimiter {

    public boolean isAllowed(String clientId);

}
