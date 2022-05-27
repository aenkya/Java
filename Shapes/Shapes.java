import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;


public class Shapes extends Application {
    @Override
    public void start(Stage stage) {

        Text title = new Text("Welcome to the Shapes program");
        title.setFont(Font.font("Helvetica", FontWeight.MEDIUM, FontPosture.REGULAR, 20));

        Text text1 = new Text("This program will draw a shape based on the number you enter below");
        
        TextField numOfSides = new TextField();
        numOfSides.setMaxWidth(50);

        Button drawButton = new Button("Draw");
        drawButton.setOnAction(e -> drawShape(numOfSides.getText()));

        HBox controls = new HBox();
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(numOfSides, drawButton);

        Label description = new Label ("Currently no shape...");

        Group drawing = new Group();
        drawing.minHeight(40);
        drawing.minWidth(40);
        drawing.maxHeight(100);
        drawing.maxWidth(100);
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(title, text1, controls, description, drawing);
        
        ColorChanger colorChanger = new ColorChanger(stage);
        colorChanger.addColorChangeUI(root);

        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }
    
    public void drawShape(String numOfSides) {
        // int sides = Integer.parseInt(numOfSides);
        Polygon shape = new Polygon();
        shape.getPoints().addAll(new Double[]{
            0.0, 0.0,
            50.0, 50.0,
            100.0, 0.0
        });
        shape.setFill(Color.RED);
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(2);
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class ColorChanger{
    ColorChanger(Stage stage){
        stage.setOnCloseRequest(e -> {
            System.exit(0);
        });
    }
    
    public void addColorChangeUI(VBox root){
        Button changeColor = new Button("Change Color");
        changeColor.setOnAction(e -> {
            root.setStyle("-fx-background-color: " + getRandomColor());
        });
        root.getChildren().add(changeColor);
    }

    private String getRandomColor(){
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        return String.format("#%02X%02X%02X", r, g, b);
    }
}