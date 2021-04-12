package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import org.springframework.stereotype.Service;

@FunctionalInterface
@Service
public interface DeleteDisciplineService {

    void delete(Long id);

}
