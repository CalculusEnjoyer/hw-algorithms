package sort.non_comparison;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class CountingSort implements NonComparisonSort {
    @Override
    public <A> A[] sort(A[] personArr, ToIntFunction<A> getValue) {
        A personMax = personArr[0];
        for (A i : personArr) {
            if (getValue.applyAsInt(i) > getValue.applyAsInt(personMax)) personMax = i;
        }

        int[] countings = new int[getValue.applyAsInt(personMax) + 1];
        Arrays.fill(countings, 0);

        for (A i : personArr) {
            countings[getValue.applyAsInt(i)]++;
        }

        int[] positions = new int[countings.length];
        Arrays.fill(positions, 0);
        int position = 0;
        for (int i = 0; i < countings.length - 1; i++) {
            position += countings[i];
            positions[i + 1] = position;
        }

        Object[] sorted = new Object[personArr.length];

        for (A i : personArr) {
            sorted[positions[getValue.applyAsInt(i)]] = i;
            positions[getValue.applyAsInt(i)]++;
        }

        System.arraycopy(sorted, 0, personArr, 0, sorted.length);
        return personArr;
    }
}
