package com.kim.dani.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity//시큐리티를 활성화하겠다라는 애노테이션 webSecurity 를 상속받아야한다. 지원종료?
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // h2 console 하위 모든요청과 favicon 은 모두 무시하는것으로 설정
    @Override
    public void configure(WebSecurity web){
        web
                .ignoring()
                .antMatchers("/h2-console/**", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()    //HttpservletRequest를 사용하는 요청들에 대한 접근 제한을 설정하겠다는 의미
                .antMatchers("/api/hello").permitAll()  //api/hello 에대한 요청접근은 허용하겠다.
                .anyRequest().authenticated();        //나머지 요청에대해서는 인증을 받아라
    }


}
