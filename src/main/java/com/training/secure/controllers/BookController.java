package com.training.secure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.secure.model.Book;
import com.training.secure.model.Subject;
import com.training.secure.service.BookService;
import com.training.secure.service.SubjectService;


@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	SubjectService subjectService;

	@RequestMapping("/addbook")
	public String bookform(Model model) {
		model.addAttribute("book", new Book());
		List<Subject> objects = subjectService.getAllSubjects();
		model.addAttribute("subjects", objects);
		return "bookform";
	}
	
	@RequestMapping("/deletebookform")
	public String deletebookform() {
		return "deletebookform";
	}
	
	@RequestMapping("/searchbook")
	public String searchbookform() {
		return "searchbookform";
	}
	@RequestMapping(value ="/savebook", method = RequestMethod.POST)
	public String savebook(@ModelAttribute("Book") Book book, Model model) {
		bookService.addBook(book);
		model.addAttribute("book", book);
		return "success";
	}
	@RequestMapping(value = "/searchBook")
	public String Search(@RequestParam("searchString") String searchString, Model model) {
		List<Book> books = bookService.searchBook(searchString);
		model.addAttribute("books", books);
		return "searchResult";
	}

	@RequestMapping(value = "/deleteBook")
	public String delete(@RequestParam("bookTitle") String bookTitle, Model model) {
		
		String result = bookService.deleteBook(bookTitle);
		model.addAttribute("books", bookService.getAllBooks());
		model.addAttribute("fromBook", true);
		model.addAttribute("result", result);
		return "deleteResult";
	}
}

