package sort.comparison;

import java.util.Comparator;

public class HeapSort implements ComparisonSort {
    @Override
    public <A> A[] sort(A[] arr, Comparator<A> comparator) {
        int arrLength = arr.length;

        for (int i = arrLength / 2 - 1; i >= 0; i--)
            makeHeap(arr, arrLength, i, comparator);

        for (int i = arrLength - 1; i > 0; i--) {
            A temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            makeHeap(arr, i, 0, comparator);
        }

        return arr;
    }

    private static <A> void makeHeap(A[] arr, int n, int parent, Comparator<A> comparator) {
        int largest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (left < n && comparator.compare(arr[left], arr[largest]) > 0)
            largest = left;

        if (right < n && comparator.compare(arr[right], arr[largest]) > 0)
            largest = right;

        if (largest != parent) {
            A swap = arr[parent];
            arr[parent] = arr[largest];
            arr[largest] = swap;

            makeHeap(arr, n, largest, comparator);
        }
    }
}
