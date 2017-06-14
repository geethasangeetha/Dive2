package dive2DAO;


import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import dive2model.BookRating;

public class BookRatingsDAO {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	public List<BookRating> findAll(){

		String sql = "SELECT * FROM BOOKRATINGS";

		List<BookRating> bookrate  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(BookRating.class));

		return bookrate;
	}
	
	public int findTotalBookRatings(){

		String sql = "SELECT COUNT(*) FROM BOOKRATINGS";

		int total = jdbcTemplate.queryForInt(sql);

		return total;
	}
	
	public void saveOrUpdate(BookRating bookrate) {
	    if (bookrate.getBookid() < 0) {
	        // update
	        String sql = "UPDATE BOOKRATINGS SET  userid=?,rating=? "
	                    + " WHERE bookid=?";
	        jdbcTemplate.update(sql, bookrate.getUserid(), bookrate.getRating());
	    } else {
	        // insert
	        String sql = "INSERT INTO BOOKRATINGS(bookid,quantity)"
	                    + " VALUES (?, ?)";
	        jdbcTemplate.update(sql, bookrate.getBookid(),bookrate.getUserid(),bookrate.getRating());
	    }
	 
	}
	
	public void delete(int bookid) {
	    String sql = "DELETE FROM BOOKRATINGS WHERE bookid=?";
	    jdbcTemplate.update(sql, bookid);
	    
	    System.out.println("Successfully deleted");
	}
}
