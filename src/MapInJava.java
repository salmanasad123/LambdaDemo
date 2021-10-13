import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapInJava {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = Arrays.asList(intArray);

        Function<Integer, Integer> timesTwo = (x) -> {
            return x * 2;
        };

        List<Integer> doubled = integerList.stream()
                .map((x) -> {
                    return 2 * x;
                })
                .collect(Collectors.toList());

        List<Integer> doubledTwo = integerList.stream()
                .map(timesTwo)
                .collect(Collectors.toList());
    }
}

