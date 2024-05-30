package com.elaparato.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class KeyCloakJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  public static final String REALM_ROLES_CLAIM = "realm_access";
  public static final String CLIENT_ROLES_CLAIM = "resource_access";
  public static final String SCOPE_CLAIM = "scope";

  @Override
  public Collection<GrantedAuthority> convert(Jwt source) {

    Collection<GrantedAuthority> authorities = new ArrayList<>();

    Map<String, Object> realmAccessRoles = (Map<String, Object>) source.getClaims().get(REALM_ROLES_CLAIM);
    if (realmAccessRoles!= null && !realmAccessRoles.isEmpty()) {
      authorities.addAll(extractRoles(realmAccessRoles));
    }

    Map<String, Object> clientAccessRoles = (Map<String, Object>) source.getClaims().get(CLIENT_ROLES_CLAIM);
    if (clientAccessRoles != null && !clientAccessRoles.isEmpty()) {
      clientAccessRoles.forEach((client, roles) -> {
        Map<String, Object> clientRoles = (Map<String, Object>) roles;
        if (clientRoles != null && !clientRoles.isEmpty()) {
          authorities.addAll(extractRoles(clientRoles));
        }
      });
    }

    String scopes= (String) source.getClaims().get(SCOPE_CLAIM);
    if (scopes != null && !scopes.isEmpty()) {
      authorities.addAll(extractScopes(scopes));
    }

    return authorities;
  }

  private static Collection<GrantedAuthority> extractRoles(Map<String, Object> realmAccessRoles) {
    return ((List<String>) realmAccessRoles.get("roles"))
            .stream()
            .map(roleName -> "ROLE_" + roleName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  private static Collection<GrantedAuthority> extractScopes(String scopes) {
    return Arrays.stream(scopes.split(" ")).toList()
            .stream().map(roleName -> "SCOPE_" + roleName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }
}
