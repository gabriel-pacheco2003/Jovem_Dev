package br.com.trier.exemploPolimorfismoTest;

import br.com.trier.exemploPolimorfismo.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.exemploPolimorfismo.Forma;

public class TestPolimorfismo {
	
	private List<Forma> lista = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		lista.add(new Circulo(3));
		lista.add(new Cone());
		lista.add(new Quadrado());
		lista.add(new Triangulo());
	}
	
	@Test
	@DisplayName("Teste desenhar Círculo")
	public void desenharCirculoTest() {
		String s = lista.get(0).desenhar();
		assertEquals("Desenhando um Círculo", s);
	}
	
	@Test
	@DisplayName("Teste área Círculo")
	public void areaCirculoTest() {
		Circulo c = (Circulo) lista.get(0);
		assertEquals(28.274333882308138, c.calculaArea());
	}
	
	@Test
	@DisplayName("Teste desenhar quadrado")
	public void desenharQuadradoTest() {
		Quadrado q = (Quadrado) lista.get(2);
		assertEquals("Desenhando um Quadrado com 4 lados ", q.desenhar());
	}

}
