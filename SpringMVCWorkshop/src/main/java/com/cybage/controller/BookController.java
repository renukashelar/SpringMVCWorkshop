package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Book;
import com.cybage.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@GetMapping("/getAllBook")
	public ModelAndView getAllBook() {
		List<Book> bookList= bookService.getBook();
		 return new ModelAndView("dispalyBook","bookList",bookList);
		
	}
	
	
@GetMapping("/addBook")
	public String showForm(Model model) {
		
		model.addAttribute("book", new Book());
		
		return "addBook";
	}
	
	
@PostMapping("/addBook")
public ModelAndView addBook(@Valid @ModelAttribute("book") Book book,BindingResult result) {
	if(result.hasErrors()) {
		return new ModelAndView("addBook","book",book);
	}
	
	bookService.addBook(book);
	return new ModelAndView("dispalyBook","bookList",bookService.getBook());
	
}


@GetMapping("/deleteBook/{id}")
public ModelAndView deleteBook(@PathVariable int id) {
	bookService.deleteBook(id);
	return new ModelAndView("dispalyBook","bookList",bookService.getBook());
}
@GetMapping("/edit/{id}")
public ModelAndView showUpdateBook(@PathVariable int id) {
	Book book=bookService.getBookId(id);
	return new ModelAndView("updateBook","book",book);
}

@PostMapping("/updateBook")
public ModelAndView updateBook(@Valid @ModelAttribute("book") Book book) {
	
	
	bookService.updateBook(book);
	return new ModelAndView("dispalyBook","bookList",bookService.getBook());
	
}


@GetMapping("/getBookById")
public String showFormId() {
	return "book";
}

@PostMapping("/getBook")
public ModelAndView getEmployeeById(@RequestParam("bookId") int id) {
	
	
	Book book=bookService.getBookId(id);
	return new ModelAndView("BookDetail","bookInfo",book);
	
}
	
	
}
