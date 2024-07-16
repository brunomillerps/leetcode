package bmps.com.dsa.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sort() {
        MergeSort mergeSort = new MergeSort();

        var arr = new int[]{8,2,5};
        mergeSort.sort(arr);
    }
}