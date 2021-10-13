import java.util.function.Function;

public class ReturningFunction {

    static class MyMath {

        public static Integer timesTwo(Integer x) {
            return x * 2;
        }

        public static Integer timesThree(Integer x) {
            return x * 3;
        }

        public static Integer timesFour(Integer x) {
            return x * 4;
        }

        public static Function<Integer, Integer> createMultiplier(Integer y) {
            return (Integer x) -> {
                return x * y;
            };
        }
    }

    public static void main(String[] args) {
        // a function that returns a function

        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            return () -> {
                return "Hello Functional!";
            };
        };

        NoArgFunction<String> greeter = createGreeter.apply();

        System.out.println(greeter.apply());

        Function<Integer, Integer> timesTwo = MyMath.createMultiplier(2);

        System.out.println(timesTwo.apply(3));

    }
}
