package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import org.springframework.stereotype.Service;

@FunctionalInterface
@Service
public interface UpdateNameDisciplineService {

    Discipline updateName(Long id, String newName);

}
