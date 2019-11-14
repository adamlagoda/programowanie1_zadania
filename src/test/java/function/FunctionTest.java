package function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import predicate.User;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {

    private final String lowerCase = "lower case";
    private String userWithPhoneNumber = "Zygmunt - +48 123 456 789";
    private final User user;

    public FunctionTest() {
        user = new User();
    }

    @Test
    @Disabled
    public void testToUppercaseFunction() {
        Function<String, String> toUppercase = s -> null;

        Pattern onlySmallLetters = Pattern.compile("[a-z]+");
        assertFalse(onlySmallLetters.matcher(toUppercase.apply(lowerCase)).find());
    }

    @Test
    @Disabled
    public void testToListOfPhoneNumbersFunction() {
        Function<String, String> listOfPhoneNumbers = null;

        List<String> resultList = null;

        assertTrue(resultList.stream()
                .anyMatch(s -> s.equals(userWithPhoneNumber)));
    }
}
