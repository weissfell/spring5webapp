package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    //Constructor needed in Controller so Spring injects an instance of the bookrepository into the controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());

        return "books/list"; //return String tells MVC that the view named "books" should be called
        //by naming it books/list we're telling the MVC that it should fetch the template list from the template dir books
    }


}
