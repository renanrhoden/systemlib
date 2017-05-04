package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.github.gchudnov.squel.*;

import items.Book;
import items.Megazine;
import items.ScientificArticle;

public class LibraryDB {
	private static Connection dBConnection;
	private static Statement stmt;

	public static boolean createBookTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			System.out.println("Opened database successfully");
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
			if ( e.getMessage().equals(e.getMessage())){
				System.out.println("J� h� um registro com esse c�digo de barras, por favor, insira outro");
			} else {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
			}
			
		}
		System.out.println("Table created successfully");
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
					" barcode        NCHAR(8)	NOT NULL, " + 
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
		System.out.println("Table created successfully");
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
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			if ( repeatedBarcode(e)){
				System.out.println("J� h� um registro com esse c�digo de barras, por favor, insira outro");
				
			} else {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			
			}
			return false;
		}

	}

	private static boolean repeatedBarcode(SQLException e) {
		return e.getMessage().equals("column barcode is not unique");
	}
	
	public static boolean registerNewItem(Megazine megazine){

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
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);

			return false;
		}

	}
	
	
	public static boolean registerNewItem(ScientificArticle article){
		try{
			QueryBuilder query = Squel.insert()
					.into("Scientific_Article")
					.set("name", article.getName())
					.set("barcode", article.getBarcode())
					.set("numberOfPages", article.getNumberOfPages())
					.set("author", article.getAuthor())
					.set("available", article.isAvailable(true));

			stmt.executeUpdate(query.toString());
			System.out.println(query.toString());
			return true;
			
		} catch ( SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
	}

	
	public static boolean createScientificArticleTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			System.out.println("Opened database successfully");
			stmt = dBConnection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Scientific_Article " +
					"(id INTEGER PRIMARY KEY    NOT NULL," +
					" name           NVARCHAR  	NOT NULL, " + 
					" barcode        NCHAR(8)	NOT NULL, " + 
					" numberOfPages  INT 				, " + 
					" available		 BOOLEAN	NOT NULL, " +
					" author		 NVARCHAR			 " 
					+ ");"; 
			stmt.executeUpdate(sql);

		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
			
		}
		System.out.println("Table created successfully");
		return true;
	}
	

	
	public static void printTable(){
		try {
		      dBConnection.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = dBConnection.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM book;" );
		      while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String  name = rs.getString("name");

		         System.out.println( "ID = " + id );
		         System.out.println( "NAME = " + name );

		      }
		      rs.close();
		      close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
	}

}