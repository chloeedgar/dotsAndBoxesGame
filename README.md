# Dots and Boxes Game

This repository contains the implementation of the **Dots and Boxes** game, designed with clean coding principles, extensibility, and modular architecture in mind. The project demonstrates a well-organized approach to building a turn-based game with scoring, move validation, and game-end detection.

---

## Overview

The **Dots and Boxes** game is a two-player grid-based game. Players alternate turns to draw lines, aiming to complete boxes for points. This implementation uses a console interface, with plans for future GUI integration.

---

## Assumptions
- **Two-Player Game:** The game is strictly for two players.
- **Variable Grid Size:** The grid size is configurable, with a default of 4x4 dots.
- **Turn Order:** Player 1 always starts the game.
- **Validated Moves:** Moves are checked for validity before being applied.
- **Scoring Rules:** Players earn points by completing boxes, which are marked with their player number.
- **Game-End Detection:** The game ends when all boxes are completed.
- **Board Representation:** A 2D array is used for efficient board state management.

---

## File Structure

The project uses a **Model-View-Controller (MVC)** design pattern to separate concerns and maintain extensibility:

```plaintext
src/
 ├── controller/
 │   ├── GameController.java    // Manages game flow and interactions between model and view
 │
 ├── model/
 │   ├── GameSession.java         // Handles board state, player turns, and scores
 ├── utils/
 │   ├── BoardInitializer.java  // Creates and initializes the board
 │   ├── MoveValidator.java     // Ensures moves are valid
 ├── view/
 │   ├── GameView.java          // Abstract interface for rendering
 │   ├── ConsoleView.java       // Console-specific implementation of GameView
 │
 └── DotsAndBoxes.java          // Entry point for the game
```
---

## Development Process

### Iterative Development
The implementation followed an **Agile-inspired iterative approach**:

1. **Sprint 1: Foundation and Basic Flow**
   - Created board initialization logic.
   - Developed a basic game loop to accept and display player moves.

2. **Sprint 2: Move Validations and Display**
   - Added logic to validate player moves.
   - Updated the board display to reflect valid moves dynamically.

3. **Sprint 3: Scoring and Game-End Detection**
   - Implemented logic to detect completed boxes and update scores.
   - Added a mechanism to check if all boxes are completed, ending the game.

---

## Key Features

### Board Design
The game board for a 4x4 grid is initialized as follows:

```plaintext
  A B C D E F G
0 *   *   *   *
1               
2 *   *   *   *
3               
4 *   *   *   *
5               
6 *   *   *   *
```


#### Board Initialization Rules:
- **Top Row:** Alternates between spaces (`' '`) and letters (`A-G`) for column labels.
- **Left Column:** Alternates between spaces (`' '`) and numbers (`0-6`) for row labels.
- **Inner Grid:** 
  - Dots (`*`) are placed at intersections in even rows and columns.
  - Empty spaces (`' '`) fill the gaps.

---

## Key Components

### Move Validation
- The `MoveValidator` class checks:
  - If the move is within bounds.
  - If the position is valid for a line (horizontal or vertical).
  - If the move does not overwrite an existing line.

### Scoring and Box Completion
- Scores are updated when a box is completed.
- The board marks completed boxes with the player's number (`1` or `2`).
- A helper method simplifies checking if a box is completed.

### Game End Detection
- A method checks if all boxes are filled using Java Streams for efficiency.

---

## Challenges and Solutions

### 1. **Move Validation**
- **Problem:** Ensuring that moves are valid without duplicating logic across methods.
- **Solution:** Centralized validation in the `MoveValidator` class.

### 2. **Scoring and Box Detection**
- **Problem:** Detecting completed boxes in all directions (above, below, left, right).
- **Solution:** Used a helper method to modularize box-completion checks, improving clarity and reusability.

### 3. **Game-End Detection**
- **Problem:** Efficiently checking if all boxes are filled.
- **Solution:** Used `Java Streams` to simplify the logic for detecting incomplete boxes.

---

## Running the Game

### Prerequisites
- **Java 8+** installed.

### Instructions
1. Clone the repository:
 git clone https://github.com/your-repo/dots-and-boxes.git

2. Compile the project:
javac src/**/*.java

3. Run the main class:
java src/Main

4. Follow the on-screen prompts to play.

---

## Lessons Learned
- **Design Patterns:** Adopting MVC architecture ensured scalability and maintainability.
- **Code Modularity:** Breaking functionality into small, reusable methods improved readability and reduced bugs.
- **Documentation:** Documenting assumptions and design decisions early streamlined development and review processes.

---

This project demonstrates a clean and extensible implementation of the **Dots and Boxes** game, ready for further enhancements. Contributions and suggestions are welcome!


