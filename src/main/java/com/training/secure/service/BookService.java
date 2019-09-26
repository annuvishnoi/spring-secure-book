package com.training.secure.service;

import java.util.List;

import com.training.secure.model.Book;

public interface BookService {
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public String deleteBook(String title);
	public List<Book> searchBook(String bookTitle);
}