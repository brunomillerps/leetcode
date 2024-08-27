package bmps.com.dsa.ratelimit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In this task, a basic message delivery service is to be implemented that has a rate-limiting
 *  algorithm that drops any message that has already been delivered in the last k seconds.
 * Given the integer k, a list of messages as an array of n strings, messages, and a sorted integer array timestamps representing
 *  the time at which the message arrived, for each message report the string "true" if the message is delivered and
 * "false" otherwise.
 *
 * Example:
 * Suppose n = 6, timestamps = [1, 4, 5, 10, 11, 14], messages = ["hello", "bye", "bye",
 * "hello", "bye", "hello"], and k = 5.
 */
public class MessageDeliveryService {

    public List<String> getMessageStatus(List<Integer> timestamp, List<String> messages, int k) {

        Map<String, Integer> delivered = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {

            String msg = messages.get(i);
            Integer ts = timestamp.get(i);

            Integer lastTs = delivered.get(msg);
            if (lastTs == null || (ts - lastTs > k )) {
                delivered.put(msg, ts);
                result.add(ts + ":" + msg);
            }
        }

        return result;
    }
}
