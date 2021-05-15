package br.eti.emersondantas.coursesocialnetwork.api.discipline.services;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Comment;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.CommentRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.DisciplineRepository;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.CommentDTO;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.DisciplineNotFoundException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.service.JWTService;
import br.eti.emersondantas.coursesocialnetwork.api.user.UserRepository;
import br.eti.emersondantas.coursesocialnetwork.api.user.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCommentServiceImpl implements CreateCommentService{

    private final DisciplineRepository disciplineRepository;

    private final CommentRepository commentRepository;

    private final JWTService jwtService;

    private final UserRepository userRepository;

    @Override
    public Discipline create(CommentDTO comment, Long disciplineId, String authHeader) {
        userRepository.findByEmail(this.jwtService.getSujeitoDoToken(authHeader)).orElseThrow(UserNotFoundException::new);

        Discipline discipline = this.disciplineRepository.findById(disciplineId).orElseThrow(DisciplineNotFoundException::new);
        this.commentRepository.save(Comment.builder().comentario(comment.getComentario()).disciplina(discipline).build());
        return discipline;
    }
}
