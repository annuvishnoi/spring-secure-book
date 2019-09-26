package com.training.secure.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.secure.model.Book;


@Repository
@Transactional
public class BookDAOImpl implements BookDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> getAllBooks() {
		Session session= this.sessionFactory.getCurrentSession();
		Query<Book> query= session.createQuery("from Book",Book.class);
		List<Book> books=query.getResultList();
		return books;
	}
	public String deleteBook(String subTitle) {
		
		String hql = "delete FROM Book b WHERE b.title ='" + subTitle + "'";
		Session session= this.sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery(hql);
		int results = query.executeUpdate();
		if(results == 0) {
			System.out.println("Book is not found." + subTitle);
			return "Book is not found." + subTitle;
		} else {
			System.out.println("Book deleted successfully." + subTitle);
			return "Book deleted successfully." + subTitle;
		}
	}

	public void addBook(Book book) {
		Session session= this.sessionFactory.getCurrentSession();
		session.save(book);
		System.out.println("Book added successfully." + book);

	}
	
	public List<Book> searchBook(String bookTitle) {
		Session session= this.sessionFactory.getCurrentSession();
		String hql = "FROM Book b WHERE b.title = '" + bookTitle +"'";
		Query query = session.createQuery(hql);
		List<Book> books = query.list();
		for (Book searchBook : books) {
			System.out.println("Book Id: " + searchBook.getBookId());
			System.out.println("Book Title: " + searchBook.getTitle());
			System.out.println("Price: " + searchBook.getPrice());
			System.out.println("Volume: " + searchBook.getVolume());
			System.out.println("Publish Date: " + searchBook.getPublishDate());
		}
		if(books == null || books.size() == 0) {
			System.out.println("Subject is not found.");
		}
		return books;
	}
}
