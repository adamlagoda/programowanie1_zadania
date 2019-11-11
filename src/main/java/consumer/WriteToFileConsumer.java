package consumer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class WriteToFileConsumer implements Consumer<String> {
    private final String filename;

    public WriteToFileConsumer(String filename) {
        this.filename = filename;
    }

    @Override
    public void accept(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            printWriter.println(message);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
