
import java.util.*;

/**
 * AlienShip - Unit 4 exercise.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KlingonShip
{
	double photonPower = 45;
	int threatFactor = 7;
	double cosmicProximity = 20.6;
	
	//Put the displayKlingonDetails()and getDangerLeve() methods below.
	void displayKlingonDetails() {
		System.out.println("Photon Power: \t\t" + photonPower);
		System.out.println("Threat Factor: \t\t" + threatFactor);
		System.out.println("Cosmic Proximity: \t" + cosmicProximity);
		System.out.println("Danger Level: \t\t" + getDangerLevel());
	}
	
	double getDangerLevel() {
		double dangerLevel = (photonPower * threatFactor) / cosmicProximity;
		return dangerLevel;
	}

	/**
	 * Prompts the user for the KlingonShip settings.
	 * 
	 * @param input Scanner object for user input.
	 */
	void promptSettings(Scanner input) {
		System.out.println("Enter the photon power: ");
		photonPower = input.nextDouble();
		System.out.println("Enter the threat factor: ");
		threatFactor = input.nextInt();
		System.out.println("Enter the cosmic proximity: ");
		cosmicProximity = input.nextDouble();
	}
	
}
