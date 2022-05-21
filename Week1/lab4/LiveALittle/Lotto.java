
/**
 * Write a description of class Lotto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lotto
{
	
	//Put the luckyDip() method here
	void luckyDip() {
		int random;
		for (int i = 1; i < 7; i++) {
			random = (int)(Math.random() * 49) + 1;
			System.out.println("Ball " + i + " = " + random);
		}
	}


        //Test
	public static void main (String args[]) {
		
		Lotto l=new Lotto();
		l.luckyDip();
	}

	
}
