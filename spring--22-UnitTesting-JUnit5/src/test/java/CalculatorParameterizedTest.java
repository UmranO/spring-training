import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
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

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    @EmptySource
        // ""
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty()); //3 tests passed (@ValueSource-bec not empty) 1 failed (@EmptySource)
        //UOS-After the 1st 3 at that point arg is empty bec of (@EmptySource)
        //In the 4th test arg is empty like this "", not even space in it
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
        // @EmptySource  //UOS sets it to ""
    @NullSource          //UOS sets it to null at this point
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());          //This fails bec. NullPointerException so no chance of invoking
                                                        //"String.isEmpty()" bec "arg" is null
    }

    }