package com.zmb.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bookClub.models.Book;
import com.zmb.bookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	//find all
	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	//create one
		public Book create(Book newBook) {
			return bookRepo.save(newBook);
		}
	//retrieves one
	public Book find(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	//update one
	public Book update(Book oneBook) {
		return bookRepo.save(oneBook);
	}
	//delete one
	public void delete(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			bookRepo.deleteById(id);
		}
	}
}
