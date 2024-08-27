package bmps.com.dsa.arrays.medium;

import java.util.*;

public class EncodeDecode {
    private static final String DELIMITER = "$";

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(var s : strs) {
            sb.append(s.length()).append(DELIMITER).append(s);
        }

        return sb.toString();
    }

    record CountElement(int a, int b){}

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();



        PriorityQueue<CountElement> heap = new PriorityQueue<>(Comparator.comparingInt(e -> e.));


        var numsMap = Map.of('0', 0, '1', 1, '2', 2, '3', 3, '4', 4, '5', 5, '6', 6, '7', 7, '8', 8, '9', 9);
        StringBuilder wordCount = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (numsMap.containsKey(str.charAt(i))) {
                wordCount.append(str.charAt(i));
                continue;
            }

            if (DELIMITER.charAt(0) == str.charAt(i)) {
                StringBuilder sb2 = new StringBuilder();
                int j = i;
                for (int wordCountInt = Integer.parseInt(wordCount.toString()); wordCountInt > 0; wordCountInt--) {
                    sb2.append(str.charAt(j+1));
                    j++;
                }
                res.add(sb2.toString());
                i += Integer.parseInt(wordCount.toString());
                wordCount = new StringBuilder();
            }
        }

        return res;
    }
}
