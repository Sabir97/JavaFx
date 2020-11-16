import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Polygon hexagon = new Polygon();
        hexagon.getPoints().addAll(new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0
        });

        hexagon.setFill(Color.BLUE);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(hexagon);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        Button btn1 = new Button("Click Me");
        Button btn2 = new Button("Lambda Expression");
        btn2.setTranslateX(80);
        btn1.setStyle("-fx-background-color:GREY");
        btn2.setStyle("-fx-background-color:GREY");

        Text text = new Text("Text animation by Saber !");
        text.setTranslateX(80);
        text.setTranslateY(500);

        Timeline timeline = new Timeline();

        //btn2.setTranslateY();

        btn1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Hover!");
                btn1.setTextFill(Color.GREEN);
                btn1.setStyle("-fx-background-color:BLUE");
            }
        });

        btn1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Exited !");
                btn1.setTextFill(Color.BLACK);
            }
        });

        btn1.setOnMouseExited(event -> {
            btn1.setStyle("-fx-background-color:GREY");
        });

        btn2.setOnMouseEntered(event -> {
            System.out.println("Hover Lambda !");
            btn2.setTextFill(Color.BLUE);
            btn2.setStyle("-fx-background-color:BLACK");
        });

        btn2.setOnMouseExited(event -> {
            System.out.println("Exited Lambda ! ");
            btn2.setTextFill(Color.PURPLE);
            btn2.setStyle("-fx-background-color:GREY");
        });

        Group root = new Group(hexagon, btn1, btn2, text);
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Rotation Transition exemple");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}