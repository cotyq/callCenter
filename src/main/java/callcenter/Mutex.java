package callcenter;

import java.util.concurrent.Semaphore;

public class Mutex {
    private static Semaphore semaphore = new Semaphore(0);

    public static void up() {
        semaphore.release();
    }

    public static void down() throws InterruptedException {
        semaphore.acquire();
    }
}
