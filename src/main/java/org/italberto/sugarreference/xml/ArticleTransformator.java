/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.xml;

import java.util.List;
import org.italberto.sugarreference.domain.Article;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author italberto
 */
public class ArticleTransformator implements Transformator<Article> {

    @Override
    public List<Article> getObject(Document xmlDoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Document getXml(List<Article> objectList) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;

        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ArticleTransformator.class.getName()).log(Level.SEVERE, null, ex);
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElementNS("", "records");
        doc.appendChild(rootElement);

        for (Article article : objectList) {
            Element recordElement = doc.createElement("record");
            rootElement.appendChild(recordElement);

            //Authres
            Element authorsElement = doc.createElement("authros");
            recordElement.appendChild(authorsElement);

            String[] autores = null;

            if (article.getAuthors() != null) {
                if (article.getAuthors().contains(",")) {
                    autores = article.getAuthors().split(",");
                } else if (article.getAuthors().contains(";")) {
                    autores = article.getAuthors().split(";");
                } else {
                    autores = new String[1];
                    autores[0] = article.getAuthors();
                }
            }

            if (autores != null) {
                for (String author : autores) {
                    Element authorElment = doc.createElement("author");
                    authorElment.appendChild(doc.createTextNode(author));
                    authorsElement.appendChild(authorElment);
                }
            }

            //título
            Element titleElement = doc.createElement("title");
            try{
            titleElement.appendChild(doc.createTextNode(article.getTitle()));
            }catch(Exception e){
                
            }
            recordElement.appendChild(titleElement);

            //Keywords
            Element keywordsElement = doc.createElement("keywords");
            recordElement.appendChild(keywordsElement);

            Element keywordElment = null;

            
            try {
                
                for (String keyword : article.getKeywords()) {
                    keywordElment = doc.createElement("keyword");
                    keywordElment.appendChild(doc.createTextNode(keyword));
                    keywordsElement.appendChild(keywordElment);

                }
                
            }catch(Exception e){
                
            }
                
            

            //abstract
            Element abstractElement = doc.createElement("abstract");

            try{
            abstractElement.appendChild(doc.createTextNode(article.getTextAbstract()));
            }catch(Exception e){
                
            }
            
            recordElement.appendChild(abstractElement);

            //url
            Element urlElement = doc.createElement("url");
            
            try{
            urlElement.appendChild(doc.createTextNode(article.getUrlCitation()));
            }catch(Exception e){
                
            }
            
            recordElement.appendChild(urlElement);

            //isbn
            Element isbnElement = doc.createElement("isbn");
            
            try{
            isbnElement.appendChild(doc.createTextNode(article.getIsbn()));
            }catch(Exception e){
                
            }
            recordElement.appendChild(isbnElement);

            //doi
            Element doiElement = doc.createElement("doi");
            try{
            doiElement.appendChild(doc.createTextNode(article.getDoi()));
            }catch(Exception e){
                
            }
            recordElement.appendChild(doiElement);

        }

        return doc;
    }

}
