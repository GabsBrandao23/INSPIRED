# INSPIRED

A text-based RPG battle game developed in Java, where players choose a hero and face an ancient dragon in a turn-based combat system.

## About the Project

*The Ancient Dragon* is a console-based RPG developed as an Object-Oriented Programming (OOP) project. The game combines character selection, dice-based combat, defensive abilities, and status effects in a fantasy adventure.

The player's mission is to choose a hero, use their unique abilities strategically, and defeat the dragon threatening the kingdom.

## Features

- **Character Selection:** Choose between three heroes, each with unique abilities and combat styles.
- **Turn-Based Combat:** Take turns attacking, defending, and using special abilities.
- **Dice-Based Damage:** Damage is determined by dice rolls based on each character's attributes.
- **Defensive Mechanics:** Physical defense and magic resistance help reduce incoming damage.
- **Status Effects:** Burn and bleed effects can deal damage over multiple turns.
- **Character Attributes:** Each character has health, physical damage, magic damage, physical defense, and magic defense attributes.
- **Console Interface:** Text-based storytelling, colored ASCII art, and interactive menus.

## Playable Characters

### Merlin — The Arcane Mage
A magic-focused hero who uses elemental attacks and defensive spells.

- **Fireball:** Deals magical damage and has a chance to inflict burn.
- **Magic Dagger:** Deals physical damage and has a chance to inflict bleed.
- **Arcane Shield:** Provides magical defense with a chance to reflect magical attacks.
- **Physical Ward:** Provides physical defense.

### Maximus — The Mighty Warrior
A powerful warrior who specializes in physical attacks and tactical defense.

- **Heavy Cleave:** Attacks enemies with a powerful axe strike.
- **Hunter Sense:** Temporarily increases physical damage at the cost of reduced physical defense.
- **Runic Axe:** Provides magical defense.
- **Axe Guard:** Provides physical defense.

### Jork — The Enchanted Swordsman
A swordsman who combines physical combat with magical abilities.

- **Ice Blast:** Deals magical damage.
- **Sword Strike:** Deals physical damage.
- **Vine Potion:** Provides magical defense.
- **Enchanted Oak Shield:** Provides physical defense.

## Combat System

The game uses dice rolls to determine attack damage. The dice type depends on the character's star rating.

| Star Rating | Dice Type |
|---|---|
| 1 star | 2d4 |
| 2 stars | 2d6 |
| 3 stars | 2d8 |
| 4 stars | 2d10 |
| 5 stars | 2d12 |

For example, a character with a 3-star damage rating rolls two eight-sided dice (`2d8`).

The combat system also includes defensive actions, status effects, and character-specific abilities.

## Technologies

- **Java**
- **Object-Oriented Programming (OOP)**
- **Java Collections Framework**
- **ANSI Escape Codes** for terminal colors
- **Scanner** for console input

## Project Structure

The project is organized into classes, each responsible for a specific part of the game.

```text
The-Ancient-Dragon/
├── Main.java
├── Battle.java
├── TextUI.java
├── Dice.java
├── GameCharacter.java
├── DefenseType.java
├── StatusEffect.java
├── Dragon.java
├── Merlin.java
├── Maximus.java
└── Jork.java
```

- **Main.java:** Entry point of the application; displays the title, introduces the story, and handles character selection.
- **Battle.java:** Manages combat turns, attacks, defensive actions, and battle flow.
- **TextUI.java:** Provides text animations, screen-clearing functionality, and user interface utilities.
- **Dice.java:** Implements dice rolls used to calculate damage.
- **GameCharacter.java:** Defines shared character attributes, health management, and status effect handling.
- **DefenseType.java:** Defines the available defense categories.
- **StatusEffect.java:** Represents status effects such as burn and bleed.
- **Dragon.java:** Defines the main enemy and its combat behavior.
- **Merlin.java, Maximus.java, Jork.java:** Implement the playable heroes and their abilities.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- A terminal or Java-compatible IDE, such as IntelliJ IDEA, Eclipse, or Visual Studio Code.

### Running the Game

1. Clone the repository:

   ```bash
   git clone YOUR_REPOSITORY_URL
   ```

2. Navigate to the project directory:

   ```bash
   cd The-Ancient-Dragon
   ```

3. Compile the Java files:

   ```bash
   javac *.java
   ```

4. Run the game:

   ```bash
   java Main
   ```

> **Note:** These commands assume that all Java files are in the same directory and do not declare a package. If your project uses packages, adjust the compilation and execution commands accordingly.

## How to Play

1. Launch the game.
2. Read the introduction.
3. Choose your hero from the character selection menu.
4. Follow the on-screen instructions during combat.
5. Select attacks or defensive abilities strategically.
6. Defeat the Ancient Dragon to protect the kingdom.

## Project Goals

This project was created to practice and demonstrate core Object-Oriented Programming concepts, including:

- Classes and objects
- Encapsulation
- Inheritance and polymorphism
- Methods and responsibilities
- Enums
- Collections
- Turn-based game logic

## Future Improvements

Potential improvements include:

- Additional playable characters and enemies.
- More status effects and combat abilities.
- A progression system with experience and levels.
- A graphical user interface.
- Save and load functionality.
- Sound effects and background music.

## Author

Developed as a Java Object-Oriented Programming project.

---

*Choose your hero. Face the beast. Become a legend.*