
package cog.fsd.java.assgn2.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cog.fsd.java.assgn2.dto.Book;
import cog.fsd.java.assgn2.service.BookService;


@Controller
@RequestMapping("/book")
public class BookController {

	private static final Logger logger = Logger
			.getLogger(BookController.class);

	public BookController() {
		System.out.println("BookController()");
	}

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/list")
	public ModelAndView listBook(ModelAndView model) throws IOException {
		List<Book> listBook = bookService.getAllBook();
		System.out.println("===listBook=="+listBook);
		model.addObject("listBook", listBook);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Book book = new Book();
		model.addObject("book", book);
		model.setViewName("BookForm");
		return model;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) throws SQLException {
		
		bookService.addBook(book); 
		
		return new ModelAndView("redirect:/book/list");
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookService.deleteBook(bookId);
		return new ModelAndView("redirect:/book/list");
	}
	
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public ModelAndView searchBook(HttpServletRequest request,ModelAndView model) {
		String title = request.getParameter("title");
		Book  book = bookService.searchBook(title);
		
		model.addObject("book", book);
		model.setViewName("home");
		
		List<Book> listBook = bookService.getAllBook();
		model.addObject("listBook", listBook);
		
		return model;
	}

	/*
	 * @RequestMapping(value = "/editEmployee", method = RequestMethod.GET) public
	 * ModelAndView editContact(HttpServletRequest request) { int employeeId =
	 * Integer.parseInt(request.getParameter("id")); Employee employee =
	 * employeeService.getEmployee(employeeId); ModelAndView model = new
	 * ModelAndView("EmployeeForm"); model.addObject("employee", employee);
	 * 
	 * return model; }
	 */

}