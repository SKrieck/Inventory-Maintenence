package inventoryadjustments;

public class ItemAttributes {
	String name;
	String department;
	int plu;
	int quantity;
	
	public void item(String itemName, String itemDepartment, int itemPlu, int itemQuantity) {
		
		name = itemName;
		department = itemDepartment;
		plu = itemPlu;
		quantity = itemQuantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String itemName) {
		name = itemName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String dept) {
		department = dept;
	}
	
	public int getPlu() {
		return plu;
	}
	
	public void setPlu(int plu) {
		this.plu = plu;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
}
