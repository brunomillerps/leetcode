package bmps.com.dsa.arrays.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeDecodeTest {

    @Test
    void shouldDecode() {

        EncodeDecode dec = new EncodeDecode();

        var encString = dec.encode(List.of("neet$","$code","love","you","127.0.0.1:51545"));
        var decStr = dec.decode(encString);

        Assertions.assertEquals(List.of("neet$","$code","love","you","127.0.0.1:51545"), decStr);
    }

}