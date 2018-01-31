import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.animation.AnimationTimer;

public class Animate extends Application{
    private Image earth = new Image("earth.jpg");
    private Image space = new Image("space.jpg");
    private Image sun = new Image("thesun.jpg");
    private Circle sunHitBox = new Circle(500 , 400 , sun.getHeight()/2 );
    private Circle earthHitBox = new Circle(0,0, earth.getHeight()/2 );
    private Font font = Font.font("Calibri", FontWeight.BOLD, 48);
    private Group root = new Group();
    private Scene scene = new Scene(root);
    private Canvas canvas = new Canvas(1000,800);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private int earthCount, sunCount;

    public static void main(String[] args){ launch(args); }

    @Override
    public void start(Stage stage){
        stage.setTitle("Animation!");
        scene.setOnMousePressed(this::click);
        stage.setScene(scene);
        root.getChildren().add(canvas);

        sunHitBox.setFill(new Color(0.0, 0.0, 0.0, 0));
        earthHitBox.setFill(new Color(0.0, 0.0, 0.0, 0));
        sunHitBox.setStroke(Color.RED);
        earthHitBox.setStroke(Color.GREEN);
        root.getChildren().add(sunHitBox);
        root.getChildren().add(earthHitBox);
        final long startTime = System.nanoTime();

        new AnimationTimer(){
            public void handle (long currentTime){
                gc.drawImage(space, 0, 0); // background first
                double t = (currentTime - startTime) / 1000000000.0; //0.016 seconds
                drawEarth(t);
                drawSun(t);
            }
        }.start();

        stage.show();

    }

    private void drawEarth(double t){
        double x = 500 - earth.getWidth()/2 +  sun.getWidth() * Math.cos(t*0.8); // non-standard orbit
        double y = 400 - earth.getHeight()/2 + sun.getWidth() * Math.sin(t);
        gc.drawImage(earth, x, y);
        earthHitBox.setCenterX(x + earth.getWidth()/2);
        earthHitBox.setCenterY(y + earth.getHeight()/2);
        earthCount = hitBoxFill(earthHitBox, earthCount);
    }

    private void drawSun(double t){
        gc.drawImage(sun, 500 - sun.getHeight()/2, 400 - sun.getWidth()/2 );
        sunCount = hitBoxFill(sunHitBox, sunCount);
    }

    int hitBoxFill(Shape c, int count){
        if(c.getFill() != null ){
            if(count == 1){
                c.setFill(null);
                return 0;
            }
            if(count > 1){ return count-1; }
            return 100;
        }
        return 0;
    }

    private void click(MouseEvent event) {
        System.out.print("click");
        if(sunHitBox.contains( event.getX(), event.getY())){
            sunHitBox.setFill(new Color(1.0, 1.0, 1.0, 0.5));
            earthHitBox.setFill(null);
            System.out.print(" Sun!\n");
        }
        else if(earthHitBox.contains( event.getX(), event.getY())){
            earthHitBox.setFill(new Color(1.0, 1.0, 1.0, 0.5));
            sunHitBox.setFill(null);
            System.out.print(" Earth!\n");
        }
        else{
            sunHitBox.setFill(new Color(0.0, 0.0, 0.0, 0));
            earthHitBox.setFill(new Color(0.0, 0.0, 0.0, 0));
            System.out.print("!\n"); }
    }
}
