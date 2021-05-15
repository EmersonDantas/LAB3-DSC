package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.InvalidTypeException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.service.JWTService;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateNoteDisciplineServiceImpl implements UpdateNoteDisciplineService{

    private final DisciplineRepository disciplineRepository;

    private final UserRepository userRepository;

    private final JWTService jwtService;

    @Override
    public Discipline updateNote(Long id, String newNote, String authHeader) {
        userRepository.findByEmail(this.jwtService.getSujeitoDoToken(authHeader)).orElseThrow(UserNotFoundException::new);
        Double note;
        try {
            note = Double.parseDouble(newNote);
        } catch (NumberFormatException e) {
            throw new InvalidTypeException("Token inexistente ou mal formatado!");
        }
        Discipline discipline = this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
        Double lastNote = discipline.getNota() != null ? discipline.getNota() : 0.0;
        discipline.setNota((lastNote + note) / 2);
        return this.disciplineRepository.save(discipline);
    }
}
