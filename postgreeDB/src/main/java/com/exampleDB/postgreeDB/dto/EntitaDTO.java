package com.exampleDB.postgreeDB.dto;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entita")
public class EntitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "simpatico", nullable = false)
    private String simpatico;

    public EntitaDTO(){}

    public EntitaDTO(String nome, String simpatico){
        this.nome = nome;
        this.simpatico = simpatico;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimpatico() {
        return simpatico;
    }

    public void setSimpatico(String simpatico) {
        this.simpatico = simpatico;
    }
}
