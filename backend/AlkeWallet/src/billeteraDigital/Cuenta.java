/** Clase para crear objetos Cuenta, con número de cuenta, saldo y divisa
* @author Sebastián León
* @version 1.0
*
**/

package billeteraDigital;

public class Cuenta {
	
	//atributos
	private int numeroCuenta;
	private Double saldo;
	private Moneda divisa;
	
		
	//constructor vacío
	public Cuenta() {
	}
	
	/** 
	* Constructor por defecto
	* @param int numeroCuenta - numero de la cuenta
	* @param Double saldo - saldo de la cuenta
	* @param Moneda divisa - objeto tipo Moneda que corresponde a la divisa que utiliza la cuenta
	**/
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
	
	/**
	* Método para realizar giro, comprueba saldo y, si es suficiente, baja el saldo en el monto del giro
	* @param Double montoGiro - el monto del giro que se quiere realizar
	**/
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
	

	/** 
	* Método para realizar depósito, suma el monto de depósito al saldo de la cuenta
	* @param Double montoDeposito - el monto del depósito que se quiere realizar
	**/
	public void realizarDeposito (Double montoDeposito) {
		this.saldo = this.saldo + montoDeposito;
		System.out.println("El depósito se ha realizado exitosamente.");
		System.out.println("Su saldo actual es " + getDivisa().getSigno() + this.saldo);
	}
	
	/**
	* Método para realizar transferencias entre dos cuentas, cambia el saldo de las dos cuentas, uno baja y el otro sube en el monto solicitado
	* @param Cuenta cuentaReceptora - objeto de tipo Cuenta que será la cuenta receptora, la que subirá su saldo
	* @param Double montoTransferencia - monto de la transferencia
	**/
	public void realizarTransferencia (Cuenta cuentaReceptora, Double montoTransferencia) {
		if(this.divisa != cuentaReceptora.divisa) {
			System.out.println("La transferencia no ha podido realizarse porque la divisa de la cuenta receptora es diferente de la de origen.");
		} else {
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
	}
	
	@Override
	public String toString() {
		return "\nNúmero de cuenta: " + numeroCuenta + "\nSaldo: " + saldo + "\nDivisa: " + divisa.getNombre() + "\n";
	}
	
	
	
}
