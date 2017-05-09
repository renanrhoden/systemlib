package helper;

import java.util.LinkedHashMap;

public class Messages {
	
	public static LinkedHashMap<String, String> messages;
	
	public static LinkedHashMap<String, String> getBookMessages(){
		messages = new LinkedHashMap<>();
		messages.put("barcode", "Insert the bar code here:");
		messages.put("name", "Type the name of the book:");
		messages.put("author", "Type here the name of the author:");
		messages.put("ISBN", "Type the ISBN of the book:");
		messages.put("edition", "Type the edition:");
		messages.put("year", "Type the year of the book:");
		messages.put("numberOfPages", "Type the number of pages the book has:");
		messages.put("subject", "Type the subject of the book:");
		messages.put("available", "Would you like to set the book as available? Type 'y' or 'n'");

		return messages;
	}
	
	public static LinkedHashMap<String, String> getMegazineMessages(){
		messages = new LinkedHashMap<>();
		messages.put("barcode", "Insert the bar code here:");
		messages.put("name", "Type the name of the book:");
		messages.put("editor", "Type here the name of the editor:");
		messages.put("edition", "Type the edition:");
		messages.put("numberOfPages", "Type the number of pages the book has:");
		messages.put("available", "Would you like to set the book as available? Type 'y' or 'n'");

		return messages;
	}
	
	public static LinkedHashMap<String, String> getScientificArticleMessages(){
		messages = new LinkedHashMap<>();
		messages.put("barcode", "Insert the bar code here:");
		messages.put("name", "Type the name of the book:");
		messages.put("author", "Type here the name of the author:");
		messages.put("numberOfPages", "Type the number of pages the book has:");
		messages.put("available", "Would you like to set the book as available? Type 'y' or 'n'");

		return messages;
	}
}
