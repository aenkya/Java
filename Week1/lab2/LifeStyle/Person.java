
/**
* To demonstrate boolean.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Person
{
   double cmHeight ;
   double kgWeight;
   boolean smoker = false;
   int weeklyAlcholUnits = 15;
   final int RWAL = 21;   //RWAL - Recommended Weekly Alcohol Limit
   int restPulse = 150;
   
   
   public void checkPulse()
   {
      boolean healthyPulse;
      healthyPulse = ((restPulse > 30) && (restPulse < 180));
      System.out.print("Healthy pulse = ");
      System.out.println(healthyPulse);
   }
   
   public void checkForAbuse()
   {
      boolean abuser ;
      abuser = ((weeklyAlcholUnits > RWAL) || (smoker) );
      System.out.print("Checking for abuse -- ");
      System.out.println(abuser);
      
   }

   public void checkDesirability()
   {
      boolean desirable;
      desirable = ((cmHeight < 150) && (kgWeight > 100) && ((smoker) && (weeklyAlcholUnits > RWAL)));
      System.out.print("Checking for desirability -- ");
      System.out.println(desirable);
   }
   
   public void setHeight(double height)
   {
      cmHeight = height;
   }
   
   public void setWeight(double weight)
   {
      kgWeight = weight;
   }
   
   public void displayDetails()
   {
      System.out.print("Height = " + cmHeight + " cm\nWeight = " + kgWeight + " kg\nSmoker = " + smoker + "\nWeekly Alcohol Units = " + weeklyAlcholUnits + "\nRest Pulse = " + restPulse + "\n");
   }
   
}
