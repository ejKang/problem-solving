package com.joo.book.springboot.springbootwebservice.web;

import com.joo.book.springboot.springbootwebservice.service.posts.PostsService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService PostsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", PostsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
