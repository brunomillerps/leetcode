package bmps.com.dsa.ratelimit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageDeliveryServiceTest {

    @Test
    void getMessageStatus() {
        var timestamps = List.of(1, 4, 5, 10, 11, 14);
        var messages = List.of("Hello", "Bye", "Bye", "Hello", "Bye", "Hello");
        int k = 5;

        var SQS = new MessageDeliveryService();
         var res = SQS.getMessageStatus(timestamps, messages, k);

        var expected = List.of("1:Hello", "4:Bye", "10:Hello", "11:Bye");

        Assertions.assertEquals(expected, res);
    }
}