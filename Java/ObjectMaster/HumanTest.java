import com.human.*;
public final class HumanTest {

	public static void main(String[] args) {
		Ninja player1 = new Ninja("Manolo");
		Samurai player2 = new Samurai("Carmelo");
		player1.display();
		player2.display();
		player1.attack(player2);
		player1.attack(player2);
		player1.attack(player2);
		player1.attack(player2);
		player2.displayHealth();
		player2.attack(player1);
		player2.attack(player1);
		player2.attack(player1);
		player1.displayHealth();
	}

}
