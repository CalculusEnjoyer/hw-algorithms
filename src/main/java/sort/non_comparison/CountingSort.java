package sort.non_comparison;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class CountingSort implements NonComparisonSort {
//    This is sorting method based on counting sort algorithm. It is useful when you have
//    to sort array using on one integer field. It has O(N) time and
//    O(N) memory complexities. Even though it requires O(N) memory, testing shows that it is
//    approximately 5 times faster than default Array.sort() algorithm on a 30 000 000 array.
//    (and with bigger arrays efficiency continue to increase). So you should you this algorithm
//    when you really need computational speed, and you have enough RAM.
    @Override
    public <A> A[] sort(A[] arr, ToIntFunction<A> getValue) {
        A personMax = arr[0];

//      c0*n
        for (A i : arr) {
            if (getValue.applyAsInt(i) > getValue.applyAsInt(personMax)) personMax = i;
        }

        int[] countings = new int[getValue.applyAsInt(personMax) + 1];
        Arrays.fill(countings, 0);

//      c1*n
        for (A i : arr) {
            countings[getValue.applyAsInt(i)]++;
        }

        int[] positions = new int[countings.length];
        Arrays.fill(positions, 0);
        int position = 0;

//      If getValue has limited range (like age, weight) counting would not
//      contain more than 100-200 elements, so we can approximate actions
//      with countings as const c2.
        for (int i = 0; i < countings.length - 1; i++) {
            position += countings[i];
            positions[i + 1] = position;
        }

//      memory c3*n
        Object[] sorted = new Object[arr.length];

//      c3*n
        for (A i : arr) {
            sorted[positions[getValue.applyAsInt(i)]] = i;
            positions[getValue.applyAsInt(i)]++;
        }
//      c4*n
        System.arraycopy(sorted, 0, arr, 0, sorted.length);

//      Total complexity: n*(c0+c1+c4)+c2 = O(N)
//      Memory complexity: c3*n = O(N)

        return arr;
    }
}
