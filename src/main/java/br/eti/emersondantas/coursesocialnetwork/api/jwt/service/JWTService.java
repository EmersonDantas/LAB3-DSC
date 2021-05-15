package br.eti.emersondantas.coursesocialnetwork.api.jwt.service;

import br.eti.emersondantas.coursesocialnetwork.api.auth.dto.LoginResponse;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.exceptions.InvalidTypeException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.exceptions.InvalidTokenException;
import br.eti.emersondantas.coursesocialnetwork.api.jwt.filter.JWTFilter;
import br.eti.emersondantas.coursesocialnetwork.api.user.User;
import br.eti.emersondantas.coursesocialnetwork.api.user.service.ValidateUserPasswordService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final ValidateUserPasswordService validateUserPasswordService;
    public static final String TOKEN_KEY = "wdsjfhkwbfdgwuierhweij";

    public LoginResponse autentica(User usuario) {

        if (!validateUserPasswordService.validateUserPassword(usuario)) {
            return new LoginResponse("Usuario ou senha invalidos. Nao foi realizado o login.");
        }

        String token = geraToken(usuario.getEmail());
        return new LoginResponse(token);
    }

    private String geraToken(String email) {
        return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(email)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 1440 * 60 * 1000)).compact();// 1 dia
    }

    public String getSujeitoDoToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new InvalidTokenException("Token inexistente ou mal formatado!");
        }

        // Extraindo apenas o token do cabecalho.
        String token = authorizationHeader.substring(JWTFilter.TOKEN_INDEX);

        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token).getBody().getSubject();
        } catch (SignatureException e) {
            throw new SecurityException("Token invalido ou expirado!");
        }
        return subject;
    }

}
