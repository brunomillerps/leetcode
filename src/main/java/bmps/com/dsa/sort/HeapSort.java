package bmps.com.dsa.sort;

import java.util.PriorityQueue;

public class HeapSort {
    public void sort(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i : arr) {
            heap.add(i);
        }

        int n = heap.size();
        for (int i = 0; i < n; i++) {
            arr[i] = heap.poll();
        }
    }
}
