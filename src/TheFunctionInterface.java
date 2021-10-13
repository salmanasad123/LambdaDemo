import java.util.function.Function;

public class TheFunctionInterface {

    protected static class MyMath {
        public static Integer triple(int x) {
            return x * 3;
        }
    }

    public static void main(String[] args) {

        Function<Integer, Integer> myTriple = MyMath::triple;
        // call myTriple function
        int result = myTriple.apply(4);
        System.out.println(result);
    }
}
