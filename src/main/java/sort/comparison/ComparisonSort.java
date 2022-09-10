package sort.comparison;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public interface ComparisonSort {
    <A> A[] sort(A[] personArr, Comparator<A> comparator);
}
