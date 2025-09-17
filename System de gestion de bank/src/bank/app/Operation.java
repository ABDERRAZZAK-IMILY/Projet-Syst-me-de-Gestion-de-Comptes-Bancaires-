package bank.app;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {

	private UUID numero;
	
	private LocalDateTime date;
	
	private double montant;
	
	public Operation(double montant) {
		this.numero = UUID.randomUUID();
		this.date = LocalDateTime.now();
		this.montant = montant;
	}
	
	public UUID getNumero() { return numero;}
	
	public LocalDateTime getDate() { return date;}
	
	
	public double getMontant() { return montant;}	
	
	
}