
public class Pokemon {
	private String name,type;
	private int health;
	public Pokemon(String name, int health, String type) {
		this.name = name;
		this.health=health;
		this.type = type;
	}
	public void attack(Pokemon target) {
		System.out.println("El pokemon "+this.getName()+" a atacado a "+target.getName()+" !!!!");
		target.setHealth(target.getHealth() - 10);
	}
	public int getHealth() {
		return health;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
