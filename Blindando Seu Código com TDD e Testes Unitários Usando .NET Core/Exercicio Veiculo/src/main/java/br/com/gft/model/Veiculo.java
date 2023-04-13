package br.com.gft.model;

public class Veiculo {

	private String Marca;
	private String Modelo;
	private String Placa;
	private String Cor;
	private float Km;
	private boolean isLigado = false;
	private int litrosCombustivel;
	private int Velocidade = 0;
	private double Preco;
	
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		Cor = cor;
	}
	public float getKm() {
		return Km;
	}
	public void setKm(float km) {
		Km = km;
	}
	public boolean isLigado() {
		return isLigado;
	}
	public void setLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}
	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}
	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}
	public int getVelocidade() {
		return Velocidade;
	}
	public void setVelocidade(int velocidade) {
		Velocidade = velocidade;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	
	public void ligar() {
		if (isLigado == false) {
			isLigado = true;
			System.out.println("O carro foi ligado!");
		} else {
			System.out.println("O carro já está ligado");
		}
	}
	
	public void acelerar() {
		if (isLigado == true) {
			Velocidade += 20;
		} else {
			System.out.println("O carro está desligado! Ligue-o.");
		}
	}
	
	public void pintar(String cor) {
		if (Velocidade > 0 || isLigado() == true) {
			System.out.println("Não é possível pintar o carro em andamento ou ligado, desligue-o!");
		} else {
			Cor = cor;
			System.out.println("A cor atual do carro é: " + Cor);
		}
	}
	public void abastecer(int combustivel) {
		if (Velocidade > 0 || isLigado()) {
			System.out.println("Não é possível abastecer o carro em andamento ou ligado, desligue-o!");
		}else if ((litrosCombustivel + combustivel) > 60) {
			System.out.println("Você só pode abastecer até " + (60 - litrosCombustivel) + " litros");
		} else {
			litrosCombustivel += combustivel;
			System.out.println("Agora o tanque possui " + litrosCombustivel + " litros de combustivel");
		}
	}
	public void frear() {
		if (Velocidade > 0){
			Velocidade -= 20;
			if (Velocidade < 0) {
				Velocidade = 0;
			}
		} else {
			System.out.println("O veículo já está parado!");
		}
	}
	public void desligar() {
		if (isLigado == true) {
			if (Velocidade == 0) {
				isLigado = false;
				System.out.println("O carro foi desligado!");
			} else {
				System.out.println("Não é possível desligar com o carro em andamento, diminua a velocidade");
			}
		} else {
			System.out.println("O carro já está desligado!");
		}

	}
}
