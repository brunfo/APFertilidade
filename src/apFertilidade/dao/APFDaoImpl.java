package apFertilidade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.regexp.internal.recompile;

import apFertilidade.model.Beneficios;
import apFertilidade.model.Contato;
import apFertilidade.model.Parceiro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class APFDaoImpl implements APFDao {

	Connection con;

	Statement stmt;

	ResultSet rs;
	// for how to set up data source nome see below.
	SetupDB cfg = new SetupDB();

	// list is working as a database

	public APFDaoImpl() {
		// step 1: load driver
		loadDriver();

		// step 3: establish connection
		makeConnection();

		// step 4: create a statement
		createStatement();

	}

	// ****************DB SETUP *************

	@Override
	public void loadDriver() {
		try {
			// step 2: Define connection URL
			Class.forName(cfg.getDRV());
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void makeConnection() {
		try {
			con = DriverManager.getConnection(cfg.getURL(), cfg.getUSR(), cfg.getPWD());
			System.out.println("Connected successfully to: " + cfg.getURL());
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("database connection: " + ex.getMessage());

		}

	}

	@Override
	public void createStatement() {
		try {

			stmt = con.createStatement();
		} catch (SQLException ex) {
			System.err.println("database statement: " + ex.getMessage());

		}
	}

	@Override
	public void closeAll() {
		try {
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("closeAll: " + ex.getMessage());
		}
	}

	// ****************TABLE MANAGEMENT *************
	@Override
	public void createTable() {

		String createString = "create table parceiros " + "(idParceiro INT, " + "nome VARCHAR(45), "
				+ "CONSTRAINT pk_students PRIMARY KEY (idParceiro))";
		try {

			// step 5: execute a query or update.
			try {
				deleteTable("parceiros");
				// new one
			} catch (SQLException ex) {
				System.err.println("DropTable: " + ex.getMessage());
			}
			stmt.executeUpdate(createString);

		} catch (SQLException ex) {
			System.err.println("CreateTable: " + ex.getMessage());
		}

	}

	/**
	 * Drops a table if exists.
	 * 
	 * @throws SQLException
	 */
	@Override
	public void deleteTable(String table) throws SQLException {
		stmt.execute("drop table " + table);

	}

	// ****************DB MANAGEMENT *************
	/**
	 * Busca todos os parceiros da base de dados
	 * 
	 * @return ObservableList<Parceiro>
	 */
	@Override
	public ObservableList<Parceiro> getAllParceiros() {
		ObservableList<Parceiro> parceiro = FXCollections.observableArrayList();
		try {
			String gdta = "SELECT * FROM parceiros";
			// busca os parceiros.
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				//busca contatos do parceiro
				ObservableList<Contato> contatos = getContatos(rs.getInt("idParceiro"));

				//busca beneficios do parceiro
				ObservableList<String> beneficios = getBeneficios(rs.getInt("idParceiro"));

				parceiro.add(new Parceiro(rs.getString("tipoParceiro"), 
						rs.getString("nome"), 
						rs.getString("morada"),
						rs.getString("codigoPostal"), 
						rs.getString("localidade"), 
						rs.getString("freguesia"),
						rs.getString("concelho"), 
						rs.getString("distrito"), 
						contatos,
						beneficios));
			}
		} catch (SQLException ex) {
			System.err.println("getAllParceiro: " + ex.getMessage());
		}
		return parceiro;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	private ObservableList<String> getBeneficios(int idParceiro) throws SQLException {
		ObservableList<String> beneficios = FXCollections.observableArrayList();
		ResultSet rsBeneficios;
		String getBeneficios = "SELECT * FROM beneficios WHERE  fk_idParceiro =" + idParceiro;
		rsBeneficios = con.createStatement().executeQuery(getBeneficios);
		while (rsBeneficios.next()) {
			beneficios.add(new String(rsBeneficios.getString("beneficios")));
		}
		return beneficios;
	}

	/**
	 * 
	 * @throws SQLException
	 * @retrun	
	 */
	private ObservableList<Contato> getContatos(int idParceiro) throws SQLException {
		ObservableList<Contato> contatos = FXCollections.observableArrayList();
		ResultSet rsContatos;
		String getContatos = "SELECT * FROM contatos WHERE  fk_idParceiro =" + idParceiro;
		rsContatos = con.createStatement().executeQuery(getContatos);
		while (rsContatos.next()) {
			contatos.add(new Contato(rsContatos.getInt("idContato"), 
					rsContatos.getString("contato"),
					rsContatos.getString("tipoContato")));
		}
		return contatos;
	}

	/**
	 * Insert a student in the database
	 * 
	 * @param parceiro
	 *            to insert
	 */
	@Override
	public void addParceiro(Parceiro parceiro) {

		try {
			stmt.executeUpdate("INSERT INTO parceiros " + "VALUES (" + parceiro.getIdParceiro() + "', '"
					+ parceiro.getNome() + "')");
			System.out.println("Parceiro: " + parceiro.getNome() + ", added to database");
		} catch (SQLException ex) {
			System.err.println("AddParceiro: " + ex.getMessage());
		}

	}

	/**
	 * Delete a student from database
	 * 
	 * @param parceiro
	 *            to delete
	 */
	@Override
	public void deleteParceiro(Parceiro parceiro) {
		try {
			stmt.executeUpdate("DELETE FROM parceiros WHERE `idParceiro`=" + parceiro.getIdParceiro());
			System.out.println("Parceiro: ID " + parceiro.getIdParceiro() + ", deleted from database");
		} catch (SQLException ex) {
			System.err.println("DeleteParceiro: " + ex.getMessage());
		}
	}

	/**
	 * Gets a student by id from database.
	 * 
	 * @return Parceiro or null
	 */
	@Override
	public Parceiro getParceiroByID(int idParceiro) {
		try {
			String gdta = "SELECT * FROM parceiros where idParceiro=" + idParceiro;
			rs = stmt.executeQuery(gdta);
			while (rs.next()) {
				return new Parceiro(rs.getString("tipoParceiro"), 
						rs.getString("nome"), 
						rs.getString("morada"),
						rs.getString("codigoPostal"), 
						rs.getString("localidade"), 
						rs.getString("freguesia"),
						rs.getString("concelho"), 
						rs.getString("distrito"), 
						null, 
						null);
			}
		} catch (SQLException ex) {
			System.err.println("GetParceiroByID: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public void updateParceiro(Parceiro parceiro) {
		try {
			stmt.executeUpdate("UPDATE patceiros SET nome= '" + parceiro.getNome() + "' WHERE idParceiro="
					+ parceiro.getIdParceiro());
			System.out.println("Parceiro: ID " + parceiro.getIdParceiro() + ", updated in database" + " new nome: "
					+ parceiro.getNome());
		} catch (SQLException ex) {
			System.err.println("UpdateParceiro: " + ex.getMessage());
		}
	}
}
