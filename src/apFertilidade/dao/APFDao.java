package apFertilidade.dao;

import java.sql.SQLException;
import java.util.List;

import apFertilidade.model.Parceiro;

public interface APFDao {
	//DB setup
	void loadDriver();
	void makeConnection();
	void createStatement();
	void closeAll();
	//Table management
	public void createTable();
	public void deleteTable(String table) throws SQLException;
	//Data management
	public List<Parceiro> getAllParceiros();
	public Parceiro getParceiroByID(int idParceiro);
	public void updateParceiro(Parceiro parceiro);
	public void deleteParceiro(Parceiro parceiro);
	public void addParceiro(Parceiro parceiro);

}
