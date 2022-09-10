package sort.non_comparison;

import java.util.function.ToIntFunction;

public interface NonComparisonSort {
    <A> A[] sort(A[] arr, ToIntFunction<A> getValue);
}
