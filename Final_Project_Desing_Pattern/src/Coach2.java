public class Coach2 implements Runnable {
    public Coach2() {
    }

    public void run() {
        while(CoachesBattle.firstHP > 0 && CoachesBattle.secondHP > 0) {
            if (!CoachesBattle.command) {
                CoachesFight.giveSecondCommand();
            }

            try {
                Thread.sleep(500L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }

    }
}