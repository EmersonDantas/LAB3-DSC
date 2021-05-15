package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserDoesntHavePermissionException;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    private final UserRepository userRepository;

    private final ValidateUserPermissionService validateUserPermissionService;

    @Override
    public User delete(String email, String authHeader) {
        User usuario = this.userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        if (this.validateUserPermissionService.userHasPermission(authHeader, email)) {
            userRepository.delete(usuario);
            return usuario;
        }
        throw new UserDoesntHavePermissionException();
    }

}
