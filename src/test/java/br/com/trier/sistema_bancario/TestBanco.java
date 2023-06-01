package br.com.trier.sistema_bancario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestBanco {
	private Caixa caixa = new Caixa();
	private ContaCorrente cc;
	private ContaEspecial ce;
	private ContaUniversitaria cu;
	
	@BeforeEach
	void init() {
		cc = new ContaCorrente("Gabriel", "111", "222", 2000.00);
		ce = new ContaEspecial("Joyce", "333", "444", 2000.00, 500.00);
		cu = new ContaUniversitaria("Eynar", "555", "666", 100.00);
	}
	
	@Test
	@DisplayName("Teste depósito ContaCorrente")
	void depositoContaCorrenteTest(){
		caixa.operacaoDeposito(cc, 200.00);
		assertEquals(2200.00, cc.getSaldo());
		
	}
	
	@Test
	@DisplayName("Teste saque ContaCorrente")
	void saqueContaCorrenteTest() {
		caixa.operacaoSaque(cc, 500.00);
		assertEquals(1500.00, cc.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoSaque(cc, 1501.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
	}
	
	@Test
	@DisplayName("Teste transferencia ContaCorrente")
	void transferenciaContaCorrenteTest() {
		caixa.operacaoTransferencia(cc, ce, 100.00);
		assertEquals(1900.00, cc.getSaldo());
		assertEquals(2100.00, ce.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoTransferencia(cc, ce, 3000.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
	}
	
	@Test
	@DisplayName("Teste depósito ContaEspecial")
	void depositoContaEspecialTest(){
		caixa.operacaoDeposito(ce, 200.00);
		assertEquals(2200.00, ce.getSaldo());
		
	}
	
	@Test
	@DisplayName("Teste saque ContaEspecial")
	void saqueContaSaqueTest() {
		caixa.operacaoSaque(ce, 500.00);
		assertEquals(1500.00, ce.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoSaque(ce, 2001.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
	}
	
	@Test
	@DisplayName("Teste transferencia ContaEspecial")
	void transferenciaContaEspecialTest() {
		caixa.operacaoTransferencia(ce, cc, 100.00);
		assertEquals(1900.00, ce.getSaldo());
		assertEquals(2100.00, cc.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoTransferencia(ce, cc, 3000.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
	}
	
	@Test
	@DisplayName("Teste depósito ContaUniversitaria")
	void depositoContaUniversitariaTest(){
		caixa.operacaoDeposito(cu, 200.00);
		assertEquals(300.00, cu.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoDeposito(cu, 2001.00));
		assertEquals(exception.getMessage(), "Limite de saldo ultrapassado");
	}
	
	@Test
	@DisplayName("Teste saque ContaUniversitaria")
	void saqueContaUniversitariaTest() {
		caixa.operacaoSaque(cu, 50.00);
		assertEquals(50.00, cu.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoSaque(cu, 51.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
	}
	
	@Test
	@DisplayName("Teste transferencia ContaUniversitaria")
	void transferenciaContaUniversitariaTest() {
		caixa.operacaoTransferencia(cu, cc, 100.00);
		assertEquals(0.00, cu.getSaldo());
		assertEquals(2100.00, cc.getSaldo());
		
		Throwable exception = assertThrows(Exception.class, () -> caixa.operacaoTransferencia(cu, cc, 101.00));
		assertEquals(exception.getMessage(), "Saldo insuficiente");
		
		cc.setSaldo(100000.00);
		Throwable exception1 = assertThrows(Exception.class, () -> caixa.operacaoTransferencia(cc, cu, 3000.00));
		assertEquals(exception1.getMessage(), "Limite de saldo ultrapassado");
	}

}
