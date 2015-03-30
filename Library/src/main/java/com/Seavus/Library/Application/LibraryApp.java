package com.Seavus.Library.Application;

//import com.Seavus.Library.Dao.BookDao;
import com.Seavus.Library.Dao.FactoryDao;
import com.Seavus.Library.Dao.Impl.HibernateBookDaoImpl;
//import com.Seavus.Library.Dao.Impl.JDBCBookDaoImpl;
import com.Seavus.Library.Model.Book;

public class LibraryApp {

	public static void main(String[] args) {
//
//		Book book = new Book(1, "123NA", "Crime and punishment");
//		BookDao bookDao = new JDBCBookDaoImpl();
//
//		Book book2 = new Book(2, "345A", "Hamlet");
//
//		bookDao.registerBook(book);
//
//		bookDao.registerBook(book2);
//
//		bookDao.listAllBooks();
//
//		book = new Book(1, "123NA", "Hamlet");
//
//		bookDao.updateBook(book);
//
//		bookDao.listAllBooks();
//
//		bookDao.unregisterBook(book);
//
//		bookDao.listAllBooks();
		
		
		Book book = new Book("Petar","Prison Break");

		FactoryDao bookDao = new HibernateBookDaoImpl();
		bookDao.createSessionFactory();
		
		bookDao.registerBook(book);
		//bookDao.updateBook(new Book(1,"Leverage"));

		//bookDao.unregisterBook(new Book(1, ""));
		
		bookDao.listAllBooks();
		
		
		bookDao.closeFactory();
	}
}
