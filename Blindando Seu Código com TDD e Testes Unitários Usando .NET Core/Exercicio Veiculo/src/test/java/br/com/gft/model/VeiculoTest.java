package br.com.gft.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class VeiculoTest {

	private Veiculo veiculo;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setup() {
		veiculo = new Veiculo();
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void deveVerificarSeOCarroEstaDesligado() throws Exception {
		assertFalse(veiculo.isLigado());
	}
	
	@Test
	public void naoDeveLigarVeiculoJaLigado() throws Exception {
		veiculo.ligar();
		veiculo.ligar();
		String expected = "O carro foi ligado!\r\nO carro já está ligado\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveLigarOVeiculoCasoEstejaDesligado() throws Exception {
		veiculo.ligar();
		String expected = "O carro foi ligado!\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void naoDeveAcelerarOCarroDesligado() throws Exception {
		veiculo.acelerar();
		String expected = "O carro está desligado! Ligue-o.\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveAcelerarOCarroAposLigar() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		assertEquals(20, veiculo.getVelocidade());
	}
	
	@Test
	public void deveAcelerarDuasVezesOCarroAposLigar() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.acelerar();
		assertEquals(40, veiculo.getVelocidade());
	}
	
	@Test
	public void naoDeveFrearOCarroParado() throws Exception {
		veiculo.frear();
		String expected = "O veículo já está parado!\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveFrearOCarro() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.frear();
		assertEquals(0, veiculo.getVelocidade());
	}
	
	@Test
	public void devePintarOCarro() throws Exception {
		veiculo.pintar("Rosa");
		String expected = "A cor atual do carro é: Rosa\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveUltrapassarLimiteParaAbastecerOCarro() throws Exception {
		veiculo.abastecer(70);
		String expected = "Você só pode abastecer até 60 litros\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveAbastecerOCarro() throws Exception {
		veiculo.abastecer(50);
		String expected = "Agora o tanque possui 50 litros de combustivel\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void naoDeveDesligarCarroDesligado() throws Exception {
		veiculo.desligar();
		String expected = "O carro já está desligado!\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void naoDeveDesligarOCarroEmAndamento() throws Exception {
		veiculo.ligar();
		veiculo.acelerar();
		veiculo.desligar();
		String expected = "O carro foi ligado!\r\nNão é possível desligar com o carro em andamento, diminua a velocidade\r\n";
        assertEquals(expected, outContent.toString());
	}
	
	@Test
	public void deveDesligarOCarro() throws Exception {
		veiculo.ligar();
		veiculo.desligar();
		String expected = "O carro foi ligado!\r\nO carro foi desligado!\r\n";
        assertEquals(expected, outContent.toString());
	}
}
