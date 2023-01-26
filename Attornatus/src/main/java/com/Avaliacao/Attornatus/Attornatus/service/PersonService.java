package com.Avaliacao.Attornatus.Attornatus.service;

import com.Avaliacao.Attornatus.Attornatus.model.Person;
import com.Avaliacao.Attornatus.Attornatus.model.dto.PersonDto;
import com.Avaliacao.Attornatus.Attornatus.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    //construtor
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Person save(Person person){
        return repository.save(person);
    }
    //Procura pela id ou retorna id inválida
    public Person findById(Long id){
        var op = repository.findById(id);
        return op.orElseThrow(() -> new EntityNotFoundException("Invalid User ID"));
    }

    //Se o nome for diferente de nulo, salva novo nome
    public Person update(Person person, PersonDto personDto) {
        if (personDto.getName() != null) {
            person.setName(personDto.getName());
            save(person);
        }

        if (personDto.getBirthDay() != null) {
            person.setBirhtDay(personDto.getBirthDay());
            save(person);

        }
        return person;

    }

}

