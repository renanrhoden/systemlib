package items;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import db.LibraryDB;


public class LibraryItem {

	private static final String ITEM_RETURNED_SUCCESSFULLY = "Item returned successfully!!\n";
	private String barcode;
	private String name;
	private int numberOfPages;
	private boolean available;

	private Scanner sc = new Scanner(System.in);

	public LibraryItem(){
		this.barcode = "";
	}

	public LibraryItem(String barcode, String name, int numberOfPages, boolean available) {
		super();
		this.barcode = barcode;
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.available = available;
	}

	public boolean returnItem(String type, String barcode){
		switch(type.toLowerCase()){
		case "book":
			Book book = new Book();
			book.setBarCode(barcode);
			LibraryDB.updateItem(book, "available", "1");
			break;
		case "megazine":
			Megazine megazine = new Megazine();
			megazine.setBarCode(barcode);
			LibraryDB.updateItem(megazine, "available", "1");
			break;
		case "scientific article":
			ScientificArticle article = new ScientificArticle();
			article.setBarCode(barcode);
			LibraryDB.updateItem(article, "available", "1");
		default: return false;

		}
		System.out.println(ITEM_RETURNED_SUCCESSFULLY);
		return true;
	}
	
	public LibraryItem search(String type, String barcode){

		switch(type.toLowerCase()){
		case "book":
			return LibraryDB.getBook(barcode);

		case "megazine":
			return LibraryDB.getMegazine(barcode);

		case "scientific article":
			return LibraryDB.getArticle(barcode);
		default: return new LibraryItem();

		}

	}

	public boolean checkOut(String type, String barcode){
		
		switch(type.toLowerCase()){
		case "book":
			Book book = new Book();
			book.setBarCode(barcode);
			LibraryDB.updateItem(book, "available", "0");
			break;
		case "megazine":
			Megazine megazine = new Megazine();
			megazine.setBarCode(barcode);
			LibraryDB.updateItem(megazine, "available", "0");
			break;
		case "scientific article":
			ScientificArticle article = new ScientificArticle();
			article.setBarCode(barcode);
			LibraryDB.updateItem(article, "available", "0");
		default: return false;

		}
		System.out.println("Item checked out succesfully");
		return true;
	}

	public boolean setAttributes(String field, String userData){
		switch(field){

		case "barcode":
			if ( isPatterned(userData) ){
				setBarCode(userData);
				return true;
			} else return false;

		case "name":
			setName(userData);
			return true;

		case "numberOfPages":
			if (StringUtils.isNumeric(userData)){
				setNumberOfPages(Integer.parseInt(userData));
				return true;
			} else return false;

		case "available":
			if (setAvailability(userData))
				return true;
			else return false;

		default: return false;
		}
	}


	public boolean isPatterned(String userData) {
		return StringUtils.isNumeric(userData) && userData.length() == 8;
	}


	private boolean setAvailability(String userData) {
		if (userData.equalsIgnoreCase("y")){
			setAvailable(true);
			return true;
		} else if(userData.equalsIgnoreCase("n")){
			setAvailable(false);
			return true;
		} else return false;
	}


	protected String getInputFromConsole() {
		String input;
		input = sc.nextLine();
		return input;
	}

	public void showRequestMessage(String message){
		System.out.println(message);
	}


	public String getBarcode() {
		return barcode;
	}

	public void setBarCode(String barCode) {
		this.barcode = barCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public boolean isAvailable() {
		return available;
	}

	public int isAvailable(boolean toInt) {
		if (isAvailable()){
			return 1;
		} else return 0;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}


	@Override
	public String toString() {
		return "barcode: " + barcode + ", \n"
				+ "name: " + name + ", \n"
				+ "numberOfPages: " + numberOfPages + ", \n"
				+ "available: " + available + "\n\n";

	}



}
