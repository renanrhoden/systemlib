package library;


import java.util.Scanner;

public class BookAdder {
	
	private static final String BARCODE_REQUEST_MESSAGE = "Insert the bar code here:";
	private static final String NAME_BOOK_REQUEST_MESSAGE = "Type the name of the book:";
	private static final String ISBN_REQUEST_MESSAGE = "Type the ISBN of the book:";
	private static final String AUTHOR_REQUEST_MESSAGE = "Type here the name of the author:";
	private static final String EDITION_REQUEST_MESSAGE = "Type the edition: ";
	private static final String YEAR_REQUEST_MESSAGE = "Type the year of the book:";
	private static final String SUBJECT_REQUEST_MESSAGE = "Type the subject of the book:";
	private static final String NUMBER_PAGES_REQUEST_MESSAGE = "Type the number of pages that book has:";
	private static final String AVAILABILITY_REQUEST_MESSAGE = "Would you like to set the book as available? Type 'y' or 'n'";
	Scanner sc = new Scanner(System.in);
	Book book = new Book();
	
	public void requestBookData(){
		System.out.println("Please, type the data as requested:");
		
		requestNameOfTheBook();
		
		requestBarcode();
		
		requestISBN();
		
		requestAuthor();
		
		requestEdition();
		
		requestYear();

		requestSubject();

		requestNumberOfPages();
		
		requestAvailability();
		sc.close();
	}

	private void requestAvailability() {
		String field;
		do {
			showRequestMessage(AVAILABILITY_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestSubject() {
		String field;
		do {
			showRequestMessage(SUBJECT_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestYear() {
		String field;
		do {
			showRequestMessage(YEAR_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestEdition() {
		String field;
		do {
			showRequestMessage(EDITION_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestAuthor() {
		String field;
		do {
			showRequestMessage(AUTHOR_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestISBN() {
		String field;
		do {
			showRequestMessage(ISBN_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setISBN(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestBarcode() {
		String field = null;
		do {
			showRequestMessage(BARCODE_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setBarCode(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestNameOfTheBook() {
		String field = null;
		do {
			showRequestMessage(NAME_BOOK_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}

	private void requestNumberOfPages() {
		String field;
		do {
			showRequestMessage(NUMBER_PAGES_REQUEST_MESSAGE);
			field = getRequestedData();
			if (!field.isEmpty()){
				book.setName(field);
				break;
			}
		} while (field.isEmpty());
	}
	
	public void showRequestMessage(String message){
		System.out.println(message);
	}
	
	private String getRequestedData(){
		String input = getInputFromConsole();
		return input;
	}
	
	public void requestData(String message){
		showRequestMessage(message);
	}


	private String getInputFromConsole() {
		String input;
		input = sc.nextLine();
		return input;
	}
}
