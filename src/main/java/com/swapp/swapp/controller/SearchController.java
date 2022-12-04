package com.swapp.swapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swapp.swapp.model.AutorModel;
import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.CategoriaModel;
import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.service.AutorService;
import com.swapp.swapp.service.BooksService;
import com.swapp.swapp.service.CategoriaService;
import com.swapp.swapp.service.EditoraService;
import com.swapp.swapp.service.LinguaService;
import com.swapp.swapp.service.UsersService;

@Controller
public class SearchController {

    @Autowired
    BooksService s;

    @Autowired
    UsersService usersService;

    @Autowired
    AutorService autorService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    EditoraService editoraService;

    @Autowired
    LinguaService linguaService;


    @GetMapping("/pesquisa")
    public String getAllPages(Model model, HttpServletRequest request){
        return getOnePage(model, 1, request);
    }

    @GetMapping("/pesquisa/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);
        Page<Books> page = s.findPage(currentPage, u);

        int totalPages = page.getTotalPages();
        long totalitems = page.getTotalElements();

        List<Books> livros = page.getContent();
        
        Books b = new Books();
        b.setEditora(new EditoraModel());
        b.setCategoria(new CategoriaModel());
        b.setLingua(new LinguaModel());
        b.setAutor(new AutorModel());
        model.addAttribute("book", b);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalitems);
        model.addAttribute("livros", livros);
        return "pesquisa";
    }

    @GetMapping("/titleAutocomplete")
    @ResponseBody
    public List<String> booksTitlesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = s.findTitles(term);
        return suggestions;
    }

    @GetMapping("/autorAutocomplete")
    @ResponseBody
    public List<String> booksAutorsAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = autorService.findAllNames(term);
        return suggestions;
    }

    @GetMapping("/isbnAutocomplete")
    @ResponseBody
    public List<String> booksIsbnAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = s.findIsbns(term);
        return suggestions;
    }

    @GetMapping("/editoraAutocomplete")
    @ResponseBody
    public List<String> booksEditoraAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = editoraService.findAllNomes(term);
        return suggestions;
    }

    @GetMapping("/generoAutocomplete")
    @ResponseBody
    public List<String> booksGeneroAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = categoriaService.findAllNames(term);
        return suggestions;
    }

    @GetMapping("/linguaAutocomplete")
    @ResponseBody
    public List<String> booksLinguaAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term){
        List<String> suggestions = new ArrayList<String>();
        suggestions = linguaService.fingAllNames(term);
        return suggestions;
    }

}
