package com.swapp.swapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapp.swapp.GoogleBooksAPI.GeolocationAPI;
import com.swapp.swapp.GoogleBooksAPI.LivroRequest;
import com.swapp.swapp.model.AutorModel;
import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.CategoriaModel;
import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.service.BooksService;
import com.swapp.swapp.service.UsersService;

@Controller
public class BookController {

    @Autowired
    BooksService s;

    @Autowired
    UsersService usersService;

    @GetMapping("/newbook")
    public String getRegisterPage(Model model, HttpServletRequest request) {
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);
        Books b = new Books();
        b.setEditora(new EditoraModel());
        b.setCategoria(new CategoriaModel());
        b.setLingua(new LinguaModel());
        b.setAutor(new AutorModel());
        model.addAttribute("book", b);
        return "livro_registro";
    }

    @PostMapping("/newbook")
    public String register(@ModelAttribute Books l, Model model, @RequestParam("action") String action, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);
        
        if (action.equals("search_isbn")){
            Books b = s.findByIsbn(l.getIsbn());
            model.addAttribute("book", b);
            return "livro_registro";
        }else{
            if (action.equals("adicionar")){
                s.registerBook(l, u);
            }else{
            }
        }

        model.addAttribute("book", l);

        return "livro_registro";
    }

/*     @GetMapping("/estante")
    public String getEstante(Model model, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);

        List<Books> livros = u.getBookslist();
        model.addAttribute("livros", livros);
        return "estante";
    } */

     @GetMapping("/estante")
    public String getAllPages(Model model, HttpServletRequest request){
        return getOnePage(model, 1, request);
    }

     @GetMapping("/estante/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request){

        Books b = new Books();
        b.setEditora(new EditoraModel());
        b.setCategoria(new CategoriaModel());
        b.setLingua(new LinguaModel());
        b.setAutor(new AutorModel());
        model.addAttribute("book", b);


        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);
        Page<Books> page = s.findPage(currentPage, u);

        int totalPages = page.getTotalPages();
        long totalitems = page.getTotalElements();

        List<Books> livros = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalitems);
        model.addAttribute("livros", livros);
        return "estante";
    }

    @PostMapping("/delete_b")
    public String deleteBook(Model model, @RequestParam String bookID, HttpServletRequest request){

        Integer id = Integer.parseInt(bookID);
        if(bookID != null){
            if(s.findById(id) != null){
                s.deleteBook(bookID);
            }
        }

        return getAllPages(model, request);
    }
}