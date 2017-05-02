package db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.github.gchudnov.squel.*;

import library.Book;
import library.Megazine;
import library.ScientificArticle;

public class LibraryDB {
	private static Connection dBConnection;
	private static Statement stmt;

	public static boolean createBookTableIfNotExists(){
		try {
			dBConnection = connectToDB();
			System.out.println("Opened database successfully");
			stmt = dBConnection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS book " +
					"(id INTEGER PRIMARY KEY    NOT NULL," +
					" name           NVARCHAR  	NOT NULL, " + 
					" author         INT   	  	NOT NULL, " + 
					" barcode        NCHAR(8)	NOT NULL, " + 
					" numberOfPages  INT 				, " + 
					" available		 NCHAR		NOT NULL, " +
					" isbn			 NCHAR(13)	NOT NULL, " + 
					" edition		 INT				, " +
					" year			 INT				, " +
					" subject		 NVARCHAR			  " +
					")"; 
			stmt.executeUpdate(sql);
			
		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
			
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
					+ ")"; 
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

	public static boolean registerNewBook(Book book){

		try{
			String sql = 	"INSERT INTO book " +
					"(name, author, barcode, numberOfPages, available, isbn, edition, year, subject)" + 
					"VALUES ('" +
					book.getName() +		"', '" +
					book.getAuthor() +		"', '" +
					book.getBarcode() +		"', " +
					book.getNumberOfPages()+", " +
					book.isAvailable() +	", '" + 
					book.getISBN() +		"', " +
					book.getEdition() +		", " +
					book.getYear() +		", '" +
					book.getSubject() +		"'); ";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);

			return false;
		}

	}
	
	
	public static boolean registerNewScientificArticle(ScientificArticle article){
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
		} catch ( SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
		
		return true;
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
					+ ")"; 
			stmt.executeUpdate(sql);

		} catch ( SQLException | ClassNotFoundException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
			
		}
		System.out.println("Table created successfully");
		return true;
	}
	
	public static boolean registerNewMegazine(Megazine megazine){

		try{
			String sql = 	"INSERT INTO megazine " +
					"(name, barcode, numberOfPages, available, edition, editor)" + 
					"VALUES ('" +
					megazine.getName() +		"', '" +
					megazine.getBarcode() +		"', " +
					megazine.getNumberOfPages()+", " +
					megazine.isAvailable( true ) +	", " + 
					megazine.getEdition() +		", '" +
					megazine.getEditor() + 		"'" +
					"); ";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch ( SQLException e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);

			return false;
		}

	}
	
	public static void printTable(){
		try {
		      dBConnection.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = dBConnection.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM scientific_article;" );
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
