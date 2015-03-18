/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.xml.output;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

/**
 *
 * @author italberto
 */
public interface OutputXML {
    public void writeOut(Document doc) throws TransformerConfigurationException,TransformerException;
}
