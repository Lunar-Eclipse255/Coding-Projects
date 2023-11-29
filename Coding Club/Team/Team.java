package Team;
import java.util.Scanner;
public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int solved = 0;
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<num;i++){
            String problem = scanner.nextLine();
            int space=problem.indexOf(" ");
            int Petya = Integer.parseInt(problem.substring(0,space));
            String problemPtTwo=problem.substring(space+1);
            int spaceTwo=problemPtTwo.indexOf(" ");
            int Vasya = Integer.parseInt(problemPtTwo.substring(0,spaceTwo));
            int Tonya = Integer.parseInt(problemPtTwo.substring(spaceTwo+1));
            if ((Petya==1&&Vasya==1)||(Petya==1&&Tonya==1)||(Vasya==1&&Tonya==1)){
                solved++;
            }
        }
        System.out.println(solved);
        scanner.close();
    }
}