package apFertilidade.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contato {
	private int idContato;
	private StringProperty contato;
	private StringProperty tipoContato;
	
	/**
	 * Contrutor nulo
	 */
	public Contato() {
		this(0, null, null);
	}
	
	/**Construtor novo contacto
	 * 
	 * @param idContato id  do contato
	 * @param contato valor co contato
	 * @param tipoContato tipo de contato (tel, email, site, fax)
	 */
	public Contato(int idContato, String contato, String tipoContato) {
		this.idContato = idContato;
		this.contato= new SimpleStringProperty(contato);
		this.tipoContato= new SimpleStringProperty(tipoContato);
	}
	
	/**
	 * @return the tipoContato
	 */
	public String getTipoContato() {
		return tipoContato.get();
	}

	/**
	 * @param tipoContato the tipoContato to set
	 */
	public void setTipoContato(String tipoContato) {
		this.tipoContato.set(tipoContato);
	}
	
	/**
	 * 
	 * @return StringProperty - tipoContato
	 */
    public StringProperty tipoContatoProperty() {
        return tipoContato;
    }
    
	/**
	 * @return the contato
	 */
	public String getContato() {
		return contato.get();
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato.set(contato);
	}
	
	/**
	 * 
	 * @return StringProperty - contato
	 */
    public StringProperty contatoProperty() {
        return contato;
    }
}
