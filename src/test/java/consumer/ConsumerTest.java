package consumer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

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
    @Disabled
    public void displayStringConsumerTestLambda() {

        assertEquals(outputString, out.toString());
    }

    @Test
    @Disabled
    public void displayStringConsumerTestAnonymousClass() {

        assertEquals(outputString, out.toString());
    }

    @Test
    @Disabled
    public void displayStringConsumerTestMethodReference() {

        assertEquals(outputString, out.toString());
    }

    @Test
    @Disabled
    public void displayStringConsumerTestImplementation() {

        assertEquals(outputString, out.toString());
    }

    @Test
    @Disabled
    public void writeToFileConsumerLambda() {

        checkReadStringEqualsWritten();
    }

    @Test
    @Disabled
    public void writeToFileConsumerTestAnonymousClass() {

        checkReadStringEqualsWritten();
    }

    @Test
    @Disabled
    public void writeToFileConsumerTestMethodReference() {

        checkReadStringEqualsWritten();
    }

    @Test
    @Disabled
    public void writeToFileConsumerTestImplementation() {

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
