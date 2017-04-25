package library;

public class Megazine extends LibraryItem{

	private String editor;

	public boolean getDataFromUser(String field) {
		String userData;
		userData = getInputFromConsole();
		boolean hasSetted;

		if (!userData.isEmpty()){

			hasSetted = super.setAttributes(field, userData);
			if (hasSetted){
				return true;
			} else {
				switch(field){
				case "editor":
					this.editor = userData;
					return true;
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
