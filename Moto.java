
public class Moto extends Veiculo {

	private int cilindradas;

	public int getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(int cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public double seguro() {

		return (getValorDoBem() * 0.11) / 365;
	}

	public Moto(String marca, String modelo, int anoDeFabricacao, String placa, double valorDaDiaria, double valorDoBem,
			int cilindradas) {

		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.valorDaDiaria = valorDaDiaria;
		this.valorDoBem = valorDoBem;
		this.cilindradas = cilindradas;

	}

}
