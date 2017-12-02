package com.bookStore.Service;

import java.util.List;

import com.bookStore.model.Book;

public interface BookService {

	public List<Book> getBooks();
	public List<Book> editBook(Book b);
	public List<Book> deleteBook(int id);
	public List<Book> addBook(Book b);
	public Book getBook(int i);
}
