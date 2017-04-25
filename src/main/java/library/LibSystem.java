package library;

public class LibSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.showRequestMessage(Book.NAME_BOOK_REQUEST_MESSAGE);
		book.getDataFromUser("name");
		
		System.out.println(book.getName());

	}

}
