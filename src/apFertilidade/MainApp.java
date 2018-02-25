package apFertilidade;

import java.io.IOException;

import apFertilidade.dao.APFDaoImpl;
import apFertilidade.model.Parceiro;
import apFertilidade.view.ParceiroEditDialogController;
import apFertilidade.view.ParceirosOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Parceiro> parceirosData = 
			FXCollections.observableArrayList();
	// private APFDao parceiroDao = new APFDaoImpl();

	/**
	 * Construtor
	 */
	public MainApp() {
		// Busca os parceiros à base de dados
		parceirosData = new APFDaoImpl().getAllParceiros();
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("APFertilidade");

		// carrega o root layout
		initRootLayout();
		// carrega o ParceirosOverview
		showParceirosOverview();

	}

	/**
	 * Retorna o palco principal.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Inicializa o root layout ( layout de base).
	 */
	private void initRootLayout() {
		try {
			// Carrega o root layout do arquivo fmxl.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.
					getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Mostra a scene contendo o root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Mostra o scene ParceirosOverview dentro do root layout.
	 */
	public void showParceirosOverview() {
		try {
			// carrega o ParceirosOverview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.
					getResource("view/ParceirosOverview.fxml"));
			AnchorPane parceirosOverview = (AnchorPane) loader.load();

			// Define parceirosOverview dentro do root layout.
			rootLayout.setCenter(parceirosOverview);

			// Dá ao controllador acesso à mainApp.
			ParceirosOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Retorna os dados como uma observable list de Parceiros
	 * 
	 * @return
	 */
	public ObservableList<Parceiro> getParceirosData() {
		return parceirosData;
	}

	/**
	 * Abre janela de edição de de detalhes do parceiro específico. Se utilizador
	 * clicar OK, grava as mudanças e retorna true.
	 * 
	 * @param parceiro
	 *            - O parceiro a ser editado.
	 * @return true se o uutilizador clicou OK, caso contrário false.
	 */
	public boolean showParceiroEditDialog(Parceiro parceiro) {
		try {
			// carrega o arquivo fxml e cria um ovo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.
					getResource("view/ParceiroEditDialog.fxml"));

			AnchorPane pane = (AnchorPane) loader.load();

			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar Parceiro");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(pane);
			dialogStage.setScene(scene);

			// Define o parceiro no controller.
			ParceiroEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setParceiro(parceiro);

			// Mostra a janela e espera até o utilizador fechar.
			dialogStage.showAndWait();

			// retorna true ou false se o ok foi clicado.
			return controller.isOkClicked();
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

	}
}
