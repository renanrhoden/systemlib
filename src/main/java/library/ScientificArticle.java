package library;

public class ScientificArticle extends LibraryItem{
	private String author;

	
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
	

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
