package mt_practice.circuitbreaker;

public interface Fallback<T> {
    T getFallback();
}
