
public class Aluguel {

	private Veiculo veiculo;
	private Cliente cliente;
	private int dias;
	private double valor;
	private boolean fechado;
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isFechado() {
		return fechado;
	}
	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}
	public Aluguel(Veiculo veiculo, Cliente cliente, int dias, double valor) {
		
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.dias = dias;
		this.valor = valor;
		this.fechado = false;
	}
	
	
	
	
	
}
