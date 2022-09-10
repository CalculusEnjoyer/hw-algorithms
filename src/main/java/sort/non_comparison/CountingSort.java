package sort.non_comparison;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class CountingSort implements NonComparisonSort {
    @Override
    public <A> A[] sort(A[] arr, ToIntFunction<A> getValue) {
        A personMax = arr[0];
        for (A i : arr) {
            if (getValue.applyAsInt(i) > getValue.applyAsInt(personMax)) personMax = i;
        }

        int[] countings = new int[getValue.applyAsInt(personMax) + 1];
        Arrays.fill(countings, 0);

        for (A i : arr) {
            countings[getValue.applyAsInt(i)]++;
        }

        int[] positions = new int[countings.length];
        Arrays.fill(positions, 0);
        int position = 0;
        for (int i = 0; i < countings.length - 1; i++) {
            position += countings[i];
            positions[i + 1] = position;
        }

        Object[] sorted = new Object[arr.length];

        for (A i : arr) {
            sorted[positions[getValue.applyAsInt(i)]] = i;
            positions[getValue.applyAsInt(i)]++;
        }

        System.arraycopy(sorted, 0, arr, 0, sorted.length);
        return arr;
    }
}
