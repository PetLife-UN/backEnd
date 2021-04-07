package com.petlife.backend.models;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private eRole name;

    public Role() {

    }

    public Role(eRole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public eRole getName() {
        return name;
    }

    public void setName(eRole name) {
        this.name = name;
    }

}
