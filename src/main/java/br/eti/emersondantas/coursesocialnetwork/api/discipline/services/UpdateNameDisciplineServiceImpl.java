package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateNameDisciplineServiceImpl implements UpdateNameDisciplineService{

    private final DisciplineRepository disciplineRepository;


    @Override
    public Discipline updateName(Long id, String newName) {
        Discipline discipline = this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
        discipline.setNome(newName);
        return this.disciplineRepository.save(discipline);
    }
}
