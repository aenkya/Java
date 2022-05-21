/*
 * @author Tommy Yuan
 * The purpose is to practise the use of if statement.
 * 
 * */


import java.util.*;

public class HiLo {
    
     int random;
     int guess;
    
    public void generateNumber() 
    {
       //The following lines generate and output a random number between 1 and 10
        random = (int)(Math.random()*100)+1;
    }
    
   //Write the guess() method below 
   public void guess()
   {
	   //Use scanner to accept a user input 
	   //Create a new scanner object to receive user input
	      Scanner sc = new Scanner(System.in);
	    
	      System.out.println("Enter you guess ");
	      guess = sc.nextInt();
	      
	      //write your code below
         if(guess < random)
         {
        	 System.out.println("Your guess is too low");
         }
         else if(guess > random)
         {
        	 System.out.println("Your guess is too high");
         }
         else
         {
        	 System.out.println("You guessed it right");
         }
   }
   
   //Write startGuessing method here
   public void startGuessing()
   {
      int count = 0;
      do{
         guess();
         count++;
      } while(guess != random);
      System.out.println("You guessed it in " + count + " times");
   }

   public static void main(String[] args) {
      HiLo l=new HiLo();
      l.generateNumber();
      l.startGuessing();
   }
    
}
 