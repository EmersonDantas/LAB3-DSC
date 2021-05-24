package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListDisciplineRankingLikesServiceImpl implements ListDisciplineRankingLikesService {

    private final DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> listRankingLikes() {
        List<Discipline> disciplines = this.disciplineRepository.findAllDisciplinesOrderByLikes();
        disciplines.sort(Comparator.comparingInt(disciplneA -> disciplneA.getLikes().size()));
        Collections.reverse(disciplines);
        return disciplines;
    }

}
