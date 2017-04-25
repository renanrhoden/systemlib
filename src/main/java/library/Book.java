package library;

import org.apache.commons.lang3.StringUtils;

public class Book extends LibraryItem{


	private String ISBN;
	private String author;
	private int edition;
	private int year;
	private String subject;


	public void requestData( String message, String field ){
		boolean success;
		do {
			showRequestMessage(message);
			success = saveDataFromUser(field);
			if ( !success ){
				System.out.println("Please enter the required information or type Q to exit");
			}
		} while (!success);
	}

	public boolean saveDataFromUser(String field) {
		String userData;
		userData = getInputFromConsole();

		if (!userData.isEmpty()){

			return setAttributes(field, userData);
		}
		return false;
	}
	
	@Override
	public boolean setAttributes(String field, String userData) {
		boolean hasSetted;
		hasSetted = super.setAttributes(field, userData);
		if (hasSetted){
			return true;
		} else {
			
			switch(field){
			case "ISBN":
				if ( isInISBNPattern(userData) ){
					this.ISBN = userData;
					return true;
				} else return false;
				
			case "author":
				this.author = userData;
				return true;
				
			case "edition":
				if (StringUtils.isNumeric(userData)){
					this.edition = Integer.parseInt(userData);
					return true;
				} else return false;
				
			case "year":
				if (StringUtils.isNumeric(userData)){
					this.year = Integer.parseInt(userData);
					return true;
				} else return false;
				
			case "subject":
				this.subject = userData;
				return true;
			
			default: return false;
			}
		}
	}

	private boolean isInISBNPattern(String userData) {
		return StringUtils.isNumeric(userData) && userData.length() == 13;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", author=" + author + ", edition=" + edition + ", year=" + year + ", subject="
				+ subject + ", toString()=" + super.toString() + "]";
	}
	
	
}

