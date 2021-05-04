package br.eti.emersondantas.coursesocialnetwork.api.discipline.dto;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(builderClassName = "Builder")
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 8148215752966399322L;

    @NonNull
    private String comentario;

    public static CommentDTO from(Comment comment) {
        return CommentDTO.builder()
                .comentario(comment.getComentario())
                .build();
    }

    public static List<CommentDTO> from(List<Comment> comentarios) {
        return comentarios.stream().map(CommentDTO::from).collect(Collectors.toList());
    }
}
