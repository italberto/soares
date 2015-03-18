/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.formats;

import java.util.List;

/**
 *
 * @author italberto
 */
public abstract class ArticleAbstractFormat  {
    public abstract String getTitle();
    public abstract String getAuthors();
    public abstract String getDate();
    public abstract String getAbstract();
    public abstract List<String> getKeyWords();
    public abstract String getUrl();
    public abstract String getISBN();
    public abstract String getDOI();
    public abstract String getCountry();
}
