package apFertilidade.deprecated;

public class APFView {

	
	   public void printParceiroDetails(int idParceiro,String nomeParceiro ){
	      System.out.println("Parceiro: ");
	      System.out.println("\tNome: " + nomeParceiro);
	      System.out.println("\tID: " + idParceiro);
	   }

	public void getMenu() {
		System.out.println("\t\tMenu");
		System.out.println("Introduza uma das seguinte opções:");
		System.out.println("1 - Lista todos");
		System.out.println("2 - Seleciona parceiro por ID");
		System.out.println("3 - Filtra por Distrito");
		System.out.println("4 - Filtra por Localidade");
		System.out.println("5 - Remover filtros");
		System.out.println("9 - Sair");
	}
	}
