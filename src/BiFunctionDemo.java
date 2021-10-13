import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
            return x + y;
        };

        int result = add.apply(2, 3);
        System.out.println(result);

        TriFunction<Integer, Integer, Integer, Integer> addTri = (Integer x, Integer y, Integer z) -> {
            return x + y + z;
        };

        System.out.println(addTri.apply(2, 3, 4));

        NoArgFunction<String> noArgFunction = () -> {
            return "Hello World";
        };

        System.out.println(noArgFunction.apply());
    }
}
