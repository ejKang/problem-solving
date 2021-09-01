package com.joo.book.springboot.springbootwebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joo.book.springboot.springbootwebservice.service.team.TeamService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TeamApiController {

    private final TeamService postsService;

    @GetMapping("/api/v1/member")
    public Long getTestmm() {
        return postsService.getmm();
    }
    
    @GetMapping("/api/v1/member2")
    public Long getTestmm2() {
        return postsService.getmm2();
    }
    
    @GetMapping("/api/v1/memberJoinFetch")
    public Long getMemberJoinFetch() {
        return postsService.getMemberJoinFetch();
    }
    
    @GetMapping("/api/v1/memberJoin")
    public Long getMemberJoin() {
        return postsService.getMemberJoin();
    }
    
    @GetMapping("/api/v1/memberJoinFetch2")
    public Long getMemberJoinFetch2() {
        return postsService.getMemberJoinFetch2();
    }
    
    @GetMapping("/api/v1/memberJoin2")
    public Long getMemberJoin2() {
        return postsService.getMemberJoin2();
    }
}
