/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.net;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.italberto.sugarreference.depaginator.Depaginator;
import org.italberto.sugarreference.depaginator.DepaginatorACM;
import org.italberto.sugarreference.net.Vacum;

/**
 *
 * @author italberto
 */
public class LinkVacum {

    public List<String> getLinks(String linkPage) throws IOException{
        return this.getLinks("", linkPage);
    }
    
    public List<String> getLinks(String trailer,String linkPage) throws IOException {
        Depaginator d = new DepaginatorACM();

        d.setTrailler(trailer);

        d.findAllPages(linkPage);

        List<String> paginas = d.getPages();
        

        return paginas;
    }
}
