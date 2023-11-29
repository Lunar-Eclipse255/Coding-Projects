import java.util.*;
public class Long {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] list = new String[num];
        for (int i=0; i<list.length;i++){
            String word = scanner.nextLine();
            if (word.length()>10){
                list[i]=word.substring(0,1)+(word.length()-2)+word.substring(word.length()-1);
            }
            else{
                list[i]=word;
            }
        }
        for (String j : list){
            System.out.println(j);
        }
        scanner.close();
    }
}