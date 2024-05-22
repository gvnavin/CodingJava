package mt_practice.blockingqueue.withmutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithMutex<T> {

    private T[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;
    private final Lock lockObject = new ReentrantLock();

    public BlockingQueueWithMutex(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public void enqueue(T obj) throws InterruptedException {

        lockObject.lock();
        while (size == capacity) {
            lockObject.unlock();
            lockObject.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        queue[tail] = obj;
        tail++;
        size++;
        lockObject.unlock();

    }

    public T dequeue() throws InterruptedException {
        lockObject.lock();
        while (size == 0) {
            lockObject.unlock();
            lockObject.lock();
        }

        if (head == capacity) {
            head = 0;
        }

        T item = queue[head];
        size--;
        head++;

        lockObject.unlock();

        return item;
    }
}
