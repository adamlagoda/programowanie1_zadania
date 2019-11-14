package predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

    private final String containingPolishChars = "Dżawa";
    private final String nonContainingPolishChars = "Java";
    private final User userWithOnePhone;
    private final User userWithMultiplePhones;

    public PredicateTest() {
        userWithOnePhone = new User();
        userWithMultiplePhones = new User();
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestLambda() {
        Predicate<String> containsPolishCharacters = null;

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestAnonymousClass() {
        Predicate<String> containsPolishCharacters = null;


        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void containsPolishCharactersTestImplementation() {
        Predicate<String> containsPolishCharacters = null;

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    @Disabled
    public void hasMoreThanOnePhoneTestLambda() {
        Predicate<User> hasMoreThanOnePhone = null;

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }

    @Test
    @Disabled
    public void hasMoreThanOnePhoneTestAnonymousClass() {
        Predicate<User> hasMoreThanOnePhone = null;

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }

    @Test
    @Disabled
    public void hasMoreThanOnePhoneTestImplementation() {
        Predicate<User> hasMoreThanOnePhone = null;

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }
}
