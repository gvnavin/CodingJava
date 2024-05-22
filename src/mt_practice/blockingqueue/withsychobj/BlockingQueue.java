package mt_practice.blockingqueue.withsychobj;

public class BlockingQueue<T> {

    private T[] queue;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;
    private final Object lockObject = new Object();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    public void enqueue(T obj) throws InterruptedException {
        synchronized (lockObject) {
            while (size == capacity) {
                lockObject.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            queue[tail] = obj;
            tail++;
            size++;
            lockObject.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (lockObject) {
            while (size == 0) {
                lockObject.wait();
            }

            if (head == capacity) {
                head = 0;
            }

            T item = queue[head];
            size--;
            head++;
            lockObject.notifyAll();
            return item;
        }
    }
}
