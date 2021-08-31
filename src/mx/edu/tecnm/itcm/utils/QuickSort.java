/*
 * To change this license header, choose License Headers in Project Properties.
 */
package mx.edu.tecnm.itcm.utils;

/**
 * @author Henry McElwaine
 *
 *         It is based on the divide and conquer technique, which consists of
 *         subdividing the array into smaller sub-arrays, and ordering them. To
 *         do this division, an array value is taken as a pivot, and all the
 *         elements less than this pivot are moved to its left, and the greater
 *         ones to its right. Next, the same method is applied to each of the
 *         two parts into which the array is divided.
 */
public class QuickSort {

    public QuickSort() {

    }

    /**
     * Assuming we take the first element as a pivot, the Java
     * <code>QuickSort()</code> method that implements this sort algorithm to sort
     * an array of integers is presented below. The left parameters. and right. they
     * are the first and last element of the array to be treated at all times.
     */
    public QuickSort(int arr[], int low, int hight) {
        sort(arr, low, hight);
    }

    /**
     * Takes last element as pivot, places the pivot element at its correct position
     * in sorted array, and places all smaller (smaller than pivot) to left of pivot
     * and all greater elements to right of pivot
     *
     * @param arr  to sort.
     * @param low  of the array.
     * @param high of the array.
     * @return the last element.
     */
    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * The main function that implements <code>QuickSort()</code> arr[] --> Array to
     * be sorted, low --> Starting index, high --> Ending index
     *
     * @param arr  to sort.
     * @param low  of the array.
     * @param high of the array
     */
    public void sort(int arr[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Takes first element as pivot, places the pivot element at its correct
     * position in sorted array, and places all smaller (smaller than pivot) to left
     * of pivot and all greater elements to right of pivot
     *
     * @param arr  to sort.
     * @param low  of the array.
     * @param high of the array.
     * @return the partition.
     */
    public int partitionInverse(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * The main function that implements <code>QuickSort()</code> arr[] --> Array to
     * be sorted, low --> Starting index, high --> Ending index
     *
     * @param arr  to sort.
     * @param low  of the array.
     * @param high of the array
     */
    public void sortInverse(int arr[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * A utility function to print array of size n
     *
     * @param arr to display.
     */
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();

        long startTime;
        long endTime;

        int[] arr = { 5, 26, 12, 6, 1, 4, 7 };
        int n = arr.length;

        System.out.println("Original array");
        printArray(arr);

        // startTime = System.currentTimeMillis(); // milisegundos
        startTime = System.nanoTime(); // nanosegundos

        quickSort.sort(arr, 0, n - 1);

        // endTime = System.currentTimeMillis() - startTime; // milisegundos
        endTime = System.nanoTime() - startTime; // nanosegundos

        System.out.println();

        System.out.println("sorted array");
        printArray(arr);

        System.out.println();

        // System.out.println("Tiempo de ejecución QuickSort: " + endTime + "
        // milisegundos");//
        System.out.println("\nTiempo de ejecución QuickSort:\n" + endTime + " nanosegundos\n"
                + ((double) endTime / 1000000) + " milisegundos");
    }
}
