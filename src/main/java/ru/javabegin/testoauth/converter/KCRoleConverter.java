package ru.javabegin.testoauth.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class KCRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        //получаем доступ к разделу JSON
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

        //если раздел JSON не будет найден, значит нет ролей
        if(realmAccess == null || realmAccess.isEmpty()){
            return new ArrayList<>();
        }

        //получаем объект список ролей и преобразуем в коллекцию GrantedAuthority
        Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles"))
                .stream().map(roleName -> "ROLE_" + roleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return returnValue;
    }
}
