import javafx.scene.Node;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TestShapes {
    public static Shapes testingInstance;
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                Application.launch(Shapes.class, args);
            }
        }.start();
        testingInstance = Shapes.waitForStartUpTest();
        testComponents();
    }

    static void testComponents(){
        System.out.println("Testing components...\n");
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                testInitialSize();
                testDescription();
                testDrawShape();
                testFillColor();
            }
        });
    }

    static void testInitialSize() {
        System.out.println("Should load all the right components at start\n");
        ObservableList<Node> nodes = testingInstance.container.getChildren();
        if(nodes.size() == 7) {
            System.out.println("Test 1: Passed");
        } else {
            System.out.println("Test 1: Failed");
        }
    }

    static void testDescription() {
        System.out.println("Should show the initial description\n");
        if(testingInstance.description.getText().equals("Please input a value between 3 and 5 inclusive")) {
            System.out.println("Test 2: Passed");
        } else {
            System.out.println("Test 2: Failed");
        }
        System.out.println();
    }

    static void testDrawShape() {
        System.out.println("Should draw different shapes based on input...\n");
        boolean passed = false;
        String description;
        ObservableList<Node> nodes = testingInstance.container.getChildren();
        HBox hbox = (HBox) nodes.get(2);
        TextField num = (TextField) hbox.getChildren().get(0);
        Button button = (Button) hbox.getChildren().get(1);

        // Check for 3 sided polygon
        num.setText("3");
        button.fire();
        if(testingInstance.drawingSpace.getChildren().size() != 1) {
            passed = false;
        }
        ObservableList<Node> drawing = testingInstance.drawingSpace.getChildren();
        if(drawing.get(0) instanceof Polygon) {
            Polygon poly = (Polygon) drawing.get(0);
            if(poly.getPoints().size() == 6) {
                passed = true;
            }
        }

        // should respond to keystroke events
        testingInstance.drawingSpace.getChildren().clear();
        num.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.ENTER, false, false, false, false));
        if(testingInstance.drawingSpace.getChildren().size() != 1) {
            passed = false;
        }

        // Check for 5 sided polygon
        testingInstance.drawingSpace.getChildren().clear();
        num.setText("5");
        button.fire();
        if(drawing.get(0) instanceof Polygon) {
            Polygon poly = (Polygon) drawing.get(0);
            if(poly.getPoints().size() == 10) {
                passed = true;
            }
        }

        // Check for invalid input
        testingInstance.drawingSpace.getChildren().clear();
        num.setText("2");
        button.fire();
        description = testingInstance.description.getText();
        if(
            testingInstance.drawingSpace.getChildren().size() >= 1 &&
            !description.equals("Invalid number of sides: 2. Put number from 3 to 5")
        ) {
            passed = false;
        }
        num.setText("6");
        button.fire();
        description = testingInstance.description.getText();
        if(
            testingInstance.drawingSpace.getChildren().size() >= 1 &&
            !description.equals("Invalid number of sides: 6. Put number from 3 to 5")
        ) {
            passed = false;
        }

        num.setText("3 4");
        button.fire();
        description = testingInstance.description.getText();
        if(
            testingInstance.drawingSpace.getChildren().size() >= 1 &&
            !description.equals("Please enter one number")) {
            passed = false;
        }

        if(passed) {
            System.out.println("Test 3: Passed");
        } else {
            System.out.println("Test 3: Failed");
        }

        num.setText("3");
        button.fire();
    }

    static void testFillColor(){
        System.out.println("Should fill colors based on provided input\n");;
        boolean passed = true;
        String description;
        ObservableList<Node> nodes = testingInstance.container.getChildren();
        HBox hbox = (HBox) nodes.get(2);
        TextField num = (TextField) hbox.getChildren().get(0);
        Button draw = (Button) hbox.getChildren().get(1);
        num.setText("3");
        draw.fire();

        TextField colorfield = (TextField) nodes.get(5);
        Button button = (Button) nodes.get(6);
        
        // Check for red color
        colorfield.setText("red");
        button.fire();
        description = testingInstance.description.getText();
        Polygon existingShape = (Polygon) testingInstance.container.lookup("#shape");
        if(
            !existingShape.getFill().equals(Color.RED) ||
            !description.equals("Color changed to red")
        ) {
            passed = false;
        }

        // Check for green color
        colorfield.setText("green");
        button.fire();
        description = testingInstance.description.getText();
        if(
            !existingShape.getFill().equals(Color.GREEN) ||
            !description.equals("Color changed to green")
        ) {
            passed = false;
        }

        // Check for grey color
        colorfield.setText("grey");
        button.fire();
        description = testingInstance.description.getText();
        if(
            !existingShape.getFill().equals(Color.GRAY) ||
            !description.equals("Color changed to grey")
        ) {
            passed = false;
        }

        // Check for invalid color
        colorfield.setText("blue");
        button.fire();
        description = testingInstance.description.getText();
        if(
            !description.equals("Invalid color blue. Currently supported colors are RED, GREEN & GREY")
        ) {
            passed = false;
        }

        if(passed) {
            System.out.println("Test 4: Passed");
        } else {
            System.out.println("Test 4: Failed");
        }
    }

}