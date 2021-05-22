package com.joo.book.springboot.springbootwebservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class HelloResponseDto {
    private String name;
    private int amount;
}
