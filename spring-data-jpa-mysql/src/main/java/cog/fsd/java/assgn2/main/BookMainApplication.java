package cog.fsd.java.assgn2.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cog.fsd.java.assgn2.service.BookService;

@SpringBootApplication

@ComponentScan ({"cog.fsd.java.assgn2"})
@EnableJpaRepositories("cog.fsd.java.assgn2")
@EntityScan({"cog.fsd.java.assgn2"})
//public class BookMainApplication  implements CommandLineRunner{

public class BookMainApplication  extends SpringBootServletInitializer{

	@Autowired
	BookService bookService;	
	
	
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(BookMainApplication.class, args);
	    }

	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//listt all book 
		System.out.println("===all books==="+bookService.getAllBook());
		
		//Book by id 
		System.out.println("===Book by id 4 ==="+bookService.getBook(4));
		
	}

}
