package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import org.springframework.stereotype.Service;

@FunctionalInterface
@Service
public interface DeleteUserService {

    User delete(String email, String authHeader);

}
