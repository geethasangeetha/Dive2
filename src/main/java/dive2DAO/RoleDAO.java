package dive2DAO;



import java.util.List;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import dive2model.Role;

public class RoleDAO {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<Role> findAll(){

		String sql = "SELECT * FROM ROLE";

		List<Role> role  = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper(Role.class));

		return role;
	}
	
	public int findTotalRole(){

		String sql = "SELECT COUNT(*) FROM ROLE";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(Role role) {
	    if (role.getId() < 0) {
	        // update
	        String sql = "UPDATE ROLE SET name=? "
	                    + " WHERE user_id=?";
	        jdbcTemplate.update(sql, role.getName(), role.getId());
	    } else {
	        // insert
	        String sql = "INSERT INTO ROLE (user_id,name)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, role.getId(), role.getName());
	    }
	 
	}
	
	public void delete(int userid) {
	    String sql = "DELETE FROM ROLE WHERE userid=?";
	    jdbcTemplate.update(sql, userid);
	    
	    System.out.println("Successfully deleted");
	}
	


}
