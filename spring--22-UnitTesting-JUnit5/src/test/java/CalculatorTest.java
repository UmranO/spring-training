import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);                     //JUnit5 expected value is written 1st & actual is the 2nd
        assertEquals(5,actual,"Test failed");       //we can also add a fail message
    }
    @Test
    void testCase1(){
      //  System.out.println("Test Case 1");
        fail("Not implemented yet.");
    }
    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);   //Same as assertTrue--We can do more than 1 assertion in 1
        assertTrue(Calculator.operator.equals("add"));       //Same as assertEquals--                     unit test
    }
    @Test
    void testCase3(){
        System.out.println("Test Case 3");
    }
    @Test
    void testCase4(){
        System.out.println("Test Case 4");
    }
    @Test
    void testCase5(){
        System.out.println("Test Case 5");
    }

}