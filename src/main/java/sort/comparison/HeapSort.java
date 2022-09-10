package sort.comparison;

import java.util.Comparator;

public class HeapSort implements ComparisonSort{
    @Override
    public <A> A[] sort(A[] arr, Comparator<A> comparator) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify (arr, N, i,comparator);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            A temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0,comparator);
        }

        return arr;
    }

    private static <A> void heapify(A [] arr, int N, int i,Comparator<A> comparator) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && comparator.compare(arr[l] ,arr[largest])>0)
            largest = l;

        // If right child is larger than largest so far
        if (r < N && comparator.compare(arr[r],arr[largest])>0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            A swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest,comparator);
        }
    }
}
