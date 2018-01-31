/* Demonstrate button press events. */

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;

public class Press extends Application {
  public void start(Stage stage) {
    Button b = new Button("Press me");
    b.setOnAction(this::press);
    Group root = new Group(b);
    stage.setTitle("Press");
    stage.setScene(new Scene(root));
    stage.show();
  }

  private void press(ActionEvent e) {
    System.out.println("Button pressed");
  }
}
