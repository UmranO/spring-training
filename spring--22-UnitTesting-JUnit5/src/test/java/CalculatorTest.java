import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll                                       //This @ makes this () to run before all the other () in this Class
    static void setUpAll(){
        System.out.println("BeforeAll is executed.");
    }

    @AfterAll                                         //This @ makes this () to run after all the other () in this Class
    static void tearDownAll(){
        System.out.println("AfterAll is executed.");
    }

    @BeforeEach                                 //This @ makes this () to run before each of the other ()s in this Class
    void setUpEach(){
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach                                  //This @ makes this () to run after each of the other ()s in this Class
    void tearDownEach(){
        System.out.println("AfterEach is executed.");
    }

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);                     //JUnit5 expected value is written 1st & actual is the 2nd
        assertEquals(5,actual,"Test failed");       //we can also add a fail message
    }

    @Test
    void add2(){
        System.out.println("Add2 method");
    //assertThrows(IllegalArgumentException.class, ()->Calculator.add2(3,2)); //This test should fail either if no
                                                                              //exception thrown OR there is one but
                                                                              //the type exception thrown is as NOT the
                                                                              //expected Exception type
    //assertThrows(AccessDeniedException.class, ()->Calculator.add2(3,2));    //since num1>num2 there should be an excep.

    assertThrows(IllegalArgumentException.class, ()->Calculator.add2(2,3));  //num1>num2 there should NOT be an excep.

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
        assertTrue(Calculator.operator.equals("add"));       //Same as assertEquals--                         unit test
    }
    @Test
    void testCase3(){
        System.out.println("Test Case 3");
      //assertArrayEquals(new int[] {1,2,3}, new int [] {1,2,3}, "Arrays are not same.");
                                  //These are 2 diff. Arrays in the memory but if they have the same elements in the
                                     //same order they are said to be equal and assertArrayEquals pass
        assertArrayEquals(new int[] {1,2,3}, new int [] {1,3,2}, "Arrays are not same.");
        }                                                            //we see the messages only if the tests fail
    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        String nullString=null;
        String notNullString="Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

//      assertNull(notNullString);                //When failed we'll see underlined and it doesn't go to the next line
        assertNotNull(nullString);

    }
    @Test
    void testCase5(){
        System.out.println("Test Case 5");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1,c2);                                        //To check object references you need to use these()s
        assertNotSame(c1,c3);

        }

    }

