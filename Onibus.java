
public class Onibus extends Veiculo {

	private int capacidade;
	
	
	
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Onibus(String marca, String modelo, int anoDeFabricacao, String placa, double valorDaDiaria, double valorDoBem, int capacidade) {
	
		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.valorDaDiaria = valorDaDiaria;
		this.valorDoBem = valorDoBem;
		this.capacidade = capacidade;
		
	}

	@Override
	public double seguro() {
		
		return (getValorDoBem() * 0.20) / 365;
	}

}
