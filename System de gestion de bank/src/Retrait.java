
public class Retrait extends Operation {
  
	 private String  destination;
	 
	
	public Retrait( double montant , String source ) {
		super(montant);
		this. destination = source;
	}
	
	
	public void afficherDetails() {
		System.out.println("le numero de operation est : " + getNumero());
		System.out.println("la date de operation est : " + getDate() );
		System.out.println("le montant de operation est : " + getMontant());
	}
	
}
