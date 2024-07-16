package bmps.com.dsa.sort;

public class InsertSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public String sort(String str) {
        char[] arr = str.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while(j >= 0 && arr[j + 1] < arr[j]) {
                char temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) sb.append(c);
        return sb.toString();
    }
}
