package com.joo.book.springboot.springbootwebservice.config.auth;

import com.joo.book.springboot.springbootwebservice.domain.user.Role;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // SPRING SECURITY 설정을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면을 사용하기 위해
                .and().authorizeRequests() // url별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "images/**", "/js/**", "h2-console/**", "/hello/dto").permitAll() // 권한관리대상을
                                                                                                               // 지정하는
                                                                                                               // 옵션
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()).anyRequest().authenticated() // 설정된 값들 이외 나머지 url,
                                                                                                  // authenticated 설정은
                                                                                                  // 인증된 사용자들에게만 허용
                .and().logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 설정
                .and().oauth2Login() // oauth2 로그인 기능에 대헌 설정 진입점
                .userInfoEndpoint() // oauth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들
                .userService(customOAuth2UserService); // 로그인 성공 시 후속 조치를 진행할 userservice 구현체를 등록
                                                       // 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시

    }

}
