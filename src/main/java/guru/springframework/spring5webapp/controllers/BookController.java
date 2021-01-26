package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    //bring instance of book repo
    private final BookRepository bookRepository;

    //needed for Dependency Injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        //for this model, add attribute called books and execute bookRepository
        model.addAttribute("books", bookRepository.findAll());
        //looks for list template inside directory books (thymeleaf template  )
        return "books/list";
    }


}
