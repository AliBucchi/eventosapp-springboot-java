package com.eventoapp.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity  //indica que a classe é uma entidade JPA e será mapeada para uma tabela na BD
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id //indica a chave primária de uma tabela
    @GeneratedValue(strategy = GenerationType.AUTO)         //gera valores de id automaticamente
    private long codigo;

    private String nome, local, data, horario;

    @OneToMany
    private List<Convidado> convidados;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public long getCodigo() { return codigo; }

    public void setCodigo(long codigo) { this.codigo = codigo; }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
    /////////////////////////////////////////////////////////////////////////////////
    public String getLocal() { return local; }

    public void setLocal(String local) { this.local = local; }
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public String getData() { return data; }

    public void setData(String data) { this.data = data; }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public String getHorario() { return horario; }

    public void setHorario(String horario) { this.horario = horario; }
}
