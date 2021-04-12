package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteDisciplineServiceImpl implements DeleteDisciplineService{

    private final DisciplineRepository disciplineRepository;

    @Override
    public void delete(Long id) {
        this.disciplineRepository.findById(id).orElseThrow(DisciplineNotFoundException::new);
        this.disciplineRepository.deleteById(id);
    }
}
