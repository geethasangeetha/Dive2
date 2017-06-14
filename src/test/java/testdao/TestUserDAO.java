package testdao;
 

import java.util.logging.Logger;

import dive2DAO.UserDAO;
import dive2model.User;

public class TestUserDAO {
	public static final Logger logger = Logger.getLogger("Role.class");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO user = new UserDAO();
		
		System.out.println(user.findAll());
		
		System.out.println(user.findTotalUser());
		
		
	    user.findTotalUser();
	    user.delete(90);
	}

	}


