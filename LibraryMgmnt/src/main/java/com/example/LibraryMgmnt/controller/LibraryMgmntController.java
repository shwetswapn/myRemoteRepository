package com.example.LibraryMgmnt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryMgmnt.model.BookDetails;
import com.example.LibraryMgmnt.service.LibraryMgmntService;

//adding comment to check my branch trial
//adding second comment for trial
@RestController
public class LibraryMgmntController {
	@Autowired
	private LibraryMgmntService libraryMgmntService;
	
	@GetMapping("/hello")
	public String greetUser() {
		return libraryMgmntService.displayMessage();
	}
	@GetMapping(value = "/getallbooks")
	public List<BookDetails> fetchAllBooks() {
		return libraryMgmntService.getAllBooksDetails();
	}
	
	//@RequestMapping(value = "/addbook", method =RequestMethod.POST)
	@PostMapping(value = "/addbook")
	@ResponseBody
	public ResponseEntity<BookDetails> addBookDetails(@RequestBody BookDetails book) {
		BookDetails bookToReturn= libraryMgmntService.addBookDetails(book);
		return ResponseEntity.ok(bookToReturn);
	}

	@GetMapping("/book/{isbn}")
	@ResponseBody
	public Optional<BookDetails> fetchABook(@PathVariable Long isbn) {
		return libraryMgmntService.getBook(isbn);
	}
	
	@DeleteMapping("/book/{isbn}")
	public String deleteBook(@PathVariable Long isbn) {
		return libraryMgmntService.deleteBook(isbn);
	}
	
	@GetMapping("/books/count")
	public long countAllBooks() {
		return libraryMgmntService.countBooks();
	}
	
	@PostMapping("/addBooks")
	@ResponseBody
	public List<BookDetails> addAllBooks(@RequestBody List<BookDetails> bookList) {
		return libraryMgmntService.addAllBooks(bookList);
	}

	@DeleteMapping("/cancelBooking/{booking_id}")
	public String cancelOrder(@PathVariable Long isbn) {
		return libraryMgmntService.cancelOrder(isbn);
	}
	
	@PostMapping("/borrowBook/{isbn}/{quantity}")
	@ResponseBody
	public Optional<BookDetails> orderBook(@PathVariable long isbn,@PathVariable int quantity) {
		return libraryMgmntService.createOrder(isbn,quantity);
	}
	
	@PostMapping("/borrowMultipleBooks")
	@ResponseBody
	public int boorowMultipleBooks(@RequestBody List<BookDetails> list){
		return libraryMgmntService.borrowMultiBooks(list);
	}
}
