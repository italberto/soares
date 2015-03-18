/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "estudo", schema = "public")
public class Estudo implements Comparable<Estudo>, Serializable {

    @Id
    @Column(name = "id_estudo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 99999)
    private String titulo;

    @Column(name = "abstract_text", length = 99999)
    private String abstractText;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudo", fetch = FetchType.EAGER)
    private List<Autor> autores;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_engine")
    private Engine engine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pais")
    private Pais paisEstudo;

    @OneToMany(mappedBy = "estudo", cascade = CascadeType.ALL)
    private List<Keyword> keywords;

    @Column(name = "doi")
    private String doi;

    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    private Criterio criterio;

    public Estudo() {
        this.autores = new ArrayList<>();
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine Engine) {
        this.engine = Engine;
    }

    public Pais getPaisEstudo() {
        return paisEstudo;
    }

    public void setPaisEstudo(Pais paisEstudo) {
        this.paisEstudo = paisEstudo;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public String getAbstractReduzido() {
        if (!this.getAbstractText().isEmpty() && this.getAbstractText().length() <= 59) {
            return this.getAbstractText();
        } else if ((!this.getAbstractText().isEmpty() && this.getAbstractText().length() >= 59)) {
            return this.getAbstractText().substring(0, 59).concat("...");
        } else {
            return this.getAbstractText();
        }
    }

//    public void setAbstractReduzido(String abstractReduzido) {
//        this.abstractReduzido = abstractReduzido;
//    }
    @Override
    public int compareTo(Estudo o) {
        if (this.getId() < o.getId()) {
            return -1;
        }
        return 1;
    }

}
