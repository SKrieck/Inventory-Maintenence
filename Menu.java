package inventoryadjustments;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

	static Scanner scanner = new Scanner(System.in);
	static FileHandling session = new FileHandling();
	static ItemAttributes item = new ItemAttributes();
	static int selection = 0;
	static boolean isExit = false;

	public static void menu(boolean isExit) throws IOException {
		
		do {
			System.out.println("\nInventory Tracker");
			System.out.println("-----------------");
			System.out.println("1. Create Session\n2. Delete Session\n"
					+ "3. Print All Sessions");
			System.out.println("\nType \"1\" to Create Session, \"2\""
					+ " to Delete Session,\n\"3\" to Print All Sessions,"
					+ " and \"4\" to Exit: ");
			
			try {
				do {
					selection = scanner.nextInt();
					
					if (selection > 1 || selection < 4) {
						continue;
					} else {
						System.out.println("Please select 1, 2, 3, or 4: ");
						selection = scanner.nextInt();
					}
				} while (selection > 1 && selection < 4);
				
			} catch (Exception e) {
				System.out.println("That selection is not valid.");
			}
			
			switch(selection) {
			case 1:
				session.createSession();
				scanner.nextLine();
				
				System.out.print("Enter the name of the item: ");
				String name = scanner.nextLine();
				item.setName(name);
				
				System.out.print("Enter the department the item is in: ");
				String department = scanner.nextLine();
				item.setDepartment(department);
				
				System.out.print("Enter the plu for the item: ");
				int plu = scanner.nextInt();
				item.setPlu(plu);
				
				System.out.print("Enter the quantity of the item: ");
				int quantity = scanner.nextInt();
				item.setQuantity(quantity);
				
				session.writeSession(name, department, plu, quantity);
				
				// Give user option to save, edit, delete, or cancel
				System.out.print("\nEnter 1, 2, 3, or 4 to save, edit, delete, "
						+ " or cancel session: ");
				
				try {
					do {
						selection = scanner.nextInt();
						
						if (selection > 1 || selection < 4) {
							continue;
						} else {
							System.out.println("Please select 1, 2, 3, or 4: ");
							selection = scanner.nextInt();
						}
						
					} while (selection > 1 && selection < 4);
				} catch (Exception e) {
					System.out.println("Number out of bounds");
				}
				
				switch(selection) {
				case 1:
					session.writeSession(name, department, plu, quantity);
				}
				
				System.out.println("Session saved.");
				break;
				
			case 2:
				// Print session numbers and ask which one to delete
				/* At a later date, add in options to choose which 
				 * sessions to delete** */
				System.out.println("Deleted session.");
				break;
				
			case 3:
				/* Give user option to print a particular session,
				 * print last session or print all sessions */
				session.printSession();
				break;
				
			case 4:
				isExit = true;
				break;
				
				default:
					System.out.println("Please select 1, 2, 3, or 4");
			}
			
			
		} while (isExit != true);
	}
}
