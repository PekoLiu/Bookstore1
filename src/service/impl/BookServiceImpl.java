package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import service.BookService;

public class BookServiceImpl implements BookService {
	
	BookDao dao = new BookDaoImpl();
	
	@Override
	public List<Book> queryAll() {
		return dao.queryAll();
	}

	@Override
	public int insert(Book book) {
		return dao.insert(book);
	}

	@Override
	public int update(Book book) {
		return dao.update(book);
	}

	@Override
	public int delete(int bid) {
		return dao.delete(bid);
	}

}
