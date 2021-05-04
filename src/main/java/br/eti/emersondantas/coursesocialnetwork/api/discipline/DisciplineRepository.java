package br.eti.emersondantas.coursesocialnetwork.api.discipline;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findAllByOrderByNotaDesc();

    List<Discipline> findAllByOrderByLikesDesc();

}
