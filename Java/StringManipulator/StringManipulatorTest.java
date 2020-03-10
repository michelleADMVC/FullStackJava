
public class StringManipulatorTest {

	public static void main(String[] args) {
		StringManipulator manipulator = new StringManipulator();
		System.out.println(manipulator.trimAndConcat("    Hola     ","     Mundo    "));
		System.out.println(manipulator.getIndexOrNull("soy una ardilla", 'a'));
		System.out.println(manipulator.getIndexOrNull("soy una ardilla", 'k'));
		System.out.println(manipulator.getIndexOrNull("soy una ardilla", "dilla"));
		System.out.println(manipulator.concatSubstring("hola", 1, 2,"mundo"));
	}

}
   