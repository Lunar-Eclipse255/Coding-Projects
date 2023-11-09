import java.util.Scanner;
public class WatermelonSplit {
    public static void main(String[] args) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        for(double i=1;i<num;i++){
            //if(!((num-i)==0)&&((num-i)%2==0)&&(i%2==0)){

                if (((num-i)%2==0)&&(i%2==0)){
                        check=true;
                }
        }
            
        if (check==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
