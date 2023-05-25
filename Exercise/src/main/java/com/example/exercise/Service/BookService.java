package com.example.exercise.Service;

import com.example.exercise.ApiException.ApiException;
import com.example.exercise.Model.Book;
import com.example.exercise.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book b = bookRepository.getBookByID(id);
        if (b == null)
            throw new ApiException("Not found");

        b.setTitle(book.getTitle());
        b.setCategory(book.getCategory());
        b.setAuthor(book.getAuthor());
        b.setIsbn(book.getIsbn());
        b.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(b);

    }

    public void deleteBook(Integer id){
        Book b = bookRepository.getBookByID(id);
        if (b == null)
            throw new ApiException("Not found");

        bookRepository.delete(b);
    }

    public List<Book> getBooksByCategory(String category){
        List<Book> books = bookRepository.getBooksByCategory(category);
        if (books.size() == 0)
            throw new ApiException("Not found");
        return books;
    }

    public List<Book> getBooksByNumberOfPages(Integer pages){
        List<Book> books = bookRepository.getBooksByNumberOfPages(pages);
        if (books.size() == 0)
            throw new ApiException("Not found");
        return books;
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> books = bookRepository.getBooksByAuthor(author);
        if (books.size() == 0)
            throw new ApiException("Not found");
        return books;
    }

    public Book getBookByTitle(String title){
        Book book = bookRepository.getBookByTitle(title);
        if (book == null)
            throw new ApiException("Not found");
        return book;
    }
}
