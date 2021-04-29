package com.joo.book.springboot.springbootwebservice.web;

import com.joo.book.springboot.springbootwebservice.service.posts.PostsService;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsResponseDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = PostsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
