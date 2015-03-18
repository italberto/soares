/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author italberto
 */
@Entity
@Table(name = "autor", schema = "public")
public class Autor implements Comparable<Autor> {

    @Id
    @Column(name = "id_autor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    @Column(name = "ultimo_nome")
    private String ultimoNome;

    @ManyToOne
    @JoinColumn(name = "id_estudo")
    private Estudo estudo;

    @Column(name = "autor_principal")
    private Boolean autorPrincipal;

    public Autor() {
    }

    public Autor(String primeiroNome, String ultimoNome, Boolean autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    public Boolean isAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(Boolean autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public Estudo getEstudo() {
        return estudo;
    }

    public void setEstudo(Estudo estudo) {
        this.estudo = estudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.primeiroNome);
        hash = 59 * hash + Objects.hashCode(this.ultimoNome);
        hash = 59 * hash + Objects.hashCode(this.estudo);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.primeiroNome, other.primeiroNome)) {
            return false;
        }
        if (!Objects.equals(this.ultimoNome, other.ultimoNome)) {
            return false;
        }
        if (!Objects.equals(this.estudo, other.estudo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + '}';
    }

    @Override
    public int compareTo(Autor obj) {
        if (this.getId() > obj.getId()) {
            return -1;
        }
        return 1;
    }

}
