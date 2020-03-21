
public class Operation {
	double result;
	String operator;
	private double operandOne;
	private double operandTwo;
	
	public Operation(double operandOne, double operandTwo, String operator) {
		this.setOperandOne(operandOne);
		this.setOperandTwo(operandTwo);
		this.setOperator(operator);
		perfomOperation();
	}
	
	public double getOperandOne() {
		return operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperator() {
		return operator;
	}
	public double getResult() {
		return result;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void perfomOperation(){
		switch (this.operator) {
		case "+": this.setResult(getOperandOne()+getOperandTwo());
		break;
		case "-": this.setResult(getOperandOne()-getOperandTwo());
		break;
		}
	}
	
}
