package org.example.morpion.view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import org.example.morpion.model.Game;
import org.example.morpion.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View class for GUI version of the game
public class GUIView {

  // Attributes
  private Game game; // The game
  private JFrame frame; // The frame
  private JButton[][] buttons; // The buttons
  private JLabel topLabel; // The label for the top row

  // Constructor
  public GUIView(Game game) {
    this.game = game;
    frame = new JFrame("Morpion"); // Create the frame with title "Morpion"
    frame.setLayout(new BorderLayout()); // Set the layout of the frame to BorderLayout
    frame.setSize(400, 440); // Set the size of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the frame when clicking on the cross
    frame.setLocationRelativeTo(null); // Center the frame on the screen
    frame.setResizable(false);

    topLabel = new JLabel("Morpion", SwingConstants.CENTER); // Create the label with text "Morpion
    frame.add(topLabel, BorderLayout.NORTH); // Add the label to the top of the frame

    JPanel panel = new JPanel(new GridLayout(3, 3)); // Create a panel with a 3x3 grid layout
    buttons = new JButton[3][3]; // Create the buttons
    initializeButtons(panel); // Initialize the buttons and add them to the panel
    frame.add(panel, BorderLayout.CENTER); // Add the panel to the center of the frame

    frame.setVisible(true); // Make the frame visible
  }

  // Methods

  /**
   * Initialize the buttons of the frame
   */
  private void initializeButtons(JPanel panel) {
    // Create the buttons and add them to the panel with an action listener for each button
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
        panel.add(buttons[i][j]);
        final int row = i;
        final int col = j;
        buttons[i][j].addActionListener(new ActionListener() {
          // When clicking on a button, if the game is not over and the move is valid, update the button and make the move
          @Override
          public void actionPerformed(ActionEvent e) {
            if (!game.isGameOver() && game.isValidMove(row, col)) {
              updateButton(row, col);
              game.makeMove(row, col);
              Player winner = game.getWinner();
              if (winner != null) {
                JOptionPane.showMessageDialog(frame, "Le joueur " + winner + " a gagné !");
              } else if (game.isGameOver()) {
                JOptionPane.showMessageDialog(frame, "Match nul !");
              }
            }
          }
        });
      }
    }
  }

  /**
   * Update the button at the given position
   *
   * @param row, the row
   * @param col, the column
   */
  private void updateButton(int row, int col) {
    Player player = game.getCurrentPlayer();
    buttons[row][col].setText(player.toString());
    buttons[row][col].setEnabled(false);
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    GUIView view = new GUIView(game);
  }

}
