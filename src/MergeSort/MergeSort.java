package MergeSort;

public class MergeSort {

    public static <E extends Comparable<E>> void mergeSort(E[] list) {

    }
    public static void mergeSort(Object[] list, int low, int high) {
        if (high == low) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(list, low, middle);
        mergeSort(list, middle + 1, high);

        merge(list, low, middle + 1, high);
    }

    public static void merge(Object[] list, int low, int middle, int high) {

    }
}