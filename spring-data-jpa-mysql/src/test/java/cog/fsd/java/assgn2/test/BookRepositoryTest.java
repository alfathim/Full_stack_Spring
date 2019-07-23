package cog.fsd.java.assgn2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import cog.fsd.java.assgn2.dto.Book;
import cog.fsd.java.assgn2.repository.BookRepository;
import cog.fsd.java.assgn2.service.BookService;

@RunWith(MockitoJUnitRunner.class)

public class BookRepositoryTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository repository;

    @Test
    public void testFindByName() {
    	
    	Book b =new Book();
    	b.setId(1);
    	b.setTitle("one");
    	b.setPrice(1.0);
    	
    	List<Book> lst  = new ArrayList<Book>();
    	lst.add(b);
    	
    	Iterator<Book> iterator = lst.iterator();
    	
    	Iterable<Book> iterableMock = Mockito.mock(Iterable.class); 
    	
    	Mockito.when(repository.findAll()).thenReturn(iterableMock);
    	Mockito.when(iterableMock.iterator()).thenReturn(iterator);
    //	Mockito.when(iterableMock.iterator().hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
    	
    	List<Book> bookLst =bookService.getAllBook();
    	assertEquals(1, bookLst.size());   

    }
    
    @Test
    public void testSearchBook() {
    	
    	Book b =new Book();
    	b.setId(1);
    	b.setTitle("One");
    	b.setPrice(1.0);
    	
    	Mockito.when(repository.findBookByTitle("One")).thenReturn(b);    	
    	
    	Book book =bookService.searchBook("One");
    	assertEquals("One", book.getTitle());   

    }
    
    @Test
    public void testGetBook() {
    	
    	Book b =new Book();
    	b.setId(1);
    	b.setTitle("One");
    	b.setPrice(1.0);
    	
    	Optional<Book> op = Optional.of(b);
    	
    	
    	Mockito.when(repository.findById(1)).thenReturn(op);    	
    	
    	Optional<Book> book =bookService.getBook(1); 
    	assertEquals("One", book.get().getTitle());   

    }

}
