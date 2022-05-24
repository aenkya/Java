
/**
 * To demonstrate some methods found in the Math class.
 * 
  */
import java.util.*;
public class MathDemo
{
	
	public double squareRoot(double rootIn)
	{
	 return  Math.sqrt(rootIn);
	}
	
	public void  rollDice()
	{
	   int score;
	   score = (int) (Math.random() * 6) + 1;
	   System.out.println("You rolled a " + score);
	}
	
	public void findThePower()
	{
	   double base, exponent;
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter a number you wish to raise to the power");
	   base = sc.nextDouble();
	   System.out.println("Enter the power you wish to raise the number to");
	   exponent = sc.nextDouble();
	   System.out.print("The number " + base + " raised to the power " + exponent + " = ");
	   System.out.println(Math.pow(base,exponent));
	}

	public void generateLottoNumber ()
	{
		int lottoNumber;
		lottoNumber = (int) (Math.random() * 49) + 1;
		System.out.println("Your lotto number is " + lottoNumber);
	}
	
	public int max (int x, int y, int z)
	{
		int max = Math.max(x, Math.max(y,z));
		return max;
	}

	public void bestOfThree ()
	{
		int x, y, z;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three numbers");
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		System.out.println("The best of three is " + max(x,y,z));
	}
}
