/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "engine", schema = "public")
public class Engine implements Comparable<Engine> {

    @Id
    @Column(name = "id_engine")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "expressao")
    private String expressao;

    @Column(name = "codigo")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_revisao")
    private Revisao revisao;

    public Engine() {
    }

    public Engine(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Engine other = (Engine) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Engine{" + "id=" + id + ", nome=" + nome + '}';
    }

    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    @Override
    public int compareTo(Engine obj) {
        if (this.getId() > obj.getId()) {
            return -1;
        }
        return 1;
    }
}
