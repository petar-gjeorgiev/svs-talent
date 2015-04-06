package com.Seavus.Library.Dao;

import java.util.List;

import com.Seavus.Library.Model.Book;

/**
 * 
 * @author Petar Gjeorgiev
 * 
 * This version is done for the first version of the app when
 * there was only book entity .. No need of this for the later version
 * 
 * There is possible solution with one interface but
 * because casting object is not safe that's why i have different interfaces
 * for each model .. 
 *
 */

public interface HibernateBookDao {

	public void register(Book object);

	public List<Book> list();

	public void update(Book object);

	public void unregister(long id);

	public void createSessionFactory();

	public void closeFactory();

}
