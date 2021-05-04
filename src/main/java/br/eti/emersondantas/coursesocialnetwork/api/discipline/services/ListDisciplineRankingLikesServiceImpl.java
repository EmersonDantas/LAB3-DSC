package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListDisciplineRankingLikesServiceImpl implements ListDisciplineRankingLikesService {

    private final DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> listRankingLikes() {
        return this.disciplineRepository.findAllByOrderByLikesDesc();
    }

}
