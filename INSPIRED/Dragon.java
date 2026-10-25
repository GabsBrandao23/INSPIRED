
 // The Dragon is a type of GameCharacter,
 // so it inherits the attributes and methods of that class.
public class Dragon extends GameCharacter {

    // Initializes the dragon's attributes.
    public Dragon() {

        super(
            "Ancient Dragon", // Name
            150,              // Health
            3,                // Physical damage stars
            4,                // Magic damage stars
            4,                // Physical defense stars
            2                 // Magic defense stars
        );
    }
}
