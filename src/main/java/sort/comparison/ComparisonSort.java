package sort.comparison;

import java.util.Comparator;

public interface ComparisonSort {
    <A> A[] sort(A[] arr, Comparator<A> comparator);
}
