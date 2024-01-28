package org.example.morpion.model;

public class Board {

  // Attributes
  private static final int SIZE = 3; // Size of the board
  private Player[][] board; // The board of the game

  // Constructor
  public Board() {
    this.board = new Player[SIZE][SIZE];
    this.initBoard();
  }

  // Methods

  /**
   * Initialize the board with null values
   */
  private void initBoard() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++)
        this.board[row][col] = null; // null is the default value for a Player
    }
  }

  /**
   * Check if the move is valid
   *
   * @param row, the x coordinate
   * @param col, the y coordinate
   * @return true if the move is valid, false otherwise
   */
  public boolean isValidMove(int row, int col) {
    return this.board[row][col] == null;
  }

  /**
   * Make a move on the board if it is valid
   *
   * @param row,    the x coordinate
   * @param col,    the y coordinate
   * @param player, the player who makes the move
   */
  public boolean makeMove(int row, int col, Player player) {
    if (this.isValidMove(row, col)) {
      this.board[row][col] = player;
      return true;
    }
    return false;
  }

  /**
   * Check if there is a winner on the board and return it
   *
   * @return the winner if there is one, null otherwise
   */
  public Player getWinner() {
    // Check rows
    for (int row = 0; row < SIZE; row++) {
      if (this.board[row][0] != null && this.board[row][0] == this.board[row][1] && this.board[row][0] == this.board[row][2])
        return this.board[row][0];
    }

    // Check columns
    for (int col = 0; col < SIZE; col++) {
      if (this.board[0][col] != null && this.board[0][col] == this.board[1][col] && this.board[0][col] == this.board[2][col])
        return this.board[0][col];
    }

    // Check diagonals
    if (this.board[0][0] != null && this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2])
      return this.board[0][0];
    if (this.board[0][2] != null && this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0])
      return this.board[0][2];

    return null;
  }

  /**
   * Check if the board is full
   *
   * @return true if the board is full, false otherwise
   */
  public boolean isFull() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++)
        if (this.board[row][col] == null) // if there is at least one null value, the board is not full
          return false;
    }
    return true;
  }

  // Getters
  public Player[][] getBoard() {
    return this.board;
  }


}
