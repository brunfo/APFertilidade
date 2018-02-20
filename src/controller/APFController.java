package controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import dao.APFDao;
import dao.APFDaoImpl;
import model.Parceiro;
import view.APFView;

public class APFController {
	private Parceiro model = null;
	private APFView view;
	private APFDao parceiroDao = new APFDaoImpl();
	private Scanner scanner = new Scanner(System.in);

	List<Parceiro> parceiros;

	public APFController(Parceiro model, APFView view) {
		this.model = model;
		this.view = view;
	}

	// public APFController(Parceiro model, APFParceirosView windowView) {
	// this.model = model;
	// this.view = windowView;
	// }

	// **************MODEL*****************

	public void setNomeParceiro(String nome) {
		model.setNome(nome);
	}

	public String getNameParceiro() {
		return model.getNome();
	}

	public void setIdParceiro(int idParceiro) {
		model.setIdParceiro(idParceiro);
	}

	public int getIdParceiro() {
		return model.getIdParceiro();
	}

	/**
	 * Sets the current parceiro
	 * 
	 * @param model
	 */
	public void setParceiro(Parceiro model) {
		this.model = model;
	}

	// *************DAO*****************

	/**
	 * get the parceiro by roll number
	 * 
	 * @param idParceiro
	 * @return Parceiro model
	 */
	public Parceiro getParceiroById(int idParceiro) {
		return parceiroDao.getParceiroByID(idParceiro);
	}

	/**
	 * Adds a parceiro to database and list
	 * 
	 * @param parceiro
	 */
	public void addParceiro(Parceiro parceiro) {
		parceiroDao.addParceiro(parceiro);
	}

	/**
	 * Update parceiro nome in list
	 * 
	 * @param parceiro
	 */
	public void updateNameParceiro(Parceiro parceiro) {
		parceiroDao.updateParceiro(parceiro);
	}

	/**
	 * Deletes the parceiro from the list
	 * 
	 * @param parceiro
	 */
	public void deleteParceiro(Parceiro parceiro) {
		parceiroDao.getAllParceiros().remove(parceiro.getIdParceiro());
	}

	// **************VIEW************

	/**
	 * Prints parceiro details
	 */
	public void updateView() {
		view.printParceiroDetails(model.getIdParceiro(), model.getNome());
	}

	/**
	 * Print all parceiros details
	 */
	public void printAllParceiros() {
		for (Parceiro parceiro : parceiroDao.getAllParceiros()) {
			view.printParceiroDetails(parceiro.getIdParceiro(), parceiro.getNome());
		}
	}

	/**
	 * Closes database connection
	 */
	public void closeConnection() {
		parceiroDao.closeAll();

	}

	public APFView getView() {
		return view;
	}

	/**
	 * Inicializa menu de Comandos de Consola
	 * 
	 */
	public void getMenu() {
		int input;
		do {
			getView().getMenu();
			input =  scanner.nextInt();
		} while (!(input > 0 && input <= 5 || input == 9));

		switch (input) {
		case 1: this.printAllParceiros();
				pressioneEnter();
				getMenu();
				break;
		case 2: System.out.println("Introduza o ID: ");
		 		this.model= getParceiroById(scanner.nextInt());
		 		System.out.println(this.getIdParceiro() +
		 				": " + this.getNameParceiro());
		 		pressioneEnter();
		 		getMenu();
		 		break;
		case 9:
				System.out.println("Tem a certeza que quer sair? (s/n): ");
				String inputChar=  scanner.next();
				if (inputChar.toLowerCase().equals("s"))  {
					this.closeConnection();
					break;
				}
				getMenu();
		}
	}

	/**
	 * 
	 */
	private void pressioneEnter() {
		try {
			System.out.println("Prima Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
