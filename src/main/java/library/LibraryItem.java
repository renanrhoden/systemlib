package library;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class LibraryItem {


	private String barCode;
	private String name;
	private int numberOfPages;
	private boolean available;


	protected static final String BARCODE_REQUEST_MESSAGE = "Insert the bar code here:";
	protected static final String NAME_BOOK_REQUEST_MESSAGE = "Type the name of the book:";
	protected static final String NUMBER_PAGES_REQUEST_MESSAGE = "Type the number of pages that book has:";
	protected static final String AVAILABILITY_REQUEST_MESSAGE = "Would you like to set the book as available? Type 'y' or 'n'";
	protected Scanner sc = new Scanner(System.in);


	protected boolean setAttributes(String field, String userData){
		switch(field){
		case "barCode":
			setBarCode(userData);
			return true;
		case "name":
			setName(userData);
			return true;
		case "numberOfPages":
			if (StringUtils.isNumeric(userData)){
				setNumberOfPages(Integer.parseInt(userData));
				return true;
			} else {
				return false;
			}
		case "available":
			if (userSetAvailability(userData))
				return true;
			else return false;
		}
		return false;
	}


	private boolean userSetAvailability(String userData) {
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


	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public void setAvailable(boolean available) {
		this.available = available;
	}



}
