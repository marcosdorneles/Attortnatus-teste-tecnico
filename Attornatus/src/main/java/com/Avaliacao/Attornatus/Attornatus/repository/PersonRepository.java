package com.Avaliacao.Attornatus.Attornatus.repository;

import com.Avaliacao.Attornatus.Attornatus.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{

    void delete(Long id);

    void getUserById(Long id);
}
