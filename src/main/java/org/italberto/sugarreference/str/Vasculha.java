/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author italberto
 */
public class Vasculha {

    private String padrao;

    public Vasculha(String padrao) {
        this.padrao = padrao;
    }

    public Vasculha() {

    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public String getLinkFromTag(String htmlLinkTag) {

        String retorno = "";

        String lowValue = new String(htmlLinkTag);

        
        
       // Pattern pattern = Pattern.compile("\\(?\\b((http|https) ??://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]");
        //Pattern pattern = Pattern.compile("(http|https)://[^\".]+");
        Pattern pattern = Pattern.compile("\".+\"");
       
        Matcher matcher = pattern.matcher(lowValue);

        while (matcher.find()) {

            String url = matcher.group();

            retorno = url;

        }

        return retorno.replace("\"", "");

    }

    public List<String> getAllHtmlLinkTags(String data) {

        List<String> crawledUrlList = new ArrayList<String>();

        String lowValue = new String(data);

        Pattern pattern = Pattern.compile("(?i)<a([^>]+)>(.+?)</a>");
        Matcher matcher = pattern.matcher(lowValue);

        while (matcher.find()) {

            String url = matcher.group();

            crawledUrlList.add(url);

        }

        return crawledUrlList;

    }

    public List<String> getAllLinks(String data) {

        List<String> crawledUrlList = new ArrayList<String>();

        String lowValue = new String(data);

        Pattern pattern = Pattern.compile("\\(?\\b((http|https) ??://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]");
        Matcher matcher = pattern.matcher(lowValue);

        while (matcher.find()) {

            String url = matcher.group();

            crawledUrlList.add(url);

        }

        return crawledUrlList;

    }

    public boolean padraoExisteEm(String str) {
        Pattern p = Pattern.compile(this.padrao);
        Matcher m = p.matcher(str);

        if (m.find()) {
            return true;
        }

        return false;
    }
}
