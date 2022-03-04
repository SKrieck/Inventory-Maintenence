package inventoryadjustments;

import java.io.*;
import java.util.*;

public class FileHandling {

	ItemAttributes item = new ItemAttributes();
	private int sessionNumber = 1;
	List<String> stringData = new ArrayList<String>();
	StringBuffer stringBuff = new StringBuffer();
	Menu menu = new Menu();
	
	public void createSession() throws IOException {
		
	}
	
	public void writeSession(String itemName, String itemDept, int itemPlu, int itemQuantity)
			throws IOException {
		FileWriter writer = new FileWriter("sessions.txt", true);
		BufferedWriter buffWriter = new BufferedWriter(writer);
		
		buffWriter.write("session " + sessionNumber + ",");
		buffWriter.write("name " + itemName + ",");
		buffWriter.write("dept " + itemDept + ",");
		buffWriter.write("plu " + Integer.toString(itemPlu) + ",");
		buffWriter.write("qty " + Integer.toString(itemQuantity) + "\n");
		
		// make sure each saved session has a different session number
		sessionNumber++;
		
		// allows additional items to be added
		buffWriter.close();
		
		// done?
	}
	
	public void printSession() throws IOException {
		Scanner scanner = new Scanner(new File("sessions.txt"));
		String nameRegex = "name";
		String deptRegex = "dept";
		String pluRegex = "plu";
		String qtyRegex = "qty";
		String sessionRegex = "Session";
		String[] line = null;
		
		while(scanner.hasNext()) {
			line = scanner.nextLine().split(",");
			System.out.println();
			
			for(String sessionData : line) {
				if(sessionData.contains(sessionRegex)) {
					System.out.println(sessionData);
				} else if (sessionData.contains(nameRegex)) {
					System.out.println(sessionData.replace("name", "Name: "));
				} else if (sessionData.contains(deptRegex)) {
					System.out.println(sessionData.replace("dept", "Department: "));
				} else if (sessionData.contains(pluRegex)) {
					System.out.println(sessionData.replace("plu", "PLU: "));
				} else if (sessionData.contains(qtyRegex)) {
					System.out.println(sessionData.replace("qty", "Quantity"));
				}
			}
		}
	}
}
