package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDisciplineServiceImpl implements CreateDisciplineService{

    private final DisciplineRepository disciplineRepository;

    @Override
    public Discipline create(Discipline discipline) {
        return this.disciplineRepository.save(discipline);
    }
}
