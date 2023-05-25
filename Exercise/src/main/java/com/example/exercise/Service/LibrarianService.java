package com.example.exercise.Service;

import com.example.exercise.ApiException.ApiException;
import com.example.exercise.Model.Librarian;
import com.example.exercise.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getLibrarians(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id, Librarian librarian){
        Librarian l = librarianRepository.getLibrarianById(id);
        if (l == null)
            throw new ApiException("Not found");
        l.setName(librarian.getName());
        l.setUsername(librarian.getUsername());
        l.setPassword(librarian.getPassword());
        l.setEmail(librarian.getEmail());
        librarianRepository.save(l);
    }

    public void deleteLibrarian(Integer id){
        Librarian l = librarianRepository.getLibrarianById(id);
        if (l == null)
            throw new ApiException("Not found");
        librarianRepository.delete(l);
    }

    public Librarian getLibrarianById(Integer id){
        Librarian l = librarianRepository.getLibrarianById(id);
        if (l == null)
            throw new ApiException("Not found");
        return l;
    }

    public String login(String username, String password){
        Librarian l = librarianRepository.login(username,password);
        if (l == null)
            throw new ApiException("Invalid username or password");
        return "Successful login";
    }

    public Librarian getLibrarianByEmail(String email){
        Librarian l = librarianRepository.getLibrarianByEmail(email);
        if (l == null)
            throw new ApiException("Not found");
        return l;
    }
}
