package com.joo.book.springboot.springbootwebservice.web;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import com.joo.book.springboot.springbootwebservice.config.auth.LoginUser;
import com.joo.book.springboot.springbootwebservice.config.auth.dto.SessionUser;
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
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", PostsService.findAllDesc());
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
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
