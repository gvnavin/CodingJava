package practice.walmart;

public class Producer<T> {

    private String producerId;

    public Producer(String producerId) {
        this.producerId = producerId;
    }

    ProduceStatus produce(T obj) {
        produce(obj, QueueConstants.MAIN_QUEUE);
    }

    ProduceStatus produce(T obj, String subscriptionKey) {

    }

}
