import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoachesFight {
    public static int firstCommand;
    public static int secondCommand;
    static Lock lock = new ReentrantLock();

    public CoachesFight() {
    }

    static void giveFirstCommand() {
        lock.lock();

        try {
            Random rand = new Random();
            firstCommand = rand.nextInt(3);
        } catch (Exception var4) {
            var4.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    static void giveSecondCommand() {
        lock.lock();

        try {
            Random rand = new Random();
            secondCommand = rand.nextInt(3);
        } catch (Exception var4) {
            var4.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
