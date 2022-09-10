package person;

import sort.comparison.HeapSort;

import java.util.Comparator;

public class UniqueFinder {
    private UniqueFinder() {
    }

    public static int countSameWeightDiffHeight(Person[] arr) {
        Comparator<Person> comparator = Comparator.comparing(Person::getWeight)
                .thenComparing(Person::getHeight);

        Person[] copy = new Person[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);

        new HeapSort().sort(copy, comparator);

        Person previous = copy[0];
        int result = 1;

        for (Person person : copy) {
            if (!(comparator.compare(person, previous) == 0)) {
                result++;
            }
            previous = person;
        }

        return result;
    }
}
