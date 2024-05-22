package mt_practice.circuitbreaker;

public interface ServiceCall<T> {
    T call() throws Exception;
}
