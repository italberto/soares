/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.xml;

import java.util.List;
import org.w3c.dom.Document;

public interface Transformator<Type> {

    public List<Type> getObject(Document xmlDoc);

    public Document getXml(List<Type> objectList);
}
