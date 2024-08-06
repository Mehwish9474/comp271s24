public class Sorting271 {

    // Method to merge two sorted arrays into one sorted array
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and merge them in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }

        // Add remaining elements from left array if any
        while (i < left.length) {
            merged[k++] = left[i++];
        }

        // Add remaining elements from right array if any
        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    // Method to sort an array using the iterative merge sort technique
    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Divide the array into individual elements (subarrays of size 1)
        int n = array.length;
        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {
                int mid = leftStart + size - 1;
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);

                // Merge the two halves
                int[] left = new int[mid - leftStart + 1];
                int[] right = new int[rightEnd - mid];
                System.arraycopy(array, leftStart, left, 0, left.length);
                System.arraycopy(array, mid + 1, right, 0, right.length);

                int[] merged = merge(left, right);
                System.arraycopy(merged, 0, array, leftStart, merged.length);
            }
        }

        return array;
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original Array: " + java.util.Arrays.toString(array));

        int[] sortedArray = sort(array);
        System.out.println("Sorted Array: " + java.util.Arrays.toString(sortedArray));
    }
}