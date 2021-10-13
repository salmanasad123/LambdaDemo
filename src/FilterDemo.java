import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterDemo {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = Arrays.asList(intArray);

        Predicate<Integer> evenCheck = (Integer x) -> {
            return x % 2 == 0 ? true : false;
        };

        List<Integer> evens = integerList.stream()
                .filter(evenCheck)
                .collect(Collectors.toList());

        System.out.println(evens);

        String[] wordsArray = {"hello", "functional", "programming", "is", "cool"};
        List<String> wordsList = Arrays.asList(wordsArray);

        List<String> lengthGreaterThan5 = wordsList
                .stream()
                .filter((String str) -> {
                    return str.length() > 5;
                })
                .collect(Collectors.toList());

        System.out.println(lengthGreaterThan5);

        // a function that checks for different lengths
        Function<Integer, Predicate<String>> functionThatChecksForAnyLength = (Integer minLength) -> {
            return (String str) -> str.length() > minLength;
        };

        // create a predicate that check for length > 3
        Predicate<String> checkForGreaterThan3 = functionThatChecksForAnyLength.apply(3);
        // create a predicate that checks for length > 5
        // apply is used to call the function
        Predicate<String> checkForLengthGreaterThan5 = functionThatChecksForAnyLength.apply(5);

        List<String> wordListWithWordsGreaterThan3 = wordsList
                .stream()
                .filter(checkForGreaterThan3)
                .collect(Collectors.toList());

        System.out.println(wordListWithWordsGreaterThan3);

        wordsList
                .stream()
                .filter(checkForLengthGreaterThan5)
                .collect(Collectors.toList());
    }
}
