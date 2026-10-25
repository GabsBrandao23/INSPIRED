
public class Dice {

    // Rolls two dice based on the character's star rating.
    // This method is static because no Dice object is required.
    public static int rollByStars(int stars) {

        // Stores the number of sides on each die.
        int sides;

        // Determines the die type based on the star rating.
        switch (stars) {

            // 1 star = 2d4
            case 1:
                sides = 4;
                break;

            // 2 stars = 2d6
            case 2:
                sides = 6;
                break;

            // 3 stars = 2d8
            case 3:
                sides = 8;
                break;

            // 4 stars = 2d10
            case 4:
                sides = 10;
                break;

            // 5 stars = 2d12
            case 5:
                sides = 12;
                break;

            // Uses four-sided dice if the rating is invalid.
            default:
                sides = 4;
                break;
        }

        // Generates a random result for the first die.
        int die1 = (int) (Math.random() * sides) + 1;

        // Generates a random result for the second die.
        int die2 = (int) (Math.random() * sides) + 1;

        // Returns the sum of both dice.
        return die1 + die2;
    }
}
