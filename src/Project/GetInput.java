package Project;
import java.util.Scanner;

public class GetInput {
    private static final Scanner scanner = new Scanner(System.in);
    public static String getWordInput() {
        while (true){
            try {
                return scanner.next();
            } catch (Exception e) {
                System.out.println("Please enter only a String: ");
            }
        }
    }
    public static String getSentenceInput() {
        while (true){
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a String: ");
            }
        }
    }
    public static int getNumberInput() {
        while (true){
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter only a number!: ");;
            }
        }
    }
    public static void closeScanner() {
        scanner.close();
    }
}
