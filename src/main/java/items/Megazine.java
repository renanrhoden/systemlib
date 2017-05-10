package items;

import org.apache.commons.lang3.StringUtils;

public class Megazine extends LibraryItem{

	private String editor;
	private int edition;
	private static final String PLEASE_ENTER_THE_REQUIRED_INFORMATION_OR_TYPE_Q_TO_EXIT = "Please enter the required information or type Q to exit";

	public void setEdition(int edition) {
		this.edition = edition;
	}


	public int getEdition() {
		return edition;
	}
	
	public Megazine(){
	
	}
	
	
	public Megazine(String barcode, String name, int numberOfPages, boolean available, String editor, int edition) {
		super(barcode, name, numberOfPages, available);
		this.editor = editor;
		this.edition = edition;
	}


	public static Megazine getExpleOFMegazine(){
		Megazine megazine = new Megazine();
		megazine.edition = 156;
		megazine.editor = "Globo";
		megazine.setAvailable(true);
		megazine.setBarCode("12345678");
		megazine.setName("Science");
		megazine.setNumberOfPages(16);
		
		return megazine;
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
			case "editor":
				this.editor = userData;
				return true;
				
			case "edition":
				if (StringUtils.isNumeric(userData)){
					this.edition = Integer.parseInt(userData);
					return true;
				} else return false;
				
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
	
	public boolean getDataFromUser(String field) {
		String userData;
		userData = getInputFromConsole();
		boolean hasSetGeneralField;

		if (!userData.isEmpty()){

			hasSetGeneralField = super.setAttributes(field, userData);
			if (hasSetGeneralField){
				return true;
			} else {
				switch(field){
				case "editor":
					this.editor = userData;
					return true;
				case "edition":
					if (StringUtils.isNumeric(userData)) {
						this.edition = Integer.parseInt(userData);
						return true;
					} else return false;
					
				}
			}
		}
		return false;
	}


	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}


}
