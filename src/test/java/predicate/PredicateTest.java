package predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredicateTest {

    private final String containingPolishChars = "Dżawa";
    private final String nonContainingPolishChars = "Java";
    private User userWithOnePhone;
    private User userWithMultiplePhones;
    private final char[] polishCharacters = {'ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ś', 'ż', 'ź'};

    private PredicateTest() {
        userWithMultiplePhones = new User("user with multiple phones");
        userWithOnePhone = new User("user with one phone");

        Phone phone1 = new Phone("+48 123 456 789");
        Phone phone2 = new Phone("+48 987 654 321");

        userWithOnePhone.setPhones(new Phone[]{phone1});
        userWithMultiplePhones.setPhones(new Phone[]{phone1, phone2});
    }

    @Test
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
    public void containsPolishCharactersTestImplementation() {
        Predicate<String> containsPolishCharacters = new ConstainsPolishCharactersPredicate();

        assertTrue(containsPolishCharacters.test(containingPolishChars));
        assertFalse(containsPolishCharacters.test(nonContainingPolishChars));
    }

    @Test
    public void hasMoreThanOnePhoneTestLambda() {
        Predicate<User> hasMoreThanOnePhone = u -> u.getPhones().length > 1;

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }

    @Test
    public void hasMoreThanOnePhoneTestAnonymousClass() {
        Predicate<User> hasMoreThanOnePhone = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getPhones().length > 1;
            }
        };

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }

    @Test
    public void hasMoreThanOnePhoneTestImplementation() {
        Predicate<User> hasMoreThanOnePhone = new HasMoreThanOnePhoneNumbers();

        assertTrue(hasMoreThanOnePhone.test(userWithMultiplePhones));
        assertFalse(hasMoreThanOnePhone.test(userWithOnePhone));
    }
}
