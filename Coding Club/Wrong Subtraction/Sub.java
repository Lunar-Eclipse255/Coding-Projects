import java.util.Scanner;
public class Sub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String full = scanner.nextLine();
        int space = full.indexOf(" ");
        int num = Integer.parseInt(full.substring(0,space));
        int count = Integer.parseInt(full.substring(space+1,full.length()));
        for (int i =0;i<count;i++){
            if (num%10==0){
                num/=10;
            }
            else{
                num--;
            }
        }
        System.out.println(num);
    }
}
