package bank.valid;

public class Validation {

    public static boolean validerCode(String code) {
        if (code == null || !code.matches("^CPT-\\d{5}$")) {
            System.out.println(" code invalide  doit etre comme : CPT-XXXXX");
            return false;
        }
        return true;
    }

    public static boolean validateMontant(double montant) {
        if (montant <= 0) {
            System.out.println(" le montant doit etre positif");
            return false;
        }
        return true;
    }
}
