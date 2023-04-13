package br.com.gft.main;

import java.util.Scanner;

import br.com.gft.model.Veiculo;

public class Main {

	public static void main(String[] args) {

		Veiculo objveiculo = new Veiculo();
		
		int opcao, combustivel;
		String cor;
		
		Scanner entrada = new Scanner(System.in);
			
		do {
			System.out.println("\nQual ação deseja realizar?");
			System.out.println("1 - Acelerar");
			System.out.println("2 - Abastecer");
			System.out.println("3 - Frear");
			System.out.println("4 - Pintar");
			System.out.println("5 - Ligar");
			System.out.println("6 - Desligar");
			System.out.println("7 - Sair");
			System.out.println("Digite a opção: ");
			opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1: objveiculo.acelerar();
					System.out.println("A velocidade atual é: " + objveiculo.getVelocidade() + "km/h");
					break;
			case 2: System.out.println("Qual a quantidade que será abastecida?");
					combustivel = entrada.nextInt();
					objveiculo.abastecer(combustivel);
					break;
			case 3: objveiculo.frear();
					System.out.println("A velocidade atual é: " + objveiculo.getVelocidade() + "km/h");
					break;
			case 4: System.out.println("Qual cor deseja pintar?");
					cor = entrada.next();
					objveiculo.pintar(cor);
					break;
			case 5: objveiculo.ligar();
					break;
			case 6: objveiculo.desligar();
					break;
			case 7: System.out.println("Você saiu do sistema");
					break;
			default: System.out.println("Opção invalida, digite novamente");
			}
		} while(opcao != 7);
		
		entrada.close();

	}

}
