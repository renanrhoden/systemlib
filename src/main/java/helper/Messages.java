package helper;

import java.util.LinkedHashMap;

public class Messages {
	
	public static LinkedHashMap<String, String> registerNewBook;
	
	public static LinkedHashMap<String, String> getMessages(){
		registerNewBook = new LinkedHashMap<>();
		registerNewBook.put("barcode", "Insert the bar code here:");
		registerNewBook.put("name", "Type the name of the book:");
		registerNewBook.put("author", "Type here the name of the author:");
		registerNewBook.put("ISBN", "Type the ISBN of the book:");
		registerNewBook.put("edition", "Type the edition:");
		registerNewBook.put("year", "Type the year of the book:");
		registerNewBook.put("numberOfPages", "Type the number of pages the book has:");
		registerNewBook.put("subject", "Type the subject of the book:");
		registerNewBook.put("available", "Would you like to set the book as available? Type 'y' or 'n'");

		return registerNewBook;
	}
}
