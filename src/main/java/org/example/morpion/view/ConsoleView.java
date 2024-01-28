package org.example.morpion.view;

import org.example.morpion.model.Board;
import org.example.morpion.model.Game;
import org.example.morpion.model.Player;

import java.util.Scanner;

// View class for console version of the game
public class ConsoleView {

  // Attributes
  private Game game;
  private Scanner scanner;

  // Constructor
  public ConsoleView(Game game) {
    this.game = game;
    scanner = new Scanner(System.in);
  }

  /**
   * Display welcome message
   */
  public void displayWelcomeMessage() {
    System.out.println("Bienvenue dans le jeu du morpion !");
  }

  /**
   * Display the board
   *
   * @param board, board of the game
   */
  public void displayBoard(Board board) {
    Player[][] grid = board.getBoard();
    System.out.println("-------------");
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        String symbol = "-";
        if (grid[row][col] != null) {
          symbol = grid[row][col] == Player.X ? "X" : "O";
        }
        System.out.print("| " + symbol + " ");
      }
      System.out.println("|");
      System.out.println("-------------");
    }
  }

  /**
   *
   * @return
   */
  public int[] promptPlayerMove() {
    int[] move = new int[2];
    System.out.print("Joueur " + game.getCurrentPlayer() + ", veuillez entrer votre coup (ligne colonne) : ");
    move[0] = scanner.nextInt();
    move[1] = scanner.nextInt();
    return move;
  }

  /**
   * Display invalid move message
   */
  public void displayInvalidMoveMessage() {
    System.out.println("Coup invalide. Veuillez entrer un coup valide.");
  }

  /**
   * Display result
   * @param winner
   */
  public void displayResult(Player winner) {
    if (winner == null) {
      System.out.println("Match nul !");
    } else {
      System.out.println("Le joueur " + winner + " a gagné !");
    }
  }
}
