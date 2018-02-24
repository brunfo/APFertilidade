package apFertilidade.view;

import apFertilidade.MainApp;
import apFertilidade.model.Parceiro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ParceirosOverviewController {
	//splitPane Esq
	@FXML
	private TableView<Parceiro> parceiroTable;
	@FXML
	private TableColumn<Parceiro, String> tipoParceiroColuna;
	@FXML
	private TableColumn<Parceiro, String> nomeColuna;
	
	//splitPane Dto
	@FXML
	private Label tipoParceiroLabel;
	@FXML
	private Label nomeLabel;
	@FXML
	private Label moradaLabel;
	@FXML
	private Label localidadeLabel;
	@FXML
	private Label codigoPostalLabel;
	@FXML
	private Label freguesiaLabel;
	@FXML
	private Label concelhoLabel;
	@FXML
	private Label distritoLabel;
	
	
	//Referência para aplicação principal
	private MainApp mainApp;
	
	/**
	 * O construtor é chamado ates do método inicialize().
	 */
	public ParceirosOverviewController() {
	}
	
	/**
	 * Inicializa a classe controller. Este método é chamado
	 * automáticamente após o arquivo fxml ter sido carregado.
	 */
	@FXML
	private void initialize() {
		//Inicializa tabela de pessoa com duas colunas
		tipoParceiroColuna.setCellValueFactory(cellData -> 
				cellData.getValue().tipoParceiroProperty());
		nomeColuna.setCellValueFactory(cellData ->
				cellData.getValue().nomeProperty());
	}
	
	/**
	 * É chamada pela aplicação principal para dar uma referência
	 * de volta a si mesmo.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		//Adiciona os dados da observable list na tabela
		parceiroTable.setItems(mainApp.getParceirosData());
	}

}
