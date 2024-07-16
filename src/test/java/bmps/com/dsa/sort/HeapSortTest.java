package bmps.com.dsa.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @ParameterizedTest
    @CsvSource({
            "'8,3,9,0,1', '0,1,3,8,9'"
    })
    void sort(String input, String expectOutput) {
        var arr = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        var expected = Arrays.stream(expectOutput.split(",")).mapToInt(Integer::parseInt).toArray();

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        Assertions.assertArrayEquals(expected, arr);
    }
}