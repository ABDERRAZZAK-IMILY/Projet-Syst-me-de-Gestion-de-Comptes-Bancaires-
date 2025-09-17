import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
	        
	   
	    
	
	    public static final String RESET = "\u001B[0m";
	    public static final String RED = "\u001B[31m";
	    public static final String GREEN = "\u001B[32m";
	    public static final String YELLOW = "\u001B[33m";
	    public static final String CYAN = "\u001B[36m";
	    
	    
	private static Map<String , Compte> comptes = new HashMap<>();
	
    private static Scanner scanner = new Scanner(System.in);
    
    public static boolean validerCode(String code) {
        return code.matches("^CPT-\\d{5}$");
    }

    
    public static void main(String[] args) {
    	
    	int choix;
       
    	 System.out.println( GREEN +  "=== Gestion de Comptes Bancaires ===" + RESET );
         System.out.println( CYAN +   "1. Créer un compte");
         System.out.println("2. Faire un versement");
         System.out.println("3. Faire un retrait");
         System.out.println("4. Faire un virement");
         System.out.println("5. Consulter solde");
         System.out.println("6. Consulter opérations" + RESET );
         System.out.println( RED +  "7. Quitter" + RESET);
         System.out.print( YELLOW + "Choix: " + RESET);
         choix = scanner.nextInt();
         scanner.nextLine();
         
         if (choix == 7) {
        	    System.out.println("Au revoir!");
        	    return;
        	}
 
         
         switch (choix) {
         case 1:
             System.out.println("Création de compte...");
             System.out.println("entre le code de compte que debut de CPT-XXXXX");
              
             String code;
             
             code = scanner.next();
             scanner.nextLine();
             if (!validerCode(code)){
            	 System.out.println("code incorrect");
            	 return;
             }else if (comptes.containsKey(code)) {
            	 System.out.println("code deja exist");
            	 return;
             }
             
             System.out.println("entre votre sold : ");
             double solde;
             solde = scanner.nextDouble();
             scanner.nextLine();
             
             System.out.println("====slectioner le type de compte : ====");
             System.out.println("1 . compte courant");
             System.out.println("2 . compte epargne");
             
             int choix2;
             
             choix2 = scanner.nextInt();
             scanner.nextLine();
             
           if (choix2 == 1) {
        	   Compte compte = new CompteCourant(code , solde);
               comptes.put(code , compte);
               System.out.println("votre compte est cree avec succes");
               break;
           }else if (choix2 == 2) {
        	   
        	   System.out.println("comtpe epargne");
        	   
           }else {
        	   System.out.println("choix2 invalide");
           }

             break;
         case 2:
             System.out.println("Versement...");
             break;
         case 3:
             System.out.println("Retrait...");
             break;
         case 4:
             System.out.println("Virement...");
             break;
         case 5:
             System.out.println("Consulter solde...");
             break;
         case 6:
             System.out.println("Consulter opérations...");
             break;
         default:
             System.out.println("choix invalide");
     }
    	
    
         
         
         
         
    }
}
