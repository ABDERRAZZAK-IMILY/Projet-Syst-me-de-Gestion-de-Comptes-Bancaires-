package bank.app;

public class CompteCourant extends Compte {
	
	

     private double decouvert;

	 public CompteCourant(String code, double solde) {
		super(code, solde);
		this.setDecouvert(300);
	}

	 public  void retirer(double montant) {
		 if ( montant > getSolde() + decouvert ) {
			 System.out.println("votre solde et  termine");
		 }else {
			 setSolde(getSolde()-montant);
			 
			 Retrait retrait = new Retrait(montant , "Distributeur ATM" );
			 getListeOperations().add(retrait);
			 
			 System.out.println("retirer est effectuer de montant :  " + montant);
		 }
		 
     };
     
	 public double calculerInteret() {
	  return 0;
	 };
	
	public void afficherDetails() {
		    System.out.println("Compte Courant:");
	        System.out.println("Code: " + getCode());
	        System.out.println("Solde: " + getSolde());
	        System.out.println("decouvert est de : " + decouvert);
		
	 }

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	};
	
}
