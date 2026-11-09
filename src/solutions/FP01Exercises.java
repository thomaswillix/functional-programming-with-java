package solutions;

import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
        List<String> courses = List.of(
                "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"
        );
        // printAllNumbersInListStructured(numbers);
        // printAllEvenNumbersInListStructured(numbers);
        // printAllOddNumbersInListStructured(numbers);
        // printAllCoursesIndividually(courses);
        // printAllSpringCourses(courses);
        // printAllCoursesWhoseNameHasAtLeastFourLetters(courses);
        // printSquaresOfEvenNumbersInList(numbers);
        // printCubesOfOddNumbersInList(numbers);
        printNumberOfCharactersInEachCourseName(courses);
    }

    private static void print(int number) {
        System.out.println(number);;
    }

    // private static boolean isEven(int number) {
    //     return number %2 == 0;
    // }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        numbers.forEach(FP01Exercises::print);
    }

    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2==0)
                .forEach(System.out::println);
    }

    private static void printAllOddNumbersInListStructured(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 1)
                .forEach(System.out::println);
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private static void printAllSpringCourses(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCoursesWhoseNameHasAtLeastFourLetters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInList(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number  -> number * number)
                .forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInList(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number % 2 == 1)
                .map(number  -> (int) Math.pow(number, 3))
                .forEach(System.out::println);
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> courses) {
        courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

}
