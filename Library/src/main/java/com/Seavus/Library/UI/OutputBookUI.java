package com.Seavus.Library.UI;

/**
 * In order first version to work where there is only
 * book entity
 */

import java.util.List;

import com.Seavus.Library.Model.Book;

public interface OutputBookUI {

	public void list(List<Book> objects);

	public void appInfo();

}
