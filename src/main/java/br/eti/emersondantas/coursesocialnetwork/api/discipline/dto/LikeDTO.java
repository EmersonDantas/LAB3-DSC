package br.eti.emersondantas.coursesocialnetwork.api.discipline.dto;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Like;
import br.eti.emersondantas.coursesocialnetwork.api.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
public class LikeDTO implements Serializable {

    private static final long serialVersionUID = -9191572158785669199L;

    @NonNull
    private UserDTO usuario;

    public static LikeDTO from(Like like) {
        return LikeDTO.builder()
                .usuario(UserDTO.from(like.getUsuario()))
                .build();
    }

    public static List<LikeDTO> from(List<Like> likes) {
        return likes.stream().map(LikeDTO::from).collect(Collectors.toList());
    }
}
