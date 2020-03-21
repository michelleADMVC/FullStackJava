
public class Calculator {
	public void operation(String input){
		String[] operationString = input.split(" ");
		double operand1 = Double.parseDouble(operationString[0]);		
		double operand2 =  Double.parseDouble(operationString[2]);
		Operation newOperation = new Operation(operand1,operand2,operationString[1]);
		System.out.println(newOperation.getResult());
		
	}
}
