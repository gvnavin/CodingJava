package mt_practice.circuitbreaker;

public class CircuitBreaker {
    private final int noOfFailureThreshold;
    private final int openStateTimeout;
    private final int halfOpenSuccessThreshold;

    private int noOfFailures = 0;
    private int noOfHalfOpenSuccess = 0;
    private long lastFailedTime = 0;
    private CircuitState currentState = CircuitState.CLOSED;

    public CircuitBreaker(int noOfFailureThreshold, int openStateTimeout, int halfOpenSuccessThreshold) {
        this.noOfFailureThreshold = noOfFailureThreshold;
        this.openStateTimeout = openStateTimeout;
        this.halfOpenSuccessThreshold = halfOpenSuccessThreshold;
    }

    public <T> T execute(ServiceCall<T> serviceCall, Fallback<T> fallback) {
        switch (currentState) {
            case CLOSED:
                T t = null;
                try {
                    t = serviceCall.call();
                    currentState = CircuitState.CLOSED;
                } catch (Exception e) {
                    noOfFailures++;
                    lastFailedTime = System.currentTimeMillis();
                    if (noOfFailures >= noOfFailureThreshold) {
                        currentState = CircuitState.OPEN;
                    }
                    return fallback.getFallback();
                }
                return t;
            case OPEN:
                if (System.currentTimeMillis() - lastFailedTime > openStateTimeout) {
                    currentState = CircuitState.HALF_OPEN;
                } else {
                    return fallback.getFallback();
                }
            case HALF_OPEN:
                T t1 = null;
                try {
                    t1 = serviceCall.call();
                    currentState = CircuitState.HALF_OPEN;
                    noOfHalfOpenSuccess ++;
                    if (noOfHalfOpenSuccess > halfOpenSuccessThreshold) {
                        currentState = CircuitState.CLOSED;
                        noOfFailures = 0;
                        noOfHalfOpenSuccess = 0;
                    }
                } catch (Exception e) {
                    currentState = CircuitState.OPEN;
                    lastFailedTime = System.currentTimeMillis();
                    return fallback.getFallback();
                }
                return t1;
            default:
                throw new IllegalStateException("Unexpected state: " + currentState);
        }

    }
}
