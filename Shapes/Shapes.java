import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.util.concurrent.CountDownLatch;


public class Shapes extends Application {

    protected Group drawingSpace = new Group();
    protected Label description = new Label ("Please input a value between 3 and 5 inclusive");
    
    // container is made a class variable so that it can be accessed by the testComponents method
    public VBox container;

    // the class instance is also exported so that It can be accessed for testing
    public static Shapes testingInstance;

    // the countdown latch is initialised with 2 so that we can invoke it on
    // class instantiation and after the start method is done executing.
    public static final CountDownLatch latch = new CountDownLatch(2);

    public Shapes() {
        super();
        setTestingInstance(this);
    }

    public static Shapes waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return testingInstance;
    }

    // we use this method to expose the instance of the class so that it can be
    // accessed by the testComponents method. Latch is also decremented.
    public static void setTestingInstance(Shapes initInstance) {
        testingInstance = initInstance;
        latch.countDown();
    }

    @Override
    public void start(Stage stage) {

        Text title = new Text("Welcome to the Shapes program");
        title.setFont(Font.font("Helvetica", FontWeight.MEDIUM, FontPosture.REGULAR, 20));
        VBox.setMargin(title, new Insets(20, 10, 5, 10));

        Text subtitle = new Text("This program will draw a shape based on the number you enter below");
        VBox.setMargin(subtitle, new Insets(5, 10, 5, 10));

        // Create a TextField to enter the number of sides for the shape
        TextField numOfSides = new TextField();
        numOfSides.setMaxWidth(50);

        // Listen for enter event to draw shape
        numOfSides.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    drawShape(numOfSides.getText());
                }
            }
        });

        // Alternatively, use a button to draw the shape
        Button drawButton = new Button("Draw");
        drawButton.setOnAction(e -> drawShape(numOfSides.getText()));

        // Align input controls in a horizontal box
        HBox controls = new HBox();
        controls.setAlignment(Pos.CENTER);
        controls.setSpacing(10);
        controls.getChildren().addAll(numOfSides, drawButton);
        HBox.setMargin(numOfSides, new Insets(0, 50, 0, 50));
        HBox.setMargin(drawButton, new Insets(0, 50, 0, 50));
        
        description.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.ITALIC, 12));
        description.setId("description");
        VBox.setMargin(description, new Insets(10, 10, 10, 10));


        VBox root = new VBox(10);
        container = new VBox(10);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(title, subtitle, controls, description, drawingSpace);
        VBox.setMargin(title, new Insets(10, 10, 10, 10));
        root.getChildren().addAll(container);
        root.setAlignment(Pos.TOP_CENTER);
        
        // initialise the second component with the layout in which to inject components
        ColorChanger colorChanger = new ColorChanger(container);
        colorChanger.addColorChangeUI();

        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();

        // countdown second latch to unblock thread execution
        latch.countDown();
    }
    
    private void drawShape(String numOfSides) {
        // check that there is an input and it is a digit
        if(numOfSides.length() < 1 || !numOfSides.matches("[0-9]+")) {
            description.setTextFill(Color.RED);
            description.setText("Please enter one number");
            return;
        }

        Polygon shape = new Polygon();

        int sides = Integer.parseInt(numOfSides);
        switch(sides){
            case 3:
                shape.getPoints().addAll(new Double[]{
                    0.0, 0.0,
                    50.0, 50.0,
                    100.0, 0.0,
                });
                break;
            case 4:
                shape.getPoints().addAll(new Double[]{
                    0.0, 0.0,
                    100.0, 0.0,
                    100.0, 100.0,
                    0.0, 100.0,
                });
                break;
            case 5:
                shape.getPoints().addAll(new Double[]{
                    0.0, 0.0,
                    100.0, 100.0,
                    200.0, 0.0,
                    150.0, -100.0,
                    50.0, -100.0
                });
                break;
            default:
                description.setTextFill(Color.RED);
                description.setText("Invalid number of sides: " + numOfSides + ". Put number from 3 to 5");
                return;
        }
        description.setTextFill(Color.BLACK);
        description.setText("Displaying shape of " + numOfSides + " sides");

        shape.setStroke(Color.BLACK);
        shape.setFill(Color.TRANSPARENT);
        shape.setId("shape");

        drawingSpace.getChildren().clear();
        drawingSpace.getChildren().add(shape);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// this class is used to inject the color changer component into the container
class ColorChanger{
    VBox root;
    ColorChanger(VBox root){
        this.root = root;
    }
    
    public void addColorChangeUI(){
        // Add textfield to pick color and change on ENTER keypress
        TextField colorValue = new TextField();
        colorValue.setPromptText("Enter color name");
        VBox.setMargin(colorValue, new Insets(0, 10, 0, 10));
        colorValue.setMaxWidth(200);
        colorValue.addEventFilter(KeyEvent.ANY, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    changeColor(colorValue);
                }
            }
        });

        // Add a button to change the color
        Button changeColor = new Button("Change Color");
        changeColor.setOnAction(e -> changeColor(colorValue));

        root.getChildren().addAll(colorValue, changeColor);
    }

    private void changeColor(TextField colorValue) {
        Label desc = (Label) root.lookup("#description");
        Polygon existingShape = (Polygon) root.lookup("#shape");
        if (existingShape == null) {
            desc.setTextFill(Color.RED);
            desc.setText("No existing shape to change color");
            return;
        }
        desc.setTextFill(Color.BLACK);
        String colorVal = colorValue.getText();
        switch (colorVal.toLowerCase()){
            case "red":
                existingShape.setFill(Color.RED);
                desc.setText("Color changed to " + colorVal);
                break;
            case "green":
                existingShape.setFill(Color.GREEN);
                desc.setText("Color changed to " + colorVal);
                break;
            case "grey":
                existingShape.setFill(Color.GREY);
                desc.setText("Color changed to " + colorVal);
                break;
            case "gray":
                existingShape.setFill(Color.GREY);
                desc.setText("Color changed to " + colorVal);
                break;
            default:
                desc.setTextFill(Color.RED);
                desc.setText("Invalid color " + colorVal + ". Currently supported colors are RED, GREEN & GREY");
        }
    }
}