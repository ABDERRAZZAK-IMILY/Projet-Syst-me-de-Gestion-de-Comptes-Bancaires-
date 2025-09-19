package bank.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import bank.model.Compte;
import bank.model.CompteCourant;
import bank.model.CompteEpargne;
import bank.valid.Validation;




public class CompteService {

    private Map<String, Compte> comptes = new HashMap<>();

    public String creerCompteCourant(double solde, double decouvert) {
        String code = genererCodeUnique();
        comptes.put(code, new CompteCourant(code, solde, decouvert));
        return code;
    }
    
    public String creerCompteEpargne(double solde, double tauxInteret) {
        String code = genererCodeUnique();
        comptes.put(code, new CompteEpargne(code, solde, tauxInteret));
        return code;
    }
    
    public void retirer(String code, double montant) {
        Compte compte = getCompte(code);
        compte.retirer(montant , "hi");
    }
    
    public void virement(String codeSource, double montant) {
        Compte source = getCompte(codeSource);
        source.retirer(montant , "hi");
        
    }
    
    public double getSolde(String code) {
        Compte compte = getCompte(code);

        if (compte instanceof CompteEpargne) {
            CompteEpargne epargne = (CompteEpargne) compte;
            return epargne.getSolde() + epargne.calculerInteret();
        }

        return compte.getSolde();
    }

    
    public String getDetails(String code) {
        return getCompte(code).afficherDetails();
    }

    private Compte getCompte(String code) {
        if (!Validation.validerCode(code)) {
            throw new IllegalArgumentException("code et invalide.");
        }
        Compte compte = comptes.get(code);
        if (compte == null) {
            throw new IllegalArgumentException("compte non trouve : " + code);
        }
        return compte;
    }

    private String genererCodeUnique() {
        Random random = new Random();
        String code;
        do {
            code = String.format("CPT-%05d", random.nextInt(100000));
        } while (comptes.containsKey(code) || !Validation.validerCode(code));
        return code;
    }
	
	

}
