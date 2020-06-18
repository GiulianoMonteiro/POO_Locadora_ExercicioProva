
public abstract class Veiculo {

	protected String marca;
	protected String modelo;
	protected int anoDeFabricacao;
	protected String placa;
	protected double valorDaDiaria;
	protected double valorDoBem;
	
	public abstract double seguro();
	
	public double aluguel(int dias) {
		return (valorDaDiaria + seguro())* dias;
	}
	
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public String getPlaca() {
		return placa;
	}
	public double getValorDaDiaria() {
		return valorDaDiaria;
	}
	public double getValorDoBem() {
		return valorDoBem;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setValorDaDiaria(double valorDaDiaria) {
		this.valorDaDiaria = valorDaDiaria;
	}

	public void setValorDoBem(double valorDoBem) {
		this.valorDoBem = valorDoBem;
	}
	
	
	
	
	
}
