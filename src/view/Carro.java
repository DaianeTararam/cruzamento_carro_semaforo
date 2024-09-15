package view;

import controller.CarroCruzamento;

public class Carro {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			CarroCruzamento carro = new CarroCruzamento();
			carro.start();
		}

	}

}
