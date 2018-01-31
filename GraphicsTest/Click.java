/* Count the number of mouse clicks. */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class Click extends Application {
  private Label counter;
  private int n = 0;

  public void start(Stage stage) {
    counter = new Label("0");
    Group root = new Group(counter);
    Scene scene = new Scene(root);
    scene.setOnMousePressed(this::click);
    stage.setTitle("Click");
    stage.setScene(scene);
    stage.show();
  }

  private void click(MouseEvent event) {
    n++; //increase Click.n
    counter.setText("" + n); // seperately change the counter lable display text
  }
}
