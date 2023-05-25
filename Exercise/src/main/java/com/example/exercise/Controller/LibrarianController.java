package com.example.exercise.Controller;

import com.example.exercise.Model.Librarian;
import com.example.exercise.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getLibrarians());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid@RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @Valid@RequestBody Librarian librarian){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("Librarian updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getLibrarianById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.getLibrarianById(id));
    }

    @GetMapping("/get-login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(librarianService.login(username, password));
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getLibrarianByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.getLibrarianByEmail(email));
    }
}
