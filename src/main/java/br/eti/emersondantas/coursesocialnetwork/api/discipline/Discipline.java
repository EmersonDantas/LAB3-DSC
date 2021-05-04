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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder(builderClassName = "Builder")
@Entity
public class Discipline implements Serializable {

    private static final long serialVersionUID = -1213774996663578291L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_generator")
    @SequenceGenerator(name = "discipline_generator", sequenceName = "discipline_sequence", allocationSize = 1)
    private Long id;

    @NonNull
    private String nome;

    private Double nota;

    @Column(name = "amount_likes")
    private Long likes;

    @OneToMany(mappedBy = "disciplina")
    private List<Comment> comentarios = new ArrayList<>();

    public static Discipline from(DisciplineCreationDTO discipline) {
        return Discipline.builder()
                .nome(discipline.getNome())
                .nota(discipline.getNota())
                .build();
    }
}
