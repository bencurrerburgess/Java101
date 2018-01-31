/* Enable two human players to play noughts and crosses.  The program
demonstrates the graphics, not the game logic. */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.canvas.*;

public class Cross extends Application {
  private Grid grid;
  private GraphicsContext g;

  public void start(Stage stage) {
    grid = new Grid();
    Canvas canvas = new Canvas(300, 300);
    Group root = new Group(canvas);
    Scene scene = new Scene(root);
    scene.setOnMousePressed(this::move);
    stage.setTitle("Cross");
    stage.setScene(scene);
    g = canvas.getGraphicsContext2D();
    draw();
    stage.show();
  }

  // The current player makes a move in one of the cells.
  private void move(MouseEvent e) {
    int x = (int) e.getSceneX() / 100;
    int y = (int) e.getSceneY() / 100;
    grid.move(x, y);
    draw();
  }

  // Redraw the current state of the grid, from scratch.
  private void draw() {
    g.clearRect(0, 0, 300, 300);
    g.setLineWidth(1);
    drawLines();
    g.setLineWidth(3);
    for (int x=0; x<3; x++) {
      for (int y=0; y<3; y++) {
        char c = grid.get(x,y);
        if (c == 'O') drawO(100*x, 100*y);
        else if (c == 'X') drawX(100*x, 100*y);
      }
    }
  }

  // Draw the four grid lines.
  private void drawLines() {
    g.strokeLine(100.5, 10, 100.5, 290);
    g.strokeLine(200.5, 10, 200.5, 290);
    g.strokeLine(10, 100.5, 290, 100.5);
    g.strokeLine(10, 200.5, 290, 200.5);
  }

  // Draw an O
  private void drawO(double x, double y) {
    g.strokeOval(12+x, 12+y, 75, 75);
  }

  // Draw an X
  private void drawX(double x, double y) {
    g.strokeLine(12+x, 12+y, 88+x, 88+y);
    g.strokeLine(12+x, 88+y, 88+x, 12+y);
  }
}
