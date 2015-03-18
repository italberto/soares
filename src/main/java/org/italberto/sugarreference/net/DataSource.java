/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.net;

/**
 *
 * @author italberto
 */
public abstract class DataSource {

    private String trailer;
    private String url;

    public DataSource(String trailer, String url) {
        this.url = url;
        this.trailer = trailer;
    }

    public String getUrl() {
        return url;
    }

    public String getTrailer() {
        return trailer;
    }

}
