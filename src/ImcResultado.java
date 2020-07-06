/**
 * esta clase es un bean para expresar el resultado
 * del cálculo del imc
 * 
 * @author Jose
 *
 */

public class ImcResultado {

	private String tipo_imc_nominal;
	private double valor_num;
	
	
	
	public ImcResultado() {
		super();
	}
	public ImcResultado(String tipo_imc_nominal, double valor_num) {
		super();
		this.tipo_imc_nominal = tipo_imc_nominal;
		this.valor_num = valor_num;
	}
	public String getTipo_imc_nominal() {
		return tipo_imc_nominal;
	}
	public void setTipo_imc_nominal(String tipo_imc_nominal) {
		this.tipo_imc_nominal = tipo_imc_nominal;
	}
	public double getValor_num() {
		return valor_num;
	}
	public void setValor_num(double valor_num) {
		this.valor_num = valor_num;
	}
	
	
}
