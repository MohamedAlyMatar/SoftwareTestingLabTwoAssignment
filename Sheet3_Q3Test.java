import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sheet3_Q3Test
{
    Sheet3_Q3 button;
    @BeforeEach
    public void start(){
        button = new Sheet3_Q3();
    }
    //A testsuite for edge coverage
    @Nested
    public class EdgeCoverageTest
    {
        @Nested
        public class NormalStateTest
        {
            @Test
            public void TimeToDate(){
                button.press('a');
                assertEquals("NORMAL,DATE", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
            }
            @Test
            public void DateToTime(){
                button.press('a');
                button.press('a');
                assertEquals("NORMAL,TIME", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
            }
            @Test
            public void NormalToUpdate(){
                button.press('c');
                assertEquals("UPDATE,min", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());

            }
            @Test
            public void NormalToAlarm(){
                button.press('b');
                assertEquals("ALARM,Alarm", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());

            }
            @AfterEach
            public void cleanUp(){
                button =null;
            }
        }

        @Nested
        public class UpdateStateTest{
            @Test
            public void MinuteToMinute()
            {
                button.press('c');
                button.press('b');
                assertEquals("UPDATE,min", button.getState());
                assertEquals("0:1", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
            }
            @Test
            public void MinuteToHourAndHourToHour()
            {
                button.press('c');
                button.press('a');
                assertEquals("UPDATE,hour", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
                button.press('b');
                assertEquals("UPDATE,hour", button.getState());
                assertEquals("1:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());

            }
            @Test
            public void HourToDayAndDayToDay()
            {
                button.press('c');
                button.press('a');
                button.press('a');
                assertEquals("UPDATE,day", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
                button.press('b');
                assertEquals("UPDATE,day", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-2", button.DisplayDate());

            }
            @Test
            public void DayToMonthAndMonthToMonth()
            {
                button.press('c');
                button.press('a');
                button.press('a');
                button.press('a');
                assertEquals("UPDATE,month", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
                button.press('b');
                assertEquals("UPDATE,month", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-2-1", button.DisplayDate());
            }
            @Test
            public void MonthToYearAndYearToYear()
            {
                button.press('c');
                button.press('a');
                button.press('a');
                button.press('a');
                button.press('a');
                assertEquals("UPDATE,year", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
                button.press('b');
                assertEquals("UPDATE,year", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2001-1-1", button.DisplayDate());
            }
            @Test
            public void YearToNormal()
            {
                button.press('c');
                button.press('a');
                button.press('a');
                button.press('a');
                button.press('a');
                button.press('a');
                assertEquals("NORMAL,TIME", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
            }
            @AfterEach
            public void cleanUp() {
                button = null;
            }
        }
        @Nested
        //A testSuite for Alarm State
        public class AlarmStateTest{
            @Test
            public void AlarmToChimeAndChimeToNormal()
            {
                button.press('b');
                button.press('a');
                assertEquals("ALARM,Chime", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
                button.press('d');
                assertEquals("NORMAL,TIME", button.getState());
                assertEquals("0:0", button.DisplayTime());
                assertEquals("2000-1-1", button.DisplayDate());
            }
            @AfterEach
            public void cleanUp() {
                button = null;
            }
        }
    }

    @Nested
    public class ADUPTest{
        @Test
        public void ADUP1(){
            button.press('c');
            assertEquals("UPDATE,min", button.getState());
            assertEquals("0:0", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP2(){
            button.press('c');
            button.press('b');
            assertEquals("UPDATE,min", button.getState());
            assertEquals("0:1", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());

        }
        @Test
        public void ADUP3(){
            button.press('c');
            button.press('b');
            button.press('b');
            assertEquals("UPDATE,min", button.getState());
            assertEquals("0:2", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP4(){
            button.press('c');
            button.press('b');
            button.press('b');
            button.press('a');
            assertEquals("UPDATE,hour", button.getState());
            assertEquals("0:2", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP5(){
            button.press('c');
            button.press('b');
            button.press('b');
            button.press('a');
            button.press('b');
            assertEquals("UPDATE,hour", button.getState());
            assertEquals("1:2", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP6(){
            button.press('c');
            button.press('b');
            button.press('b');
            button.press('a');
            button.press('b');
            button.press('b');
            assertEquals("UPDATE,hour", button.getState());
            assertEquals("2:2", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP7(){
            button.press('c');
            button.press('b');
            button.press('b');
            button.press('a');
            button.press('b');
            button.press('b');
            button.press('a');
            assertEquals("UPDATE,day", button.getState());
            assertEquals("2:2", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
        @Test
        public void ADUP8(){
            button.press('a');
            button.press('b');
            button.press('a');
            button.press('d');
            button.press('c');
            button.press('a');
            button.press('a');
            button.press('a');
            button.press('a');
            button.press('a');
            assertEquals("NORMAL,TIME", button.getState());
            assertEquals("0:0", button.DisplayTime());
            assertEquals("2000-1-1", button.DisplayDate());
        }
      
        @AfterEach
        public void cleanUp(){
            button =null;
        }
    }
}
