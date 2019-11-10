package example;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCharactersFunctionTest {

    @Test
    public void countCharactersTestLambda() {
        Function<String, Integer> countCharacters = s -> s.length();
        assertEquals(6, countCharacters.apply("Johnny"));
    }

    @Test
    public void countCharactersTestAnonymousClass() {
        Function<String, Integer> countCharacters = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        assertEquals(4, countCharacters.apply("John"));
    }

    @Test
    public void countCharactersTestMethodReference() {
        Function<String, Integer> countCharacters = String::length;
        assertEquals(7, countCharacters.apply("Mateusz"));
    }

    @Test
    public void countCharactersTestImplementation() {
        Function<String, Integer> countCharacters = new CountCharactersFunction();
        assertEquals(9, countCharacters.apply("Winicjusz"));
    }
}
