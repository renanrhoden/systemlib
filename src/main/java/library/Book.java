package library;

import org.apache.commons.lang3.StringUtils;

public class Book extends LibraryItem{

	@SuppressWarnings("unused")
	private String ISBN;
	@SuppressWarnings("unused")
	private String author;
	@SuppressWarnings("unused")
	private int edition;
	@SuppressWarnings("unused")
	private int year;
	@SuppressWarnings("unused")
	private String subject;
	
	private static final String ISBN_REQUEST_MESSAGE = "Type the ISBN of the book:";
	private static final String AUTHOR_REQUEST_MESSAGE = "Type here the name of the author:";
	private static final String EDITION_REQUEST_MESSAGE = "Type the edition: ";
	private static final String YEAR_REQUEST_MESSAGE = "Type the year of the book:";
	private static final String SUBJECT_REQUEST_MESSAGE = "Type the subject of the book:";


	public void requestData( String message, String field ){
		boolean success;
		do {
			showRequestMessage(message);
			success = getDataFromUser(field);
		} while (!success);
	}

	public boolean getDataFromUser(String field) {
		String userData;
		userData = getInputFromConsole();
		boolean hasSetted;

		if (!userData.isEmpty()){

			hasSetted = super.setAttributes(field, userData);
			if (hasSetted){
				return true;
			}else {
				switch(field){
				case "ISBN":
					if (StringUtils.isNumeric(userData)){
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
				}
			}
		}
		return false;
	}
}

