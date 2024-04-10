package billeteraDigital;

public class Cuenta {
	
	//atributos
	private int numeroCuenta;
	private Double saldo;
	private Moneda divisa;
	
		
	//constructor vacío
	public Cuenta() {
	}
	
	//constructor para poblado
	public Cuenta(int numeroCuenta, Double saldo, Moneda divisa) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.divisa = divisa;
	}

	
	//Setters and Getters
	
	//numeroCuenta
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	//saldo
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	//divisa
	public Moneda getDivisa() {
		return divisa;
	}
	public void setDivisa(Moneda divisa) {
		this.divisa = divisa;
	}
	
	//Método para realizar giro, comprueba saldo y, si es suficiente, lo realiza
	public void realizarGiro (Double montoGiro) {
		if(this.saldo >= montoGiro) {
			this.saldo =  this.saldo - montoGiro;
			System.out.println("El giro se ha realizado exitosamente.");
			System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
		} else {
			System.out.println("El giro no ha podido realizarse por saldo insuficiente.");
			System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
		}
	}
	
	//Método para realizar depósito, suma el monto de depósito al saldo de la cuenta
	public void realizarDeposito (Double montoDeposito) {
		this.saldo = this.saldo + montoDeposito;
		System.out.println("El depósito se ha realizado exitosamente.");
		System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
	}
	
	public void realizarTransferencia (Cuenta cuentaReceptora, Double montoTransferencia) {
		if(this.saldo >= montoTransferencia) {
			this.saldo =- montoTransferencia;
			cuentaReceptora.saldo =+ montoTransferencia;
			System.out.println("La transferencia se ha realizado exitosamente.");
			System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
		} else {
			System.out.println("La transferencia no ha podido realizarse por saldo insuficiente.");
			System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
		}
	}

	
	@Override
	public String toString() {
		return "\nNúmero de cuenta: " + numeroCuenta + "\nSaldo: " + saldo + "\nDivisa: " + divisa.getNombre() + "\n";
	}
	
	
	
}
