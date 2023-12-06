import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class DayThree {
    public static void main(String[] args) throws IOException {
        File file =new File("/Users/gagrehansavona/Desktop/Coding Projects/Advent Of Code/2023/Day Three/DayThree.txt");
        int count=0;
        int sum=0;
        char[][] fileArray = new char[140][];
        String specialCharacters = "&+-#$@*/=%";
        int newSum=0;
        try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileArray[count] = new char[line.length()];
                    for(int i=0;i<line.length();i++){
                        if (line.charAt(i)=='.'){
                            fileArray[count][i]=' ';
                        }
                        else {
                            fileArray[count][i]=line.charAt(i);
                        }
                    }
                    count++;
                }
            for(int i=0;i<140;i++){
                for(int j=0;j<fileArray[i].length;j++){
                    int k=0;
                    boolean numCheck=true;
                    int numCount=0;
                    outerLoop: if (Character.isDigit(fileArray[i][j])){
                        while (numCheck){
                            
                            if (((j+numCount+1)>=fileArray[i].length)){
                                numCheck=false;
                            }
                            else if(!(Character.isDigit(fileArray[i][j+numCount+1]))){
                                numCheck=false;
                            }
                            else {
                                numCount++;
                            }
                            
                        }
                        if((j-1)!=-1){
                            if (specialCharacters.contains(String.valueOf(fileArray[i][j-1]))){
                                if((j+numCount-1)<fileArray[i].length){
                                    sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                    newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                    j+=numCount;
                                    break outerLoop;
                                }
                            }
                            if ((i-1)!=-1){
                                if (specialCharacters.contains(String.valueOf(fileArray[i-1][j-1]))){
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                            if ((i+1)!=fileArray.length){
                                if (specialCharacters.contains(String.valueOf(fileArray[i+1][j-1]))){
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                        for (int l=0;l<=numCount;l++){
                            if ((i-1)!=-1){
                                if (specialCharacters.contains(String.valueOf(fileArray[i-1][j+l]))){
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                            if ((i+1)!=fileArray.length){
                                if (specialCharacters.contains(String.valueOf(fileArray[i+1][j+l]))){
                                    //System.out.println("First: "+ fileArray[i][j]+"Last: "+fileArray[i][j+l]);
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                        if((j+1)!=fileArray[i].length){
                            if (specialCharacters.contains(String.valueOf(fileArray[i][j+1]))){
                                if((j+numCount-1)<fileArray[i].length){
                                    sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                    newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                    j+=numCount;
                                    break outerLoop;
                                }
                            }
                            if ((i-1)!=-1){
                                if (specialCharacters.contains(String.valueOf(fileArray[i-1][j+1]))){
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                            if ((i+1)<fileArray.length){
                                if (specialCharacters.contains(String.valueOf(fileArray[i+1][j+1]))){
                                    if((j+numCount-1)<fileArray[i].length){
                                        sum += Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount-1))).trim());
                                        newSum=Integer.parseInt(String.valueOf(Arrays.copyOfRange(fileArray[i], j, j + (numCount))).trim());
                                    System.out.println(newSum);
                                        j+=numCount;
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                        j+=numCount;
                        
                    }
                }
            }
            System.out.println(sum);
        }
        
        catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        
    }
}
