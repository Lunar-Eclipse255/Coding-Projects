import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class DayTwo {
    public static void main(String[] args) 
        throws IOException
    {
        File file = new File("/Users/gagrehansavona/Desktop/Coding Projects/Advent Of Code/2023/Day Two/DayTwo.txt");
        // read using FileReader, no encoding support, not
        // efficient
        try (FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                int redCount=0;
                int greenCount=0;
                int blueCount=0;
                boolean colonCheck=false;

                
                int redPlace= line.indexOf("red");
                int bluePlace = line.indexOf("blue");
                int greenPlace = line.indexOf("green");
                int redNum=0;
                int greenNum=0;
                int blueNum=0;
                while (redPlace != -1) {
                    redCount++;
                    redPlace = line.indexOf("red", redPlace + 3);
                }
                while (greenPlace != -1) {
                    greenCount++;
                    greenPlace = line.indexOf("green", greenPlace + 5);
                }
                while (bluePlace != -1) {
                    blueCount++;
                    bluePlace = line.indexOf("blue", bluePlace + 4);
                }
                int[] redArray = new int[redCount];
                int[] greenArray = new int[greenCount];
                int[] blueArray = new int[blueCount];
                redPlace= line.indexOf("red");
                bluePlace = line.indexOf("blue");
                greenPlace = line.indexOf("green");
                while (redPlace != -1) {
                    redNum++;
                    if (line.charAt(redPlace-3)==' '){
                        redArray[redNum]=Integer.parseInt(line.substring(redPlace-2,redPlace-1));
                    }
                    else{
                        redArray[redNum]=Integer.parseInt(line.substring(redPlace-3,redPlace-1));
                    }
                    redPlace = line.indexOf("red", redPlace + 3);
                }
                while (greenPlace != -1) {
                    greenNum++;
                    if (line.charAt(greenPlace-3)==' '){
                        greenArray[greenNum]=Integer.parseInt(line.substring(greenPlace-2,greenPlace-1));
                    }
                    else{
                        greenArray[greenNum]=Integer.parseInt(line.substring(greenPlace-3,greenPlace-1));
                    }
                    greenPlace = line.indexOf("green", greenPlace + 5);
                }
                while (bluePlace != -1) {
                    blueNum++;
                    if (line.charAt(bluePlace-3)==' '){
                        blueArray[redNum]=Integer.parseInt(line.substring(bluePlace-2,bluePlace-1));
                    }
                    else{
                        blueArray[redNum]=Integer.parseInt(line.substring(bluePlace-3,bluePlace-1));
                    }
                    bluePlace = line.indexOf("blue", bluePlace + 4);
                }
                for (int i:redArray){
                    System.out.println("R"+i);
                }
                for (int i:greenArray){
                    System.out.println("G"+i);
                }
                for (int i:blueArray){
                    System.out.println("B"+i);
                }
                //System.out.println("R: "+ redCount+ "G: "+greenCount +"B: "+ blueCount);
                for (int j=0;j<line.length();j++){
                    
                    if (line.charAt(j)==':'){
                        colonCheck=true;
                        int colonIndex = j;
                    }
                    if (colonCheck){
                        
                        
                    }
                }
            }
        }
            catch (IOException e) {
            System.out.println("File not found");
        }

        }
        
    }

