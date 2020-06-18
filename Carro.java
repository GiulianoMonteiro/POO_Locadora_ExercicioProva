
public class Carro extends Veiculo {

	public final int PASSEIO = 1;
	public final int SUV = 2;
	public final int PICKUP = 3;
	
	public int tipo;
	
	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	@Override
	public double seguro() {
		
		return (getValorDoBem()*0.03)/365;
	}

	public Carro(String marca, String modelo, int anoDeFabricacao, String placa, double valorDaDiaria, double valorDoBem, int tipo) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.placa = placa;
		this.valorDaDiaria = valorDaDiaria;
		this.valorDoBem = valorDoBem;
		this.tipo = tipo;
		
		
		
	}
	
	

}
