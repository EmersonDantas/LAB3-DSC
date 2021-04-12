package br.eti.emersondantas.coursesocialnetwork.api.discipline;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.DisciplineCreationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder(builderClassName = "Builder")
public class Discipline implements Serializable {

    private static final long serialVersionUID = -1213774996663578291L;

    private Long id;

    @NonNull
    private String nome;

    private Double nota;

    public static Discipline from(DisciplineCreationDTO discipline) {
        return Discipline.builder()
                .nome(discipline.getNome())
                .nota(discipline.getNota())
                .build();
    }
}
