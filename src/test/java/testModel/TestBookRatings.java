package testModel;


import java.util.logging.Logger;

import dive2model.BookRating;

public class TestBookRatings {
	public static final Logger logger = Logger.getLogger("BookRatings.class");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
BookRating cc= new BookRating();
		
		
BookRating bookr = new BookRating();

bookr.setBookid(103);
bookr.setRating(2);
bookr.setUserid(23);
		cc.setBookid(102);
		cc.setUserid(21);
		cc.setRating(4);
		

	}
	
	
	}