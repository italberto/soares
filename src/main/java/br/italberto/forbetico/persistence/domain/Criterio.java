/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "criterio", schema = "public")
public class Criterio implements Comparable<Criterio> {

    @Id
    @Column(name = "id_criterio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Etapa etapa;

    public Criterio(String descricao) {
        this.descricao = descricao;
    }

    public Criterio(String descricao, Etapa etapa) {
        this.descricao = descricao;
        this.etapa = etapa;
    }

    public Criterio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    @Override
    public int compareTo(Criterio obj) {
        if (this.getId() > obj.getId()) {
            return -1;
        }
        return 1;
    }
}
