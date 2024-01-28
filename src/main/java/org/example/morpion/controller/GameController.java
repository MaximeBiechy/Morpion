package org.example.morpion.controller;

import org.example.morpion.model.Game;
import org.example.morpion.model.Player;
import org.example.morpion.view.ConsoleView;

// Controller for the game
public class GameController {

  // Attributes
  private Game game; // The game
  private ConsoleView view; // The view

  // Constructor
  public GameController(Game game, ConsoleView view) {
    this.game = game;
    this.view = view;
  }

  // Methods
  /**
   * Start the game
   */
  public void startGame() {
    view.displayWelcomeMessage(); // Display welcome message
    view.displayBoard(game.getBoard()); // Display the board

    // While the game is not over (board is not full or there is no winner)
    while (!game.isGameOver()) {
      int[] move = view.promptPlayerMove();
      int row = move[0];
      int col = move[1];

      if (!game.isValidMove(row, col)) {
        view.displayInvalidMoveMessage(); // Display invalid move message if the move is not valid
        continue;
      }

      game.makeMove(row, col);
      view.displayBoard(game.getBoard());

      Player winner = game.getWinner();
      if (winner != null) {
        view.displayResult(winner); // Display the result if there is a winner
      }
    }
  }
}
