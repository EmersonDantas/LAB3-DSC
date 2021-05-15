package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.jwt.service.JWTService;
import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidateUserPermissionServiceImpl implements ValidateUserPermissionService {

    private UserRepository userRepository;

    private final JWTService jwtService;

    @Override
    public boolean userHasPermission(String authorizationHeader, String email) {
        String subject = jwtService.getSujeitoDoToken(authorizationHeader);
        Optional<User> optUsuario = userRepository.findByEmail(subject);
        return optUsuario.isPresent() && optUsuario.get().getEmail().equals(email);
    }

}
