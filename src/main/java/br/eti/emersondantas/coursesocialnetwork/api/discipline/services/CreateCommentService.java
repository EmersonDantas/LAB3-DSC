package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.CommentDTO;
import org.springframework.stereotype.Service;

@FunctionalInterface
@Service
public interface CreateCommentService {

    Discipline create(CommentDTO comment, Long disciplineId, String authHeader);

}
