package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Comment;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.CommentRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.CommentDTO;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCommentServiceImpl implements CreateCommentService{

    private final DisciplineRepository disciplineRepository;

    private final CommentRepository commentRepository;

    @Override
    public Discipline create(CommentDTO comment, Long disciplineId) {
        Discipline discipline = this.disciplineRepository.findById(disciplineId).orElseThrow(DisciplineNotFoundException::new);
        this.commentRepository.save(Comment.builder().comentario(comment.getComentario()).disciplina(discipline).build());
        return discipline;
    }
}
