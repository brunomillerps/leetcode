package bmps.com.dsa.sort;

public class BucketSort {

    public void sort(int[] nums) {
        int[] counts = new int[3];

        for (int n: nums) {
            counts[n] += 1;
        }

        int i = 0;
        for(int n = 0; n < counts.length; n++) {
            for(int j = counts[n]; j > 0 ; j--) {
                nums[i] = n;
                i++;
            }
        }
    }
}
