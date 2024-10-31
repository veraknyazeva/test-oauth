//package ru.javabegin.testoauth.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @GetMapping("/delete/{id}") //@PreAuthorize проверяет роль до выполнения PostAuthorize после выполнения
//    @PreAuthorize("hasRole('admin')") // в PreAuthorize можно устанавливать дополнительные условия, Secured нельзя(устаревшая)
//    public String delete(@PathVariable(name = "id") String id, @AuthenticationPrincipal Jwt jwt){ //@AuthenticationPrincipal говорит, что мы хотим получить не только ид пользователя, но и сам json access token
//        System.out.println("jwt.getClime(\"email\") = " + jwt.getClaims());
//        System.out.println("id delete = " + id);
//        return "delete";
//    }
//
//    @GetMapping("/internal")
//    @PreAuthorize("hasRole('admin')")
//    public String add(){
//        return "add";
//    }
//
//    @GetMapping("/view")
//    @PreAuthorize("hasRole('user')")
//    public String view(){
//        return "view";
//    }
//}
//
//
////в кейлок Bearer могут быть слова Basic (передаются логин/пароль),
//// Digest (hash-значение от логина/пароля) и некоторые другие