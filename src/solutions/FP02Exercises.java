package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of(
                "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"
        );
        //System.out.println("Numbers list: " + numbers);
        //System.out.println("Add numbers with Integer::sum: " + addListFunctional(numbers));
        //System.out.println("Add numbers with lambda (x, y) -> x + y: " + addListLambda(numbers));
        //System.out.println("Compare highest number 0, (x, y) -> x > y ? x : y " + compareHighestNumber(numbers));
        //System.out.println("Compare the lowest number Integer.MAX_VALUE, (x, y) -> x > y ? y : x " + compareLowestNumber(numbers));

        // Exercise 7
        //System.out.println("Square every number in a list and find the sum of squares: " + findSumOfSquaresInList(numbers));

        // Exercise 8
        //System.out.println("Cube every number in a list and find the sum of cubes: " + findSumOfCubesInList(numbers));

        // Exercise 9
        //System.out.println("Find sum of odd numbers in a list: " + findSumOfOddNumbersInList(numbers));

        //printDistinctValuesFromList(numbers);
        //printSortedValuesFromList(numbers);
        //printDistinctAndSortedValuesFromList(numbers);
        //printComparingStringLengthFromList(courses);

        //List<Integer> doubledNumbers = numbers.stream()
        //        .map(x -> x*x)
        //        .collect(Collectors.toList());
        //System.out.println(doubledNumbers);

        // Exercise 10
        List<Integer> evenNumbersList = numbers.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbersList);

        // Exercise 11
        List<Integer> courseTitlesLengthsList = courses.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(courseTitlesLengthsList);
    }


    private static int addListLambda(List<Integer> numbers){
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    private static int addListFunctional(List<Integer> numbers){
        // Each sum is a lambda (x, y) -> x + y in which x == acc & y == numActual
        // reduce only makes the list reduce into a single element, the operation inside is what describes this function
        return numbers.stream().reduce(0, Integer::sum);
    }

    private static int compareHighestNumber(List<Integer> numbers){
        return numbers.stream().reduce(0, (x, y) -> x > y ? x : y);
    }

    private static int compareLowestNumber(List<Integer> numbers){
        return numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
    }

    private static int findSumOfSquaresInList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);
    }

    private static int findSumOfCubesInList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
    }

    private static int findSumOfOddNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number%2==1)
                .reduce(0, Integer::sum);
    }

    private static void printDistinctValuesFromList(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void printSortedValuesFromList(List<Integer> numbers) {
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void printDistinctAndSortedValuesFromList(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
    private static void printComparingStringLengthFromList(List<String> courses) {
        courses.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
