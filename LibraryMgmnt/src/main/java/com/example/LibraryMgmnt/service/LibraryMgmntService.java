package com.example.LibraryMgmnt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LibraryMgmnt.model.BookDetails;
import com.example.LibraryMgmnt.model.Order;
import com.example.LibraryMgmnt.repository.BookRepository;
import com.example.LibraryMgmnt.repository.OrderRepository;

@Service
public class LibraryMgmntService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public String displayMessage() {
		return "Hello World in LibraryManagementProject class!!";
	}
	
	public List<BookDetails> getAllBooksDetails() {
		//List<BookDetails> bookListToReturn= new ArrayList<BookDetails>();
		return bookRepository.findAll();
	
	}
	
	public BookDetails addBookDetails( BookDetails bookDetails) {
		bookRepository.save(bookDetails);
		//return "Book details added successfully!!!";
		return bookDetails;
	}

	public Optional<BookDetails>  getBook(Long isbn) {
		 return bookRepository.findById(isbn);
	
	}

	public String deleteBook(Long isbn) {	
		bookRepository.deleteById(isbn);
		return "Deleted!!!!!";
	}
	
	public long countBooks() {
		return bookRepository.count();
	}
	
	public List<BookDetails> addAllBooks(List<BookDetails> bookList) {
		List<BookDetails> listToReturn=bookRepository.saveAll(bookList);
		return listToReturn;
	}

	public String cancelOrder(Long booking_id) {
		orderRepository.deleteById(booking_id);
		return "Order with id "+booking_id+" is canceled!!";
	}

	public Optional<BookDetails> createOrder(long isbn,int quantity) {
		Optional<BookDetails> bookToOrder=bookRepository.findById(isbn);
		Date orderDate=new Date();
		Order myOrder=new Order();
		myOrder.setBooking_date(orderDate);
		myOrder.setQuantity(quantity);
		myOrder.setISBN(isbn);
		orderRepository.save(myOrder);
		return bookToOrder;
	}

	public int borrowMultiBooks(List<BookDetails> list) {
		for(BookDetails book:list) {
			Date orderDate=new Date();
			Order myOrder=new Order();
			myOrder.setBooking_date(orderDate);
			myOrder.setQuantity(1);
			myOrder.setISBN(book.getISBN());
			orderRepository.save(myOrder);
		}
		int noOfBooksBorrowed=list.size();
		return noOfBooksBorrowed;

	}
}
