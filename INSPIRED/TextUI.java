
import java.util.Scanner;

public class TextUI {

    private static final int DEFAULT_DELAY = 35;

    public static void printSlow(String text) {
        printSlow(text, DEFAULT_DELAY);
    }

    public static void printSlow(String text, int delayMs) {
        for (char character : text.toCharArray()) {
            System.out.print(character);

            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println();
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitForEnter(Scanner scanner) {
        System.out.println();
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
    }
}
