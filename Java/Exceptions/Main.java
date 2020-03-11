import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add(1);
		myList.add(2);
		myList.add("3");
		myList.add("4");
		myList.add("Hola Mundo");
		myList.add(48);
		myList.add("Adios Mundo");
		Caster caster = new Caster(myList);
		caster.cast(0);
	}


}
