package ui;

import helper.Messages;
import items.Book;

public class LibUserInterface {

	public LibUserInterface() {
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
	
	public void showOptions(){
		System.out.println();
	}
	
	

}
