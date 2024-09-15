//@author Daiane Tararam

package controller;

import java.util.concurrent.Semaphore;

public class CarroCruzamento extends Thread{
	private int idCarro;
	private static int podeAndar = 0;
	private static Semaphore semaforo = new Semaphore(1);
	
	public CarroCruzamento() {
		super();
	}
	@Override
	public void run() {
		carroAndando();	
	}

	@SuppressWarnings("deprecation")
	private void carroAndando() {
		int continuarDeslocamento = 40;
		int tempo = 1000;
		idCarro = (int) this.getId();
		
		while(podeAndar < 200) {
			podeAndar += continuarDeslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro "+idCarro+ " está se deslocando...");
		}
		if (podeAndar == 200) {
			try {
				semaforo.acquire();
				System.out.println("O carro "+ idCarro + " parou no semaforo.");
				sleep(200);
				System.out.println("O carro " + idCarro + " está atravessando o cruzamento....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		}
		carroParado();

	}
	
	private void carroParado() {
		System.out.println("O carro "+idCarro+ " passou pelo cruzamento.");	
		try {
			semaforo.acquire();
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}	
		System.out.println("Passagem do carro "+idCarro + " concluída!");
	}
}