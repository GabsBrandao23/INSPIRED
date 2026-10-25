
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TextUI.clearScreen();

        System.out.println("          [0;97m▄[0;37m    [0;97m▄▄▄[0;37m [0;97m▄▄▄▄[0;37m   [0;97m▄▄▄▄▄▄▄[0;37m     [0;97m▄▄▄▄▄[0;37m     [0;97m▄[0;37m     [0;97m▄▄▄▄▄[0;37m       [0;97m▄▄▄▄▄▄[0;37m    [0;97m▄▄▄▄▄[0;37m    [0m\r\n" + //
                        "[0;97m█▀[0;37m▄  [0;97m█[0;37m  [0;97m▀[0;37m ░  ▀▄ [0;97m█[0;37m      [0;97m▀[0;37m▄  [0;97m█[0;37m     [0;97m▀▀[0;37m▄  [0;97m█▀[0;37m▄  [0;97m█[0;37m     [0;97m▀▀[0;37m▄  [0;97m▄▀[0;37m   ░  ▀▄ [0;97m█[0;37m     [0;97m▀▀[0;37m▄ [0m\r\n" + //
                        "[0;97m█[0;37m  [0;90;47m░[0;37m [0;97m█[0;37m ░[0;90m▄▀[0;37m▀[0;97m▄[0;37m ░[0;90;47m░[0;37m [0;97m█[0;37m  [0;90;47m▓[0;90m▀▀[0;90;47m░[0;37m  [0;90;47m░[0;37m [0;97m█[0;37m ░[0;90;47m█[0;37m▀[0;97m▄[0;37m   [0;90;47m▒[0;37m [0;97m█[0;37m  [0;90;47m░[0;37m [0;97m█[0;37m ░[0;90;47m█[0;37m▀[0;97m▄[0;37m   [0;90;47m▒[0;37m [0;97m█[0;37m ░[0;90m▄▀[0;37m▀[0;97m▄[0;37m ░[0;90;47m░[0;37m [0;97m█[0;37m ░[0;90;47m█[0;37m▀[0;97m▄[0;37m   [0;90;47m▒[0m\r\n" + //
                        "[0;97m█[0;37m░░[0;90;47m▒[0;37m [0;97m█[0;37m ░[0;90;47m▒[0;37m  [0;97m█[0;37m░ [0;90;47m▒[0;37m ▀[0;90m▀▀▀[0;37m  [0;97;47m░[0;37m░ [0;90;47m▒[0;37m [0;97m█[0;37m▒░[0;90;47m█[0;37m  [0;97m█[0;37m░░[0;90;47m▓[0;37m [0;97m█[0;37m░░[0;90;47m▒[0;37m [0;97m█[0;37m▒░[0;90;47m█[0;37m  [0;97m█[0;37m░ [0;90;47m▓[0;37m [0;97m█[0;37m ░[0;90;47m▒[0;37m  [0;97m█[0;37m▄▀  [0;97m█[0;37m▒░[0;90;47m▓[0;37m  [0;97m█[0;37m░ [0;90;47m▓[0m\r\n" + //
                        "[0;97m█[0;37m▒░[0;90;47m▓[0;37m [0;97m█[0;37m░░[0;90;47m▓[0;37m  [0;97m█[0;37m░░[0;90;47m▓[0;37m    [0;97m▄▄[0;97;47m▀[0;37m█░▒[0;90;47m▓[0;37m [0;97m█[0;37m▒▒[0;90;47m▒[0;37m▄[0;97;47m▀[0;37m▒▒▒[0;90m█[0;37m [0;97m█[0;37m▒░[0;90;47m▓[0;37m [0;97m█[0;37m▒▒[0;90;47m▒[0;37m▄[0;97;47m▀[0;37m░▒░[0;90m█[0;37m [0;97m█[0;37m░░[0;97;47m▓[0;97m▄[0;37m [0;97m▀[0;37m    [0;97m█[0;37m▒░[0;90;47m▒[0;37m  [0;97m█[0;37m░░[0;90m█[0m\r\n" + //
                        "[0;97m█[0;37m▒▒[0;90m█[0;37m [0;97m█[0;37m▒░[0;90m█[0;37m  [0;97m█[0;37m▒▒[0;90m█[0;37m  [0;97m▄[0;97;47m▀[0;37m░▒▒▒▒[0;90;47m▄[0;90m▀[0;37m [0;97m█[0;37m▒▒▒▒▓[0;90;47m▄▄[0;90m▀[0;37m  [0;97m█[0;37m▒▒[0;90m█[0;37m [0;97m█[0;37m▒▒▒░░▒[0;90m▓▀[0;37m  [0;97m█[0;37m▒░▒▒[0;37;47m▀[0;37m▄    [0;97m█[0;37m▒▒[0;90m█[0;37m  [0;97;47m▒[0;37m▒▒[0;90m█[0m\r\n" + //
                        "[0;97m█[0;37m█▓[0;90m█[0;37m [0;97m█[0;37m▒▓[0;90;47m▓[0;37m  [0;97;47m▓[0;37m▓▓[0;90m█[0;37m [0;97m█[0;37m▓▓█[0;90;47m▄[0;90m▀▀▀[0;37m   [0;97m█[0;37m▒▓[0;90m█[0;37m▀▀     [0;97m█[0;37m█▓[0;90m█[0;37m [0;97m█[0;37m▒▓[0;90m█[0;37m▀[0;97;47m▄[0;37m▒▒[0;90m█[0;37m  [0;97m█[0;37m▒▓[0;90;47m▓[0;90m▀▀▀[0;37m    [0;97m█[0;37m▒▓[0;90m▓[0;37m  [0;97;47m▓[0;37m▒▒[0;90m█[0m\r\n" + //
                        "[0;97;47m▓[0;37m█▓[0;90m█[0;37m [0;97m█[0;37m▓▓[0;90;47m▒[0;37m  [0;97;47m▒[0;37m█▓[0;90m▓[0;37m [0;97m█[0;37m▓▓[0;90;47m▓[0;37m  [0;97m█[0;97;47m▀▀[0;90;47m░[0;37m [0;97m█[0;37m▓▓[0;90m█[0;37m       [0;97;47m▓[0;37m█▓[0;90m█[0;37m [0;97m█[0;37m▓▓[0;90m█[0;37m [0;97m█[0;37m▓▒[0;90m█[0;37m  [0;97m█[0;37m▓▓[0;90;47m▒[0;37m  [0;97;47m▒[0;37m▄[0;90m▄[0;37m  [0;97m█[0;37m▓▓[0;90m▒[0;37m  [0;97;47m▒[0;37m▓▒[0;90m█[0m\r\n" + //
                        "[0;97;47m▒[0;37m█[0;37;47m [0;90m█[0;37m [0;97m█[0;37m█▓[0;90;47m░[0;37m  [0;97;47m░[0;37m██[0;90m▒[0;37m [0;97;47m▒  [0;90;47m░[0;37m  [0;97;47m▒[0;37m██[0;90;47m▓[0;37m [0;97;47m▒[0;37m██[0;90m█[0;37m       [0;97;47m▒[0;37m█[0;37;47m [0;90m█[0;37m [0;97;47m▒[0;37m██[0;90m█[0;37m [0;97;47m▒[0;37m▓█[0;90m█[0;37m  [0;97m█[0;37m█▓[0;90;47m░[0;37m  [0;97;47m░[0;37m██[0;90m▒[0;37m [0;97;47m▒[0;37m██[0;90m▒[0;37m  [0;97m█[0;37m▓█[0;90m▒[0m\r\n" + //
                        "[0;97;47m░  [0;90m▓[0;37m [0;97m█[0;97;47m [0;37m█[0;90;47m▒[0;37m  [0;97;47m▒[0;37m██[0;90m░[0;37m [0;97;47m░  [0;37;47m▀[0;37m▄ [0;97;47m░  [0;90m▓[0;37m [0;97;47m░[0;37m██[0;90m▓[0;37m       [0;97;47m░  [0;90m▓[0;37m [0;97;47m░[0;37m██[0;90m▓[0;37m [0;97;47m░[0;37m██[0;90m▓[0;37m  [0;97m█[0;97;47m [0;37m█[0;37;47m▀[0;37m▄▄[0;37;47m▀[0;37m██[0;90m░[0;37m [0;97m█[0;97;47m [0;37m█[0;37;47m▀[0;37m▄▄[0;37;47m▀[0;37m██[0;90m░[0m\r\n" + //
                        "[0;37m▀[0;37;47m▄[0;37m█[0;90m▒[0;37m [0;97m▀[0;37;47m▄ [0;90;47m▓[0;37m  [0;97;47m▓[0;37;47m [0;90;47m▄[0;90m▀[0;37m ▀[0;90;47m▄ [0;37m██[0;97;47m▀[0;37;47m▀[0;37m█[0;90;47m [0;90m▒[0;37m ▀[0;37;47m▄[0;37m█[0;90m▒[0;37m       ▀[0;37;47m▄[0;37m█[0;90m▒[0;37m ▀[0;37;47m▄[0;37m█[0;90m▒[0;37m ▀[0;37;47m▄[0;37m█[0;90m▒[0;37m  [0;97m▀[0;37;47m▄      [0;90;47m▄[0;37m  [0;97m▀[0;37;47m▄      [0;90;47m▄[0;37m [0m\r\n" + //
                        "[0;37m  [0;90m▀░[0;37m   [0;90m▀▀[0;37m  ▀[0;90m▀[0;37m     [0;90m▀[0;90;47m▄▄▄▄▄▄[0;90m░[0;37m   [0;90m▀░[0;37m         [0;90m▀░[0;37m   [0;90m▀░[0;37m   [0;90m▀░[0;37m    [0;90m▀▀▀▀▀▀[0;37m     [0;90m▀▀▀▀▀▀[0;37m  [0m");

        TextUI.pause(500);

        TextUI.printSlow("");
        TextUI.printSlow(
                "A terrible dragon has awakened from its ancient slumber."
        );
        TextUI.printSlow(
                "The kingdom is in danger, and a hero must face the beast."
        );

        TextUI.pause(500);

        GameCharacter player = chooseCharacter(scanner);

        if (player == null) {
            TextUI.printSlow("No hero was selected. Goodbye!");
            scanner.close();
            return;
        }

        TextUI.clearScreen();

        TextUI.printSlow("You have chosen " + player.getName() + "!");
        TextUI.printSlow("Health: " + player.getHealth());
        TextUI.printSlow(
                "Physical Damage Stars: " + player.getStarsPhysicalDamage()
        );
        TextUI.printSlow(
                "Magic Damage Stars: " + player.getStarsMagicDamage()
        );
        TextUI.printSlow(
                "Physical Defense Stars: " + player.getStarsPhysicalDefense()
        );
        TextUI.printSlow(
                "Magic Defense Stars: " + player.getStarsMagicDefense()
        );

        TextUI.waitForEnter(scanner);

        Dragon dragon = new Dragon();

        Battle.startFight(player, dragon, scanner);

        TextUI.printSlow("");
        TextUI.printSlow("Thank you for playing!");

        scanner.close();
    }

    private static GameCharacter chooseCharacter(Scanner scanner) {

        while (true) {
            TextUI.printSlow("");
            TextUI.printSlow("Choose your hero:");
            TextUI.printSlow("1. Merlin - The Arcane Mage");
            TextUI.printSlow("2. Maximus - The Mighty Warrior");
            TextUI.printSlow("3. Jork - The Enchanted Swordsman");
            TextUI.printSlow("0. Exit Game");

            System.out.print("> ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                TextUI.printSlow("Invalid input. Please enter a number.");
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    return new Merlin();

                case 2:
                    return new Maximus();

                case 3:
                    return new Jork();

                case 0:
                    return null;

                default:
                    TextUI.printSlow(
                            "Invalid choice. Please select 1, 2, 3, or 0."
                    );
            }
        }
    }
}
