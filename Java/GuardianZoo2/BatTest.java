import com.animal.Bat;

public class BatTest {
	public BatTest() {
		System.out.println("--------------------------------");
		Bat marta = new Bat("Marta");
		marta.displayEnergy();
		marta.atackTown();
		marta.atackTown();
		marta.atackTown();
		marta.displayEnergy();
		marta.eatHumans();
		marta.eatHumans();
		marta.displayEnergy();
		marta.fly();
		marta.fly();
		marta.displayEnergy();
	}
}
