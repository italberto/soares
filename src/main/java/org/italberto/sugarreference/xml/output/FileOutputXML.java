/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.xml.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author italberto
 */
public class FileOutputXML implements OutputXML {

    private File file;

    public FileOutputXML(File file) {
        this.file = file;
    }

    @Override
    public void writeOut(Document doc) {

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);
            
            StreamResult result = new StreamResult(new FileOutputStream(file.getPath()));
            
            tr.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FileOutputXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOutputXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FileOutputXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

   
    }

}
