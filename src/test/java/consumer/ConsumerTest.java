package consumer;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    private final String filename = "consumed.txt";
    private final String outputString = "Output message";
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public ConsumerTest() {
        /* Przekierowanie standardowego wyjścia (czyli konsoli) na własny potok.
           Dzięki temu, możemy sprawdzić, jaki łańcuch znaków przekazujemy z naszej funkcji na konsolę.*/
        System.setOut(new PrintStream(out));
    }

    @Test
    public void displayStringConsumerTestLambda() {
        Consumer<String> stringConsumer = s -> System.out.print(s);
        stringConsumer.accept(outputString);

        assertEquals(outputString, out.toString());
    }

    @Test
    public void displayStringConsumerTestAnonymousClass() {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        };
        stringConsumer.accept(outputString);

        assertEquals(outputString, out.toString());
    }

    @Test
    public void displayStringConsumerTestMethodReference() {
        Consumer<String> stringConsumer = System.out::print;
        stringConsumer.accept(outputString);

        assertEquals(outputString, out.toString());
    }

    @Test
    public void displayStringConsumerTestImplementation() {
        Consumer<String> stringConsumer = new DisplayStringConsumer();
        stringConsumer.accept(outputString);

        assertEquals(outputString, out.toString());
    }

    @Test
    public void writeToFileConsumerLambda() {
        Consumer<String> stringConsumer = s -> {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
                printWriter.println(s);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        };

        stringConsumer.accept(outputString);

        checkReadStringEqualsWritten();
    }

    @Test
    public void writeToFileConsumerTestAnonymousClass() {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
                    printWriter.println(s);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        };
        stringConsumer.accept(outputString);

        checkReadStringEqualsWritten();
    }

    @Test
    public void writeToFileConsumerTestMethodReference() throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(filename));
        Consumer<String> stringConsumer = printWriter::println;

        stringConsumer.accept(outputString);
        printWriter.close();

        checkReadStringEqualsWritten();
    }

    @Test
    public void writeToFileConsumerTestImplementation() {
        Consumer<String> stringConsumer = new WriteToFileConsumer(filename);
        stringConsumer.accept(outputString);

        checkReadStringEqualsWritten();
    }

    private void checkReadStringEqualsWritten() {
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner scanner = new Scanner(fileReader);
            scanner.useDelimiter("\n");
            assertEquals(outputString, scanner.next());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
