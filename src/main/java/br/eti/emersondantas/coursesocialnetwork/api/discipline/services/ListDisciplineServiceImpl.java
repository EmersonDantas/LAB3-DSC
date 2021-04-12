package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListDisciplineServiceImpl implements ListDisciplineService{

    private final DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> list() {
        return this.disciplineRepository.findAll();
    }
}
