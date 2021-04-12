package br.eti.emersondantas.coursesocialnetwork.api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 3806821135608484054L;

    private Integer status;

    private String msg;

    private Long timeStamp;

}
