package predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

    private final String containingPolishChars = "Dżawa";
    private final String nonContainingPolishChars = "Java";
    private final char[] polishCharacters = {'ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ś', 'ż', 'ź'};

    @Test
    @Disabled
    public void containsPolishCharactersTestLambda() {
        Predicate<String> containsPolishCharacters = s ->
                s.chars()
                        .anyMatch(c -> {
                            for (char polishChar : polishCharacters)
                                if (c == polishChar)
                                    return true;
                            return false;
                        });

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestAnonymousClass() {
        Predicate<String> containsPolishCharacters = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.chars()
                        .anyMatch(c -> {
                            for (char polishChar : polishCharacters)
                                if (polishChar == c)
                                    return true;
                            return false;
                        });
            }
        };

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestImplementation() {
        Predicate<String> containsPolishCharacters = new ConstainsPolishCharactersPredicate();

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }
}
