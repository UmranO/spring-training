import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorParameterizedTest {

    // @ParameterizedTest       If @ParameterizedTest is used NO need for @Test - It leets App that test we are writing
    //                          is a test that can accept parameters. BUT how these params will be passed is defined by
    //                          below @s
    // @ValueSource(strings = {"Java","JS","TS"})
    //If @ParameterizedTest is used we have to use of the other @s like @ValueSource,@MethodSource
    //@CsvSource, @CsvFileSource. These are the @s letting us pass data-parameters

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {                     //Even though 1 testCase is ran 3 tests passed bec. it runs the test
        Assertions.assertFalse(arg.isEmpty());       //method 1 time- 1 time for "Java", 1 time for "JS"....in total 3
                                                     //this was an examp. for running the test for data @ValueSource
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase1(int num) {
        Assertions.assertEquals(0, num % 3); // testing if all the 3 numbers can be evenly divided by 3


    }
}