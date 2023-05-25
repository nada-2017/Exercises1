package com.example.exercise.Controller;

import com.example.exercise.Model.Book;
import com.example.exercise.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/vi/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAllBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid@RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted");
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBooksByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBooksByCategory(category));
    }

    @GetMapping("/get-pages/{pages}")
    public ResponseEntity getBooksByNumberOfPages(@PathVariable Integer pages){
        return ResponseEntity.status(200).body(bookService.getBooksByNumberOfPages(pages));
    }

    @GetMapping("/get-author/{author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBookByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.getBookByTitle(title));
    }
}
