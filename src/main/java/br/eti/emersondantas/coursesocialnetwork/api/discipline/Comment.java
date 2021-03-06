package br.eti.emersondantas.coursesocialnetwork.api.discipline;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Objects;

@ToString
@Builder(builderClassName = "Builder")
@Entity
public class Comment implements Serializable {

    private static final long serialVersionUID = -1213774996663578291L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name = "comment_generator", sequenceName = "comment_sequence", allocationSize = 1)
    private Long id;

    @NonNull
    private String comentario;

    @JoinColumn(name = "discipline_id")
    @ManyToOne
    private Discipline disciplina;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User usuario;

    public Comment() {
    }

    public Comment(Long id, @NonNull String comentario, Discipline disciplina, User usuario) {
        this.id = id;
        this.comentario = comentario;
        this.disciplina = disciplina;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Discipline getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Discipline disciplina) {
        this.disciplina = disciplina;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId().equals(comment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
