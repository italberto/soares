/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.net.HttpStatus;
import org.italberto.sugarreference.xml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 *
 * @author italberto
 */
public class I3EHtmlArticles extends HtmlArticle {

    public I3EHtmlArticles(List<String> links) throws IOException {
        super(links);

        this.getHtmBody(links);

    }

    protected List<String> getAuthors() {
        List<String> retorno = new ArrayList<String>();

        return retorno;
    }

    protected String getTitle() {
        String retorno = "";

        return retorno;
    }

    protected String getDate() {
        String retorno = "";

        return retorno;
    }

    protected String getPublication() {
        String retorno = "";

        return retorno;
    }

    protected String getAbstract() {
        String retorno = "";

        return retorno.replaceAll("Keywords.+", "");
    }

    protected List<String> getKeywords() {
        List<String> retorno = new ArrayList<String>();

        return retorno;
    }

    protected String getFullTextLink() {
        String retorno = "";

        return retorno;
    }

    protected String getCitationLink() {
        String retorno = "";

        return retorno;
    }

    

    protected List<Object> getHtmBody(List<String> links) throws IOException {

        List<Object> retorno = new ArrayList<Object>();
        List<Article> listArticles = new ArrayList<Article>();
        
        //verifica se os links enviados são vazios
        if (!links.isEmpty()) {
            //pega o link principal
            String link = links.get(0);

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");

            System.out.println("HTTP STATUS:" + conn.getResponseCode() + " > " + HttpStatus.getStatusMessage(conn.getResponseCode()));

            //Document doc = XmlUtil.parse(conn.getInputStream());
            
            //document
            
           InputStream is =  conn.getInputStream();
            
           BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String tmp = "";
            StringBuffer line = new StringBuffer();
            
            while ((tmp = br.readLine()) != null) {
                line.append(tmp);
            }
            
            
            Document doc = XmlUtil.convertStringToDocument(line.toString());
            
            try {
                JAXBContext context = JAXBContext.newInstance(Article.class);
                Unmarshaller u = context.createUnmarshaller();
                
                NodeList nodeList = doc.getElementsByTagName("document");
                
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    
                    Article art = (Article) u.unmarshal(node);
                    
                    listArticles.add(art);
                }
                
                
                
            } catch (JAXBException ex) {
                Logger.getLogger(I3EHtmlArticles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setArticles(listArticles);
        return retorno;
    }
    
    

}
