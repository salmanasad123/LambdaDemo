import java.util.function.Function;

public class LambdaFunction {

    public static void main(String[] args) {

        Function<Integer, Integer> absoluteValue = (Integer x) -> {
            if (x < 0) {
                return -x;
            } else {
                return x;
            }
        };

        int result = absoluteValue.apply(-2);
        System.out.println(result);
    }
}
