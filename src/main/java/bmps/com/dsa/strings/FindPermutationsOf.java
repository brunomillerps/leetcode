package bmps.com.dsa.strings;

import java.util.concurrent.LinkedTransferQueue;

public class FindPermutationsOf {

    // s: abbc
    // b: cbabadcbbabbcbabaabccbabc
    public int countNumberOfPermutations(String s, String b) {

        int k = s.length();
        int res = 0;

        int totalS = 0;

        for (int i = 0; i < s.length(); i++) {
            totalS += s.charAt(i);
        }

        for (int i = 0; i + k - 1 < b.length(); i++) {
            var subseq = b.substring(i, k);
            int total = 0;
            for (int j = 0; j < subseq.length(); j++) {
                total += 'a' - subseq.charAt(j);
            }

            if (total == totalS) res += 1;
        }

        return res;
    }
}
