
/**
 * Write a description of class Exciting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exciting
{
    //Put your declarations for a) beneath here 
     double z ;
     int count = 0;
     double cost = 3.45;
     char choice =  'X';
     boolean goodChoice = true;
     short lowest = 5;


    //Put your declarations and initialisations to b) beneath here 
    float temperature = 0;
    short jackpotBonusNumber = 0;
    int chinaPopulation = 0;
    boolean isGameFinished = false;
    double interplanetaryDistance = 0;
    char grade = 'A';
    
    
   public void doit()
   {
     double x = 3.0;
     double y = 4.0;
     z = 2.0 * y + x/4.0 - (x + y ) ;
   }    
   
   public void displayDetails() 
   {
	   System.out.print("z= ");
	   System.out.println (z);
	   
	   //display the details for the variables you declared in a)
	   System.out.println("count = " + count + "\n"+"cost = " + cost + "\n"+"choice = " + choice + "\n"+"goodChoice = " + goodChoice + "\n"+"lowest = " + lowest + "\n");
	   
	   //display the details for the variables you declared in b)
     System.out.println("temperature = " + temperature + "\n"+"jackpotBonusNumber = " + jackpotBonusNumber + "\n"+"chinaPopulation = " + chinaPopulation + "\n"+"isGameFinished = " + isGameFinished + "\n"+"interplanetaryDistance = " + interplanetaryDistance + "\n"+"grade = " + grade + "\n");
	  
	   
   }
    
}

	   
    
 