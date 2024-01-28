package org.example.morpion.model;

public class Game {

  // Attributes
  private Board board; // The board of the game
  private Player currentPlayer; // The current player

  // Constructor
  public Game() {
    this.board = new Board();
    this.currentPlayer = Player.X; // Player X starts the game
  }

  // Methods

  /**
   * Check if the game is over (board is full or there is a winner)
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    return this.board.isFull() || this.board.getWinner() != null;
  }

  /**
   * Check if the move is valid
   *
   * @param row, the x coordinate
   * @param col, the y coordinate
   * @return true if the move is valid, false otherwise
   */
  public boolean isValidMove(int row, int col) {
    return this.board.isValidMove(row, col);
  }

  /**
   * Make a move on the board if it is valid
   *
   * @param row, the x coordinate
   * @param col, the y coordinate
   */
  public void makeMove(int row, int col) {
    if (this.board.makeMove(row, col, this.currentPlayer)) {
      this.currentPlayer = this.currentPlayer == Player.X ? Player.O : Player.X; // Change the current player
    }
  }

  // Getters
  public Player getCurrentPlayer() {
    return this.currentPlayer;
  }

  public Player getWinner() {
    return board.getWinner();
  }

  public Board getBoard() {
    return board;
  }
}
