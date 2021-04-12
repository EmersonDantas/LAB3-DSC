package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetDisciplineServiceImpl implements GetDisciplineService{

    private final DisciplineRepository disciplineRepository;

    @Override
    public Discipline get(Long id){
        return this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
    }

}
