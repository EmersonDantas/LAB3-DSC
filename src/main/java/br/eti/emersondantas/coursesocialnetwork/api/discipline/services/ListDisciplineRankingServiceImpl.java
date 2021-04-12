package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListDisciplineRankingServiceImpl implements ListDisciplineRankingService {

    private final DisciplineRepository disciplineRepository;

    @Override
    public List<Discipline> listRanking() {
        return this.disciplineRepository.findAllOrderByNota();
    }

}
