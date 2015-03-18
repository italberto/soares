/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.datafeed;

import java.util.List;
import org.italberto.sugarreference.domain.Article;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author italberto
 *
 * Fornece dados obtidos através de um arquivo
 */
public class FileFeeder implements Feeder<Article> {

    public FileFeeder() {
    }

    @Override
    public List<Article> getData() {

        List<Article> retorno = new ArrayList<>();

        //Aqui você informa o nome do arquivo XML.  
        try {
            File file = new File("/Users/italberto/Dropbox/DevelopmentItalberto/SugarReference/resource/endnote.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();

            org.w3c.dom.Document doc = db.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeLst = doc.getElementsByTagName("documents");

            for (int s = 0; s < nodeLst.getLength(); s++) {

                Node fstNode = nodeLst.item(s);

                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    org.w3c.dom.Element fstElmnt = (org.w3c.dom.Element) fstNode;

                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("database");

                    org.w3c.dom.Element fstNmElmnt = (org.w3c.dom.Element) fstNmElmntLst.item(0);

                    NodeList fstNm = fstNmElmnt.getChildNodes();

                    System.out.println(fstNmElmnt.getNodeValue());
                    //retorno.add(new Article(((Node) fstNm.item(0)).getNodeValue(), null, null, null, null, null, null));
                    //System.out.println(((Node) fstNm.item(0)).getNodeValue());

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

}
