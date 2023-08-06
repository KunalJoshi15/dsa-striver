package collections;

import java.util.*;

public class ListUsages {

    public static void main(String[] args) {
        List<Student> test = new ArrayList<>();
        test.add(new Student("1", "Kunal", "Joshi", "Vnam", "2010a"));
        test.add(new Student("2", "Aest1", "test2", "test3", "test4"));
        Collections.sort(test, new TestComparator());

        test.stream()
                .forEach(System.out::println);
    }
}
