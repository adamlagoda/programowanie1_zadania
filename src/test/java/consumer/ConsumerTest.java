package consumer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

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

}
