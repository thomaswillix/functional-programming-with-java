package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}


public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("FullStack", "FullStack", 91, 25000),
                new Course("AWS", "Cloud", 91, 21000),
                new Course("Azure", "Cloud", 92, 21000),
                new Course("Docker", "Cloud", 99, 20000),
                new Course("Kubernetes", "Cloud", 92, 20000)
        );

        //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
        Predicate<Course> categoryIsCloudPredicate = course -> course.getCategory().equals("Cloud");

        //System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        //System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        //System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));
        //System.out.println(courses.stream().anyMatch(categoryIsCloudPredicate));

        Comparator<Course> comparingNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsIncreasing)
                        .collect(Collectors.toList()));
        // [Spring Boot:18000:95, Spring:20000:98, Docker:20000:99, Kubernetes:20000:92, AWS:21000:91, Azure:21000:92, API:22000:97, FullStack:25000:91]

        Comparator<Course> comparingNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsDecreasing)
                        .collect(Collectors.toList()));
        //[FullStack:25000:91, API:22000:97, AWS:21000:91, Azure:21000:92, Spring:20000:98, Docker:20000:99, Kubernetes:20000:92, Spring Boot:18000:95]

        Comparator<Course> comparingNoOfStudentsAndNoOfReviews =
                Comparator.comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();
        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsAndNoOfReviews)
                        .collect(Collectors.toList()));
        //[FullStack:25000:91, API:22000:97, Azure:21000:92, AWS:21000:91, Docker:20000:99, Spring:20000:98, Kubernetes:20000:92, Spring Boot:18000:95]


        // limit, skip, takeWhile and dropWhile
        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsAndNoOfReviews)
                        .limit(5)
                        .collect(Collectors.toList()));
        //[FullStack:25000:91, API:22000:97, Azure:21000:92, AWS:21000:91, Docker:20000:99]

        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .collect(Collectors.toList()));
        //[AWS:21000:91, Docker:20000:99, Spring:20000:98, Kubernetes:20000:92, Spring Boot:18000:95]

        System.out.println(
                courses.stream()
                        .sorted(comparingNoOfStudentsAndNoOfReviews)
                        .skip(3)
                        .limit(3)
                        .collect(Collectors.toList()));
        //[AWS:21000:91, Docker:20000:99, Spring:20000:98]

        //Original list of courses:
        System.out.println(courses);
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, FullStack:25000:91, AWS:21000:91, Azure:21000:92, Docker:20000:99, Kubernetes:20000:92]

        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97]

        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        //[FullStack:25000:91, AWS:21000:91, Azure:21000:92, Docker:20000:99, Kubernetes:20000:92]
    }
}
