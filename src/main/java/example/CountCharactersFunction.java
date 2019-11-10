package example;

import java.util.function.Function;

public class CountCharactersFunction implements Function<String, Integer> {

    public Integer apply(String s) {
        return s.length();
    }
}
