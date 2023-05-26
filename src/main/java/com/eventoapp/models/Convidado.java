package com.eventoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Convidado {

    @Id
    private String rg;
    private String nomeconvidado;

    @ManyToOne
    private Evento evento;

    public String getNomeconvidado() {
        return nomeconvidado;
    }

    public void setNomeconvidado(String nomeconvidado) {
        this.nomeconvidado = nomeconvidado;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
