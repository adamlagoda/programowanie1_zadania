package predicate;

import java.util.function.Predicate;

public class ConstainsPolishCharactersPredicate implements Predicate<String> {

    private final char[] polishCharacters = {'ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ś', 'ż', 'ź'};

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
}
