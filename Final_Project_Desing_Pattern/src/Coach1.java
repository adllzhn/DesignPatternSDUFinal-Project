public class Coach1 implements Runnable {
    public Coach1() {
    }

    public void run() {
        while(CoachesBattle.firstHP > 0 && CoachesBattle.secondHP > 0) {
            if (!CoachesBattle.command) {
                CoachesFight.giveFirstCommand();
            }

            try {
                Thread.sleep(500L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }

    }
}