package apFertilidade.view;

import apFertilidade.model.Parceiro;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Dialog oara editar detalhes de um parceiro
 * @author brunorego
 *
 */
public class ParceiroEditDialogController {
	@FXML
	private TextField tipoParceiroTextField;
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField moradaTextField;
	@FXML
	private TextField codigoPostalTextField;
	@FXML
	private TextField localidadeTextField;
	@FXML
	private TextField freguesiaTextField;
	@FXML
	private TextField concelhoTextField;
	@FXML
	private TextField distritoTextField;
	
	private Stage dialogStage;
	private Parceiro parceiro;
	private boolean okClicked = false;
	
	/**
	 * Inicializa a classe controller.
	 */
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Define o stage deste dialogo
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Define o parceiro a ser editado.
	 * 
	 * @param parceiro
	 */
	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
		
		tipoParceiroTextField.setText(parceiro.getTipoParceiro());
		nomeTextField.setText(parceiro.getNome());
		moradaTextField.setText(parceiro.getMorada());
		codigoPostalTextField.setText(parceiro.getCodigoPostal());
		localidadeTextField.setText(parceiro.getLocalidade());
		freguesiaTextField.setText(parceiro.getFreguesia());
		concelhoTextField.setText(parceiro.getConcelho());
		distritoTextField.setText(parceiro.getDistrito());
	}
	
	/**
	 * Retorna true se o utilizador clicar OH, caso contrário false
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}
	
	/**
	 * Chamado quando o utilizador clica OK
	 */
	@FXML
	private void handleOK() {
		if (isInputValid()) {
			parceiro.setTipoParceiro(tipoParceiroTextField.getText());
			parceiro.setNome(nomeTextField.getText());
			parceiro.setMorada(moradaTextField.getText());
			parceiro.setCodigoPostal(codigoPostalTextField.getText());
			parceiro.setLocalidade(localidadeTextField.getText());
			parceiro.setFreguesia(freguesiaTextField.getText());
			parceiro.setConcelho(concelhoTextField.getText());
			parceiro.setDistrito(distritoTextField.getText());
			
			okClicked= true;
			dialogStage.close();
		}
	}
	
	/**
	 * Chamado quando o utilizador clica Cancel
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	/**
	 * Valida a entrada do utilizador nos campos de texto
	 * 
	 * @return true se a entrada é válida
	 */
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (tipoParceiroTextField.getText() == null ||
				tipoParceiroTextField.getText().length()==0) {
			errorMessage += "Tipo de Parceiro inválido\n";
		}
		if (nomeTextField.getText() == null ||
				nomeTextField.getText().length()==0) {
			errorMessage += "Nome de Parceiro inválido\n";
		}
		
		if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostra a mensagem de erro.
            Alert alert = new Alert(AlertType.ERROR);
                      alert.setTitle("Campos Inválidos");
                      alert.setHeaderText("Por favor, corrija os campos inválidos");
                      alert.setContentText(errorMessage);
                alert.showAndWait();

            return false;
        }
	}
}
