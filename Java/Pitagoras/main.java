import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingrese el numero 1");
		double num1 = reader.nextDouble();
		System.out.println("Ingrese el numero 2");
		double num2 = reader.nextDouble();
		System.out.println(calculateHypotenuse(num1,num2));
	}
	
    public static double calculateHypotenuse(double legA, double legB) {
      double res = 0;
      res = Math.sqrt((Math.pow(legA,2))+(Math.pow(legB,2)));
      return res;
    }
}
