import java.util.*;

public class TestKlingonShip {

	public static void main(String[] args) {
		
		// Create LingonShip object, then test the methods
		KlingonShip klingonShip = new KlingonShip();
		Scanner input = new Scanner(System.in);
		klingonShip.promptSettings(input);
		klingonShip.displayKlingonDetails();
		input.close();
	}

}
