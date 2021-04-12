package br.eti.emersondantas.coursesocialnetwork.api.discipline;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Substituindo o JPA, pois nesse Lab não será usado.
 */
@Service
public class DisciplineRepository {

    private final Set<Discipline> disciplines = new HashSet<>();

    private Long currentId = 0L;

    public Discipline save(Discipline discipline) {
        if (discipline.getId() != null) {
            this.disciplines.remove(discipline);
            this.disciplines.add(discipline);
        } else {
            discipline.setId(++this.currentId);
            this.disciplines.add(discipline);
        }
        return discipline;
    }

    public void deleteById(Long id) {
        this.disciplines.removeIf(discipline -> discipline.getId().equals(id));
    }

    public Optional<Discipline> findById(Long id) {
        List<Discipline> foundDisciplines =  this.disciplines.stream().filter(discipline -> discipline.getId().equals(id)).collect(Collectors.toList());
        if (foundDisciplines.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(foundDisciplines.get(0));
    }

    public List<Discipline> findAll() {
        return new ArrayList<>(this.disciplines);
    }

    public List<Discipline> findAllOrderByNota() {
        List<Discipline> allDisciplines = new ArrayList<>(this.disciplines);
        allDisciplines.sort(Comparator.comparing(Discipline::getNota));
        Collections.reverse(allDisciplines);
        return allDisciplines;
    }

}
