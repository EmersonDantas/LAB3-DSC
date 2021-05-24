package br.eti.emersondantas.coursesocialnetwork.api.discipline.dto;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
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
@RequiredArgsConstructor
@ToString
@Builder(builderClassName = "Builder")
public class DisciplineListDTO implements Serializable {

    private static final long serialVersionUID = -214863204542986002L;

    private Long id;

    @NonNull
    private String nome;

    private Double nota;

    private Long qtdLikes;

    public static DisciplineListDTO from(Discipline discipline) {
        return DisciplineListDTO.builder()
                .id(discipline.getId())
                .nome(discipline.getNome())
                .nota(discipline.getNota())
                .qtdLikes(discipline.getLikes() != null ? discipline.getLikes().size() : 0L)
                .build();
    }

    public static List<DisciplineListDTO> from(List<Discipline> disciplines) {
        return disciplines.stream().map(DisciplineListDTO::from).collect(Collectors.toList());
    }
}
