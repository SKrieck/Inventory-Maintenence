package inventoryadjustments;

import java.io.IOException;

public class InventoryTracker {

	public static void main(String[] args) throws IOException {
		/* Add description notes to all main actions within program */
		boolean isExit = false;
		
		Menu.menu(isExit);
		
		System.out.println("Exiting application.");
	}
}
