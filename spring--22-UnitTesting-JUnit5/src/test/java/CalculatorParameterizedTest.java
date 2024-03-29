import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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
    @NullSource
        //UOS sets it to null at this point
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());          //This fails bec. NullPointerException so no chance of invoking
        //"String.isEmpty()" bec "arg" is null
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    // @EmptySource  -UOS sets it to ""
    // @NullSource   -UOS sets it to null at this point
    @NullAndEmptySource
    void testCase5(String arg) {
        Assertions.assertFalse(arg.isEmpty()); //1st 3 passes but in 4th null causes it to throw an exception and the
        //5th fails bec. it couldn't assert if it is empty or not.-Assertion
        //failed-You can use these @s for validation eg@NotNull.,
        //@EmptySource in collections as well
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
        //Has to be put on top the testcase/test().
        //Another () will provide data to this MethodSourcehere: StringProvider()
        //@MethodSource will find stringProvider() & it will get the return as the

    void testCase6(String arg) {             //parameters & 1 by 1 put those elements as String arguments to testCase6()
        Assertions.assertFalse(arg.isEmpty());
    }

    static String[] stringProvider() {          //By using @MethodSource we can get this data coming from this() by
        //putting the factory method's name inside the ("") of the () in test.
        return new String[]{"Java", "JS", "TS"};   //@MethodSource can work with an Array,streams, iterable-collections

    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testCase7(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2)); //Checking if the sum of num1&num2 will give result
        //Which means we are testing Calculator.add() by
        //using data coming from CsvSource
        //1sr 2 will pass but the last one will fail bec
        //Expected:100 but Actual:50- The Expected is the Data provided in the Csv (100)-We have problem with the test
        //data.Either fix the data(100) OR if we don't know what the Calculator.add() is doing we might think that this() as
        //the problem. But this is not efficient when we have a bunch of data to our Class/java code. So we'll use Csv file
        //instead and the @CsvFileSource -Each line from the file work as a list of parameters.
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv")  //For this @ the path of the file should be provided. In JUnit5
                                                    //@CsvFileSource has this resources field and this one is where you
                                                    //define where this @ can find the Csv file. But providing the whole
                                                    //path like(main/resources..)we're just giving the name after/ bec.
                                                    //by default this @ will look in the resources folder But if you
                                                    //want to place somewhereelse then you have to give the full path
    void testCase8(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2)); //This ended up by 1 failed 3 passed tests bec. of
                                                                     //the Headers in the 1st line in the file is also
                                                                     //tested. It starts to test from the 1st line
                                                                     //To fix this we mention the lines to skip in the()
                                                                     //numLinesToSkip=1: Skip 1 line then start the test
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip=1)
    void testCase9(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));//This time it only ran 3 tests of which all passed
    }

    //If you want to display the headers from the file you'll put useHeadersInDisplayName = true in the ()-see below
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip=1,useHeadersInDisplayName = true)
    void testCase10(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));//This time it only ran 3 tests of which all passed
    }


}