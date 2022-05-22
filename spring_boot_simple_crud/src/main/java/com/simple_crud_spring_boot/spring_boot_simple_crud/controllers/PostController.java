package com.simple_crud_spring_boot.spring_boot_simple_crud.controllers;

import javax.validation.Valid;

import com.simple_crud_spring_boot.spring_boot_simple_crud.models.Post;
import com.simple_crud_spring_boot.spring_boot_simple_crud.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //indica que é um controller
@RequestMapping("/") //indica que as rotas a partir de '/' cairão nesse controller
//@RestController controller de api rest, por padrão retornará JSON

public class PostController {

    private final PostRepository postRepository;

    @Autowired //permite injeção de dependencia
    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    
    @GetMapping("/index") //mapeia rota get
    public String showPosts(Model model){
        model.addAttribute("posts", postRepository.findAll());
        return "index";
    }

    @GetMapping("new-post")
    public String viewAddPost(Post post){
        return "new-post";
    }

    @PostMapping("storepost") //mapeia rota post
    public String addPost(@Valid Post post, BindingResult result, Model model){
        if(result.hasErrors()){
            return "new-post";
        }

        postRepository.save(post);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    //@PathVariable pega o valor do parametro da rota
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        
        return "update-post";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") long id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "update-post";
        }
        
        postRepository.save(post);

        return "redirect:/index";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        postRepository.delete(post);
        
        return "redirect:/index";
    }
}
