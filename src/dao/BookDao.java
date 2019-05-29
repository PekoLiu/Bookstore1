package dao;

import java.util.List;

import entity.Book;

public interface BookDao {

	List<Book> queryAll();
	
	int insert(Book book);
	
	int update(Book book);
	
	int delete(int bid);
	
}
