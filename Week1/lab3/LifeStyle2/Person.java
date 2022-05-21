
/**
 * To demonstrate boolean.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
	double cmHeight;
	double kgWeight;
	boolean smoker = true;
	int weeklyAlcoholUnits = 50; // 1 pint = 2 units, 1 short = 1 unit)
	final int RWAL = 21;   //RWAL - Recommended Weekly Alcohol Limit
	int restPulse;

	public boolean checkPulse()
	{
	   boolean healthyPulse;
	   healthyPulse = ((restPulse > 30) && (restPulse < 180));
	   return healthyPulse;
	}
	
	public boolean checkAbuser()
	{
	      boolean abuser ;
	      abuser = ((weeklyAlcoholUnits > RWAL) || (smoker) );
	      return abuser;
	}
	
	public void displayProfile()
	{
	   System.out.println("���Health Profile��");
	   
	   System.out.println("Healthy pulse check = " + checkPulse());
	   System.out.print("Abusing Body = " + checkAbuser());
	   
	}
	//Put curseAndSwear method here
	public void curseAndSwear()
	{
		int random = (int)((Math.random()*(5-1)))+1;
		switch(random){
			case 1:
				System.out.println("FOH!");
				break;
			case 2:
				System.out.println("Oh dam!! What a nuisance!");
				break;
			case 3:
				System.out.println("No freakin way!");
				break;
			case 4:
				System.out.println("And I'm the joke!");
				break;
			case 5:
				System.out.println("Sucks to be you");
				break;
			default:
				System.out.println("You are a bad person");
				break;
		}
	}
	
	
}
