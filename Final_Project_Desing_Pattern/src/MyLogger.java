import java.util.logging.Logger;

public class MyLogger {
    public Logger logger = Logger.getLogger("MyLogger");

    public MyLogger() {
        this.logger.info("Your logger is ready!");
    }
}