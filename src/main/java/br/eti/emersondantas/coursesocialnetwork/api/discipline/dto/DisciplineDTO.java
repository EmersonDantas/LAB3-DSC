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
public class DisciplineDTO implements Serializable {

    private static final long serialVersionUID = -214863204542986002L;

    private Long id;

    @NonNull
    private String nome;

    private Double nota;

    public static DisciplineDTO from(Discipline discipline) {
        return DisciplineDTO.builder()
                .id(discipline.getId())
                .nome(discipline.getNome())
                .nota(discipline.getNota())
                .build();
    }

    public static List<DisciplineDTO> from(List<Discipline> disciplines) {
        return disciplines.stream().map(DisciplineDTO::from).collect(Collectors.toList());
    }
}
