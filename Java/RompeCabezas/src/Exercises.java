import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exercises {
	
	public void showArrayListString(ArrayList<String> arrayList) {
		System.out.print("Arreglo : ");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("");
		}
	public void showArrayListChar(ArrayList<Character> arrayList) {
		System.out.print("Arreglo : ");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("");
		}
	public void showArrayListInt(ArrayList<Integer> arrayList) {
		System.out.print("Arreglo : ");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
		System.out.println("");
		}
	public ArrayList<Integer> numerosMayores(int num, int[] array) {
		 ArrayList<Integer> arrayMayores = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] > num ) {
				arrayMayores.add(array[i]); 
			}
		}
		System.out.println("Retornando numeros mayores a : "+num);
		return arrayMayores;
		
	}
	
	public ArrayList<String> greaterThan(ArrayList<String> names,int num) {
		ArrayList<String> longNames = new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() > num) {
				longNames.add(names.get(i));
			}
		}
		return longNames;
	}
	
	public ArrayList<Integer> ex1(){
		int[] array = {3,5,1,2,7,9,8,13,25,32};
		
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("Esta es la suma de todos numeros de array : "+sum);
		
		return numerosMayores(9,array);
	}
	

	public ArrayList<String> ex2 () {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> longNames = new ArrayList<String>();
		names.add("Nancy");
		names.add("Jinichi");
		names.add("FujiBayashi");
		names.add("Momoshi");
		names.add("Isikawa");
		showArrayListString(names);
		Collections.shuffle(names);
		showArrayListString(names);
	    longNames= greaterThan(names, 5);
	    
		return longNames;
	}
	public void ex3() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		for (int i = 0; i < 26; i++) {
			alphabet.add((char)('A' + i));
			
		}
		showArrayListChar(alphabet);
		Collections.shuffle(alphabet);
		System.out.println("Mezclando alfabeto:");
		if (alphabet.get(0) =='A'||alphabet.get(0) =='E'||alphabet.get(0) =='I'||
				alphabet.get(0) =='O'||alphabet.get(0) =='U') {
			System.out.println("Uuuuuh, es una vocal owo");
		}
		showArrayListChar(alphabet);
	}
	public ArrayList<Integer> ex4() {
	    Random rnd = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int randomNumber = rnd.nextInt(45)+55;
			numbers.add(randomNumber);
		}
		showArrayListInt(numbers);
		return numbers;
	}
	
	public ArrayList<Integer> ex5() {
	    Random rnd = new Random();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int randomNumber = rnd.nextInt(45)+55;
			numbers.add(randomNumber);
		}
		showArrayListInt(numbers);
		Collections.sort(numbers);
		System.out.println("Ordenando");
		showArrayListInt(numbers);
		System.out.println("El valor minimo del arreglo es "+numbers.get(0)+" y el valor maximo es "
				+ numbers.get(numbers.size()-1));
		return numbers;
	}
	public String ex6() {
		ArrayList<Character> alphabet = new ArrayList<Character>();
		 Random rnd = new Random();
		for (int i = 0; i < 26; i++) {
			alphabet.add((char)('A' + i));
			
		}
		char[] randomWord = new char [5];
		for (int i = 0; i < randomWord.length; i++) {
			int randomNumber = rnd.nextInt(26);
			randomWord[i] = alphabet.get(randomNumber);
		}
		String word = String.valueOf(randomWord);
		System.out.println("Cadena de caracteres generada al azar");
		System.out.println(word);
		return word;
	}
	public void ex7() {
		ArrayList<String> randomWords = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			randomWords.add(ex6());
		}
		showArrayListString(randomWords);
	}
}
