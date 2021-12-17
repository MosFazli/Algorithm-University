import java.util.Arrays;

/* Mostafa Fazli
1400/01/17
Algorithm Exercise of Heap SUT University
Min Heap Sort
 */

public class HeapSort {

    private static int N;

    /**
     * Time Complexity: Total n elements, each element calls max heapify once,
     * hence total complexity is (n log n).
     */
    public static void sort(int arr[]) {

        // build the heap
        heapify(arr);

        for (int i = N; i > 0; i--) {
            // Get the root element which is maximum value from the Heap.
            // Remove root element by swapping with the last element.
            swap(arr, 0, i);
            N = N - 1;
            // Again heapify to maintain the max heap property.
            maxheap(arr, 0);
        }
    }

    /**
     * Function to build a heap.
     * Observe that the elements of heap are :
     * A([n/2]+1), A([n/2]+2), A([n/2]+3) ... A(n) are all leaves.
     * here n is the length of heap (heap size).
     * Any index after (n/2) will have left(i) and right(i) greater than n.
     * Also parent for a given index i is floor of i/2.
     */
    public static void heapify(int arr[]) {
        N = arr.length - 1;
        // Go from the bottom non-leaf nodes of the binary tree, hence i--.
        // The max non-leaf nodes of a binary tree with n nodes is n/2.
        for (int i = N / 2; i >= 0; i--)
            maxheap(arr, i);
    }

    /**
     * Function to swap largest element in heap.
     * Time complexity: O(log n)
     * Running time of max-heapify depends on height of the node.
     * For a given height h, there are at most [n/2^(h+1)] nodes.
     */
    public static void maxheap(int arr[], int i) {

        // represent a tree in form of an array, then left child of i is 2i
        // while right child of i is 2i + 1

        int left = 2 * i; // left child of i which is 2i
        int right = 2 * i + 1; // right child of i which is 2i + 1
        int max = i;

        // Now if the left child index is obviously less than max index of array
        // and left child of node i is greater than node i, then max is left child
        if (left <= N && arr[left] > arr[i])
            max = left;
        // similarly for right child
        if (right <= N && arr[right] > arr[max])
            max = right;

        // If the left or right child is greater than current node, swap it and
        // maintain the heap from subtree of max node.
        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] array = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        sort(array);
        System.out.println("Heap Sort: " + Arrays.toString(array));
    }
}