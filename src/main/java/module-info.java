module org.example.morpion {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;


  opens org.example.morpion to javafx.fxml;
  exports org.example.morpion;
  exports org.example.morpion.view;
  opens org.example.morpion.view to javafx.fxml;
  exports org.example.morpion.model;
  opens org.example.morpion.model to javafx.fxml;
  exports org.example.morpion.controller;
  opens org.example.morpion.controller to javafx.fxml;
}