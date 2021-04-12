package br.eti.emersondantas.coursesocialnetwork.api.discipline.controllers;

import br.eti.emersondantas.coursesocialnetwork.api.discipline.Discipline;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.DisciplineCreationDTO;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.dto.DisciplineDTO;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.CreateDisciplineService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.DeleteDisciplineService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.GetDisciplineService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.ListDisciplineRankingService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.ListDisciplineService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.UpdateNameDisciplineService;
import br.eti.emersondantas.coursesocialnetwork.api.discipline.services.UpdateNoteDisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/disciplinas")
public class V1DisciplineController {

    private final CreateDisciplineService createDisciplineService;

    private final DeleteDisciplineService deleteDisciplineService;

    private final GetDisciplineService getDisciplineService;

    private final ListDisciplineService listDisciplineService;

    private final ListDisciplineRankingService listDisciplineRankingService;

    private final UpdateNameDisciplineService updateNameDisciplineService;

    private final UpdateNoteDisciplineService updateNoteDisciplineService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DisciplineDTO get(@PathVariable("id") Long id){
        return DisciplineDTO.from(this.getDisciplineService.get(id));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DisciplineDTO create(@RequestBody DisciplineCreationDTO discipline){
        return DisciplineDTO.from(this.createDisciplineService.create(Discipline.from(discipline)));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/ranking", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DisciplineDTO> listRanking(){
        return DisciplineDTO.from(this.listDisciplineRankingService.listRanking());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DisciplineDTO> listAll(){
        return DisciplineDTO.from(this.listDisciplineService.list());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        this.deleteDisciplineService.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping(value = "/{id}/nome", produces = MediaType.APPLICATION_JSON_VALUE)
    public DisciplineDTO updateName(@PathVariable("id") Long id, @RequestBody String nome){
        return DisciplineDTO.from(this.updateNameDisciplineService.updateName(id, nome));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PatchMapping(value = "/{id}/nota", produces = MediaType.APPLICATION_JSON_VALUE)
    public DisciplineDTO updateNote(@PathVariable("id") Long id, @RequestBody String nota){
        return DisciplineDTO.from(this.updateNoteDisciplineService.updateNote(id, nota));
    }

}
