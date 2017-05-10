package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.gchudnov.squel.*;

import items.Book;
import items.Megazine;
import items.ScientificArticle;

public class LibraryDB {
	private static final String BARCODE_NOT_UNIQUE = "This barcode is already registered";
	private static Connection dBConnection;
	private static Statement stmt;

	public static void deleteTable(String table){
		try {
			dBConnection = connectToDB();
			System.out.println("Opened database successfully");
			stmt = dBConnection.createStatement();
			stmt.executeUpdate("DROP TABLE " + table);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean createBookTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			stmt = dBConnection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS book " +
					"(id INTEGER PRIMARY KEY    NOT NULL, " +
					" name           NVARCHAR  	NOT NULL, " + 
					" author         INT   	  	NOT NULL, " + 
					" barcode        NCHAR(8)	UNIQUE NOT NULL, " + 
					" numberOfPages  INT 				, " + 
					" available		 NCHAR		NOT NULL, " +
					" isbn			 NCHAR(13)	NOT NULL, " + 
					" edition		 INT				, " +
					" year			 INT				, " +
					" subject		 NVARCHAR			  " +
					");"; 
			stmt.executeUpdate(sql);

		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
		return true;
	}

	public static boolean createMegazineTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			System.out.println("Opened database successfully");
			stmt = dBConnection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS megazine " +
					"(id INTEGER PRIMARY KEY    NOT NULL," +
					" name           NVARCHAR  	NOT NULL, " + 
					" barcode        NCHAR(8)	UNIQUE NOT NULL, " + 
					" numberOfPages  INT 				, " + 
					" available		 BOOLEAN	NOT NULL, " +
					" edition		 INT				, " +
					" editor		 NVARCHAR			 "
					+ ");"; 
			stmt.executeUpdate(sql);

		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;

		}
		return true;
	}

	public static boolean createScientificArticleTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			stmt = dBConnection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Scientific_Article " +
					"(id INTEGER PRIMARY KEY    NOT NULL," +
					" name           NVARCHAR  	NOT NULL, " + 
					" barcode        NCHAR(8)	UNIQUE NOT NULL, " + 
					" numberOfPages  INT 				, " + 
					" available		 BOOLEAN	NOT NULL, " +
					" author		 NVARCHAR			 " 
					+ ");"; 
			stmt.executeUpdate(sql);

		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;

		}
		return true;
	}

	public static void close() throws SQLException {
		stmt.close();
		dBConnection.close();
	}

	private static Connection connectToDB() throws ClassNotFoundException, SQLException {
		Connection dBConnection;
		Class.forName("org.sqlite.JDBC");
		dBConnection = DriverManager.getConnection("jdbc:sqlite:systemLibDB.db");
		return dBConnection;
	}



	public static boolean registerNewItem(Book book){

		createBookTableIfNotExists();
		try{
			QueryBuilder query = Squel.insert()
					.into("book")
					.set("name", book.getName())
					.set("author", book.getAuthor())
					.set("barcode", book.getBarcode())
					.set("numberOfPages", book.getNumberOfPages())
					.set("available", book.isAvailable(true))
					.set("isbn", book.getISBN())
					.set("edition", book.getEdition())
					.set("year", book.getYear())
					.set("subject", book.getSubject());
			String sql = query.toString();
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			if ( repeatedBarcode(e)){
				System.out.println(BARCODE_NOT_UNIQUE);

			} else {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );

			}
			return false;
		}

	}

	public static boolean registerNewItem(Megazine megazine){
		createMegazineTableIfNotExists();

		try{			
			QueryBuilder query = Squel.insert()
					.into("megazine")
					.set("name", megazine.getName())
					.set("barcode", megazine.getBarcode())
					.set("numberOfPages", megazine.getNumberOfPages())
					.set("available", megazine.isAvailable(true))
					.set("edition", megazine.getEdition())
					.set("editor", megazine.getEditor());
			String sql = query.toString();
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			if ( repeatedBarcode(e)){
				System.out.println(BARCODE_NOT_UNIQUE);

			} else {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );

			}
			return false;
		}

	}


	public static boolean registerNewItem(ScientificArticle article){
		createScientificArticleTableIfNotExists();
		try{
			QueryBuilder query = Squel.insert()
					.into("Scientific_Article")
					.set("name", article.getName())
					.set("barcode", article.getBarcode())
					.set("numberOfPages", article.getNumberOfPages())
					.set("author", article.getAuthor())
					.set("available", article.isAvailable(true));

			stmt.executeUpdate(query.toString());
			return true;

		} catch ( SQLException e) {
			System.out.println(BARCODE_NOT_UNIQUE);
			return false;
		}
	}

	private static boolean repeatedBarcode(SQLException e) {
		return e.getMessage().equals("column barcode is not unique");
	}


	public static void printTable(){
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM book;" );

			while ( rs.next()) {
				int id = rs.getInt("id");

				String  name = rs.getString("author");

				System.out.println( "ID = " + id );
				System.out.println( "NAME = " + name );

			}
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}

	public static ResultSet showColumnsNames(String table) throws SQLException {
		dBConnection.setAutoCommit(false);
		stmt = dBConnection.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM " + table + ";" );
		ResultSetMetaData rsmd = rs.getMetaData();

		for (int i = 1; i <= rsmd.getColumnCount(); i++ ){
			System.out.println(rsmd.getColumnName(i));
		}
		return rs;
	}

	public static ArrayList<String> getColumnsNames(String table) throws SQLException {
		ArrayList<String> columnsNames = new ArrayList<>();
		dBConnection.setAutoCommit(false);
		stmt = dBConnection.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM " + table + ";" );
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++ ){
			columnsNames.add(rsmd.getColumnName(i));
		}
		return columnsNames;
	}

	public static boolean updateItem (Book book, String column, String newValue){
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			QueryBuilder query = Squel.update()
					.table("book")
					.set(column, newValue)
					.where("barcode=" + book.getBarcode() );
			stmt.executeUpdate( query.toString() );
			dBConnection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean updateItem (Megazine megazine, String column, String newValue){
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			QueryBuilder query = Squel.update()
					.table("megazine")
					.set(column, newValue)
					.where("barcode=" + megazine.getBarcode() );
			stmt.executeUpdate( query.toString() );
			dBConnection.commit();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean updateItem (ScientificArticle article, String column, String newValue){
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			QueryBuilder query = Squel.update()
					.table("ScientificArticle")
					.set(column, newValue)
					.where("barcode=" + article.getBarcode() );
			stmt.executeUpdate( query.toString() );
			dBConnection.commit();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Book getBook(String barcode){
		Book book = new Book();
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM book WHERE barcode=" + barcode + ";");
			
			if(rs.next())
				book = new Book(rs.getString("barcode"), rs.getString("name"), rs.getInt("numberOfPages"),
						rs.getBoolean("available"), rs.getString("isbn"), rs.getString("author"), rs.getInt("edition"),
						rs.getInt("year"), rs.getString("subject"));
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return book;
	}


	public static Megazine getMegazine(String barcode){
		Megazine megazine = new Megazine();
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM book WHERE barcode=" + barcode + ";");

			megazine = new Megazine(
					rs.getString("barcode"), 
					rs.getString("name"),
					rs.getInt("numberOfPages"),
					rs.getBoolean("available"),
					rs.getString("editor"),
					rs.getInt("edition"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return megazine;
	}

	public static ScientificArticle getArticle(String barcode){
		ScientificArticle article = new ScientificArticle();
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM book WHERE barcode=" + barcode + ";");

			article = new ScientificArticle(
					rs.getString("barcode"), 
					rs.getString("name"),
					rs.getInt("numberOfPages"),
					rs.getBoolean("available"),
					rs.getString("author"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return article;
	}


	public static boolean listBorrowedItems(boolean available){
		try {
			dBConnection = connectToDB();
			dBConnection.setAutoCommit(false);
			stmt = dBConnection.createStatement();
			int status;
			if (available)
				status = 1;
			else status = 0;
			ResultSet rs = stmt.executeQuery( "SELECT * FROM book WHERE available = " + status + ";");
			while (rs.next()) {
				Book book = new Book(rs.getString("barcode"), rs.getString("name"), rs.getInt("numberOfPages"),
						rs.getBoolean("available"), rs.getString("isbn"), rs.getString("author"), rs.getInt("edition"),
						rs.getInt("year"), rs.getString("subject"));
				System.out.println(book.toString());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
