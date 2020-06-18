import java.util.ArrayList;

public class MinhaLocadora implements Locadora {

	ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>(); // LISTA DE VEICULOS CADASTRADOS
	ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // LISTA DE CLIENTES CADASTRADOS
	ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>(); // LISTA DE VEICULOS ALUGADOS

	@Override
	public void inserir(Veiculo v) throws VeiculoJaCadastrado {

		try {

			Veiculo veiculo = pesquisar(v.getPlaca()); // PESQUISA O VEICULO PELA PLACA
			throw new VeiculoJaCadastrado(); // DISPARA EXCESSAO CASO JA ESTEJA CADASTRADO

		} catch (VeiculoNaoCadastrado e) {
			veiculos.add(v); // SE NAO, CADASTRA O VEICULO
		}

	}

	// -----------------------------------------------------------------//

	@Override
	public void inserir(Cliente c) throws ClienteJaCadastrado {

		try {

			Cliente cliente = pesquisarCliente(c.getCpf()); // PESQUISA O CLIENTE PELO CPF
			throw new ClienteJaCadastrado(); // DISPARA EXCESSAO CASO JA ESTEJA CADASTRADO
		} catch (ClienteNaoCadastrado e) {
			clientes.add(c); // SE NAO, CADASTRA O VEICULO
		}

	}

	// -----------------------------------------------------------------//

	@Override
	public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado {

		for (Veiculo v : veiculos) { // PERCORRE A LISTA DE VEICULOS
			if (v.getPlaca() == placa) { // CASO ENCONTRE A PLACA, RETORNA O VEICULO
				return v;
			}
		}

		throw new VeiculoNaoCadastrado(); // CASO NAO, LANÇA EXCESSAO DE VEICULO NAO CADASTRADO

	}

	// -----------------------------------------------------------------//

	public Cliente pesquisarCliente(int cpf) throws ClienteNaoCadastrado {

		for (Cliente c : clientes) { // PERCORRE A LISTA DE CLIENTES
			if (c.getCpf() == cpf) // CASO ENCONTRE O CPF, RETORNA O CLIENTE
				return c;
		}
		throw new ClienteNaoCadastrado(); // CASO NAO, LANÇA EXCESSAO DE CLIENTE NAO CADASTRADO
	}

	// -----------------------------------------------------------------//

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {

		ArrayList<Veiculo> listaDeCarros = new ArrayList<Veiculo>(); // LISTA AUXILIAR DE BUSCA POR CARROS

		for (Veiculo c : veiculos) {
			if (c instanceof Carro && ((Carro) c).getTipo() == tipoCarro) { // PERCORRE TODOS OS VEICULOS E PROCURA OS
																			// CARROS COM O TIPO SELECIONADO
				listaDeCarros.add(c); // ADICIONA OS CARROS ACHADOS À LISTA AUXILIAR
			}
		}

		return listaDeCarros; // RETORNA A LISTA AUXILIAR DE CARROS
	}

	// -----------------------------------------------------------------//

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {

		ArrayList<Veiculo> listaDeMotos = new ArrayList<Veiculo>(); // LISTA AUXILIAR DE BUSCA POR MOTOS

		for (Veiculo m : veiculos) {
			if (m instanceof Moto && ((Moto) m).getCilindradas() == cilindrada) { // PERCORRE TODOS OS VEICULOS E
																					// PROCURA AS MOTOS COM AS
																					// CILINDRADAS SELECIONADAS
				listaDeMotos.add(m); // ADICIONA AS MOTOS ACHADAS À LISTA AUXILIAR
			}
		}

		return listaDeMotos; // RETORNA A LISTA AUXILIAR DE MOTOS
	}

	// -----------------------------------------------------------------//

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {

		ArrayList<Veiculo> listaDeCaminhao = new ArrayList<Veiculo>(); // LISTA AUXILIAR DE BUSCA DE CAMINHOES

		for (Veiculo cm : veiculos) {
			if (cm instanceof Caminhao && ((Caminhao) cm).getCarga() == carga) { // PERCORRE TODOS OS VEICULOS E PROCURA
																					// OS CAMINHOES COM A CARGA
																					// SELECIONADA
				listaDeCaminhao.add(cm); // ADICIONA OS CAMINHOES ACHADOS À LISTA AUXILIAR
			}
		}

		return listaDeCaminhao; // RETORNA A LISTA AUXILIAR DE CAMINHOES
	}

	// -----------------------------------------------------------------//

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {

		ArrayList<Veiculo> listaDeOnibus = new ArrayList<Veiculo>(); // LISTA AUXILIAR DE BUSCA DE ONIBUS

		for (Veiculo o : veiculos) {
			if (o instanceof Onibus && ((Onibus) o).getCapacidade() == passageiros) { // PERCORRE TODOS OS VEICULOS E
																						// PROCURA ONIBUS COM A
																						// CAPACIDADE SELECIONADA
				listaDeOnibus.add(o); // ADICIONA OS ONIBUS ACHADOS À LISTA AUXILIAR
			}
		}

		return listaDeOnibus; // RETORNA A LISTA AUXILIAR
	}

	// -----------------------------------------------------------------//

	@Override
	public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado {

		Veiculo v = pesquisar(placa); // PESQUISA O VEICULO PELA PLACA
		double valorDoAluguel = v.aluguel(dias); // CASO O VEICULO ESTEJA CADASTRADO, CALCULA-SE O ALUGUEL A PARTIR DOS
													// DIAS INFORMADOS

		return valorDoAluguel; // RETORNA O VALOR DO ALUGUEL
	}

	// -----------------------------------------------------------------//

	@Override
	public void registrarAluguel(String placa, int dias, Cliente c)
			throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {

		Cliente cli = pesquisarCliente(c.getCpf()); // PROCURA SE O CLIENTE EXISTE
		Veiculo v = pesquisar(placa); // PROCURA SE O VEICULO PELA PLACA
		Aluguel a = pesquisarAluguelAberto(v); // CASO O VEICULO EXISTA, VERIFICA-SE A DISPONIBILIDADE DO VEICULO PARA
												// ALUGUEL
		
		
		if (a != null) {

			throw new VeiculoAlugado(); // SE ESTIVER ALUGADO, LANÇA EXCESSAO DE VEICULO ALUGADO
		}

		
		
		double valor = v.aluguel(dias); // CASO ESTEJA LIVRE, É O VALOR DO ALUGUEL COM OS DIAS INFORMADOS
		Aluguel aluguel = new Aluguel(v, cli, dias, valor); // É CRIADO UM OBJETO ALUGUEL GUARDANDO O VEICULO, CLIENTE,
															// DIAS E VALOR DO ALUGUEL
		alugueis.add(aluguel); // É ARMAZENADO NA LISTA DE ALUGUEIS

		
		
	}

	// -----------------------------------------------------------------//

	// PESQUISA SE É POSSÍVEL ALOCAR UM VEÍCULO

	private Aluguel pesquisarAluguelAberto(Veiculo v) { // PESQUISA NA LISTA DE ALUGUEIS PELO VEICULO PEDIDO
		for (Aluguel a : alugueis) {
			if (!a.isFechado() && a.getVeiculo().getPlaca() == v.getPlaca()) { // AVISA SE O VEICULO JA FOI ALOCADO
				return a; // CASO ESTEJA ALOCADO, O ALUGUEL É RETORNADO
			}
		}
		return null; // RETORNA NULL CASO O VEICULO ESTEJA LIVRE
	}

	// -----------------------------------------------------------------//

	@Override
	public void registrarDevolucao(String placa, Cliente c)
			throws VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado {

		Cliente cli = pesquisarCliente(c.getCpf()); // VERIFICA SE O CLIENTE EXISTE
		Veiculo v = pesquisar(placa); // PESQUISA O VEICULO PELA PLACA
		Aluguel a = pesquisarAluguelAberto(v); // PESQUISA NOS ALUGEIS PELO VEICULO ENCONTRADO

		if (a == null) { // SE O CARRO ESTIVER LIVRE, LANÇA A EXCESSAO DE "VEICULO NAO ALUGADO". (NULL =
							// VEICULO LIVRE)
			throw new VeiculoNaoAlugado();
		}

		a.setFechado(true); // ATUALIZA O VEICULO COMO LIVRE. (ALTERAR O "isFechado" MUDA O RESULTADO NA
							// PESQUISA)

	}

	// -----------------------------------------------------------------//

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {

		for (Veiculo v : veiculos) { // PERCORRE A LISTA DE VEICULOS

			if (tipo == 0) { // DEPRECIA O VALOR DE TODOS OS VEICULOS
				v.setValorDoBem(v.getValorDoBem() * (1 - taxaDepreciacao));
			}
			if (tipo == 1 && v instanceof Moto) { // DEPRECIA APENAS MOTOS
				v.setValorDoBem(v.getValorDoBem() * (1 - taxaDepreciacao));
			}
			if (tipo == 2 && v instanceof Carro) {// DEPRECIA APENAS CARROS
				v.setValorDoBem(v.getValorDoBem() * (1 - taxaDepreciacao));
			}
			if (tipo == 3 && v instanceof Caminhao) {// DEPRECIA APENAS CAMINHOES
				v.setValorDoBem(v.getValorDoBem() * (1 - taxaDepreciacao));
			}
			if (tipo == 4 && v instanceof Onibus) {// DEPRECIA APENAS ONIBUS
				v.setValorDoBem(v.getValorDoBem() * (1 - taxaDepreciacao));
			}

		}

	}

	// -----------------------------------------------------------------//

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {

		for (Veiculo v : veiculos) {// PERCORRE A LISTA DE VEICULOS

			if (tipo == 0) {// AUMENTA A DIARIA DE TODOS OS VEICULOS
				v.setValorDaDiaria(v.getValorDaDiaria() * (1 + taxaAumento));
			}
			if (tipo == 1 && v instanceof Moto) {// AUMENTA A DIARIAS APENAS DAS MOTOS
				v.setValorDaDiaria(v.getValorDaDiaria() * (1 + taxaAumento));
			}
			if (tipo == 2 && v instanceof Carro) {// AUMENTA A DIARIA APENAS DOS CARROS
				v.setValorDaDiaria(v.getValorDaDiaria() * (1 + taxaAumento));
			}
			if (tipo == 3 && v instanceof Caminhao) {// AUMENTA A DIARIA APENAS DOS CAMINHOES
				v.setValorDaDiaria(v.getValorDaDiaria() * (1 + taxaAumento));
			}
			if (tipo == 4 && v instanceof Onibus) {// AUMENTA A DIARIA APENAS DOS ONIBUS
				v.setValorDaDiaria(v.getValorDaDiaria() * (1 + taxaAumento));
			}
		}

	}

	// -----------------------------------------------------------------//

	@Override
	public double faturamentoTotal(int tipo) {

		double total = 0; // VARIAVEL DE CONTAGEM

		for (Aluguel aluguel : alugueis) { // PERCORRE TODOS OS ALUGUEIS

			if (!aluguel.isFechado()) { // VERIFICA SE O VEICULO ESTA ALUGADO
				
				
				if (tipo == 0) {
					total += aluguel.getValor(); // CALCULA O FATURAMENTO DE TODOS OS ALUGUEIS
				}
				
				if (tipo == 1 && aluguel.getVeiculo() instanceof Moto) {
					total += aluguel.getValor(); // CALCULA O FATURAMENTO APENAS DAS MOTOS
				}
				
				if (tipo == 2 && aluguel.getVeiculo() instanceof Carro) {
					total += aluguel.getValor(); // CALCULA O FATURAMENTO APENAS DOS CARROS
				}
				
				if (tipo == 3 && aluguel.getVeiculo() instanceof Caminhao) {
					total += aluguel.getValor(); // CALCULA O FATURAMENTO APENAS DO CAMINHOES
				}
				
				if (tipo == 4 && aluguel.getVeiculo() instanceof Onibus) {
					total += aluguel.getValor(); // CALCULA O FATURAMENTO APENAS DOS ONIBUS
				}
				
				
			}
		}

		return total; // RETORNA A VARIAVEL DE CONTAGEM COM OS FATURAMENTOS
	}

	// -----------------------------------------------------------------//

	@Override
	public int quantidadeTotalDeDiarias(int tipo) {

		int diarias = 0; // VARIAVEL DE CONTAGEM

		for (Aluguel aluguel : alugueis) { // PERCORRE TODOS OS ALUGUEIS

			if (!aluguel.isFechado()) { // VERIFICA SE O VEICULO ESTA ALUGADO

				if (tipo == 0) {
					diarias += aluguel.getDias(); // CONTA O TOTAL DE DIAS ALUGADOS DE TODOS OS VEICULOS
				}
				if (tipo == 1 && aluguel.getVeiculo() instanceof Moto) {
					diarias += aluguel.getDias(); // CONTA O TOTAL DE DIAS ALUGADOS APENAS DE MOTOS
				}
				if (tipo == 2 && aluguel.getVeiculo() instanceof Carro) {
					diarias += aluguel.getDias(); // CONTA O TOTAL DE DIAS ALUGADOS APENAS DE CARROS
				}
				if (tipo == 3 && aluguel.getVeiculo() instanceof Caminhao) {
					diarias += aluguel.getDias(); // CONTA O TOTAL DE DIAS ALUGADOS APENAS DE CAMINHOES
				}
				if (tipo == 4 && aluguel.getVeiculo() instanceof Onibus) {
					diarias += aluguel.getDias(); // CONTA O TOTAL DE DIAS ALUGADOS APENAS DE ONIBUS
				}
			}

		}

		return diarias; // RETORNA A VARIAVEL DE CONTAGEM COM O TOTAL DE DIARIAS
	}

	// -----------------------------------------------------------------//

}
