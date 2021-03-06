package dive2DAO;



import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import dive2model.User;

public class UserDAO {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<User> findAll(){

		String sql = "SELECT * FROM USER";

		List<User> user  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));

		return user;
	}
	
	public int findTotalUser(){

		String sql = "SELECT COUNT(*) FROM USER";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(User user) {
	    if (user.getId() < 0) {
	        // update
	        String sql = "UPDATE USER SET name=?, username=?, password=?, "
	                    + " WHERE id=?";
	        jdbcTemplate.update(sql, user.getName(), user.getUsername(),
	                user.getPassword(),user.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO USER (id,name,username,password,mobileno,emailid,active,role)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, user.getId(), user.getName(),
	                user.getUsername(),user.getPassword(),user.getMobileno(),
	                user.getEmailid(),user.isActive(),user.getRole());
	    }
	 
	}
	
	public void delete(int id) {
	    String sql = "DELETE FROM USER WHERE id=?";
	    jdbcTemplate.update(sql, id);
	    
	    System.out.println("Successfully deleted");
	}
	

}

