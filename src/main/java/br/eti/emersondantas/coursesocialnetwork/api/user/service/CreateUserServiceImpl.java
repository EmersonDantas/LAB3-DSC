package br.eti.emersondantas.coursesocialnetwork.api.user.service;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }
}
