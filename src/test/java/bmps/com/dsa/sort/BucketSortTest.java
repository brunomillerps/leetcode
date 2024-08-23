package bmps.com.dsa.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {

    @Test
    void sort() {
        BucketSort bucketSort = new BucketSort();
        int[] arr = new int[]{2,0,2,1,1,0};
        bucketSort.sort(arr);

        Assertions.assertArrayEquals(new int[]{0,0,1,1,2,2}, arr);
    }
}