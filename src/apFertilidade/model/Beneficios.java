package apFertilidade.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Beneficios {
	private StringProperty beneficio;

	public Beneficios() {
		this(null);
	}
	
	public Beneficios(String beneficio) {
		this.beneficio = new SimpleStringProperty(beneficio);
	}
	
	/**
	 * @return the beneficio
	 */
	public String getBeneficio() {
		return beneficio.get();
	}

	/**
	 * @param beneficio the beneficio to set
	 */
	public void setBeneficio(String beneficio) {
		this.beneficio.set(beneficio);
	}
	
	/**
	 * 
	 * @return StringProperty - beneficio
	 */
    public StringProperty beneficioProperty() {
        return beneficio;
    }

}
