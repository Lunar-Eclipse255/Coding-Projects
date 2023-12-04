import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
// Main class
public class DayOne {
    public static void main(String[] args) 
        throws IOException
    {
        String[] nums = {"one","two","three","four","five","six","seven","eight","nine"};
        String concatString="";
        int sum=0;
        int k=0;
        // read using FileReader, no encoding support, not
        // efficient
        try {
            
            FileReader fileName = new FileReader("DayOne.txt");
 
            // Creating a BufferReader class object to
            // read file as passed above
            BufferedReader readbuffer
                = new BufferedReader(fileName);

        for(int i=0; i<1000;i++){
            String line = readbuffer.readLine();
            for(int j=0;j<line.length();j++){
                if (j==line.indexOf(nums[0], j)){
                    concatString = concatString + "1";
                }
                else if (j==line.indexOf(nums[1], j)){
                    concatString = concatString + "2";
                }
                else if (j==line.indexOf(nums[2], j)){
                    concatString = concatString + "3";
                }
                else if (j==line.indexOf(nums[3], j)){
                    concatString = concatString + "4";
                }
                else if (j==line.indexOf(nums[4], j)){
                    concatString = concatString + "5";
                }
                else if (j==line.indexOf(nums[5], j)){
                    concatString = concatString + "6";
                }
                else if (j==line.indexOf(nums[6], j)){
                    concatString = concatString + "7";
                }
                else if (j==line.indexOf(nums[7], j)){
                    concatString = concatString + "8";
                }
                else if (j==line.indexOf(nums[8], j)){
                    concatString = concatString + "9";
                }
                else if (Character.isDigit(line.charAt(j))){
                    concatString = concatString + line.substring(j,j+1);
                }
            }
            sum = sum + Integer.parseInt(concatString.substring(0,1) + concatString.substring(concatString.length()-1));
            
            
            //System.out.println("First: "+Integer.parseInt(concatString.substring(0,1)));
            //System.out.println("Final: "+Integer.parseInt(concatString.substring(concatString.length()-1)));
            //System.out.println("Sum: "+sum);
            concatString="";
        }
    }
    catch (IOException e) {
 
        // Print the line number where exception occurred
        e.printStackTrace();
    }
    System.out.println(sum);    
}
}