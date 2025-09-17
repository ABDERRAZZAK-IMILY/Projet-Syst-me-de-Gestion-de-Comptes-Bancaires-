import java.util.List;
import java.util.ArrayList;


public abstract class Compte {

	private String code;
	
	private double solde;

	private List<Operation> listeOperations;
	
	
	public Compte(String code , double solde) {
		
		this.code = code;
		this.solde = solde;
		this.listeOperations = new ArrayList<>();
		
		
	}
	
	public String getCode() { return code; }
	public double getSolde() { return solde; }
	
	protected void setSolde(double solde) {this.solde = solde; };
	
	public List<Operation> getListeOperations() { return listeOperations; }
	
	public abstract void retirer(double montant);

	
	public abstract double calculerInteret();

	
	public abstract void afficherDetails();

	
}
