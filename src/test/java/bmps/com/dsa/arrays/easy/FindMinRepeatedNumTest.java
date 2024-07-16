package bmps.com.dsa.arrays.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FindMinRepeatedNumTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,1,3,3,2,4', 4",
            "'1,1,1,1,1,1,1', 1",
            "'1,2', 1",
            "'', 0"
    })
    void minimumRepeated(String stringNums, int expect) {

        FindMinRepeatedNum minRepeatedNum = new FindMinRepeatedNum();
        List<Integer> ints = new ArrayList<>();

        if (!stringNums.isBlank()) {
            ints = Arrays.stream(stringNums.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }

        var res = minRepeatedNum.minimumRepeated(ints);

        Assertions.assertEquals(expect, res);
    }


    @ParameterizedTest
    @CsvSource({
            "'1,2,1,3,3,2,4', 4",
            "'1,1,1,1,1,1,1', 1",
            "'1,2', 1",
            "'', 0"
    })
    void minimumRepeated_withCache(String stringNums, int expect) {

        FindMinRepeatedNum minRepeatedNum = new FindMinRepeatedNum();
        List<Integer> ints = new ArrayList<>();

        if (!stringNums.isBlank()) {
            ints = Arrays.stream(stringNums.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }

        var res = minRepeatedNum.minimumRepeatedCache(ints);

        Assertions.assertEquals(expect, res);
    }
}