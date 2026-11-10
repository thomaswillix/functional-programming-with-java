package solutions;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParametrization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        // Only printing even numbers
        //filterAndPrint(numbers, x -> x % 2 == 0);

        // Only printing odd numbers
        //filterAndPrint(numbers, x -> x % 2 != 0);

        //Only printing multiples of three
        filterAndPrint(numbers, x -> x % 3 == 0);

        // Exercise 13
        List<Integer> squaredNumbers = mapAndCreateList(numbers, x -> x * x);
        List<Integer> cubedNumbers = mapAndCreateList(numbers, x -> x * x * x);
        List<Integer> doubleNumbers = mapAndCreateList(numbers, x -> x + x);

    }

    private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> function) {
        return numbers.stream()
                .map(function)
                .toList();
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
