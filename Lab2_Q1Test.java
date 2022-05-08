import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

class Lab2_Q1Test
{
    Lab2_Q1 lab2_q1;
    @BeforeEach
    public void init(){
        lab2_q1 = new Lab2_Q1();
    }

    @Nested
    public class EvenTest{
        @Test
        public void test0(){
            assertEquals("Even",lab2_q1.checkNumberParity(0));
        }
        @Test
        public void test2(){
            assertEquals("Even",lab2_q1.checkNumberParity(2));
        }
        @Test
        public void testNeg2(){
            assertEquals("Even",lab2_q1.checkNumberParity(-2));
        }
        @Test
        public void test18(){
            assertEquals("Even",lab2_q1.checkNumberParity(18));
        }
        @Test
        public void test240() {
            assertEquals("Even", lab2_q1.checkNumberParity(240));
        }
        @Test
        public void testNeg630() {
            assertEquals("Even", lab2_q1.checkNumberParity(-630));
        }
        @AfterEach
        public void cleanUp(){
            lab2_q1 = null;
        }
    }

    @Nested
    public class OddTest{
        @Test
        public void testNeg1() {
            assertEquals("Odd", lab2_q1.checkNumberParity(-1));
        }
        @Test
        public void test3() {
            assertEquals("Odd", lab2_q1.checkNumberParity(3));
        }
        @Test
        public void testNeg5() {
            assertEquals("Odd", lab2_q1.checkNumberParity(-5));
        }
        @Test
        public void test7() {
            assertEquals("Odd", lab2_q1.checkNumberParity(7));
        }
        @Test
        public void test545() {
            assertEquals("Odd", lab2_q1.checkNumberParity(545));
        }
        @Test
        public void testNeg694() {
            assertEquals("Odd", lab2_q1.checkNumberParity(-693));
        }
        @AfterEach
        public void cleanUp(){
            lab2_q1 = null;
        }
    }

    @Nested
    public class MinMaxTesting{
        @Test
        public void MaxTestAllPositive(){
            assertEquals(99,lab2_q1.getMax(new int[]{1,3,5,7,6,77,8,99,0,53,38}));
        }
        @Test
        public void MaxTestAllNegative(){
            assertEquals(0,lab2_q1.getMax(new int[]{-1,-3,-5,-7,-6,-77,-8,-99,0,-53,-38}));
        }
        @Test
        public void MaxTestPosAndNeg(){
            assertEquals(53,lab2_q1.getMax(new int[]{1,-3,5,-7,6,-77,8,-99,0,53,-38}));
        }
        @Test
        public void MinTestAllPositive(){
            assertEquals(0,lab2_q1.getMin(new int[]{1,3,5,7,6,77,8,99,0,53,38}));
        }
        @Test
        public void MinTestAllNegative(){
            assertEquals(-99,lab2_q1.getMin(new int[]{-1,-3,-5,-7,-6,-77,-8,-99,0,-53,-38}));
        }
        @Test
        public void MinTestPosAndNeg(){
            assertEquals(-38,lab2_q1.getMin(new int[]{1,-3,5,-7,6,8,99,0,53,-38}));
        }
        @AfterEach
        public void cleanUp(){
            lab2_q1 = null;
        }
    }
}

