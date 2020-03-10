import java.util.ArrayList;
public class Exercises {
	
	private void showArray(int array[]) {
		System.out.print("Arreglo : ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
	public void ex1(){
		for (int i = 1; i < 256; i++) {
			System.out.print(i+" ");
		}
	}
	public void ex2(){
		int aux = 0, sum = 0;
		
		for (int i = 0; i < 256; i++) {
			aux = i;
			System.out.print("Nuevo numero :"+ i);
			sum += aux;
			System.out.println(" Suma : " +sum);
		}
	}
	public void ex3() {
		int[] array = {1,3,5,7,9,13};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public void ex4(){
		int[] array = {-12,-3,0,-7,-9,-23,-2,1};
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		showArray(array);
		System.out.println("Max : "+max);
	}
	public void ex5() {
		int[] array = {2,10,3};
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		avg = sum/array.length;
		showArray(array);
		System.out.println("Average : "+avg);
	}
	public void ex6() {
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i = 1; i < 256; i++) {
			if (i%2 != 0) {
				y.add(i);
			}
		}
		for(int i=0; i < y.size();i++) {
			System.out.println(y.get(i));
		}
	}
	
	public void ex7() {
		int[] array = {12,-3,0,7,-9,23,-2,1};
		int num = 4,total = 0;
		for (int i = 0; i < array.length; i++) {
			if (num < array[i]) {
				total++;
			}
		}
		showArray(array);
		System.out.println("Hay "+total+ " numeros mayores que "+num);
		
	}
	public void ex8() {
		int[] x= {12,-3,0,7,-9,23,-2,1};
		showArray(x);
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(x[i], 2);
		}
		System.out.println("Elevando a al cuadrado : ");
		showArray(x);
		
	}
	
	public void ex9 () {
		int[] x= {12,-3,0,7,-9,23,-2,1};
		showArray(x);
		for (int i = 0; i < x.length; i++) {
			if (x[i]<0) {
				x[i] = 0;
			}
		}
		System.out.println("Reemplazando numeros negativos por 0");
		showArray(x);
	}
	public void ex10() {
		int[] x= {12,-3,0,7,-9,23,-2,1};
		showArray(x);
		int max = x[0],min = x[0];
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < x.length; i++) {
			if (max < x[i]) {
				max = x[i];
			}
		}
		for (int i = 0; i < x.length; i++) {
			if (min > x[i]) {
				min = x[i];
			}
		}
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		avg = sum/x.length;
		System.out.println("El numero maximo es : "+max);
		System.out.println("El numero minimo es : "+min);
		System.out.println("Average : "+avg);
	}
	
	public void ex11() {
		int[] x= {1,5,10,7,-2};
		showArray(x);
		for (int i = 0; i < x.length -1; i++) {
				x[i] = x[i+1];
		}
		x[x.length-1] = 0;
		showArray(x);
	}
	
}
//Cambiando los Valores del Arreglo
//
//Dado un arreglo x, digamos [1,5,10,7,-2],
//escribir un método que cambie cada valor por el valor
//que sigue. Por ejemplo, cuando el método haya terminado,
//un arreglo x [1,5,10,7,-2] se convertirá en [5,10,7,-2,0]. 
//Observe que el último número es 0. 
//El método no necesita ajustarse para los valores que están fuera de los límites.

