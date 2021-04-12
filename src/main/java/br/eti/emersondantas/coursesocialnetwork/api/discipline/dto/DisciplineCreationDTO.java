package br.eti.emersondantas.coursesocialnetwork.api.discipline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@ToString
@Builder(builderClassName = "Builder")
public class DisciplineCreationDTO implements Serializable {

    private static final long serialVersionUID = 8148215752966399322L;

    @NonNull
    private String nome;

    private Double nota;
}
