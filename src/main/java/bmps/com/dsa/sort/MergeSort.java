package bmps.com.dsa.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private int[] sort(int[] arr, int start, int end) {
        if (end-start + 1 <= 1) {
            return arr;
        }

        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        merge(arr, start, mid, end);
        return arr;
    }

    private void merge(int[] arr, int start, int mid, int end) {
         int[] leftArr = Arrays.copyOfRange(arr, start, mid + 1);
         int[] rightArr = Arrays.copyOfRange(arr, mid + 1, end + 1);


        int i = 0; // left sub array
        int j = 0; // right sub array
        int k = start; // position in original array

        while (i < leftArr.length && j < rightArr.length) {
            // swap
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }
}
