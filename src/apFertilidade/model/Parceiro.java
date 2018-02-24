package apFertilidade.model;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Parceiro extends TipoParceiro {
	private int idParceiro;
	private String nome;
	private String morada;
	private String codigoPostal;
	private String localidade;
	private String freguesia;
	private String concelho;
	private String distrito;
	private TipoParceiro tipoParceiro;
	private Contato[] contatos;

	public Parceiro(int idParceiro, String nome) {
		this.idParceiro = idParceiro;
		this.nome = nome;
	}
	
	/**
	 * @return the idParceiro
	 */
	public int getIdParceiro() {
		return idParceiro;
	}

	/**
	 * @param idParceiro the idParceiro to set
	 */
	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the name
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		this.morada = morada;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	/**
	 * @param freguesia the freguesia to set
	 */
	public void setFreguesia(String freguesia) {
		this.freguesia = freguesia;
	}

	/**
	 * @param concelho the concelho to set
	 */
	public void setConcelho(String concelho) {
		this.concelho = concelho;
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/**
	 * @param tipoParceiro the tipoParceiro to set
	 */
	public void setTipoParceiro(TipoParceiro tipoParceiro) {
		this.tipoParceiro = tipoParceiro;
	}

	/**
	 * @param contatos the contatos to set
	 */
	public void setContatos(Contato[] contatos) {
		this.contatos = contatos;
	}

	public Parceiro getParceiro() {
		return this;
		
	}


}
