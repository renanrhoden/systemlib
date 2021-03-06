package items;



import org.apache.commons.lang3.StringUtils;

public class Book extends LibraryItem{



	private static final String PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT = "Please enter the required information or type Q to exit";
	private String ISBN;
	private String author;
	private int edition;
	private int year;
	private String subject;

	public Book(){

	}

	public Book(String barcode, String name, int numberOfPages, boolean available, String iSBN,
			String author, int edition, int year, String subject) {
		super(barcode, name, numberOfPages, available);
		ISBN = iSBN;
		this.author = author;
		this.edition = edition;
		this.year = year;
		this.subject = subject;
	}

	public static Book getExampleOfBook(){
		Book book = new Book();
		book.author = "Rhoden";
		book.edition = 8;
		book.ISBN = "1234567890123";
		book.subject = "science";
		book.year = 1899;
		book.setBarCode("12345678");
		book.setName("Renan");
		book.setNumberOfPages(56);
		book.setAvailable(true);

		return book;
	}


	public boolean requestData( String message, String field ){
		boolean success;
		String userData;
		do {
			showRequestMessage(message);
			userData = super.getInputFromConsole();
			if (userData.equalsIgnoreCase("q")){
				return false;
			}
			success = isNotEmpty(field, userData);
			if ( !success ){
				System.out.println(PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT);
			}
		} while (!success);
		return true;
	}

	public boolean isNotEmpty(String field, String userData) {

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
		return "Book \n"
				+ "ISBN: " + ISBN + ", \n"
				+ "author: " + author + ", \n"
				+ "edition: " + edition + ", \n"
				+ "year: " + year + ", \n"
				+ "subject: " + subject + ", \n" + super.toString() + "";
	}

	public String getISBN() {
		return ISBN;
	}

	public String getAuthor() {
		return author;
	}

	public int getEdition() {
		return edition;
	}

	public int getYear() {
		return year;
	}

	public String getSubject() {
		return subject;
	}

}

