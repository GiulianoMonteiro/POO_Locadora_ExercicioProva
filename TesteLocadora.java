import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TesteLocadora {

	@Test
	void testeInserirVeiculo() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);

		locadora.inserir(carro1);
		try {
			// TENTATIVA DE INSERIR VEICULO DE MESMA PLACA
			locadora.inserir(carro1);
			fail("Excecao VeiculoJaCadastrado era esperada");
		} catch (VeiculoJaCadastrado e) {
			// OK, EXCESSAO ESPERADA !
		}
	}

	// -------------------------------------------------------//

	@Test
	void testeInserirCliente() throws ClienteJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Cliente cli1 = new Cliente("Joao Carlos", 1234);

		locadora.inserir(cli1);
		try {
			// TENTATIVA DE INSERIR CLIENTE DE MESMO CPF
			locadora.inserir(cli1);
			fail("Excessao ClienteJaCadastrado era esperada");
		} catch (ClienteJaCadastrado e) {
			// OK, EXCESSAO ESPERADA !
		}
	}

	// --------------------------------------------------------//

	@Test
	void testePesquisarVeiculo() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);

		locadora.inserir(carro1);
		Veiculo pesquisa = locadora.pesquisar("A-100");

		// VERIFICACAO SE A PESQUISA DEU CERTO
		assertEquals(carro1.getValorDoBem(), pesquisa.getValorDoBem());

		try {
			// TENTATIVA DE PESQUISAR PLACA DE VEICULO INEXISTENTE
			locadora.pesquisar("X-911");
			fail("Excessao VeiculoNaoCadastrado era esperada");
		} catch (VeiculoNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA !
		}
	}

	// -------------------------------------------------------//

	@Test
	void testePesquisarMoto() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo moto2 = new Moto("Joca Motores", "Zulu", 1978, "Q-123", 30, 10000, 40);
		Veiculo moto3 = new Moto("Calcio Motores", "Molar", 1985, "W-321", 50, 18000, 50);

		locadora.inserir(moto1);
		locadora.inserir(moto2);
		locadora.inserir(moto3);

		ArrayList<Veiculo> motos50c = locadora.pesquisarMoto(50);

		// CONFIRMANDO O NUMERO DE MOTOS COM 50 CILINDRADAS
		assertEquals(2, motos50c.size());
	}

	// -------------------------------------------------------------//
	
	@Test
	void testePesquisarCarro() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 23000, 1);
		Veiculo carro2 = new Carro("Joca Motores", "Pretao", 1978, "Q-123", 40, 20000, 3);
		Veiculo carro3 = new Carro("Calcio Motores", "Canino", 1985, "W-321", 60, 25000, 2);
		
		locadora.inserir(carro1);
		locadora.inserir(carro2);
		locadora.inserir(carro3);
		
		ArrayList<Veiculo> carrosPasseio = locadora.pesquisarCarro(1);
		
		// CONFIRMANDO O NUMERO DE CARROS DE PASSEIO
		assertEquals(1, carrosPasseio.size());
	}
	
	//---------------------------------------------------------------//
	
	
	@Test
	void testePesquisarCaminhao() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "X-911", 70, 30000, 200);
		Veiculo caminhao2 = new Caminhao("Joca Motores", "Malbará", 1978, "Q-123", 80, 45000, 300);
		Veiculo caminhao3 = new Caminhao("Cálcio Motores", "Incisivo", 1985, "W-321", 90, 60000, 200);
		
		locadora.inserir(caminhao1);
		locadora.inserir(caminhao2);
		locadora.inserir(caminhao3);
		
		ArrayList<Veiculo> caminhoesCarga200 = locadora.pesquisarCaminhao(200);
		
		// CONFIRMANDO O NUMERO DE CAMINHOES COM CARGA 200
		assertEquals(2, caminhoesCarga200.size());
	}
	
	//-------------------------------------------------------------------//
	
	@Test
	void testePesquisarOnibus() throws VeiculoJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaran", 1975, "X-911", 60, 30000, 50);
		Veiculo onibus2 = new Onibus("Joca Motores", "Kall'anggo", 1978, "Q-123", 70, 40000, 50);
		Veiculo onibus3 = new Onibus("Calcio Motores", "Bicusp", 1985, "W-321", 85, 50000, 70);
		
		locadora.inserir(onibus1);
		locadora.inserir(onibus2);
		locadora.inserir(onibus3);
		
		ArrayList<Veiculo> onibus50p = locadora.pesquisarOnibus(50);
		
		// CONFIRMANDO O NUMERO DE ONIBUS COM 50 PASSAGEIROS
		assertEquals(2, onibus50p.size());
	}
	
	//-------------------------------------------------------------------//
	
	@Test
	void testeCalcularAluguel() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaran", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		double aluguelMoto = locadora.calcularAluguel("X-911", 5);
		double aluguelCarro = locadora.calcularAluguel("A-100", 5);
		double aluguelCaminhao = locadora.calcularAluguel("S-123", 5);
		double aluguelOnibus = locadora.calcularAluguel("I-412", 5);
		
		// CONFIRMANDO O VALOR DO ALUGEL DE MOTO: (40(diaria) + 4.52(seguro diario)) * 5 dias = 222.6
		assertEquals(222.6, aluguelMoto, 0.01);
		// CONFIRMANDO O VALOR DO ALUGEL DE CARRO: (50(diaria) + 1.64(seguro diario)) * 5 dias = 258.22
		assertEquals(258.22, aluguelCarro, 0.01);
		// CONFIRMANDO O VALOR DO ALUGUEL DE CAMINHAO: (70(diaria) + 6.58(seguro diario)) * 5 dias = 382.88
		assertEquals(382.88, aluguelCaminhao, 0.01);
		// CONFIRMANDO O VALOR DO ALUGUEL DE ONIBUS: (60(diaria) + 16.44(seguro diario)) * 5 dias = 382.19
		assertEquals(382.19, aluguelOnibus, 0.01);
		
		try {
			// TESTANDO CALCULAR O ALUGUEL PARA PLACA INEXISTENTE
			locadora.calcularAluguel("X-999", 10);
			fail("Excessao VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA !
		}
	}
	
	//------------------------------------------------------------------------//
	
	@Test
	void testeRegistrarAluguel() throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, VeiculoJaCadastrado, ClienteJaCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Cliente cli1 = new Cliente("Joao Carlos", 1234);
		locadora.inserir(carro1);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("A-100", 5, cli1);
		try {
			// TENTANDO REGISTRAR ALUGUEL DE CARRO JA ALUGADO
			locadora.registrarAluguel("A-100", 5, cli1);
			fail("Excessao VeiculoAlugado esperada");
		} catch (VeiculoAlugado e) {
			// OK, EXCESSAO ESPERADA!
		}
		
		try {
			// TENTANDO REGISTRAR ALUGUEL DE PLACA NAO CADASTRADA
			locadora.registrarAluguel("X-999", 5, cli1);
			fail("Excessao VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA!
		}
		
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Cliente cli2 = new Cliente("Josue Dutra", 5412);
		locadora.inserir(moto1);
		
		try {
			// TENTANDO REGISTRAR ALUGUEL PARA CLIENTE NAO CADASTRADO
			locadora.registrarAluguel("X-911", 5, cli2);
			fail("Excessao ClienteNaoCadastrado esperada");
		} catch (ClienteNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA!
		}
	}
	
	//-------------------------------------------------------------------------//
	
	@Test
	void testeRegistrarDevolucao() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado, VeiculoNaoAlugado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Cliente cli1 = new Cliente("Joao Carlos", 1234);
		locadora.inserir(carro1);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("A-100", 5, cli1);
		locadora.registrarDevolucao("A-100", cli1);
		try {
			// TENTANDO REGISTRAR DEVOLUCAO DE VEICULO NAO ALUGADO
			locadora.registrarDevolucao("A-100", cli1);
			fail("Excessao VeiculoNaoAlugado esperada");
		} catch (VeiculoNaoAlugado e) {
			// OK, EXCESSAO ESPERADA!
		}
		
		try {
			// TENTANDO REGISTRAR DEVOLUCAO DE PLACA NAO CADASTRADA
			locadora.registrarDevolucao("X-999", cli1);
			fail("Excessao VeiculoNaoCadastrado esperada");
		} catch (VeiculoNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA!
		}
		
		Cliente cli2 = new Cliente("Josue Dutra", 5412);
		locadora.registrarAluguel("A-100", 5, cli1);
		try {
			// TENTANDO REGISTRAR DEVOLUCAO PARA CLIENTE NAO CADASTRADO
			locadora.registrarDevolucao("A-100", cli2);
			fail("Excessao ClienteoNaoCadastrado esperada");
		} catch (ClienteNaoCadastrado e) {
			// OK, EXCESSAO ESPERADA!
		}
	}
	
	//-----------------------------------------------------------------------------//
	
	@Test
	void testeDepreciarVeiculos() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaram", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		locadora.depreciarVeiculos(1, 0.1);		// DEPRECIANDO MOTOS EM 10%
		locadora.depreciarVeiculos(2, 0.2);		// DEPRECIANDO CARROS EM 20%
		locadora.depreciarVeiculos(3, 0.05);	// DEPRECIANDO CAMINHOES EM 5%
		locadora.depreciarVeiculos(4, 0.15);	// DEPRECIANDO ONIBUS EM 15%
		
		assertEquals(13500, locadora.pesquisar("X-911").getValorDoBem(), 0.01);
		assertEquals(16000, locadora.pesquisar("A-100").getValorDoBem(), 0.01);
		assertEquals(28500, locadora.pesquisar("S-123").getValorDoBem(), 0.01);
		assertEquals(25500, locadora.pesquisar("I-412").getValorDoBem(), 0.01);
		
		locadora.depreciarVeiculos(0, 0.1);		// DEPRECIANDO TODOS OS VEICULOS EM 10%
		
		assertEquals(12150, locadora.pesquisar("X-911").getValorDoBem(), 0.01);
		assertEquals(14400, locadora.pesquisar("A-100").getValorDoBem(), 0.01);
	}
	
	//-----------------------------------------------------------------------------//
	
	@Test
	void testeAumentarDiaria() throws VeiculoJaCadastrado, VeiculoNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaran", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		locadora.aumentarDiaria(1, 0.1);	// AUMENTANDO A DIARIA DE MOTOS EM 10%
		locadora.aumentarDiaria(2, 0.2);	// AUMENTNADO A DIARIA DE CARROS EM 20%
		locadora.aumentarDiaria(3, 0.05);	// AUMENTANDO A DIARIA DE CAMINHOES EM 5%
		locadora.aumentarDiaria(4, 0.15);	// AUMENTANDO A DIARIA DE ONIBUS EM 15%
		
		assertEquals(44, locadora.pesquisar("X-911").getValorDaDiaria(), 0.01);
		assertEquals(60, locadora.pesquisar("A-100").getValorDaDiaria(), 0.01);
		assertEquals(73.5, locadora.pesquisar("S-123").getValorDaDiaria(), 0.01);
		assertEquals(69, locadora.pesquisar("I-412").getValorDaDiaria(), 0.01);
		
		locadora.aumentarDiaria(0, 0.1);	// AUMENTANDO A DIARIA DE TODOS OS VEICULOS EM 10%
		
		assertEquals(48.4, locadora.pesquisar("X-911").getValorDaDiaria(), 0.01);
		assertEquals(66, locadora.pesquisar("A-100").getValorDaDiaria(), 0.01);
	}
	
	//--------------------------------------------------------------------------------//
	
	@Test
	void testeFaturamentoTotal() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaran", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		Cliente cli1 = new Cliente("Joao Carlos", 1234);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("X-911", 5, cli1);	// VALOR DO ALUGUEL = 222.6  (MOTO)
		locadora.registrarAluguel("A-100", 5, cli1);	// VALOR DO ALUGUEL = 258.22 (CARRO)
		locadora.registrarAluguel("S-123", 5, cli1);	// VALOR DO ALUGUEL = 382.88 (CAMINHAO)
		locadora.registrarAluguel("I-412", 5, cli1);	// VALOR DO ALUGUEL = 382.19 (ONIBUS)
		
		assertEquals(222.6, locadora.faturamentoTotal(1), 0.01);	// FATURAMENTO TOTAL DE MOTOS
		assertEquals(258.22, locadora.faturamentoTotal(2), 0.01);	// FATURAMENTO TOTAL DE CARROS
		assertEquals(382.88, locadora.faturamentoTotal(3), 0.01);	// FATURAMENTO TOTAL DE CAMINHOES
		assertEquals(382.19, locadora.faturamentoTotal(4), 0.01);	// FATURAMENTO TOTAL DE ONIBUS
		assertEquals(1245.89, locadora.faturamentoTotal(0), 0.01);	// FATURAMENTO TOTAL DE TODOS OS VEICULOS
	}
	
	//--------------------------------------------------------------------------------------//
	
	@Test
	void testeQuantidadeTotalDeDiarias() throws VeiculoJaCadastrado, ClienteJaCadastrado, VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		MinhaLocadora locadora = new MinhaLocadora();
		Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, "X-911", 40, 15000, 50);
		Veiculo carro1 = new Carro("Estrela", "Antares", 1980, "A-100", 50, 20000, 1);
		Veiculo caminhao1 = new Caminhao("Estrela", "Betelgeuse", 1975, "S-123", 70, 30000, 200);
		Veiculo onibus1 = new Onibus("Estrela", "Aldebaran", 1975, "I-412", 60, 30000, 50);
		locadora.inserir(moto1);
		locadora.inserir(carro1);
		locadora.inserir(caminhao1);
		locadora.inserir(onibus1);
		
		Cliente cli1 = new Cliente("Joao Carlos", 1234);
		locadora.inserir(cli1);
		
		locadora.registrarAluguel("X-911", 5, cli1);	// 5 DIARIAS DE MOTO
		locadora.registrarAluguel("A-100", 10, cli1);	// 10 DIARIAS DE CARRO
		locadora.registrarAluguel("S-123", 7, cli1);	// 7 DIARIAS DE CAMINHAO
		locadora.registrarAluguel("I-412", 2, cli1);	// 2 DIARIAS DE ONIBUS
		
		assertEquals(5, locadora.quantidadeTotalDeDiarias(1));	// QUANTIDADE DE DIARIAS DE MOTOS
		assertEquals(10, locadora.quantidadeTotalDeDiarias(2));	// QUANTIDADE DE DIARIAS DE CARRO
		assertEquals(7, locadora.quantidadeTotalDeDiarias(3));	// QUANTIDADE DE DIARIAS DE CAMINHAO
		assertEquals(2, locadora.quantidadeTotalDeDiarias(4));	// QUANTIDADE DE DIARIAS DE ONIBUS
		assertEquals(24, locadora.quantidadeTotalDeDiarias(0));	// QUANTIDADE DE DIARIAS DE TODOS OS VEICULOS
	}
	
	//----------------------------------------------------------------------------------------//
}
