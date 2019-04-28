package com.gunda.spring.crud.model;


import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "JURISDICTION_MASTER")
public class Jurisdiction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "juris_id", nullable = false)
    private Long id;

    @Column(name = "juris_name", nullable = false)
    private String name;

    @Column(name = "juris_year")
    private Integer year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Jurisdiction.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("year=" + year)
                .toString();
    }
}
