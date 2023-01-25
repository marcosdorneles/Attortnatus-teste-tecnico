package com.Avaliacao.Attornatus.Attornatus.model;

import com.Avaliacao.Attornatus.Attornatus.model.dto.PersonDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Person")
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1, initialValue = 1)
public class Person implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    private Long id;

    private LocalDate birhtDay;
    @ManyToOne
    @JoinColumn(name = "adress_ID")
    private Adress adress;

    public Person() {
    }

    public Person(PersonDto person) {
        this.id = person.getId();
        this.birhtDay = person.getBirthDay();
        this.adress = person.getAdress();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public LocalDate getBirhtDay() {
        return birhtDay;
    }

    public void setBirhtDay(LocalDate birhtDay) {
        this.birhtDay = birhtDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
