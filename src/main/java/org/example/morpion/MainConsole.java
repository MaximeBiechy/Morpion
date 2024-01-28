package org.example.morpion;

import org.example.morpion.controller.GameController;
import org.example.morpion.model.Game;
import org.example.morpion.view.ConsoleView;

// Main class for console version of the game
public class MainConsole {

  public static void main(String[] args) {
    Game game = new Game();
    ConsoleView view = new ConsoleView(game);
    GameController controller = new GameController(game, view);

    controller.startGame();
  }
}
