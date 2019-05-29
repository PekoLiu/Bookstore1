package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.BookDao;
import entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao {
	
	@Override
	public List<Book> queryAll() {//查询
		String sql = "select * from book";
		return executeQuery(sql, Book.class);
	}

	@Override
	public int insert(Book book) {//插入
		String sql = "insert into book(bname,author,price) values(?,?,?)";
		return executeUpdate(sql, book.getBname(),book.getAuthor(),book.getPrice());
	}

	@Override
	public int update(Book book) {//更新
		String sql = "update book set bname=?,author=?,price=? where bid=?";
		return executeUpdate(sql, book.getBname(),book.getAuthor(),book.getPrice(),book.getBid());
	}

	@Override
	public int delete(int bid) {//删除
		String sql = "delete from book where bid = ?";
		return executeUpdate(sql, bid);
	}

}
