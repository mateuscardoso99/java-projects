package br.csi.servlet_spring_aula.controller;


import br.csi.servlet_spring_aula.model.Livro;
import br.csi.servlet_spring_aula.service.LivroService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private SessionFactory sessionFactory;
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping("/addLivro")
    public String addLivroView(Model model){
        System.out.println("chamou o get de addLivro");
        model.addAttribute("livro", new Livro());
        return "addLivro";
    }

    @PostMapping("/addLivro")
    public RedirectView addLivroView(@ModelAttribute("livro") Livro livro, RedirectAttributes redirectAttributes){
        System.out.println("chamou o POST de addLivro");
        final RedirectView redirectView = new RedirectView("/livro/addLivro", true);
        Livro livroSalvo = livroService.save(livro);
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(livro);
        redirectAttributes.addFlashAttribute("livroSalvo", livroSalvo);
        redirectAttributes.addFlashAttribute("addLivroSucesso", true);
        redirectAttributes.addFlashAttribute("livros", livroService.getLivros());
        return redirectView;
    }

    @GetMapping("/lista")
    public String listarLivros(Model model){

        model.addAttribute("livros", livroService.getLivros());

        return "lista-livros";
    }

}
