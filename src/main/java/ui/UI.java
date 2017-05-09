package ui;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import db.LibraryDB;
import helper.Messages;
import items.Book;

public class UI {

	private static final String OPTIONS = ""
			+ "Please, select the desired option typing its number as follow: \n"
			+ "\n"
			+ "To register a new item, type '1' \n"
			+ "To update a new item already registered, type '2' "
			+ "To check out an item, type '3' \n"
			+ "To return an item, type '4' \n"
			+ "To list all borrowed items or by type, type '5' \n"
			+ "To list all not borrowed items or by type, type '6' \n"
			+ "To search for an item, type '7'\n"
			+ "Or type any moment 'q' to exit the program \n\n\n";
	private static final String TYPE_OPTION_AGAIN = "PLEASE TYPE THE OPTION AGAIN OR 'Q' TO EXIT";
	private static final String REGISTER_A_BOOK = ""
			+ "   ▄████████    ▄████████    ▄██████▄   ▄█     ▄████████     ███        ▄████████    ▄████████         ▄████████      ▀█████████▄   ▄██████▄   ▄██████▄     ▄█   ▄█▄ \n"
			+ "  ███    ███   ███    ███   ███    ███ ███    ███    ███ ▀█████████▄   ███    ███   ███    ███        ███    ███        ███    ███ ███    ███ ███    ███   ███ ▄███▀ \n"
			+ "  ███    ███   ███    █▀    ███    █▀  ███▌   ███    █▀     ▀███▀▀██   ███    █▀    ███    ███        ███    ███        ███    ███ ███    ███ ███    ███   ███▐██▀   \n"
			+ " ▄███▄▄▄▄██▀  ▄███▄▄▄      ▄███        ███▌   ███            ███   ▀  ▄███▄▄▄      ▄███▄▄▄▄██▀        ███    ███       ▄███▄▄▄██▀  ███    ███ ███    ███  ▄█████▀    \n"
			+ "▀▀███▀▀▀▀▀   ▀▀███▀▀▀     ▀▀███ ████▄  ███▌ ▀███████████     ███     ▀▀███▀▀▀     ▀▀███▀▀▀▀▀        ▀███████████      ▀▀███▀▀▀██▄  ███    ███ ███    ███ ▀▀█████▄    \n"
			+ "▀███████████   ███    █▄    ███    ███ ███           ███     ███       ███    █▄  ▀███████████        ███    ███        ███    ██▄ ███    ███ ███    ███   ███▐██▄   \n"
			+ "  ███    ███   ███    ███   ███    ███ ███     ▄█    ███     ███       ███    ███   ███    ███        ███    ███        ███    ███ ███    ███ ███    ███   ███ ▀███▄ \n"
			+ "  ███    ███   ██████████   ████████▀  █▀    ▄████████▀     ▄████▀     ██████████   ███    ███        ███    █▀       ▄█████████▀   ▀██████▀   ▀██████▀    ███   ▀█▀ \n"
			+ "  ███    ███                                                                        ███    ███                                                             ▀         \n";

			
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
				System.exit(0);
				break;
			} else{
				switch(option){
				case 1:
					LibraryDB.registerNewItem(requestBookData());
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				}
			}


		}
	}


	public Book requestBookData(){
		
		System.out.println(REGISTER_A_BOOK);
		Book book = new Book();

		for (String key : Messages.getMessages().keySet()) {
			book.requestData(Messages.getMessages().get(key), key);
		}

		return book;
	}

	public static void showOptions(){
		System.out.println(OPTIONS);
	}

	private boolean isAnOption(){
		String input;
		input = getInputFromConsole();

		while(!input.equalsIgnoreCase("q") && !StringUtils.isNumeric(input)){
			System.out.println(TYPE_OPTION_AGAIN);
			input = getInputFromConsole();
			System.out.println(input);
		} 
		if (input.equalsIgnoreCase("q")){
			return false;
		} else {
			option = Integer.parseInt(input);
			return true;
		}
	}

	private String getInputFromConsole() {
		String input;
		input = scanner.nextLine();
		return input;
	}





}
