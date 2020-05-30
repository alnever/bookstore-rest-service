package bookstore.controllers;

import bookstore.models.Book;
import bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public Iterable<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> get(@PathVariable long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("books/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book save(@PathVariable long id, @RequestBody Book book) {
        // bookRepository.findById(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable long id) {
        bookRepository.deleteById(id);
    }



}
