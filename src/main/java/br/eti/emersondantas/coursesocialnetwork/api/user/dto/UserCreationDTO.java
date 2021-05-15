package br.eti.emersondantas.coursesocialnetwork.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(builderClassName = "Builder")
public class UserCreationDTO implements Serializable {

    private static final long serialVersionUID = -2038242504639073186L;

    private String email;

    private String nome;

    private String senha;

}
