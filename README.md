Yahtzee Game: Star Wars Edition

### Table of Contents

    Overview
    Game Rules
    Software Architecture
    How to Play
    High Score Management
    Installation
    Usage
    Contributing
    License

### Overview

The Yahtzee Game: Star Wars Edition is a multi-player dice game designed for 1 to 6 players. The game features custom categories and rules inspired by the Star Wars universe, allowing players to enjoy a unique gaming experience. Players can choose from a variety of categories and enjoy the game with standard dice (up to 6 sides) or extended dice (up to 8 sides).

### Game Rules

    Player Setup: Up to 6 players can participate. Each player must input their name before starting the game.
    Dice: The game can be played with dice that have either 6 or 8 sides. Ensure that the number of sides is set in exactly one location in the code.
    Categories: Players can choose from the following categories:
        Standard Categories: 2, 3, 4, 5, 6, 7, 8, 9, Aces, and Yahtzee.
        Custom Categories:
            Star Wars Day: Points are awarded only for combinations of fours and fives.
            R2D2: The combination of 1, 8, 2, 4, 2 scores 42 points (where R = 18th letter, D = 4th letter).
    Bonus Points: A bonus is awarded only if a player scores 108 points or more during the game.

#### Software Architecture

The game is designed using a Layered Architecture consisting of:

    TUI/GUI: The user interface for interacting with the game.
    Facade: The facade layer that simplifies interaction between the UI and the underlying domain logic.
    Domain: The core business logic of the game, including rules, scoring, and player management.

The main method resides only in the UI layer, which instantiates the facade object and calls methods from the facade class. This architecture ensures a clean separation of concerns, allowing for easier maintenance and potential future enhancements.

#### How to Play

    Starting the Game: Launch the application. Players will be prompted to enter their names.
    Choosing Categories: During each turn, players will select a category from the available options.
    Rolling Dice: Players roll the dice and score points according to the selected category.
    End of Game: Once all players have completed their turns, the game will conclude and the final scores will be displayed.

#### High Score Management

At the end of each game:

    The scores, along with player names and the date, are saved to a text-based high score list.
    Upon starting the program, the high score list is loaded automatically.
    Players can access the high score list from the main menu and can choose to delete it after a confirmation prompt.


#### Installation

To install and run the Yahtzee Game, follow these steps: (bash)

    Clone the repository:  git clone https://github.com/Shoona-shama/Yahtzee.git

    Navigate to the project directory:  cd Yahtzee

    Run the application:  java -cp bin Main

#### Usage

Once the game is running, follow the on-screen instructions to enter player names and select categories. Enjoy the game with friends or family!

#### Contributing

Contributions are welcome! If you would like to contribute to this project, please fork the repository and submit a pull request with your changes.

#### License

This project is licensed under the MIT License - see the LICENSE file for details.


    
