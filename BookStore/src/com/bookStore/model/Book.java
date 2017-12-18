package com.bookStore.model;
//this is the model class
public class Book {
	private String title;
	private String author;
	private int id;
	private float price;
	//ading comment on the constructor
	public Book(String title, String author, int id, float price) {
		super();
		this.title = title;
		this.author = author;
		this.id = id;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", id=" + id + ", price=" + price + "]";
	}
	

}
