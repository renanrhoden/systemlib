package items;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class LibraryItem {

	private String barcode;
	private String name;
	private int numberOfPages;
	private boolean available;

	private Scanner sc = new Scanner(System.in);


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
			if (userSetAvailability(userData))
				return true;
			else return false;
			
		default: return false;
		}
	}


	private boolean isPatterned(String userData) {
		return StringUtils.isNumeric(userData) && userData.length() == 8;
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
		return "LibraryItem [barcode=" + barcode + ", name=" + name + ", numberOfPages=" + numberOfPages
				+ ", available=" + available + "]";
	}



}
