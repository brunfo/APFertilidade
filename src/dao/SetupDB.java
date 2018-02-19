package dao;

/**
 * Define a configura��o usada para acesso � base de dados
 * 
 */
public class SetupDB {
		  
	 /* Configura��o para o mySQL com JDBC tipo 4 private */  
	  String drv = "com.mysql.jdbc.Driver"; 
	  String serverName = "localhost"; 
	  String database = "apfertilidade"; 
	  private String url = "jdbc:mysql://"+serverName+"/"+database+"";
	  private String usr = "root"; 
	  private String pwd = "";
	 
	/**
	 * Retorna o nome do driver JDBC
	 * 
	 * @return nome do driver JDBC
	 */
	public String getDRV() {
		return drv;
	}

	/**
	 * Retorna a palavra passe do utilizador da base de dados
	 * 
	 * @return palavra passe do utilizador da base de dados
	 */
	public String getPWD() {
		return pwd;
	}

	/**
	 * Retorn o URL que permite aceder � base de dados
	 * 
	 * @return URL para acesso � base de dados
	 */
	public String getURL() {
		return url;
	}

	/**
	 * Retorna o nome do utilizador da base de dados
	 * 
	 * @return Nome do utilizador da base de dados
	 */
	public String getUSR() {
		return usr;
	}

	/**
	 * Altera o nome do driver JDBC
	 * 
	 * @param str
	 *            Novo driver JDBDC
	 */
	public void setDRV(final String str) {
		if (str != null)
			drv = str;
	}

	/**
	 * Altera a palavra passe do utilizador da base de dados
	 * 
	 * @param str
	 *            Palavra passe do utilzador da base de dados
	 */
	public void setPWD(final String str) {
		if (str != null)
			pwd = str;
	}

	/**
	 * Altera o URL que permite aceder � base de dados
	 * 
	 * @param str
	 *            Novo URL JDBC
	 */
	public void setURL(final String str) {
		if (str != null)
			url = str;
	}

	/**
	 * Altera o nome do utilizador da base de dados
	 * 
	 * @param str
	 *            Nome do utilizador da base de dados
	 */
	public void setUSR(final String str) {
		if (str != null)
			usr = str;
	}
}
