package com.example.exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Author is required")
    private String author;

    @Pattern(regexp = "\\b(?:Academic|Mystery|Novel)\\b",message = "Category Not Valid")
    @Column(columnDefinition = "varchar(20) not null check(category='Academic' or category='Mystery' or category='Novel')")
    private String category;

    @NotNull(message = "ISBN is required")
    @Positive
    @Column(columnDefinition = "int unique")
    private Integer isbn;

    @NotNull(message = "Number of pages is required")
    @Min(value = 50)
    @Positive
    private Integer numberOfPages;
}
