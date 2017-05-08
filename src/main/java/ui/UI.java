package ui;

import helper.Messages;
import items.Book;

public class UI {

	private static final String OPTIONS = ""
			+ "Please, select the desired option typing its number as follow: \n"
			+ "\n"
			+ "To register a new item, type '1' \n"
			+ "To update a new item already registered, type '2' "
			+ "To check out an item, type '3' \n"
			+ "To return an item, type '4' \n"
			+ "To list all borrowed items or by type, type '5' \n"
			+ "To list all not borrowed items or by type, type '6' \n"
			+ "To search for an item, type '7'\n\n\n";

	public UI() {
		System.out.println("██   ██ █████     ██████ ██    ██  ██████ ██████ ███████  ███     ████");
		System.out.println("██   ██ ██  ██    █       ██  ██   █        ██   ██       ██ ██  ██ ██");
		System.out.println("██   ██ █████     ██████    ██     ██████   ██   ███████  ██   ██   ██");
		System.out.println("██   ██ ██  ██         █    ██          █   ██   ██       ██        ██");
		System.out.println("████ ██ █████     ██████    ██     ██████   ██   ███████  ██        ██");
	}
	

	public Book requestBookData(){

		Book book = new Book();

		for (String key : Messages.getMessages().keySet()) {
			book.requestData(Messages.getMessages().get(key), key);
		}
		
		return book;
	}
	
	public static void showOptions(){
		System.out.println(OPTIONS);
	}
	
	
	
	

}
