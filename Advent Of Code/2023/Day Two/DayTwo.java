import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gagrehansavona/Desktop/Coding Projects/Advent Of Code/2023/Day Two/DayTwo.txt");
        int count=0;
        int sum=0;
        int sumPower=0;
        if (file.exists() && file.length() > 0) {
            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    int redCount = 0;
                    int greenCount = 0;
                    int blueCount = 0;
                    int redMax=0;
                    int greenMax=0;
                    int blueMax=0;
                    int power=0;
                    boolean validity=true;
                    count++;
                    int redPlace = line.indexOf("red");
                    int bluePlace = line.indexOf("blue");
                    int greenPlace = line.indexOf("green");
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

                    int redNum = 0;
                    int greenNum = 0;
                    int blueNum = 0;

                    redPlace = line.indexOf("red");
                    greenPlace = line.indexOf("green");
                    bluePlace = line.indexOf("blue");

                    while (redPlace != -1) {
                        if (line.charAt(redPlace - 3) == ' ') {
                            redArray[redNum] = Integer.parseInt(line.substring(redPlace - 2, redPlace - 1));
                        } else {
                            redArray[redNum] = Integer.parseInt(line.substring(redPlace - 3, redPlace - 1));
                        }
                        redNum++;
                        redPlace = line.indexOf("red", redPlace + 3);
                    }

                    while (greenPlace != -1) {
                        if (line.charAt(greenPlace - 3) == ' ') {
                            greenArray[greenNum] = Integer.parseInt(line.substring(greenPlace - 2, greenPlace - 1));
                        } else {
                            greenArray[greenNum] = Integer.parseInt(line.substring(greenPlace - 3, greenPlace - 1));
                        }
                        greenNum++;
                        greenPlace = line.indexOf("green", greenPlace + 5);
                    }

                    while (bluePlace != -1) {
                        if (line.charAt(bluePlace - 3) == ' ') {
                            blueArray[blueNum] = Integer.parseInt(line.substring(bluePlace - 2, bluePlace - 1));
                        } else {
                            blueArray[blueNum] = Integer.parseInt(line.substring(bluePlace - 3, bluePlace - 1));
                        }
                        blueNum++;
                        bluePlace = line.indexOf("blue", bluePlace + 4);
                    }
                    for (int j:redArray){
                        if (j>redMax){
                            redMax=j;
                        }
                        if (j>12){
                            validity=false;
                        }
                    }
                    for (int j:greenArray){
                        if (j>greenMax){
                            greenMax=j;
                        }
                        if (j>13){
                            validity=false;
                        }
                    }
                    for (int j:blueArray){
                        if (j>blueMax){
                            blueMax=j;
                        }
                        if (j>14){
                            validity=false;
                        }
                    }
                    if (validity){
                        sum+=count;
                    }
                    power=redMax*greenMax*blueMax;
                    sumPower+=power;
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No File or Empty");
        }
        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + sumPower);
    }
}