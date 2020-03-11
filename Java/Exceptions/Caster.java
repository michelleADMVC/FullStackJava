import java.util.ArrayList;

public class Caster {

	ArrayList<Object> myList = new ArrayList<Object>();
	int aux ;
	
	public Caster(ArrayList array) {
		this.myList = array;
	}
	
	public void cast(int aux){
		try{
			for(int i = aux; i < myList.size(); i++) {
				this.aux = i;
			    Integer castedValue = (Integer) myList.get(i);
			    System.out.println("Casted value : "+castedValue);
			   
			}
        } catch (Exception e){
        	 System.out.println("Fallo en el indice : "+this.aux+" Objeto : '"+myList.get(this.aux)+"'...reanudando");
        	 this.aux++;
        	 if (this.aux == myList.size()) {
				System.out.println("Arreglo terminado ");
			}else {
				cast(this.aux);
			}
        	 
        }
		
	}
}
