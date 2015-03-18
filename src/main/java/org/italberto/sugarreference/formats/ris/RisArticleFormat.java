/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.formats.ris;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.italberto.sugarreference.formats.ArticleAbstractFormat;

/**
 *
 * @author italberto
 */
public class RisArticleFormat extends ArticleAbstractFormat {

    private List<String> record;

    public RisArticleFormat(List<String> record) {
        this.record = record;
    }

    @Override
    public String getTitle() {
        String retorno = "";

        int count = 0;

        String mString = "^T1  - .+";
        String mStringAlternate = "^TI  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno = str.replaceAll("^T1  - ", "");
            } else if (str.matches(mStringAlternate)) {
                retorno = str.replaceAll("^TI  - ", "");
            }
        }
        System.out.println("Título: " + retorno);
        return retorno;
    }

    @Override
    public String getAuthors() {
        StringBuffer retorno = new StringBuffer();

        String mString = "^AU  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno.append(str.replaceAll("^[A-Z]{2}  - ", "")).append(";");
            }
        }

        return retorno.toString().toUpperCase();
    }

    @Override
    public String getDate() {
        String retorno = "";

        String mString = "^PY  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno = str.replaceAll("^[A-Z]{2}  - ", "").substring(0, 4);
            }
        }

        return retorno;
    }

    @Override
    public String getAbstract() {
        String retorno = "";

        String mStringFirst = "^AB  - Abstract";
        String mString = "^AB  - .+";
        String mStringAlternate = "^N2  - .+";

        for (int i = 0; i < record.size(); i++) {
            //for (String str : record) {
            if (record.get(i).matches(mStringFirst)) {
                retorno = record.get(i + 1);
                i++;
            } else if (record.get(i).matches(mString)) {
                retorno = record.get(i).replaceAll("^AB  - ", "");
            } else if (record.get(i).matches(mStringAlternate)) {
                retorno = record.get(i).replaceAll("^N2  - ", "");
            }
        }

        return retorno;
    }

    @Override
    public List<String> getKeyWords() {
        List<String> retorno = new ArrayList<String>();

        String mString = "^KW  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno.add(str.replaceAll("^[A-Z]{2}  - ", "").replaceAll("^\\s+", "").replaceAll("\\s+$", "").toUpperCase());
            }
        }

        return retorno;
    }

    @Override
    public String getUrl() {
        String retorno = "";

        String mString = "^UR  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno = str.replaceAll("^[A-Z]{2}  - ", "");
            }
        }

        return retorno;
    }

    @Override
    public String getISBN() {
        String retorno = "";

        String mString = "^SN  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno = str.replaceAll("^[A-Z]{2}  - ", "");
            }
        }

        return retorno.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
    }

    @Override
    public String getDOI() {
        String retorno = "";

        String mString = "^DO  - .+";

        for (String str : record) {
            if (str.matches(mString)) {
                retorno = str.replaceAll("^[A-Z]{2}  - ", "");
            }
        }

        return retorno.replaceAll("^\\s+", "").replaceAll("\\s+$", "");
    }

    
    @Override
    public String getCountry() {
        String tmp = "";
        String retorno = "";

        String mString = "^CY  - .+";
        
        
        for (String str : record) {
            if (str.matches(mString)) {
                System.out.println("linha encontrada> " + str);
                tmp = str.replaceAll("^[A-Z]{2}  - ", "");
            }
        }

        String[] parts = tmp.split(",");
        
        if (parts!=null){
            retorno = parts[parts.length-1];                
        }
        
        
        return retorno.replaceAll("^\\s+", "").replaceAll("\\s+$", "").toUpperCase();
    }

}
