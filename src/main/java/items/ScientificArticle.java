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
				case "author":
					this.author = userData;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean saveDataFromUser(String field, String userData) {
		
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
			success = saveDataFromUser(field, userData);
			if ( !success ){
				System.out.println(PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT);
			}
		} while (!success);
		return true;
	}


	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
