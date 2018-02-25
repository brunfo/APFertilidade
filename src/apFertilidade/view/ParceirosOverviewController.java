package apFertilidade.view;

import java.util.Optional;

import apFertilidade.MainApp;
import apFertilidade.model.Parceiro;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
	private Label codigoPostalLabel;
	@FXML
	private Label localidadeLabel;
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
		
		//Limpa os detalhes da pessoa
		showParceiroDetails(null);
		
		//Detecta mudanças de seleção e mostra os detalhes da
		//pessoa quando houver mudança
		parceiroTable.getSelectionModel().selectedItemProperty().
			addListener((observable, oldValue, newValue) -> 
				showParceiroDetails(newValue));
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
	
	/**
	 * Preenche todos os campos de texto para mostrar detalhes do parceiro.
	 * Se o parceiro for null, todos os campos de texto são limpos.
	 * 
	 * @param parceiro ou null
	 */
	private void showParceiroDetails(Parceiro parceiro) {
		if (parceiro !=null) {
			//Preenche as labels com informações do objecto parceiro
			tipoParceiroLabel.setText(parceiro.getTipoParceiro());
			nomeLabel.setText(parceiro.getNome());
			moradaLabel.setText(parceiro.getMorada());
			localidadeLabel.setText(parceiro.getLocalidade());
			codigoPostalLabel.setText(parceiro.getCodigoPostal());
			freguesiaLabel.setText(parceiro.getFreguesia());
			concelhoLabel.setText(parceiro.getConcelho());
			distritoLabel.setText(parceiro.getDistrito());
		}
		else {
			//Parceiro é null, remove todo o texto
			tipoParceiroLabel.setText("");
			nomeLabel.setText("");
			moradaLabel.setText("");
			localidadeLabel.setText("");
			codigoPostalLabel.setText("");
			freguesiaLabel.setText("");
			concelhoLabel.setText("");
			distritoLabel.setText("");
		}
	}
	
	/**
	 * Chamado quando o utilizador clica no botão apagar
	 */
	@FXML
	private void handleApagarParceiro() {
		int selectedIndex = parceiroTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >=0) {
			//Caixa de alert pedindo confirmação para apagar
			Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
			alertConfirm.setTitle("Apagar Parceiro");
			alertConfirm.setHeaderText("Tem a certeza que deseja apagar parceiro?");
			Optional<ButtonType> result =alertConfirm.showAndWait();
			if( result.get() == ButtonType.OK) {
				//Apaga o parceiro da tabela
				parceiroTable.getItems().remove(selectedIndex);
				//TODO integração com base dados apagar
			}
		}
		else {
			//Nada seleccionado
			alertNadaSelecionado();
		}
		
	}

	/**
	 * Abre uma janela popup com mensagem de erro.
	 */
	private void alertNadaSelecionado() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Nenhuma seleção");
		alert.setHeaderText("Nenhum Parceiro selecionado");
		alert.setContentText("Por favor, selecione um parceiro.");
		alert.showAndWait();
	}
	
	/**
	 * Chamado quando o utilizador clica no botão novo. Abre uma janela
	 * para editar os detalhes da nova pessoa
	 */
	@FXML
	private void handleNovoParceiro() {
		Parceiro tempParceiro = new Parceiro();
		boolean okClicked = mainApp.showParceiroEditDialog(tempParceiro);
		if (okClicked) {
			mainApp.getParceirosData().add(tempParceiro);
		}
	}
	
	/**
	 * Chamado quando o utilizador clica no botão edit. Abre janela para
	 * editar detalhes do parceiro selecionado.
	 */
	@FXML
	private void handleEditParceiro() {
		Parceiro selectedParceiro = parceiroTable.getSelectionModel().
				getSelectedItem();
		if ( selectedParceiro!=null) {
			boolean okClicked = mainApp.showParceiroEditDialog(selectedParceiro);
			if (okClicked) {
				showParceiroDetails(selectedParceiro);
			}
		}
		else {
			//Nada selecionado
			alertNadaSelecionado();
		}
	}

}
