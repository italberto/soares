/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "etapa", schema = "public")
public class Etapa1 implements Comparable<Etapa1> {

    @Id
    @Column(name = "id_etapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo")
    private String codigo;

    @OneToMany(mappedBy = "etapa", cascade = CascadeType.ALL)
    private List<Criterio> criterios;

    @ManyToOne
    private Revisao revisao;

    public Etapa1() {
    }

    public Etapa1(String descricao) {
        this.descricao = descricao;
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

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
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
    public int compareTo(Etapa1 obj) {
        if (this.getId() > obj.getId()) {
            return -1;
        }
        return 1;
    }

}
