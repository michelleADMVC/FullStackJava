import java.util.ArrayList;
public class Portfolio {
	
	private ArrayList<Project> listaProyectos; 
	
	public Portfolio() {
		listaProyectos = new ArrayList<Project>();
	}
	
	public void insertProject(Project newProyecto) {
		listaProyectos.add(newProyecto);
	}

	public void showPortafolio() {
		System.out.println("Mostrando portafolio");
		System.out.println("Costo total del portafolio : $" + getPortfolioCost() );
		for (int i = 0; i < this.listaProyectos.size(); i++) {
			System.out.println(this.listaProyectos.get(i).elevatorPitch());
		}
		
	}
	private double getPortfolioCost() {
		double totalcost = 0;
		for (int i = 0; i < this.listaProyectos.size(); i++) {
			totalcost += this.listaProyectos.get(i).getInitialCost();
		}
		return totalcost;
	}
	
	
}
