import com.human.*;
public final class HumanTest {

	public static void main(String[] args) {
		Ninja player1 = new Ninja("Manolo");
		Samurai player2 = new Samurai("Carmelo");
		Wizard player3 = new Wizard("Catalino");
		player1.display();
		player2.howMany();;
		player3.display();
		player3.fireball(player2);
		player2.display();
		player2.deathBlow(player3);
		player3.display();
		player1.steal(player2);
		player2.display();
		player2.meditate();
		player2.display();
		player2.attack(player1);
		player1.display();
		player1.runAway();
		
	}

}
