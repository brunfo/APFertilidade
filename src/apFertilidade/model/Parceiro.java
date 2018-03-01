package apFertilidade.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Parceiro {
	private StringProperty tipoParceiro;
	private final IntegerProperty idParceiro;
	private StringProperty nome;
	private StringProperty morada;
	private StringProperty codigoPostal;
	private StringProperty localidade;
	private StringProperty freguesia;
	private StringProperty concelho;
	private StringProperty distrito;
	private ObservableList<Contato> contatos=FXCollections.observableArrayList();
	private ObservableList<String> beneficios=FXCollections.observableArrayList();

	
	/**
	 * Contrutor nulo
	 */
	public Parceiro() {
		this(null, null,null, null, null, null, null, null, null,null);
	}
	
	/**
	 * Construtor padrão
	 * 
	 * @param idParceiro
	 * @param nome
	 * @param beneficios 
	 */
	public Parceiro( String tipoParceiro, String nome, String morada,
			String codigoPostal, String localidade, String freguesia,
			String concelho, String distrito, ObservableList<Contato> contatos,
			ObservableList<String> beneficios) {
		
		this.idParceiro = new SimpleIntegerProperty(getNewIdParceiro());
		this.tipoParceiro = new SimpleStringProperty(tipoParceiro);
		this.nome = new SimpleStringProperty(nome);
		this.morada = new SimpleStringProperty(morada); 
		this.codigoPostal = new SimpleStringProperty(codigoPostal);
		this.localidade = new SimpleStringProperty(localidade);
		this.freguesia = new SimpleStringProperty(freguesia);
		this.concelho = new SimpleStringProperty(concelho);
		this.distrito = new SimpleStringProperty(distrito);
		this.contatos= contatos;
		this.beneficios= beneficios;
	}

	private int getNewIdParceiro() {
		// TODO Verificar na base dados qual é o ultimo id
		return 0;
	}

	/**
	 * @return the tipoParceiro
	 */
	public String getTipoParceiro() {
		return tipoParceiro.get();
	}

	/**
	 * @param tipoParceiro the tipoParceiro to set
	 */
	public void setTipoParceiro(String tipoParceiro) {
		this.tipoParceiro.set(tipoParceiro);
	}
	
	/**
	 * 
	 * @return StringProperty - tipoParceiro
	 */
    public StringProperty tipoParceiroProperty() {
        return tipoParceiro;
    }
    
	/**
	 * @return the idParceiro
	 */
	public int getIdParceiro() {
		return idParceiro.get();
	}

	/**
	 * @param idParceiro the idParceiro to set
	 */
	public void setIdParceiro(int idParceiro) {
		this.idParceiro.set(idParceiro);
	}
	
	/**
	 * 
	 * @return IntegerProperty - idParceiro
	 */
    public IntegerProperty idParceiroProperty() {
        return idParceiro;
    }

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome.get();
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome.set(nome);
	}

	/**
	 * 
	 * @return StringProperty - nome
	 */
    public StringProperty nomeProperty() {
        return nome;
    }
    
	/**
	 * @return the morada
	 */
	public String getMorada() {
		return morada.get();
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		this.morada.set(morada); 
	}
	
	/**
	 * 
	 * @return StringProperty - morada
	 */
    public StringProperty moradaProperty() {
        return morada;
    }

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal.get();
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal.set(codigoPostal);
	}

	/**
	 * 
	 * @return StringProperty - codigoPostal
	 */
    public StringProperty codigoPostalProperty() {
        return codigoPostal;
    }
    
	/**
	 * @return the localidade
	 */
	public String getLocalidade() {
		return localidade.get();
	}

	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade.set(localidade);
	}
	
	/**
	 * 
	 * @return StringProperty - localidade
	 */
    public StringProperty localidadeProperty() {
        return localidade;
    }

	/**
	 * @return the freguesia
	 */
	public String getFreguesia() {
		return freguesia.get();
	}

	/**
	 * @param freguesia the freguesia to set
	 */
	public void setFreguesia(String freguesia) {
		this.freguesia.set(freguesia);
	}
	
	/**
	 * 
	 * @return StringProperty - freguesia
	 */
    public StringProperty freguesiaProperty() {
        return freguesia;
    }
	
	/**
	 * @return the concelho
	 */
	public String getConcelho() {
		return concelho.get();
	}
	
	/**
	 * 
	 * @return StringProperty - concelho
	 */
    public StringProperty concelhoProperty() {
        return concelho;
    }

	/**
	 * @param concelho the concelho to set
	 */
	public void setConcelho(String concelho) {
		this.concelho.set(concelho);
	}

	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito.get();
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito.set(distrito);
	}
	
	/**
	 * 
	 * @return StringProperty - distrito
	 */
    public StringProperty distritoProperty() {
        return distrito;
    }
    
	/**
	 * Retorna os dados como uma observable list de Contatos
	 * 
	 * @return
	 */
	public ObservableList<Contato> getContatos() {
		return contatos;
	}
	/**
	 * Retorna os dados como uma observable list de Beneficios
	 * 
	 * @return
	 */
	public ObservableList<String> getBeneficios() {
		return beneficios;
	}
}
