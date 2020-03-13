
public class Project {
	
	private String name,description;
	private double initialCost;
	
	
	public Project() {
	this.name = "N/A";
	this.description= "N/A";
		
	}
	public Project(String name) {
		this.name = name;
		this.description= "N/A";
	}
	public Project(String name, String description) {
		this.name = name;
		this.description= description;
	
	}
	
	public String getName(){
		return this.name;
	}
	public double getInitialCost(){
		return this.initialCost;
	}
	public void setInitialCost(double newCost){
		this.initialCost = newCost;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setName(String name){
		this.description = name;
	}
	
	public String elevatorPitch() {
		return this.name +" ($"+initialCost+") "+ " : " + description;
	}
	
	
}
