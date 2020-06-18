
public class Caminhao extends Veiculo {

	private int carga;

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public Caminhao(String marca, String modelo, int anoDeFabricacao, String placa, double valorDaDiaria,
			double valorDoBem, int carga) {

		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.valorDaDiaria = valorDaDiaria;
		this.valorDoBem = valorDoBem;
		this.carga = carga;

	}

	@Override
	public double seguro() {
		return (getValorDoBem() * 0.08) / 365;
	}

}
