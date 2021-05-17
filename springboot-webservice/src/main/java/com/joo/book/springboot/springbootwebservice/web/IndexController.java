package com.joo.book.springboot.springbootwebservice.web;

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
    // private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", PostsService.findAllDesc());
        // SessionUser user = (SessionUser) httpSession.getAttribute("user"); // CustomOAuth2UserService에서 로그인 성공 시 세선에 SessionUser를 저장하도록 구성
        if (user != null) { // 세선에 저장된 값이 있을 때만 model에 userName을 등록해 준다
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
