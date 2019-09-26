package com.training.secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.secure.dao.BookDAO;
import com.training.secure.dao.SubjectDAO;
import com.training.secure.model.Book;
import com.training.secure.model.Subject;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDao;
	
	@Autowired
	SubjectDAO subjectDao;

	public void addBook(Book book) {
		Subject subject  = subjectDao.getSubject(book.getSelectedSubject());
		book.setSubject(subject);
		bookDao.addBook(book);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public String deleteBook(String title) {
		return bookDao.deleteBook(title);
	}

	public List<Book> searchBook(String bookTitle) {
		return bookDao.searchBook(bookTitle);
	}

}
