package companies.atlassian.ratelimit.dao;

public interface Dao<T> {
    T get(String id);
    void put(T t);
}
