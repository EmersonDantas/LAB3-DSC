package br.eti.emersondantas.coursesocialnetwork.api.discipline;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import lombok.Builder;
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
@Entity(name = "dsc_like")
public class Like implements Serializable {

    private static final long serialVersionUID = -2245639974192919120L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_generator")
    @SequenceGenerator(name = "like_generator", sequenceName = "like_sequence", allocationSize = 1)
    private Long id;

    @JoinColumn(name = "discipline_id")
    @ManyToOne
    private Discipline disciplina;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User usuario;

    public Like() {
    }

    public Like(Long id, Discipline disciplina, User usuario) {
        this.id = id;
        this.disciplina = disciplina;
        this.usuario = usuario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return getId().equals(like.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
