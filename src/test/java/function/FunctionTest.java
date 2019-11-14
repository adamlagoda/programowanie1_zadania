package function;

import org.junit.jupiter.api.Test;
import predicate.Phone;
import predicate.User;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {

    private final String lowerCase = "lower case";
    private String userWithPhoneNumber = "Zygmunt - +48 123 456 789";
    private final User user;

    public FunctionTest() {
        user = new User("Zygmunt");
        Phone phone = new Phone("+48 123 456 789");
        user.setPhones(new Phone[]{phone});
    }

    @Test
    public void testToUppercaseFunction() {
        Function<String, String> toUppercase = s -> s.toUpperCase();

        Pattern onlySmallLetters = Pattern.compile("[a-z]+");
        assertFalse(onlySmallLetters.matcher(toUppercase.apply(lowerCase)).find());
    }

    @Test
    public void testToListOfPhoneNumbersFunction() {
        Function<User, List<String>> listOfPhoneNumbers = u -> {
            List<String> nameWithPhones = new LinkedList<>();
            for (Phone phone : u.getPhones()) {
                String nameWithPhone = u.getName() + " - " + phone.getNumber();
                nameWithPhones.add(nameWithPhone);
            }
            return nameWithPhones;
        };

        List<String> resultList = listOfPhoneNumbers.apply(user);

        assertTrue(resultList.stream()
                .anyMatch(s -> s.equals(userWithPhoneNumber)));
    }
}
