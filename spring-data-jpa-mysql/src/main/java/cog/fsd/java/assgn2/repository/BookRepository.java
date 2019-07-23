package cog.fsd.java.assgn2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cog.fsd.java.assgn2.dto.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> { 
	
	@Query ("select book  from Book book where book.title = ?1 ")
	Book findBookByTitle(String title);
    
}