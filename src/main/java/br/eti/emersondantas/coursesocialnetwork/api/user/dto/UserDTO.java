package br.eti.emersondantas.coursesocialnetwork.api.user.dto;

import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@ToString
@Builder(builderClassName = "Builder")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -214863204542986002L;

    private String email;

    private String nome;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .nome(user.getNome())
                .build();
    }

    public static List<UserDTO> from(List<User> users) {
        return users.stream().map(UserDTO::from).collect(Collectors.toList());
    }
}
