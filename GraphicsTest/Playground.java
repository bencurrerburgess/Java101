/* Use an image as a background for a drawing. */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.image.*;

public class Playground extends Application {
  public void start(Stage stage) {
    Image bg = new Image("background.png");
    Canvas canvas = new Canvas(400, 300);
    Group root = new Group(canvas);
    stage.setScene(new Scene(root));
    GraphicsContext g = canvas.getGraphicsContext2D();
    draw(g, bg);
    stage.show();
  }

  private void draw(GraphicsContext g, Image bg) {
    g.drawImage(bg, 0, 0);
    g.fillRect(50, 100, 300, 25);
    g.fillOval(175, 125, 50, 50);
  }
  
  public static void main(String[] args){
      Playground program = new Playground();
      program.launch();
  }
}
