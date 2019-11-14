package predicate;

import java.util.function.Predicate;

public class HasMoreThanOnePhoneNumbers implements Predicate<User> {
    @Override
    public boolean test(User user){
        return user.getPhones().length > 1;
    }
}
