package com.Avaliacao.Attornatus.Attornatus.controller;

import com.Avaliacao.Attornatus.Attornatus.model.Person;
import com.Avaliacao.Attornatus.Attornatus.model.dto.PersonDto;
import com.Avaliacao.Attornatus.Attornatus.repository.PersonRepository;
import com.Avaliacao.Attornatus.Attornatus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PersonController {

    @Autowired
    private PersonService service;
    @Autowired
    private PersonRepository repository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PersonDto> cadastrar(@RequestBody PersonDto person){
        repository.save(new Person(person));
        return new ResponseEntity<PersonDto>(HttpStatus.CREATED);
    }


    //Esse método não está atualizando, apenas salvando um novo dto
    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PersonDto> atualizar(@RequestBody PersonDto person){
        repository.save(new Person(person));
        return new ResponseEntity<PersonDto>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String>delete(@RequestParam Long id){
        repository.delete(id);
        return new ResponseEntity<String>("Deleted with sucess", HttpStatus.OK);
    }

    //Deveria criar um método no service chamado getUserById, não lembro como fazer
    @GetMapping(value = "/{idUsuario}", produces = "application/json")
    public ResponseEntity<PersonDto> getUserById(@PathVariable(value = "id")Long id){
         repository.getUserById(id);
        return new ResponseEntity<PersonDto>(HttpStatus.OK);
    }

}
