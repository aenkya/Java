
/**
 * A class to hold the declarations and Expressions 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Amazing
{
   //Put your data type declarations below. Here is an example
    int m = 18;
    int n = 4;
    float x = 2.5f;
    float y = -1.5f;
    double f1, f2, f3;

     

//Put the code for your calculations in this method.   
   void doCalculations()
   {
      f1 = x+n*y-(x+n)*y;
      System.out.println("If x=2.5, y=-1.5, n=4 and f1 = x+n*y-(x+n)*y, then f1 = " + f1);
      f2 = m / n + m % n;
      System.out.println("If m=18, n=4 and f2 = m/n + m%n, then f2 = " + f2);
      f3 = 5 * x - n / 5;
      System.out.println("If x=2.5, n=4 and f3 = 5*x - n/5, then f3 = " + f3);
   }//End of doCalculations
}
