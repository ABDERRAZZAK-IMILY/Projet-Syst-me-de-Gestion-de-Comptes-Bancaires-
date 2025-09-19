package bank.model;

import bank.valid.Validation;

public class CompteEpargne extends Compte {

	 private double tauxInteret;
	 
	   public CompteEpargne(String code, double solde, double tauxInteret) {
	        super(code, solde);
	        if (tauxInteret < 0) {
             System.out.println("s");
	        }
	        this.tauxInteret = tauxInteret;
	    }
	   
	   
	   public void retirer(double montant, String destination) {
	        if (!Validation.validateMontant(montant) || destination == null || destination.trim().isEmpty()) {
                 System.out.println("s");
	        }
	        if (getSolde() < montant) {
               System.out.println("s");
	        }
	        
	        setSolde(getSolde() - montant);
	        addOperation(new Retrait(montant, destination));
	    }
	    
	    public double calculerInteret() {
	        return getSolde() * (tauxInteret / 100);
	    }
	    
	    public String afficherDetails() {
	    	calculerInteret();
	        return "Compte Epargne - solde: " + getSolde() + calculerInteret();
	    }
	
}
