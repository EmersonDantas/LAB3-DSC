package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import org.springframework.stereotype.Service;

import java.util.List;

@FunctionalInterface
@Service
public interface ListDisciplineRankingLikesService {

    List<Discipline> listRankingLikes();

}
