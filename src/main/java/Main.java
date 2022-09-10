import person.Person;
import person.UniqueFinder;
import sort.non_comparison.CountingSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static final int BENCHMARK_LENGTH = 30_000_000;
    public static final int SHOW_LENGTH = 100_000;

    public static void main(String[] args) {
//      task 1 with linear time complexity (complexity analysis in CountingSort class)

        Person[] test = new Person[BENCHMARK_LENGTH];
        for (int i = 0; i < BENCHMARK_LENGTH; i++) {
            test[i] = new Person((int) (Math.random() * 220),
                    (int) (Math.random() * 200),
                    (int) (Math.random() * 120));
        }

        long start1 = new Date().getTime();
        new CountingSort().sort(test, Person::getAge);
        long finish1 = new Date().getTime();

//        for (int i = 0; i<BENCHMARK_LENGTH; i++){
//            System.out.println(test[i]);
//        }

        for (int i = 0; i < BENCHMARK_LENGTH; i++) {
            test[i] = new Person((int) (Math.random() * 150),
                    (int) (Math.random() * 150),
                    (int) (Math.random() * 150));
        }


        long start2 = new Date().getTime();
        Arrays.sort(test, Comparator.comparingInt(Person::getAge));
        long finish2 = new Date().getTime();

//        for (int i = 0; i<BENCHMARK_LENGTH; i++){
//            System.out.println(test[i]);
//        }

        System.out.println("Counting sort time: " + (finish1 - start1));
        System.out.println("Default Array.sort() time: " + (finish2 - start2));
        System.out.println("=======================================");

//      task 2
        Person test1[] = new Person[SHOW_LENGTH];
        for (int i = 0; i < SHOW_LENGTH; i++) {
            test1[i] = new Person((int) (Math.random() * 220),
                    (int) (Math.random() * 200),
                    (int) (Math.random() * 120));
        }

        new CountingSort().sort(test1, Person::getHeight);

//        for (int i = 0; i<BENCHMARK_LENGTH; i++){
//            System.out.println(test[i]);
//        }

        new CountingSort().sort(test1, Person::getWeight);

//        for (int i = 0; i<BENCHMARK_LENGTH; i++){
//            System.out.println(test[i]);
//        }

//        task 3 (time complexity analysis in UniqueFinder class)

        for (int i = 0; i < SHOW_LENGTH; i++) {
            test1[i] = new Person((int) (Math.random() * 220),
                    (int) (Math.random() * 200),
                    (int) (Math.random() * 120));
        }

        Comparator<Person> comparator = Comparator.comparing(Person::getWeight)
                .thenComparing(Person::getHeight);

        System.out.println("Elements with unique weight and height :" + UniqueFinder.uniqueCounter(test1, comparator));
    }
}
