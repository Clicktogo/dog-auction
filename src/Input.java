// Filip Garica figa6281
import java.util.Scanner;

public class Input {

    private static final Scanner INPUT = new Scanner(System.in);

    public static String inputFromUser(){
        return INPUT.nextLine().toLowerCase().trim();
    }

    public static String userInputString(String askInput) {
        System.out.print(askInput);
        return INPUT.nextLine().toLowerCase().trim();
    }

    public static int userInputInt(String askInput){
        System.out.print(askInput);
        int userAnswer = INPUT.nextInt();
        INPUT.nextLine();
        return userAnswer;
    }

    public static double userInputDouble(String askInput){
        System.out.print(askInput);
        double userAnswer = INPUT.nextDouble();
        INPUT.nextLine();
        return userAnswer;
    }

}

