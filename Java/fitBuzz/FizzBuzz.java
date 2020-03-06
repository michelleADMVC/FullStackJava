package fitBuzz;

public class FizzBuzz {

	public static String conditional(int number) {
		String conditionString = "";
		switch(number) {
		case 3:
			conditionString = "Fizz";
			break;
		case 5:
			conditionString = "Buzz";
			break;
		case 15:
			conditionString = "FizzBuzz";
			break;
		case 2:
			conditionString = "2";
			break;
		 default:
			 conditionString = "No corresponde ningun resultado";
		}
		return conditionString;
	}
}
