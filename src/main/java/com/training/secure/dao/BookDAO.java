package com.training.secure.dao;

import java.util.List;

import com.training.secure.model.Book;

public interface BookDAO {
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public String deleteBook(String subTitle);
	public List<Book> searchBook(String bookTitle);
}

