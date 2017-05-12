package items;


public class ScientificArticle extends LibraryItem{
	private String author;
	private static final String PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT = "Please enter the required information or type Q to exit";


	public static ScientificArticle getExampleOfArticle(){
		ScientificArticle article = new ScientificArticle();
		article.setAuthor("Rhoden");
		article.setAvailable(true);
		article.setBarCode("02134587");
		article.setName("A vida e as aventuras de Luna");
		article.setNumberOfPages(42);
		return article;
	}

	public ScientificArticle(){

	}

	public ScientificArticle(String barcode, String name, int numberOfPages, boolean available, String author) {
		super(barcode, name, numberOfPages, available);
		this.author = author;
	}

	public boolean isEmpty(String field, String userData) {

		if (!userData.isEmpty()){

			return setAttributes(field, userData);
		}
		return false;
	}

	@Override
	public boolean setAttributes(String field, String userData) {
		boolean hasSet;
		hasSet = super.setAttributes(field, userData);
		if (hasSet){
			return true;
		} else {

			switch(field){
			case "author":
				this.author = userData;
				return true;

			default: return false;
			}
		}
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
			success = isValidData(field, userData);
		} while (!success);
		return true;
	}

	private boolean isValidData(String field, String userData) {
		boolean success;
		if(!userData.isEmpty())
			success = setAttributes(field, userData);
		else{
			success = false;
			System.out.println(PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT);
		}
		return success;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Scientific Article \n"
				+ "author: " + author + ", \n"
				+ "" + super.toString() + "";
	}



}
