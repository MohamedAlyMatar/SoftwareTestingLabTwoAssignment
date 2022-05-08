import java.util.*;
import java.lang.*;

public class Lab2_Q1
{
    public static void getArray(int[] arr){
        System.out.println("\nArray elements are: ");
        for (int i=0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    public int getMin(int[] arr)
    {
        int min= arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i]<min){ min= arr[i]; }
        }
        return min;
    }

    public int getMax(int[] arr)
    {
        int max= arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i] > max){ max = arr[i]; }
        }
        return max;
    }

    public String checkNumberParity(int n)
    {
        if(n % 2 == 0)
        {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args)
    {
        Scanner sizeInput = new Scanner(System.in);
        System.out.print("Enter the number of elements you want to store: \n");
        int size = sizeInput.nextInt();

        Scanner input = new Scanner(System.in);
        int[] array = new int[size];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i < size; i++)
        {
            array[i] = input.nextInt();
        }

        getArray(array);
    }
}

