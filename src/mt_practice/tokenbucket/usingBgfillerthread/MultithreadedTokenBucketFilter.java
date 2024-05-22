package mt_practice.tokenbucket.usingBgfillerthread;

public class MultithreadedTokenBucketFilter {

    private int maxTokens;
    private int possibleToken = 0;

    public MultithreadedTokenBucketFilter(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public void init() {
        Thread thread = new Thread(() -> demonThread());
        thread.start();
    }

    void demonThread() {
        while (true) {
            synchronized (this) {
                possibleToken = maxTokens;
            }
            this.notify();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("e = " + e);
            }
        }
    }

    public void getToken() throws InterruptedException {
        synchronized (this) {
            while (possibleToken == 0) {
                this.wait();
            }
            possibleToken--;
        }
        System.out.println(
                "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
    }
}
