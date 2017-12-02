package com.bookStore.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bookStore.Service.BookService;
import com.bookStore.model.Book;
import org.apache.log4j.Logger;

public class DefaultBookServiceImpl implements BookService {

private static Map<Integer, Book> books;
private static DefaultBookServiceImpl defaultbookservice;
private static Logger logger = Logger.getLogger(DefaultBookServiceImpl.class);
static{
	defaultbookservice = new DefaultBookServiceImpl();
	books = new HashMap<Integer ,Book>();
	for (int i =0 ; i<5 ;i++){
		books.put(i, new Book("BookTite" + i , "BookAuthor" +i , i , i * 2.0F));
	}
}
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		List<Book> listofBooks = new ArrayList<Book>();
		logger.warn("This is warn : " );
		logger.error("This is error : " );
		logger.fatal("This is fatal : " );
		logger.debug("This is debug : " );
		for (Entry<Integer, Book> e : books.entrySet()){
			listofBooks.add(e.getValue());
		}
		return listofBooks;
	}

	@Override
	public List<Book> editBook(Book b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Book getBook(int i) {
		// TODO Auto-generated method stub
		
		return books.get(i);
	}
	@Override
	public List<Book> deleteBook(int id) {
		// TODO Auto-generated method stub
		books.remove(id);
		return getBooks();
	}
	
	public static DefaultBookServiceImpl getBookService(){
		return defaultbookservice;
	}

	@Override
	public List<Book> addBook(Book b) {
		books.put(b.getId(), b);
		return getBooks();
	}

}
