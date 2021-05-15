package br.eti.emersondantas.coursesocialnetwork.api.discipline;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.DisciplineCreationDTO;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
@Builder(builderClassName = "Builder")
@Entity
public class Discipline {

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

    public Discipline(Long id, @NonNull String nome, Double nota, Long likes, List<Comment> comentarios) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.likes = likes;
        this.comentarios = comentarios;
    }

    public Discipline() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public List<Comment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comment> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
