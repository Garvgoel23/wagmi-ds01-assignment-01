package main.java.com.wagmi.finance.alg;

/*
 TODO[Student]: Sorting algorithms
 - Implement Quick Sort by amount (ascending).
 - Implement Merge Sort by date (ascending), stable.
 - Implement Insertion Sort by category using provided comparator.
 - See `SortersTest` for exact expectations and edge cases.
*/

import java.util.ArrayList;
import java.util.Comparator;
import main.java.com.wagmi.finance.model.Transaction;

public final class Sorters {

    private Sorters() {
        // Prevent instantiation
    }
    public static void quickSortByAmount(Transaction[] arr) {
        if (arr == null || arr.length < 2) return;
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(Transaction[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quicksort(arr, low, p - 1);
            quicksort(arr, p + 1, high);
        }
    }

    private static int partition(Transaction[] arr, int low, int high) {
        double pivot = arr[high].getAmount();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getAmount() <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(Transaction[] arr, int i, int j) {
        Transaction temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void mergeSortByDate(Transaction[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(Transaction[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(Transaction[] arr, int low, int mid, int high) {
        ArrayList<Transaction> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left].getDate().isBefore(arr[right].getDate())
                    || arr[left].getDate().isEqual(arr[right].getDate())) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    public static Transaction[] insertionSortByCategory(Transaction[] arr, Comparator<String> categoryComparator) {
        if (arr == null || arr.length < 2) return arr;

        int n = arr.length;
        for (int j = 1; j < n; j++) {
            Transaction key = arr[j];
            int i = j - 1;

            while (i >= 0 && categoryComparator.compare(arr[i].getCategory(), key.getCategory()) > 0) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        return arr;
    }
}
