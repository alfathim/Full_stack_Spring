package cog.fsd.java.assgn2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cog.fsd.java.assgn2.dto.Book;
import cog.fsd.java.assgn2.repository.BookRepository;

@Service("bookService")
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Transactional
	public List<Book> getAllBook() {
		List<Book> books=new ArrayList<Book>();
		Iterable<Book> bookIterable=bookRepository.findAll();
		Iterator<Book> booksIterator=bookIterable.iterator();
		while(booksIterator.hasNext())
		{
			books.add(booksIterator.next());
		}
		return books;
	}

	@Transactional
	public Optional<Book> getBook(int id) {
		return bookRepository.findById(id);
	}

	@Transactional
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Transactional
	public void updateBook(Book book) {
		bookRepository.save(book);

	}

	@Transactional
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	
	@Transactional
	public Book searchBook(String title) {
		return bookRepository.findBookByTitle(title);
	}
}
