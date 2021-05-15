package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateUserPasswordServiceImpl implements ValidateUserPasswordService {

    private final UserRepository userRepository;

    @Override
    public boolean validateUserPassword(User user) {
        User foundUser = this.userRepository.findByEmail(user.getEmail()).orElseThrow(UserNotFoundException::new);
        return foundUser.getSenha().equals(user.getSenha());
    }

}
