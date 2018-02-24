package apFertilidade.model;

public class Contato {
	private int idContato;
	private String contato;
	private String tipoContato;
	
	/**Cria novo contacto
	 * 
	 * @param idContato id  do contato
	 * @param contato valor co contato
	 * @param tipoContato tipo de contato (tel, email, site, fax)
	 */
	public void addNew(int idContato, String contato, String tipoContato) {
		this.idContato = idContato;
		this.contato= contato;
		this.tipoContato= tipoContato;
	}
}
