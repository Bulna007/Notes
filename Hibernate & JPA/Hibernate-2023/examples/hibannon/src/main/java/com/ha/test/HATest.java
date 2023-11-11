package com.ha.test;

import com.ha.dao.BookDao;
import com.ha.entities.Book;
import com.ha.helper.SFRegistry;

public class HATest {
	public static void main(String[] args) {
		try {
			BookDao dao = new BookDao();
			Book book = dao.getBook(1);
			System.out.println(book);
		} finally {
			SFRegistry.closeSessionFactory();
		}
	}
}
