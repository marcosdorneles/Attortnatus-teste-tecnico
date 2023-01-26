package com.Avaliacao.Attornatus.Attornatus.model.dto;

import com.Avaliacao.Attornatus.Attornatus.model.Adress;

import java.time.LocalDate;

public class PersonDto {

    private Long id;
    private String name;
    private LocalDate birthDay;
    private Adress adress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
