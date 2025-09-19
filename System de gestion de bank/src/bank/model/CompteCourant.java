package bank.model;

import bank.valid.Validation;

public class CompteCourant extends Compte {
	
	

     private double decouvert;

     public CompteCourant(String code, double solde, double decouvert) {
         super(code, solde);
         this.decouvert = decouvert;
     }

	 public void retirer(double montant, String destination) {
	        if (!Validation.validateMontant(montant) || destination == null) {
            System.out.println("s");
	        }
	        if (getSolde() - montant < -decouvert) {
	        	System.out.println("s");

	        }
	        setSolde(getSolde() - montant);
	        addOperation(new Retrait(montant, destination));
	    }     
	 public double calculerInteret() {
	  return 0;
	 };
	
	 public String afficherDetails() {
		    return "Compte Courant - solde: " + getSolde();
		}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	};
	
}
