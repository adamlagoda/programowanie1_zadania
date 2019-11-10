package consumer;

import java.util.function.Consumer;

public class DisplayStringConsumer implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.print(s);
    }
}
