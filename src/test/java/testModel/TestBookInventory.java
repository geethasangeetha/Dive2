package testModel;

import java.util.logging.Logger;

import dive2model.BookInventory;

public class TestBookInventory {
	public static final Logger logger = Logger.getLogger("BookInventory.class");
	public static void main(String[]args)
	{
BookInventory cc= new BookInventory();
		
BookInventory book = new BookInventory();

book.setBookid(103);
book.setQuantity(3);
		cc.setBookid(102);
		cc.setQuantity(3);
		
		
	
	
    
}
}


