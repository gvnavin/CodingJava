package mt_practice.tokenbucket.usingLastRequestTime;

import java.util.HashSet;
import java.util.Set;

class TokenBucketFilter {
    private int max_tokens;
    private long lastRequestTime;
    private int possibleToken;

    public TokenBucketFilter(int tokens) {
        max_tokens = tokens;
        System.out.println("max_tokens = " + max_tokens);
        lastRequestTime = System.currentTimeMillis() / 1000;
    }

    public synchronized void getToken() throws InterruptedException {
        long currentTime = System.currentTimeMillis() / 1000;
        long numberOfSeconds = lastRequestTime - currentTime;

        if (numberOfSeconds > 0) {
            possibleToken = max_tokens;
        }
        if (possibleToken > max_tokens) {
            possibleToken = max_tokens;
        }
        System.out.println(Thread.currentThread().getName() + "1 possibleToken = " + possibleToken);
        if (possibleToken == 0) {
            Thread.sleep(1000);
        } else {
            possibleToken--;
        }
        System.out.println(Thread.currentThread().getName() + "2 possibleToken = " + possibleToken);
        lastRequestTime = currentTime;
        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + lastRequestTime);
    }

    public static void runTestMaxTokenIs1() throws InterruptedException {

        Set<Thread> allThreads = new HashSet<Thread>();
        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(1);

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }

    public static void runTestMaxTokenIs5() throws InterruptedException {

        Set<Thread> allThreads = new HashSet<Thread>();
        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);

        // Sleep for 10 seconds.
        Thread.sleep(10000);

        // Generate 12 threads requesting tokens almost all at once.
        for (int i = 0; i < 12; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        tokenBucketFilter.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }

}
