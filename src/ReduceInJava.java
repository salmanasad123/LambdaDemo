import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceInJava {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integerList = Arrays.asList(intArray);

        // finding the sum of all elements.
        // acc is accumulator or carry
        BinaryOperator<Integer> getSum = (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc: " + acc + " , " + "x: " + x + " , " + "result: " + result);
            return result;
        };

        Integer sum = integerList
                .stream()
                .reduce(0, getSum);

        System.out.println(sum);
    }
}
