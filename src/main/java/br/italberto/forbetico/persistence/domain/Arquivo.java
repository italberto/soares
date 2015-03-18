/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "arquivo", schema = "public")
public class Arquivo implements Comparable<Arquivo> {

    @Id
    @Column(name = "id_arquivo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudo", columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "processado")
    private Boolean processado;

    @Column(name="data_exportacao")
    @Temporal(TemporalType.DATE)
    private Date dataExportacao;
    
    
    @ManyToOne
    @JoinColumn(name = "id_engine")
    private Engine engine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return this.conteudo.substring(0, 100);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String delete() {
        return "";
    }

    public Boolean getProcessado() {
        return this.processado;
    }

    public void setProcessado(Boolean processado) {
        this.processado = processado;
    }

    public Date getDataExportacao() {
        return dataExportacao;
    }

    public void setDataExportacao(Date dataExportacao) {
        this.dataExportacao = dataExportacao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.conteudo);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.tamanho);
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
        final Arquivo other = (Arquivo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.tamanho, other.tamanho)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Arquivo obj) {
        if (this.getId() > obj.getId()) {
            return -1;
        }
        return 1;
    }

}
