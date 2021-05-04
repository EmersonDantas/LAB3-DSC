package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeDisciplineServiceImpl implements LikeDisciplineService {

    private final DisciplineRepository disciplineRepository;


    @Override
    public Discipline likeDiscipline(Long id) {
        Discipline discipline = this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
        discipline.setLikes(discipline.getLikes() + 1L);
        return this.disciplineRepository.save(discipline);
    }

}
