package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class APFTest {
    static Connection con;

    static Statement stmt;

    static ResultSet rs;
    // for how to set up data source nome see below.
    static SetupDB cfg = new SetupDB();

    /**
     * @param args
     *            unused
     */
    public static void main(String[] args) {

	// step 1: load driver
	loadDriver();

	// step 3: establish connection
	makeConnection();

	// create a table
	createTable();

	// insert data
	insertData();

	// retrieve data
	retrieveData();
	
	// use precompiled statement to update data
	usePreparedStatement();

	// retrieve data
	retrieveData();

	// close all resources
	closeAll();
    }

    // load a driver
    static void loadDriver() {
	try {
	    // step 2: Define connection URL
	    Class.forName(cfg.getDRV());
	} catch (java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
    }

    // make a connection step 3: establish connection
    static void makeConnection() {
	try {
	    con = DriverManager.getConnection(cfg.getURL(), cfg.getUSR(), cfg.getPWD());
	    System.out.println("Connected successfully to: " + cfg.getURL());
	} catch (SQLException ex) {
	    ex.printStackTrace();
	    System.err.println("database connection: " + ex.getMessage());

	}
    }

    // create a table
    static void createTable() {

	String createString = "create table students " + "(idStudent INT, " + "nome VARCHAR(45), " +
	"CONSTRAINT pk_students PRIMARY KEY (idStudent))";
	try {
	    // step 4: create a statement
	    stmt = con.createStatement();
	    // step 5: execute a query or update.
	    try {
		stmt.execute("drop table students");// if exists, drop it, get
		// new one
	    } catch (SQLException ex) {
		System.err.println("DropTable: " + ex.getMessage());
	    }
	    stmt.executeUpdate(createString);

	} catch (SQLException ex) {
	    System.err.println("CreateTable: " + ex.getMessage());
	}
    }

    // insert data to table COFFEES
    static void insertData() {
	try {
	    stmt.executeUpdate("INSERT INTO students " + "VALUES (1, 'Bruno')");
	    stmt.executeUpdate("INSERT INTO students " + "VALUES (2, 'Rafael')");
	    stmt.executeUpdate("INSERT INTO students " + "VALUES (3, 'Francisco')");
	   
	} catch (SQLException ex) {
	    System.err.println("InsertData: " + ex.getMessage());
	}
    }

    // use PreparedStatement to precompile sql statement
    static void usePreparedStatement() {
	try {
	    PreparedStatement updateStudents;
	    String updateString = "update students " + "set nome = ? where idStudent like ?";
	    updateStudents = con.prepareStatement(updateString);
	    int[] strudentsID = { 2, 1, 3 };
	    String[] students = { "Bruno", "João", "Miguel" };
	    int len = students.length;
	    for (int i = 0; i < len; i++) {
	    	updateStudents.setString(1, students[i]);
	    	updateStudents.setInt(2, strudentsID[i]);
		updateStudents.executeUpdate();
	    }
	} catch (SQLException ex) {
	    System.err.println("UsePreparedStatement: " + ex.getMessage());
	}
    }

    // retrieve data from table Students
    static void retrieveData() {
	try {
	    String gdta = "SELECT * FROM students";
	    // step 6: process the results.
	    System.out.println("\r\nStudents:\r\n");
	    rs = stmt.executeQuery(gdta);
	    while (rs.next()) {
		int idStudent = rs.getInt("idStudent");
		String nome = rs.getString("nome");
		System.out.println(idStudent + " : " + nome);
	    }
	    System.out.println("\r\nFim.\r\n");
	} catch (SQLException ex) {
	    System.err.println("RetrieveData: " + ex.getMessage());
	}
    }

    // close statement and connection
    // step 7: close connection, etc.
    static void closeAll() {
	try {
	    stmt.close();
	    con.close();
	} catch (SQLException ex) {
	    System.err.println("closeAll: " + ex.getMessage());
	}
    }
}
