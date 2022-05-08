import java.lang.*;

public class Sheet3_Q3
{
    public String state = "NORMAL", state1 = "TIME";
    public int minute = 0, hour = 0, Day = 1, Month = 1, Year = 2000;

    public void press(char input)
    {
        //Case of NORMAL
        if (state.equals("NORMAL"))
        {
            if (input == 'c')
            {
                state = "UPDATE";
                state1 = "min";
            }
            if (input == 'b')
            {
                state = "ALARM";
                state1 = "Alarm";
            }
            if (input == 'a')
            {
                if (state1.equals("TIME"))
                {
                    state1 = "DATE";

                } else {
                    state1 = "TIME";
                }
            }
        }

        //Case of ALARM
        if (state.equals("ALARM"))
        {
            if (input == 'd')
            {
                state = "NORMAL";
                state1 = "TIME";
            }
            if (input == 'a')
            {
                state1 = "Chime";
            }
        }

        //Case of UPDATE
        if (state.equals("UPDATE"))
        {
            if (input == 'd')
            {
                state = "NORMAL";
                state1 = "TIME";
            }
            if (input == 'a')
            {
                if (state1.equals("year"))
                {
                    state = "NORMAL";
                    state1 = "TIME";
                }
                if (state1.equals("month"))
                {
                    state1 = "year";
                }
                if (state1.equals("day"))
                {
                    state1 = "month";
                }
                if (state1.equals("hour"))
                {
                    state1 = "day";
                }
                if (state1.equals("min"))
                {
                    state1 = "hour";
                }
            }

            if (input == 'b') {
                if (state1.equals("min"))
                {
                    minute++;
                    if (minute >=60)
                    {
                        minute =0;
                    }
                }
                if (state1.equals("hour"))
                {
                    hour++;
                    if (hour >=24)
                    {
                        hour =0;
                    }
                }
                if (state1.equals("day"))
                {
                    Day++;
                    if (Day >31)
                    {
                        Day =1;
                    }
                }
                if (state1.equals("month"))
                {
                    Month++;
                    if (Month >12)
                    {
                        Month =1;
                    }
                }
                if (state1.equals("year"))
                {
                    Year++;
                    if (Year > 2100)
                    {
                        Year = 2000;
                    }

                }
            }

        }

    }

    public String getState(){
        return(state+","+state1);
    }
    public String DisplayDate(){
        return (Year +"-"+ Month +"-"+ Day);
    }
    public String DisplayTime(){
        return (hour +":"+ minute);
    }
}
