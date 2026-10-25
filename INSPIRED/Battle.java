
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private static final Random RANDOM = new Random();

    private static GameCharacter currentPlayer;
    private static GameCharacter currentDragon;

    /*
     * Each character has its own defense.
     * This prevents the player's defense from being
     * accidentally used to protect the dragon.
     */
    private static class DefenseState {
        int value = 0;
        DefenseType type = DefenseType.NONE;
        boolean canReflectMagic = false;
    }

    private static final Map<GameCharacter, DefenseState> defenses =
            new HashMap<>();

    private static int hunterSenseTurns = 0;

    private Battle() {
        // Utility class.
    }

    public static void startFight(
            GameCharacter player,
            GameCharacter dragon,
            Scanner scanner) {

        currentPlayer = player;
        currentDragon = dragon;

        defenses.clear();
        hunterSenseTurns = 0;

        TextUI.clearScreen();
        TextUI.printSlow("========================================");
        TextUI.printSlow("              BATTLE BEGINS");
        TextUI.printSlow("========================================");
        TextUI.printSlow(player.getName() + " faces "
                + dragon.getName() + "!");
        TextUI.pause(700);

        while (player.isAlive() && dragon.isAlive()) {

            // Player's turn
            TextUI.clearScreen();
            showBattleStatus();

            player.processStatusEffects();

            if (!player.isAlive()) {
                break;
            }

            boolean hunterSenseWasActive = hunterSenseTurns > 0;

            int playerChoice = playerTurn(scanner);

            // Count only turns after Hunter Sense was activated.
            // Choosing Hunter Sense again refreshes its duration.
            if (hunterSenseWasActive
                    && !(player instanceof Maximus && playerChoice == 2)) {
                hunterSenseTurns--;
            }

            if (!dragon.isAlive()) {
                break;
            }

            TextUI.waitForEnter(scanner);

            // Dragon's turn
            TextUI.clearScreen();
            showBattleStatus();

            dragon.processStatusEffects();

            if (!dragon.isAlive()) {
                break;
            }

            dragonTurn();

            if (!player.isAlive()) {
                break;
            }

            TextUI.waitForEnter(scanner);
        }

        TextUI.clearScreen();
        TextUI.printSlow("========================================");

        if (player.isAlive()) {
            TextUI.printSlow("VICTORY!");
            TextUI.printSlow(player.getName()
                    + " has defeated the Ancient Dragon!");
        } else {
            TextUI.printSlow("DEFEAT!");
            TextUI.printSlow(player.getName()
                    + " has fallen in battle.");
        }

        TextUI.printSlow("========================================");
        TextUI.printSlow("Final HP:");
        TextUI.printSlow(player.getName() + ": "
                + player.getHealth());
        TextUI.printSlow(dragon.getName() + ": "
                + dragon.getHealth());
    }

    public static void startFight(
            GameCharacter player,
            GameCharacter dragon) {

        Scanner scanner = new Scanner(System.in);
        startFight(player, dragon, scanner);
    }

    private static DefenseState getDefenseState(
            GameCharacter character) {

        if (!defenses.containsKey(character)) {
            defenses.put(character, new DefenseState());
        }

        return defenses.get(character);
    }

    private static void showBattleStatus() {
        TextUI.printSlow("----------------------------------------");
        TextUI.printSlow(currentPlayer.getName()
                + " HP: " + currentPlayer.getHealth());
        TextUI.printSlow(currentDragon.getName()
                + " HP: " + currentDragon.getHealth());
        TextUI.printSlow("----------------------------------------");
    }

    // =========================
    // PLAYER TURN
    // =========================

    private static int playerTurn(Scanner scanner) {

        int choice;

        while (true) {
            TextUI.printSlow("");
            TextUI.printSlow("Choose your action:");

            if (currentPlayer instanceof Merlin) {
                TextUI.printSlow("1. Fireball");
                TextUI.printSlow("2. Magic Dagger");
                TextUI.printSlow("3. Arcane Shield");
                TextUI.printSlow("4. Physical Ward");

            } else if (currentPlayer instanceof Maximus) {
                TextUI.printSlow("1. Heavy Cleave");
                TextUI.printSlow("2. Hunter Sense");
                TextUI.printSlow("3. Runic Axe");
                TextUI.printSlow("4. Axe Guard");

            } else if (currentPlayer instanceof Jork) {
                TextUI.printSlow("1. Ice Blast");
                TextUI.printSlow("2. Sword Strike");
                TextUI.printSlow("3. Vine Potion");
                TextUI.printSlow("4. Enchanted Oak Shield");

            } else {
                TextUI.printSlow("1. Physical Attack");
                TextUI.printSlow("2. Magic Attack");
                TextUI.printSlow("3. Physical Defense");
                TextUI.printSlow("4. Magic Defense");
            }

            System.out.print("> ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                TextUI.printSlow("Invalid input. Enter a number.");
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= 4) {
                break;
            }

            TextUI.printSlow("Choose an option from 1 to 4.");
        }

        if (currentPlayer instanceof Merlin) {
            switch (choice) {
                case 1:
                    fireball();
                    break;
                case 2:
                    magicDagger();
                    break;
                case 3:
                    arcaneShield();
                    break;
                case 4:
                    physicalWard();
                    break;
            }

        } else if (currentPlayer instanceof Maximus) {
            switch (choice) {
                case 1:
                    heavyCleave();
                    break;
                case 2:
                    hunterSense();
                    break;
                case 3:
                    runicAxe();
                    break;
                case 4:
                    axeGuard();
                    break;
            }

        } else if (currentPlayer instanceof Jork) {
            switch (choice) {
                case 1:
                    iceBlast();
                    break;
                case 2:
                    swordStrike();
                    break;
                case 3:
                    vinePotion();
                    break;
                case 4:
                    enchantedOakShield();
                    break;
            }

        } else {
            switch (choice) {
                case 1:
                    physicalAttack(currentPlayer, currentDragon);
                    break;
                case 2:
                    magicAttack(currentPlayer, currentDragon);
                    break;
                case 3:
                    preparePhysicalDefense(currentPlayer);
                    break;
                case 4:
                    prepareMagicDefense(currentPlayer, false);
                    break;
            }
        }

        return choice;
    }

    // =========================
    // MERLIN'S ABILITIES
    // =========================

    private static void fireball() {
        TextUI.printSlow(
                "Merlin gathers mana between his palms, weaving it "
                + "into a blazing sphere of fire before hurling it "
                + "toward the Dragon.");

        int damage = Dice.rollByStars(
                currentPlayer.getStarsMagicDamage());

        applyMagicDamage(currentPlayer, currentDragon, damage);

        if (currentDragon.isAlive() && RANDOM.nextInt(4) == 0) {
            currentDragon.applyStatusEffect(
                    StatusEffect.Type.BURN, 5, 3);

            TextUI.printSlow(
                    "The Dragon is engulfed in flames! Burn inflicted.");
        }
    }

    private static void magicDagger() {
        TextUI.printSlow(
                "Merlin summons an arcane dagger into his hand "
                + "and darts forward, striking with a blade "
                + "charged with ancient magic.");

        // This skill deals physical damage.
        int damage = Dice.rollByStars(
                currentPlayer.getStarsPhysicalDamage());

        applyPhysicalDamage(currentPlayer, currentDragon, damage);

        if (currentDragon.isAlive() && RANDOM.nextInt(4) < 2) {
            currentDragon.applyStatusEffect(
                    StatusEffect.Type.BLEED, 7, 3);

            TextUI.printSlow(
                    "The Dragon begins bleeding! Bleed inflicted.");
        }
    }

    private static void arcaneShield() {
        TextUI.printSlow(
                "Merlin traces a glowing sigil in the air, "
                + "conjuring an arcane barrier that shimmers "
                + "with protective energy.");

        prepareMagicDefense(currentPlayer, true);
    }

    private static void physicalWard() {
        TextUI.printSlow(
                "Merlin whispers an ancient incantation, "
                + "surrounding himself with a dense magical "
                + "barrier designed to repel physical blows.");

        preparePhysicalDefense(currentPlayer);
    }

    // =========================
    // MAXIMUS'S ABILITIES
    // =========================

    private static void heavyCleave() {
        TextUI.printSlow(
                "Maximus tightens his grip on the axe, raises it "
                + "above his head, and brings it crashing down "
                + "with brutal force.");

        int damage = Dice.rollByStars(
                currentPlayer.getStarsPhysicalDamage());

        // Hunter Sense adds 5 damage without changing base stats.
        if (hunterSenseTurns > 0) {
            damage += 5;
            TextUI.printSlow(
                    "Hunter Sense improves Maximus's attack by 5!");
        }

        applyPhysicalDamage(currentPlayer, currentDragon, damage);
    }

    private static void hunterSense() {
        TextUI.printSlow(
                "Maximus narrows his eyes and studies his "
                + "opponent's movements. His instincts sharpen, "
                + "revealing the perfect moment to strike.");

        // Refreshes the duration; the bonus never stacks.
        hunterSenseTurns = 3;

        TextUI.printSlow(
                "Hunter Sense activated! +5 physical damage "
                + "and -5 physical defense for 3 turns.");
    }

    private static void runicAxe() {
        TextUI.printSlow(
                "Maximus presses his hand against the axe's runes. "
                + "They flare with ancient power, forming a ward "
                + "against hostile magic.");

        prepareMagicDefense(currentPlayer, false);
    }

    private static void axeGuard() {
        TextUI.printSlow(
                "Maximus braces himself and raises his axe, "
                + "positioning its broad blade to absorb "
                + "the force of the incoming blow.");

        preparePhysicalDefense(currentPlayer);
    }

    // =========================
    // JORK'S ABILITIES
    // =========================

    private static void iceBlast() {
        TextUI.printSlow(
                "Jork sweeps his sword through the air, releasing "
                + "a violent burst of frost that surges "
                + "toward his enemy.");

        int damage = Dice.rollByStars(
                currentPlayer.getStarsMagicDamage());

        applyMagicDamage(currentPlayer, currentDragon, damage);
    }

    private static void swordStrike() {
        TextUI.printSlow(
                "Jork steps forward and swings his sword "
                + "in a swift, decisive strike.");

        int damage = Dice.rollByStars(
                currentPlayer.getStarsPhysicalDamage());

        applyPhysicalDamage(currentPlayer, currentDragon, damage);
    }

    private static void vinePotion() {
        TextUI.printSlow(
                "Jork smashes a vial against the ground. "
                + "Glowing vines burst from the earth and twist "
                + "around him in a protective barrier.");

        prepareMagicDefense(currentPlayer, false);
    }

    private static void enchantedOakShield() {
        TextUI.printSlow(
                "Jork raises his enchanted oak shield. Ancient "
                + "runes awaken across its surface as he prepares "
                + "to withstand the attack.");

        preparePhysicalDefense(currentPlayer);
    }

    // =========================
    // DEFENSE PREPARATION
    // =========================

    private static void preparePhysicalDefense(
            GameCharacter character) {

        DefenseState state = getDefenseState(character);

        int defense = Dice.rollByStars(
                character.getStarsPhysicalDefense());

        // Hunter Sense weakens Maximus's physical defense.
        if (character instanceof Maximus && hunterSenseTurns > 0) {
            defense = Math.max(0, defense - 5);
            TextUI.printSlow(
                    "Hunter Sense reduces Maximus's physical "
                    + "defense by 5.");
        }

        state.value = defense;
        state.type = DefenseType.ARMOR;
        state.canReflectMagic = false;

        TextUI.printSlow(character.getName()
                + " prepares physical defense: " + defense + ".");
    }

    private static void prepareMagicDefense(
            GameCharacter character,
            boolean canReflectMagic) {

        DefenseState state = getDefenseState(character);

        int defense = Dice.rollByStars(
                character.getStarsMagicDefense());

        state.value = defense;
        state.type = DefenseType.MAGIC_RESISTANCE;
        state.canReflectMagic = canReflectMagic;

        TextUI.printSlow(character.getName()
                + " prepares magic defense: " + defense + ".");

        if (canReflectMagic) {
            TextUI.printSlow(
                    "The shield has a 1 in 8 chance to reflect "
                    + "the next magical attack.");
        }
    }

    // =========================
    // DAMAGE CALCULATION
    // =========================

    private static void physicalAttack(
            GameCharacter attacker,
            GameCharacter defender) {

        TextUI.printSlow(attacker.getName()
                + " launches a physical attack!");

        int damage = Dice.rollByStars(
                attacker.getStarsPhysicalDamage());

        applyPhysicalDamage(attacker, defender, damage);
    }

    private static void magicAttack(
            GameCharacter attacker,
            GameCharacter defender) {

        TextUI.printSlow(attacker.getName()
                + " casts a magical attack!");

        int damage = Dice.rollByStars(
                attacker.getStarsMagicDamage());

        applyMagicDamage(attacker, defender, damage);
    }

    private static void applyPhysicalDamage(
            GameCharacter attacker,
            GameCharacter defender,
            int attackDamage) {

        DefenseState state = getDefenseState(defender);
        int defense = 0;

        // Only physical defense blocks physical attacks.
        if (state.type == DefenseType.ARMOR) {
            defense = state.value;

            // Consume this physical defense after use.
            state.value = 0;
            state.type = DefenseType.NONE;
            state.canReflectMagic = false;
        }

        int absorbedDamage = Math.min(attackDamage, defense);
        int finalDamage = Math.max(0, attackDamage - defense);

        TextUI.printSlow(attacker.getName()
                + " deals " + attackDamage + " physical damage!");

        if (absorbedDamage > 0) {
            TextUI.printSlow(defender.getName()
                    + "'s physical defense absorbs "
                    + absorbedDamage + " damage!");
        }

        if (finalDamage > 0) {
            defender.takeDamage(finalDamage);
            TextUI.printSlow(defender.getName()
                    + " takes " + finalDamage + " damage!");
        } else {
            TextUI.printSlow("The attack is completely blocked!");
        }

        TextUI.printSlow(defender.getName()
                + "'s remaining HP: " + defender.getHealth());
    }

    private static void applyMagicDamage(
            GameCharacter attacker,
            GameCharacter defender,
            int attackDamage) {

        DefenseState state = getDefenseState(defender);

        int defense = 0;
        boolean canReflect = false;

        // Only magical defense blocks magical attacks.
        if (state.type == DefenseType.MAGIC_RESISTANCE) {
            defense = state.value;
            canReflect = state.canReflectMagic;

            // Consume the magical defense after use.
            state.value = 0;
            state.type = DefenseType.NONE;
            state.canReflectMagic = false;
        }

        int absorbedDamage = Math.min(attackDamage, defense);
        int finalDamage = Math.max(0, attackDamage - defense);

        TextUI.printSlow(attacker.getName()
                + " deals " + attackDamage + " magical damage!");

        if (absorbedDamage > 0) {
            TextUI.printSlow(defender.getName()
                    + "'s magical defense absorbs "
                    + absorbedDamage + " damage!");
        }

        if (finalDamage > 0) {
            defender.takeDamage(finalDamage);
            TextUI.printSlow(defender.getName()
                    + " takes " + finalDamage + " damage!");
        } else {
            TextUI.printSlow("The magical attack is completely blocked!");
        }

        // Reflection is available only if this specific shield
        // was prepared and is consumed by this magical attack.
        if (canReflect && RANDOM.nextInt(8) == 0) {
            TextUI.printSlow(
                    defender.getName()
                    + "'s Arcane Shield reflects the magical attack!");

            attacker.takeDamage(attackDamage);

            TextUI.printSlow(attacker.getName()
                    + " takes " + attackDamage
                    + " reflected damage!");
        }

        TextUI.printSlow(defender.getName()
                + "'s remaining HP: " + defender.getHealth());

        if (canReflect) {
            TextUI.printSlow(
                    "The Arcane Shield's protection has been consumed.");
        }
    }

    // =========================
    // DRAGON TURN
    // =========================

    private static void dragonTurn() {
        TextUI.printSlow("");
        TextUI.printSlow(currentDragon.getName() + "'s turn!");
        TextUI.pause(500);

        int choice = RANDOM.nextInt(4) + 1;

        switch (choice) {
            case 1:
                dragonPhysicalAttack();
                break;

            case 2:
                dragonMagicAttack();
                break;

            case 3:
                TextUI.printSlow(
                        "The Dragon braces itself, preparing "
                        + "to withstand a physical attack.");
                preparePhysicalDefense(currentDragon);
                break;

            case 4:
                TextUI.printSlow(
                        "The Dragon gathers arcane energy "
                        + "to protect itself from magic.");
                prepareMagicDefense(currentDragon, false);
                break;
        }
    }

    private static void dragonPhysicalAttack() {
        TextUI.printSlow(
                "The Dragon lunges forward, striking with "
                + "its massive claws!");

        int damage = Dice.rollByStars(
                currentDragon.getStarsPhysicalDamage());

        applyPhysicalDamage(currentDragon, currentPlayer, damage);
    }

    private static void dragonMagicAttack() {
        TextUI.printSlow(
                "The Dragon unleashes a torrent of "
                + "devastating magical energy!");

        int damage = Dice.rollByStars(
                currentDragon.getStarsMagicDamage());

        applyMagicDamage(currentDragon, currentPlayer, damage);
    }
}
