
public class TestPerson {

	public static void main(String[] args) {
		//create Person object here
		Person person = new Person();
		person.setHeight(180);
		person.setWeight(80);
		person.checkPulse();
		person.checkForAbuse();
		person.checkDesirability();

		System.out.println("Person 2: ");
		Person person2 = new Person();
		person2.setHeight(140);
		person2.setWeight(120);
		person2.smoker = true;
		person2.weeklyAlcholUnits = 30;
		person2.checkDesirability();
	}

}
