package dive2DAO;



import java.util.List;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import dive2model.BookInventory;

public class BookInventoryDAO {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public List<BookInventory> findAll(){

		String sql = "SELECT * FROM BOOKINVENTORY";

		List<BookInventory> bookin  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(BookInventory.class));

		return bookin;
	}
	
	public int findTotalBookInventory(){

		String sql = "SELECT COUNT(*) FROM BOOKINVENTORY";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(BookInventory bookin) {
	    if (bookin.getBookid() < 0) {
	        // update
	        String sql = "UPDATE BOOKINVENTORY SET  quantity=? "
	                    + " WHERE bookid=?";
	        jdbcTemplate.update(sql, bookin.getQuantity(), bookin.getBookid());
	    } else {
	        // insert
	        String sql = "INSERT INTO BOOKINVENTORY(bookid,quantity)"
	                    + " VALUES (?, ?)";
	        jdbcTemplate.update(sql, bookin.getBookid(),bookin.getQuantity());
	    }
	 
	}
	
	public void delete(int bookid) {
	    String sql = "DELETE FROM BOOKINVENTORY WHERE bookid=?";
	    jdbcTemplate.update(sql, bookid);
	    
	    System.out.println("Successfully deleted");
	}
}
