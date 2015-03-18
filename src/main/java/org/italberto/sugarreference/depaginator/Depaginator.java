/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.depaginator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.italberto.sugarreference.net.Vacum;
import org.italberto.sugarreference.str.Util;
import org.italberto.sugarreference.str.Vasculha;

/**
 *
 * @author italberto
 */
public abstract class Depaginator {

    private static List<String> links = new ArrayList<String>();

    private String trailler;
    private String padraoPesquisa;

    private Util utilStr;

    private static String FULL_LINK = "http://";

    public Depaginator() {
        this.padraoPesquisa = "(N|n)ext";
        utilStr = new Util("");
    }

    public static List<String> getLinks() {
        return links;
    }

    public static void setLinks(List<String> links) {
        Depaginator.links = links;
    }

    public String getTrailler() {
        return trailler;
    }

    public void setTrailler(String trailler) {
        this.trailler = trailler;
    }

    public String getPadraoPesquisa() {
        return padraoPesquisa;
    }

    protected void setPadraoPesquisa(String padraoPesquisa) {
        this.padraoPesquisa = padraoPesquisa;
    }

    public List<String> getPages() {
        return links;
    }

    public void findAllPages(String link) {

        
        
        this.utilStr.setText(link);

        if (!link.isEmpty()) {

            if (Depaginator.links.size() <= 0) {
                

                if (utilStr.existPatternIn(this.FULL_LINK)) {
                    Depaginator.links.add(link);
                    findAllPages(link);
                    
                } else {
                    Depaginator.links.add(this.trailler + link);
                    findAllPages(this.trailler + link);
                }

            } else {
                try {
                    
                    String resultado = null;
                    
                    if (utilStr.existPatternIn(this.FULL_LINK)) {
                        resultado = Vacum.getCode(link);
                    }else{
                        resultado = Vacum.getCode(this.trailler + link);
                    }

                    //System.out.println(resultado);
                    Vasculha vas = new Vasculha(padraoPesquisa);

                    List<String> links = vas.getAllHtmlLinkTags(resultado);

                    for (String string : links) {
                        if (vas.padraoExisteEm(string)) {

                            String l = this.trailler + vas.getLinkFromTag(string);

                            if (!existsLink(l)) {
                                Depaginator.links.add(l);

                                if (utilStr.existPatternIn(this.FULL_LINK)) {
                                    findAllPages(l);
                                } else {
                                    findAllPages(this.trailler + l);
                                }
                            }
                        }
                    }

                } catch (IOException ex) {
                    
                }

            }
        }
    }

    private boolean existsLink(String link) {
        if (Depaginator.links.indexOf(link) > 0) {
            return true;
        }
        return false;
    }
}
