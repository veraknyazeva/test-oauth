package ru.javabegin.testoauth.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/delete/{id}") //@PreAuthorize проверяет роль до выполнения PostAuthorize после выполнения
    public String delete(@PathVariable(name = "id") String id, @AuthenticationPrincipal Jwt jwt) { //@AuthenticationPrincipal говорит, что мы хотим получить не только ид пользователя, но и сам json access token
        System.out.println("jwt.getClime(\"email\") = " + jwt.getClaims());
        System.out.println("id delete = " + id);
        return "delete";
    }
}
