
public class ProjectTest {
	private Project proyecto1;
	private Project proyecto2;
	private Project proyecto3;
	Portfolio portafolio;
	
	public ProjectTest() {
		portafolio = new Portfolio();
		this.proyecto1 = new Project() ;
		this.proyecto2 = new Project("Sandwicheria") ;
		this.proyecto2.setInitialCost(200000);
		this.proyecto3 = new Project("Proyecto Marcelo","Agachate y conocelo owo");
		this.proyecto3.setInitialCost(200);
		addProjectsToPortfolio();
	}

	private void addProjectsToPortfolio() {
		portafolio.insertProject(this.proyecto1);
		portafolio.insertProject(this.proyecto2);
		portafolio.insertProject(this.proyecto3);
	}

	public void mostrarProyectos() {
		portafolio.showPortafolio();
		
	}
	
}
