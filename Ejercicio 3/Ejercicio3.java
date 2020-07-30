import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final String[] numberNames = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty"
    };
    
    private static final String[] hourIntervalsNames = {
            "o' clock",
            "quarter",
            "half"
    };
   
    static String timeInWords(int h, int m) {
        String minutes = null;
        String response = null;
        
        //Checks for special invervals
        if(m == 0 || m == 30 || m == 45 || m == 15) {
            switch(m) {
              case 0:
                minutes = hourIntervalsNames[0];
                break;
              case 30:
                minutes = hourIntervalsNames[2];
                break;
              default:
                minutes = hourIntervalsNames[1];
                break;
            }
            
        } 
            //Sets minute(s) word
            String pluralSingular;
            if(m == 1) {
                pluralSingular = " minute";
            } else {
                pluralSingular = " minutes";
            }
            
            //Special case for o' clock
            if(m == 0) {
                response = numberNames[h -1] + " " + minutes;
            }
            
            //Special structure for "past" format
            if(m > 0 && m <= 30) {
                if(minutes == null) {
                    if(m > 20) {
                        minutes = numberNames[19] + " " +numberNames[(m-20)-1] + pluralSingular;
                    }else {
                        minutes = numberNames[m - 1] + pluralSingular; 
                    }
                    
                    response = minutes+ " past " +numberNames[h -1];
                }    
                response =  minutes + " past " + numberNames[h -1] ;
            } 
            
            //Special structure for "to" format
            if(m > 30){
                int amount = 60 - m;
                if(minutes == null) {
                    if(amount > 20) {
                        minutes = numberNames[19] + " " +numberNames[(amount-20)-1] + pluralSingular;
                    } else {
                        minutes = numberNames[amount-1] + pluralSingular;
                    }
                    
                }
                response = minutes + " to " +numberNames[h];
            }
        
        return response;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

