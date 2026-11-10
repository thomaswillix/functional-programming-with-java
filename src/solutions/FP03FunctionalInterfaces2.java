package solutions;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        // Boolean comparison
        Predicate<Integer> isEvenPredicate = (Integer x) -> x%2==0;

        Function<Integer, Integer> squareFunction = x-> x*x;

        // Input & output defined of the function
        Function<Integer, String> stringOutputFunction = x -> x + "";

        // Consumer only processes
        Consumer<Integer> sysoutConsumer = System.out::println;

        // All operands must be of the same type
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        // No parameters, a simple factory method
        //Supplier<Integer> randomIntegerSupplier = () -> 2;

        // No parameters, a simple factory method multiline body
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        //System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        //System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, Integer> bothEven = (a, b) -> (a % 2 == 0) && (b % 2 == 0);
        //System.out.println(bothEven.test(1, 2)); // false


        String producto = "Café Latte";
        double precioBase = 3.50;

        BiPredicate<Integer, String> bniPredicate = (number, str) -> {
            return number<10 && str.length()>5;
        };

        System.out.println(bniPredicate.test(10, "in28minutes"));

        BiFunction<Integer, String, String> biFunction = (number, str) -> {
            return number + " " + str;
        };

        System.out.println(biFunction.apply(15, "in28minutes"));

        BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };

        biConsumer.accept(25, "in28minutes");

        //Better for efficiency as it doesn't need a wrapper, we use primitive type int directly
        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
    }
}
