package items;

import org.apache.commons.lang3.StringUtils;

public class Megazine extends LibraryItem{

	private String editor;
	private int edition;

	public void setEdition(int edition) {
		this.edition = edition;
	}


	public int getEdition() {
		return edition;
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
