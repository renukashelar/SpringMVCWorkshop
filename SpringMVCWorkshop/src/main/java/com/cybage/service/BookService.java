package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cybage.model.Book;

@Service
public class BookService {

List<Book> bookList=new ArrayList<Book>();
	
	public BookService() {
		bookList.add(new Book(1, "Believe in yourself", "mohan patil", "mohan patil"));
		bookList.add(new Book(2, "A positive attitude", "Anita arya", "anita arya"));
		bookList.add(new Book(3, "Chanakya niti", "Chanakya", "Chanakya"));
		
		
	}

	public List<Book> getBook() {
		return bookList;
		// TODO Auto-generated method stub
		
	}

	public void addBook(Book book) {
		bookList.add(book);
		
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		
		bookList.removeIf(book -> book.getId() == id );
		
	}

	public Book getBookId(int id) {
		// TODO Auto-generated method stub
		Book book1=bookList.stream().filter(book->book.getId()==id).findFirst().get();
		return book1;
	}

	public void updateBook(@Valid Book book) {
		// TODO Auto-generated method stub
		Book book1=bookList.stream().filter(book2->book2.getId()==book.getId()).findFirst().get();
		int index=bookList.indexOf(book1);
		bookList.set(index, book);
		
	}


	
}
