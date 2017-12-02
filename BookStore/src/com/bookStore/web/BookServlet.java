package com.bookStore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStore.model.Book;
import com.bookStore.Service.BookService;
import com.bookStore.Service.impl.DefaultBookServiceImpl;

public class BookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("path is" + req.getServletPath());
String path = req.getServletPath();
	switch (path){
	case "/index":
		showBooks(req, resp);
		break;
	case "/new":
		addBook(req, resp);
		break;
	case "/edit":
		editBook(req, resp);
		break;
	case "/saveNewBook":
		saveBook(req, resp);
		break;
	case "/delete":
		deleteBook(req, resp);
		break;
	case "/updatebook":
		updateBook(req, resp);
		break;
	default:
		showBooks(req, resp);
		break;
	
	}
	}

	public void addBook(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher rd=  req.getRequestDispatcher("/EditBook.jsp");
		//BookService bookService = DefaultBookServiceImpl.getBookService();
		//Book b= bookService.getBook(Integer.parseInt(req.getParameter("id")));
		//req.setAttribute("book", b);
		
		rd.forward(req, resp);
	}
	
	public void editBook(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher rd=  req.getRequestDispatcher("/EditBook.jsp");
		BookService bookService = DefaultBookServiceImpl.getBookService();
		Book b= bookService.getBook(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("book", b);
		
		rd.forward(req, resp);
	}
	public void updateBook(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		BookService bookService = DefaultBookServiceImpl.getBookService();
		int i = Integer.parseInt(req.getParameter("id") );
		List<Book> listofBooks = bookService.addBook(new Book((String)req.getParameter("title") , (String)req.getParameter("author") , i , Float.parseFloat(req.getParameter("price"))));

		
		RequestDispatcher rd=  req.getRequestDispatcher("/Welcome.jsp");
		
		
		
		req.setAttribute("books", listofBooks);
		rd.forward(req, resp);
	}
	public void deleteBook(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		BookService bookService = DefaultBookServiceImpl.getBookService();
		int i = Integer.parseInt(req.getParameter("id") );
		List<Book> listofBooks = bookService.deleteBook(i);

		
		RequestDispatcher rd=  req.getRequestDispatcher("/Welcome.jsp");
		
		
		
		req.setAttribute("books", listofBooks);
		rd.forward(req, resp);
	}
	public void showBooks(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher rd=  req.getRequestDispatcher("/Welcome.jsp");
		
		//Get Books from Service layer
		BookService bookService = DefaultBookServiceImpl.getBookService();
		List<Book> listofBooks = bookService.getBooks();
		//System.out.println("i am first at first step1");
		
		//System.out.println("i am first at first step21");
		PrintWriter pw = resp.getWriter();
		req.setAttribute("books", listofBooks);
		rd.forward(req, resp);
	}
	
	public void saveBook(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		BookService bookService = DefaultBookServiceImpl.getBookService();
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		for (Book b :bookService.getBooks() ){
			intarray.add(b.getId());
		}
		Collections.sort(intarray);
		int i = intarray.get(intarray.size()-1) + 1;
		List<Book> listofBooks = bookService.addBook(new Book((String)req.getParameter("title") , (String)req.getParameter("author") , i , Float.parseFloat(req.getParameter("price"))));

		
		RequestDispatcher rd=  req.getRequestDispatcher("/Welcome.jsp");
		
		
		
		req.setAttribute("books", listofBooks);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
