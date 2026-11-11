package solutions;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    private static void print(String string){
        System.out.println(string);
    }
    public static void main(String[] args) {
        List<String> courses = List.of(
                "Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes"
        );

        courses.stream()
                //.map(string -> string.toUpperCase())
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);

        Supplier<String> supplier = String::new;
    }
}
