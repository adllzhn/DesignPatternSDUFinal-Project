import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger {
    public Logger logger = Logger.getLogger("MyLogger");
    FileHandler fh;

    public FileLogger(String pathToFile) {
        try {
            this.fh = new FileHandler(pathToFile);
            this.logger.addHandler(this.fh);
            SimpleFormatter formatter = new SimpleFormatter();
            this.fh.setFormatter(formatter);
            this.logger.setUseParentHandlers(false);
            this.logger.info("Your FileLogger is ready!");
        } catch (IOException | SecurityException var3) {
            var3.printStackTrace();
        }

    }
}
