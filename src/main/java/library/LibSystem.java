package library;

import helper.Messages;

public class LibSystem {

	public static void main(String[] args) {
		
		Book book = new Book();

		for (String key : Messages.getMessages().keySet()){
			book.requestData(Messages.getMessages().get(key), key);
		}
		
		System.out.println(book);

	}

}
