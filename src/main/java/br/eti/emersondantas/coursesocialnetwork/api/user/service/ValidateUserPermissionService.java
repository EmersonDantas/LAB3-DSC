package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;

@FunctionalInterface
public interface ValidateUserPermissionService {

    boolean userHasPermission(String authorizationHeader, String email);

}
