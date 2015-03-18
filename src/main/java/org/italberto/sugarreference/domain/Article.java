/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.domain;

import java.util.ArrayList;
import java.util.List;
import org.italberto.sugarreference.formats.ris.Type;

/**
 *
 * @author italberto
 */
//@XmlRootElement(name="document")
public class Article {
    
    private Type type;
    private String title;
    private String authors;
    private String date;
    private String textAbstract;
    private List<String> keywords;
    private String urlFullText;
    private String urlCitation;
    private String isbn;
    private String doi;
    private String country;
    private String databaseName;
    private String language;
    private String notes;
    
    public Article(String title, String authors, String date, String textAbstract, List<String> keywords, String urlFullText, String urlCitation) {
        this.title = title;
        this.authors = authors;
        this.date = date;
        this.textAbstract = textAbstract;
        this.keywords = keywords;
        this.urlFullText = urlFullText;
        this.urlCitation = urlCitation;
    }
  
    

    public Article() {

    }

//    @XmlElement(name="mdurl")
    public String getUrlCitation() {
        return urlCitation;
    }

    public void setUrlCitation(String urlCitation) {
        this.urlCitation = urlCitation;
    }

    public void addKeyword(String keyword){
        this.keywords.add(keyword);
    }
    
//    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @XmlElement(name = "authors")
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

//    @XmlElement(name="py")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    @XmlElement(name = "abstract")
    public String getTextAbstract() {
        return textAbstract;
    }

    public void setTextAbstract(String textAbstract) {
        this.textAbstract = textAbstract;
    }

//    @XmlElementWrapper(name = "controlledterms")
//    @XmlElement(name = "term")
    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

//    @XmlElement(name="pdf")
    public String getUrlFullText() {
        return urlFullText;
    }

    public void setUrlFullText(String urlFullText) {
        this.urlFullText = urlFullText;
    }
    
//    @XmlElement
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    @XmlElement
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getAuthorsList(){
        String[] str = this.authors.split(";");
        List<String> retorno = new ArrayList<>();
        
        for (String a : str) {
            retorno.add(a);
        }
        
        return retorno;        
    }
    
    
    
    @Override
    public String toString() {
        StringBuffer retorno = new StringBuffer();
        
        retorno.append("Title: ").append(this.title).append(";").append("\nKeywords: ").append(this.keywords).append(";").append("\tPublication Date: ").append(this.date).append(";").append("\n Abstract: ").append(this.textAbstract).append(";").append("\n\nAuthors: ");
        
        retorno.append(authors);
        
        return retorno.toString();
    }
 
    
    
}
