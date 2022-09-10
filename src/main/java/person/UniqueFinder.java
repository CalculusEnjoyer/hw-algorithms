package person;

import sort.comparison.HeapSort;

import java.util.Comparator;

public final class UniqueFinder {
    private UniqueFinder() {
    }

    public static int uniqueCounter(Person[] arr, Comparator<Person> comparator) {
//      Finds number of unique elements (if array contains
//      multiple unique elements, it counts then as one)

//      Coping in order to not change input array
//      c0*n
        Person[] copy = new Person[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);

//      c1*n*log(n)
        new HeapSort().sort(copy, comparator);

        Person previous = copy[0];
        int result = 1;

//      c2*n
        for (Person person : copy) {
            if (comparator.compare(person, previous) != 0) {
                result++;
            }
            previous = person;
        }
//      Total complexity = (c0+c2)*n + c1*n*log(n) = O(N*log(N))
        return result;
    }
}
