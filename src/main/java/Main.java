import person.Person;
import sort.non_comparison.CountingSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public final static int MAX_LENGTH = 50_000_000;

    public static void main(String[] args) {
        Person[] test = new Person[MAX_LENGTH];
        Person[] copy = new Person[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            test[i] = new Person((int) Math.floor(Math.random() * 200),
                    (int) Math.floor(Math.random() * 150),
                    (int) Math.floor(Math.random() * 100));
        }
        System.arraycopy(test, 0, copy, 0, MAX_LENGTH);

//        for (int i = 0; i<MAX_LENGTH; i++){
//            System.out.println(test[i]);
//        }
        long start1 = new Date().getTime();
        new CountingSort().sort(test, Person::getAge);
        long finish1 = new Date().getTime();

//        System.out.println("+++++++++++++++++++++++++++++++++++++++");

//        for (int i = 0; i<MAX_LENGTH; i++){
//            System.out.println(test[i]);
//        }

        long start2 = new Date().getTime();
        Arrays.sort(copy, Comparator.comparingInt(Person::getAge));
        long finish2 = new Date().getTime();

        System.out.println(finish1 - start1);
        System.out.println(finish2 - start2);
    }
}
