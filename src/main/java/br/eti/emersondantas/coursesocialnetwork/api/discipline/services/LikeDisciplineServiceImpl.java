package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.service.JWTService;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeDisciplineServiceImpl implements LikeDisciplineService {

    private final DisciplineRepository disciplineRepository;

    private final JWTService jwtService;

    private final UserRepository userRepository;

    @Override
    public Discipline likeDiscipline(Long id, String authHeader) {
        userRepository.findByEmail(this.jwtService.getSujeitoDoToken(authHeader)).orElseThrow(UserNotFoundException::new);

        Discipline discipline = this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
        discipline.setLikes(discipline.getLikes() + 1L);
        return this.disciplineRepository.save(discipline);
    }

}
