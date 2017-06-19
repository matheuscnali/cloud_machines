package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMaster {

	// Nesse documento temos 3 classes referentes às políticas, elas possuem
	// contrutores e o método 'run()' para escrever o código que a thread irá
	// executar.
	// O loop de cada algoritmo é rodado até que a Thread seja interrompida
	// (Nesse caso, ocorre quando é pedido a liberação da máquina).

	class ROI implements Runnable {

		public ROI(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}
	}

	class OnDemand implements Runnable {

		public OnDemand(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}

	}

	class DefineCost implements Runnable {

		public DefineCost(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}

	}

	// A classe CriadorThreads possui os métodos que são chamados no switch do
	// arquivo 'Entrada.java'. Foi feito um loop com o for para criar a
	// quantidade
	// 'nMaq' de threads.

	public class CriadorThreads {
		
		public void CriaConstrutor(){
			ExecutorService execService = Executors.newFixedThreadPool(100);
			ArrayList<Future> Futures = new ArrayList<Future>();
		}

		public void ROI(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {

			for (int i = 0; i < nMaq; i++) {

				Futures.add(execService.submit(new ROI(ThLog, ID))); // Submissão da 'task'(Execução do Runnable) ROI() para a thread.
				ID++;
			}
		}

		public void OnDemand(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {
			Futures.add(execService.submit(new OnDemand(ThLog, ID)));
		}

		public void DefineCost(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {
			Futures.add(execService.submit(new DefineCost(ThLog, ID)));
		}
	}
}
