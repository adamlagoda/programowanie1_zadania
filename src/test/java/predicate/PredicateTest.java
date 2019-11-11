package predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

    private final String containingPolishChars = "Dżawa";
    private final String nonContainingPolishChars = "Java";

    @Test
    @Disabled
    public void containsPolishCharactersTestLambda() {
        Predicate<String> containsPolishCharacters;

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestAnonymousClass() {
        Predicate<String> containsPolishCharacters;


        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestImplementation() {
        Predicate<String> containsPolishCharacters;

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

}
