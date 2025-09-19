package bank.app;

import java.util.Scanner;

import bank.service.CompteService;
import bank.valid.Validation;

public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static CompteService service = new CompteService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            afficherMenu();
            int choix;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(RED + "Erreur : entrer un nombre." + RESET);
                continue;
            }

            try {
                switch (choix) {
                    case 1:
                        creerCompte();
                        break;
                    case 2:
                        effectuerRetrait();
                        break;
                    case 3:
                        effectuerVirement();
                        break;
                    case 4:
                        consulterSolde();
                        break;
                    case 0:
                        System.out.println(GREEN + "Au revoir !" + RESET);
                        running = false;
                        break;
                    default:
                        System.out.println(RED + "Choix invalide." + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Erreur : " + e.getMessage() + RESET);
            }
        }
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println(GREEN + "\n=== Gestion de Comptes Bancaires ===" + RESET);
        System.out.println(CYAN + "1. Créer un compte");
        System.out.println("2. Effectuer un retrait");
        System.out.println("3. Effectuer un virement");
        System.out.println("4. Consulter le solde");
        System.out.println(RED + "0. Quitter" + RESET);
        System.out.print(YELLOW + "Choix : " + RESET);
    }

    
    
    private static void creerCompte() {
        System.out.print(CYAN + "Type de compte (1: Courant, 2: Epargne) : " + RESET);
        int type;
        try {
            type = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("type invalide,  entrer 1 ou 2.");
        }

        System.out.print(CYAN + "Solde initial : " + RESET);
        double solde;
        try {
            solde = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("solde invalide, entrer un nombre.");
        }
        if (!Validation.validateMontant(solde)) {
            throw new IllegalArgumentException("solde initial invalide.");
        }

        String code;
        if (type == 1) {
            System.out.print(CYAN + "decouvert autorise : " + RESET);
            double decouvert;
            try {
                decouvert = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Decouvert invalide,  entrer un nombre.");
            }
            if (decouvert < 0) {
                throw new IllegalArgumentException("Le decouvert ne peut pas etre négatif.");
            }
            code = service.creerCompteCourant(solde, decouvert);
        } else if (type == 2) {
            System.out.print(CYAN + "Taux d'interet (%) : " + RESET);
            double taux;
            try {
                taux = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Taux invalide, veuillez entrer un nombre.");
            }
            if (taux < 0) {
                throw new IllegalArgumentException("Le taux d'interet ne peut pas etre négatif.");
            }
            code = service.creerCompteEpargne(solde, taux);
        } else {
            throw new IllegalArgumentException("Type invalide, veuillez entrer 1 ou 2.");
        }
        System.out.println(GREEN + "Compte cree avec code : " + code + RESET);
    }
    
    
    
    
    
    

    private static void effectuerRetrait() {
        String code = lireCode();
        double montant = lireMontant();
        System.out.print(CYAN + "Destination (ex: Distributeur ATM, Cheque) : " + RESET);
        String destination = scanner.nextLine().trim();
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("La destination ne peut pas etre vide.");
        }
        service.retirer(code, montant);
        System.out.println(GREEN + "Retrait effectue." + RESET);
    }

    private static void effectuerVirement() {
        System.out.print(CYAN + "Code compte source : " + RESET);
        String codeSource = scanner.nextLine().trim();
        System.out.print(CYAN + "montant : " + RESET);
        double montant = lireMontant();
        service.virement(codeSource, montant);
        System.out.println(GREEN + "Virement effectue." + RESET);
    }
    
    private static void consulterSolde() {
        String code = lireCode();
        System.out.println(CYAN + "Solde : " + service.getSolde(code) + RESET);
    }

    
    private static String lireCode() {
        System.out.print(CYAN + "Code compte : " + RESET);
        String code = scanner.nextLine().trim();
        if (!Validation.validerCode(code)) {
            throw new IllegalArgumentException("Code de compte invalide.");
        }
        return code;
    }

    private static double lireMontant() {
        System.out.print(CYAN + "Montant : " + RESET);
        try {
            double montant = Double.parseDouble(scanner.nextLine().trim());
            if (!Validation.validateMontant(montant)) {
                throw new IllegalArgumentException("Montant invalide.");
            }
            return montant;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Montant invalide, veuillez entrer un nombre positif.");
        }
    }
}