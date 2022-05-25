import java.util.Scanner;

// Pseudocode
// component 1
// accepts user input for the number of sides for a shape
// checks if input is valid
// displays shape on main screen
// should be expanded to include more shapes
// currently accepts integer between 3 and 5 inclusive
// generates shape with the number of sides specified

public class Shapes {
    public static void main(String[] args) {
        int numSides = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the number of sides for the shape: ");
            Scanner input = new Scanner(System.in);
            numSides = input.nextInt();
            if (numSides >= 3 && numSides <= 5) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer between 3 and 5 inclusive.");
            }
        }
        Shape shape = new Shape(numSides);
        shape.draw();
    }

    public void Shape()
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(windowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}



// component 2
