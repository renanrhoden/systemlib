package ui;


import java.util.Scanner;


import org.apache.commons.lang3.StringUtils;

import db.LibraryDB;
import helper.Messages;
import items.*;
import items.Book;
import items.LibraryItem;

public class UI {

	private static final String PLASE_PROVIDE_THE_TYPE_OF_ITEM_YOU_WANT_TO_SEARCH_FOR = "Plase provide the type of item you want to search for: ";
	private static final String TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_REGISTER = "Type the type of item you want to register: ";
	private static final String TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_CHECK_OUT = "Type the type of item you want to check out: ";
	private static final String TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_RETURN = "Type the type of item you want to return: ";
	private static final String TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_UPDATE = "Type the type of item you want to update: ";
	private static final String TO_CONFIRM_TYPE_Y_FOLLOWING_BY_AN_ENTER_OR_TYPE_ANYTHING_ELSE_OR_JUST_AND_ENTER_TO_ESCAPE = "To confirm, type 'y' following by an enter or type anything else or just and enter to escape";
	private static final String PLEASE_PROVIDE_THE_NEW_VALUE_OF_THE_FIELD = "Please provide the new value of the field:";
	private static final String PLEASE_PROVIDE_THE_FIELD_YOU_WANT_TO_UPDATE = "Please provide the field you want to update";
	private static final String OPTIONS = "\n\n\n"
			+ "Please, select the desired option typing its number as follow: \n"
			+ "\n"
			+ "To register a new item, type '1' \n"
			+ "To update a new item already registered, type '2' \n"
			+ "To check out an item, type '3' \n"
			+ "To return an item, type '4' \n"
			+ "To list all borrowed items or by type, type '5' \n"
			+ "To list all not borrowed items or by type, type '6' \n"
			+ "To search for an item, type '7'\n"
			+ "Or type any moment 'q' to exit the program \n\n\n";
	private static final String TYPE_OPTION_AGAIN = "PLEASE TYPE THE OPTION AGAIN OR 'Q' TO EXIT";
	private static final String REGISTER_A_BOOK = ""
			+ "█▄▄▄▄ ▄███▄     ▄▀  ▄█    ▄▄▄▄▄      ▄▄▄▄▀ ▄███▄   █▄▄▄▄     ██       ███   ████▄ ████▄ █  █▀ \n"
			+ "█  ▄▀ █▀   ▀  ▄▀    ██   █     ▀▄ ▀▀▀ █    █▀   ▀  █  ▄▀     █ █      █  █  █   █ █   █ █▄█   \n"
			+ "█▀▀▌  ██▄▄    █ ▀▄  ██ ▄  ▀▀▀▀▄       █    ██▄▄    █▀▀▌      █▄▄█     █ ▀ ▄ █   █ █   █ █▀▄   \n"
			+ "█  █  █▄   ▄▀ █   █ ▐█  ▀▄▄▄▄▀       █     █▄   ▄▀ █  █      █  █     █  ▄▀ ▀████ ▀████ █  █  \n"
			+ "  █   ▀███▀    ███   ▐              ▀      ▀███▀     █          █     ███                 █   \n"
			+ " ▀                                                  ▀          █                         ▀    \n";
	private static final String REGISTER_A_MEGAZINE = ""
			+ "█▄▄▄▄ ▄███▄     ▄▀  ▄█    ▄▄▄▄▄      ▄▄▄▄▀ ▄███▄   █▄▄▄▄     ██       █▀▄▀█ ▄███▄     ▄▀  ██   ▄▄▄▄▄▄   ▄█    ▄   ▄███▄   \n"
			+ "█  ▄▀ █▀   ▀  ▄▀    ██   █     ▀▄ ▀▀▀ █    █▀   ▀  █  ▄▀     █ █      █ █ █ █▀   ▀  ▄▀    █ █ ▀   ▄▄▀   ██     █  █▀   ▀  \n"
			+ "█▀▀▌  ██▄▄    █ ▀▄  ██ ▄  ▀▀▀▀▄       █    ██▄▄    █▀▀▌      █▄▄█     █ ▄ █ ██▄▄    █ ▀▄  █▄▄█ ▄▀▀   ▄▀ ██ ██   █ ██▄▄    \n"
			+ "█  █  █▄   ▄▀ █   █ ▐█  ▀▄▄▄▄▀       █     █▄   ▄▀ █  █      █  █     █   █ █▄   ▄▀ █   █ █  █ ▀▀▀▀▀▀   ▐█ █ █  █ █▄   ▄▀ \n"
			+ "  █   ▀███▀    ███   ▐              ▀      ▀███▀     █          █        █  ▀███▀    ███     █           ▐ █  █ █ ▀███▀   \n"
			+ " ▀                                                  ▀          █        ▀                   █              █   ██         \n";
	private static final String REGISTER_AN_ARTICLE = ""
			+ "█▄▄▄▄ ▄███▄     ▄▀  ▄█    ▄▄▄▄▄      ▄▄▄▄▀ ▄███▄   █▄▄▄▄     ██      ▄       ██   █▄▄▄▄    ▄▄▄▄▀ ▄█ ▄█▄    █     ▄███▄   \n"
			+ "█  ▄▀ █▀   ▀  ▄▀    ██   █     ▀▄ ▀▀▀ █    █▀   ▀  █  ▄▀     █ █      █      █ █  █  ▄▀ ▀▀▀ █    ██ █▀ ▀▄  █     █▀   ▀  \n"
			+ "█▀▀▌  ██▄▄    █ ▀▄  ██ ▄  ▀▀▀▀▄       █    ██▄▄    █▀▀▌      █▄▄█ ██   █     █▄▄█ █▀▀▌      █    ██ █   ▀  █     ██▄▄    \n"
			+ "█  █  █▄   ▄▀ █   █ ▐█  ▀▄▄▄▄▀       █     █▄   ▄▀ █  █      █  █ █ █  █     █  █ █  █     █     ▐█ █▄  ▄▀ ███▄  █▄   ▄▀ \n"
			+ "  █   ▀███▀    ███   ▐              ▀      ▀███▀     █          █ █  █ █        █   █     ▀       ▐ ▀███▀      ▀ ▀███▀   \n"
			+ " ▀                                                  ▀          █  █   ██       █   ▀                                     ";

	private static final String CHECK_OUT = ""
			+ "▄█▄     ▄  █ ▄███▄   ▄█▄    █  █▀     ████▄   ▄     ▄▄▄▄▀ \n"
			+ "█▀ ▀▄  █   █ █▀   ▀  █▀ ▀▄  █▄█       █   █    █ ▀▀▀ █    \n"
			+ "█   ▀  ██▀▀█ ██▄▄    █   ▀  █▀▄       █   █ █   █    █    \n"
			+ "█▄  ▄▀ █   █ █▄   ▄▀ █▄  ▄▀ █  █      ▀████ █   █   █     \n"
			+ "▀███▀     █  ▀███▀   ▀███▀    █             █▄ ▄█  ▀      \n"
			+ "         ▀                   ▀               ▀▀▀          \n";

	private static final String RETURN = ""
			+ "█▄▄▄▄ ▄███▄     ▄▄▄▄▀ ▄   █▄▄▄▄   ▄   \n"
			+ "█  ▄▀ █▀   ▀ ▀▀▀ █     █  █  ▄▀    █  \n"
			+ "█▀▀▌  ██▄▄       █  █   █ █▀▀▌ ██   █ \n"
			+ "█  █  █▄   ▄▀   █   █   █ █  █ █ █  █ \n"
			+ "  █   ▀███▀    ▀    █▄ ▄█   █  █  █ █ \n"
			+ " ▀                   ▀▀▀   ▀   █   ██ \n";

	private static final String SEARCH = "" +
			"   ▄████████    ▄████████    ▄████████    ▄████████  ▄████████    ▄█    █▄    \n " +
			"   ███    ███   ███    ███   ███    ███   ███    ███ ███    ███   ███    ███   \n" +
			"   ███    █▀    ███    █▀    ███    ███   ███    ███ ███    █▀    ███    ███   \n" +
			"   ███         ▄███▄▄▄       ███    ███  ▄███▄▄▄▄██▀ ███         ▄███▄▄▄▄███▄▄ \n" +
			" ▀███████████ ▀▀███▀▀▀     ▀███████████ ▀▀███▀▀▀▀▀   ███        ▀▀███▀▀▀▀███▀  \n" +
			"          ███   ███    █▄    ███    ███ ▀███████████ ███    █▄    ███    ███   \n" +
			"    ▄█    ███   ███    ███   ███    ███   ███    ███ ███    ███   ███    ███   \n" +
			"  ▄████████▀    ██████████   ███    █▀    ███    ███ ████████▀    ███    █▀  \n ";



	private int option;
	private Scanner scanner = new Scanner(System.in);

	public UI() {
		System.out.println("██   ██ █████     ██████ ██    ██  ██████ ██████ ███████  ███     ████");
		System.out.println("██   ██ ██  ██    █       ██  ██   █        ██   ██       ██ ██  ██ ██");
		System.out.println("██   ██ █████     ██████    ██     ██████   ██   ███████  ██   ██   ██");
		System.out.println("██   ██ ██  ██         █    ██          █   ██   ██       ██        ██");
		System.out.println("████ ██ █████     ██████    ██     ██████   ██   ███████  ██        ██");
	}

	public void uiLoop(){
		while (true){
			showOptions();
			if (!isAnOption()){
				break;
			} else{
				switch(option){
				case 1:{
					register();
				}
				case 2:
					updateItem();	
					break;
				case 3:
					checkOut();
					break;
				case 4:
					returnItem();
					break;
				case 5:
					LibraryDB.listBorrowedItems(true);
					break;
				case 6:
					LibraryDB.listBorrowedItems(false);
					break;
				case 7:
					searchItem();
					break;
				}
			}
		}

	}


	private void searchItem() {
		System.out.println(SEARCH);
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println(PLASE_PROVIDE_THE_TYPE_OF_ITEM_YOU_WANT_TO_SEARCH_FOR);
			input = getInputFromConsole();
			LibraryItem item = new LibraryItem();
			if (input.equalsIgnoreCase("book") || input.equalsIgnoreCase("megazine") || input.equalsIgnoreCase("scientific article")) {
				item = item.search(input);
				if (!item.getBarcode().equals("")) {
					System.out.println(item.toString());
				} else {
					System.out.println("Item not registered");
				}
			}
		}
	}

	private void returnItem() {
		System.out.println(RETURN);
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println(TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_RETURN);
			input = getInputFromConsole();
			LibraryItem item = new LibraryItem();
			if (input.equalsIgnoreCase("book") || input.equalsIgnoreCase("megazine") || input.equalsIgnoreCase("scientific article")) {
				item.returnItem(input);
			}
		}
	}

	private void checkOut() {
		System.out.println(CHECK_OUT);
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println(TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_CHECK_OUT);
			input = getInputFromConsole();
			LibraryItem item = new LibraryItem();
			if (input.equalsIgnoreCase("book") || input.equalsIgnoreCase("megazine") || input.equalsIgnoreCase("scientific article")) {
				item.checkOut(input);
			}
		}
	}

	private void register() {
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println(TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_REGISTER);
			input = getInputFromConsole();
			switch (input.toLowerCase()) {
			case "book": {
				Book book = new Book();
				if (requestBookData(book)){
					LibraryDB.registerNewItem(book);
				}
				break;
			}
			case "megazine":
				Megazine megazine = new Megazine();
				if (requestMegazineData(megazine)){
					LibraryDB.registerNewItem(megazine);
				}
				break;
			case "scientific article":
				ScientificArticle article = new ScientificArticle();
				if (requestArticleData(article)){
					LibraryDB.registerNewItem(article);
				}
				break;
			default:
				System.out.println("Not an type available");
			}
		}
	}



	private void updateItem() {

		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println(TYPE_THE_TYPE_OF_ITEM_YOU_WANT_TO_UPDATE);
			input = getInputFromConsole();
			switch (input.toLowerCase()) {
			case "book": {
				Book book = new Book();
				if (book.requestData(Messages.getBookMessages().get("barcode"), "barcode"))
					getUpdateInfoFromUser(book);
				break;
			}
			case "megazine":
				Megazine megazine = new Megazine();
				if (megazine.requestData(Messages.getBookMessages().get("barcode"), "barcode"))
					getUpdateInfoFromUser(megazine);
				break;
			case "scientific article":
				ScientificArticle article = new ScientificArticle();
				if (article.requestData(Messages.getBookMessages().get("barcode"), "barcode"))
					getUpdateInfoFromUser(article);
				break;
			default:
				System.out.println("Not an type available");
			}
		}
	}



	private void getUpdateInfoFromUser(Book book){
		String column;
		String newValue;
		System.out.println(PLEASE_PROVIDE_THE_FIELD_YOU_WANT_TO_UPDATE);
		column = getInputFromConsole();
		System.out.println(PLEASE_PROVIDE_THE_NEW_VALUE_OF_THE_FIELD);
		newValue = getInputFromConsole();
		System.out.println("You've chosen to update the field " + column + " to the new value of " + newValue);
		System.out.println(TO_CONFIRM_TYPE_Y_FOLLOWING_BY_AN_ENTER_OR_TYPE_ANYTHING_ELSE_OR_JUST_AND_ENTER_TO_ESCAPE);
		if (getInputFromConsole().equals("y"))
			LibraryDB.updateItem(book, column, newValue);
	}

	private void getUpdateInfoFromUser(Megazine megazine){
		String column;
		String newValue;
		System.out.println(PLEASE_PROVIDE_THE_FIELD_YOU_WANT_TO_UPDATE);
		column = getInputFromConsole();
		System.out.println(PLEASE_PROVIDE_THE_NEW_VALUE_OF_THE_FIELD);
		newValue = getInputFromConsole();
		System.out.println("You've chosen to update the field " + column + " to the new value of " + newValue);
		System.out.println(TO_CONFIRM_TYPE_Y_FOLLOWING_BY_AN_ENTER_OR_TYPE_ANYTHING_ELSE_OR_JUST_AND_ENTER_TO_ESCAPE);
		if (!getInputFromConsole().equals("y"))
			LibraryDB.updateItem(megazine, column, newValue);
	}
	private void getUpdateInfoFromUser(ScientificArticle article){
		String column;
		String newValue;
		System.out.println(PLEASE_PROVIDE_THE_FIELD_YOU_WANT_TO_UPDATE);
		column = getInputFromConsole();
		System.out.println(PLEASE_PROVIDE_THE_NEW_VALUE_OF_THE_FIELD);
		newValue = getInputFromConsole();
		System.out.println("You've chosen to update the field " + column + " to the new value of " + newValue);
		System.out.println(TO_CONFIRM_TYPE_Y_FOLLOWING_BY_AN_ENTER_OR_TYPE_ANYTHING_ELSE_OR_JUST_AND_ENTER_TO_ESCAPE);
		if (!getInputFromConsole().equals("y"))
			LibraryDB.updateItem(article, column, newValue);
	}


	public boolean requestBookData(Book book){

		System.out.println(REGISTER_A_BOOK);

		for (String key : Messages.getBookMessages().keySet()) {
			if (!book.requestData(Messages.getBookMessages().get(key), key)) {
				return false;
			}
		}

		return true;
	}
	public boolean requestMegazineData(Megazine megazine){

		System.out.println(REGISTER_A_MEGAZINE);

		for (String key : Messages.getMegazineMessages().keySet()) {
			if (!megazine.requestData(Messages.getMegazineMessages().get(key), key)) {
				return false;
			}
		}

		return true;
	}
	//TODO
	public boolean requestArticleData(ScientificArticle article){

		System.out.println(REGISTER_AN_ARTICLE);

		for (String key : Messages.getScientificArticleMessages().keySet()) {
			if (!article.requestData(Messages.getScientificArticleMessages().get(key), key)) {
				return false;
			}
		}

		return true;
	}

	public static void showOptions(){
		System.out.println(OPTIONS);
	}

	private boolean isAnOption(){
		String input;
		input = getInputFromConsole();

		while(notValidInput(input)){
			System.out.println(TYPE_OPTION_AGAIN);
			input = getInputFromConsole();
		} 

		if (input.equalsIgnoreCase("q")){
			return false;
		} else {
			option = Integer.parseInt(input);
			return true;
		}
	}

	private boolean notValidInput(String input) {
		return !input.equalsIgnoreCase("q") && !StringUtils.isNumeric(input);
	}

	private String getInputFromConsole() {
		String input;
		input = scanner.nextLine();
		return input;
	}





}
