package com.zmb.bookClub.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zmb.bookClub.models.Book;
import com.zmb.bookClub.services.BookService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String renderDashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			session.invalidate();
			return "redirect:/";
		}
		List<Book> books = bookService.getAll();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("newBook")Book book) {
		return "addBook.jsp";
	}
	@PostMapping("/books/new")
	public String processCreateBook(@Valid@ModelAttribute("newBook")Book book, BindingResult result ) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}else {			
			bookService.create(book);
			return "redirect:/books";
		}
	}
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.find(id));
		return "showBook.jsp";
	}
	@DeleteMapping("/books/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	//EDIT
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.find(id));
		return "updateBook.jsp";
	}
	@PutMapping("/books/{id}/edit")
	public String edit(@Valid@ModelAttribute("book")Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "updateBook.jsp";
		} else {
			bookService.update(book);
			return "redirect:/books/"+ book.getId();
		}
	}
}
