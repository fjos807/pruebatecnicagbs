import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long min = 0;
    	long max = 0;
    	
    	//Cycle for finding the sum
    	for(int i=0; i<arr.length; i++) {
    		int possition = i;
    		long temporarySum = 0;
    		
    		//Cycle for adding up only 4 numbers
    		for (int count=0; count <=3; count ++) {
    			if(possition > arr.length - 1) {
    				possition = 0;
    			} 
    			temporarySum = temporarySum + arr[possition];
    			possition++;
    			
    		}
    		//initialize minimum value
    		if(i==0) {
    			min = temporarySum;
    		}
    		//Check if temporary sum is a maximum value
    		if (temporarySum > max) {
    			max = temporarySum;
    		}
    		//Check if temporary sum is a minimun value
    		if (temporarySum < min) {
    			min = temporarySum;
    		}
    	
    	}
    	System.out.print(String.valueOf(min) + " " + String.valueOf(max));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

