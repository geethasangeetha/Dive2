package dive2DAO;

import java.awt.print.Book;
import java.util.List;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Util.ConnectionUtil;
import dive2model.BookModel;

public class BookDAO {
	private JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	
	
	public List<Book> findAll(){

		String sql = "SELECT * FROM BOOK";

		List<Book> book  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(Book.class));

		return book ;
	}
	
	public String findTotalBook(){

		String sql = "SELECT COUNT(*) FROM BOOK";
		return sql;
}
}	