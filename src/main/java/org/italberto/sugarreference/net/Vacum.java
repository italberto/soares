/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author italberto
 */
public class Vacum {

    public static List<String> getMultipleCode(String... paths) throws MalformedURLException, IOException {

        List<String> retorno = new ArrayList<String>();

        for (String path : paths) {
            retorno.add(getCode(path));
        }

        return retorno;
    }

    public static String getCode(String path) throws MalformedURLException, IOException {

        URL url = null;
        InputStream is = null;
        BufferedReader br;
        StringBuffer line = new StringBuffer();

        //System.out.println("Vacum > getCode > " + path);
        //proxy
        url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

        Authenticator.setDefault(new ProxyAuthenticator("teste", "teste"));

        try {
            is = con.getInputStream();  // throws an IOException

            if ("gzip".equals(con.getContentEncoding())) {
                is = new GZIPInputStream(is);
            }

            br = new BufferedReader(new InputStreamReader(is));

            String tmp = "";

            while ((tmp = br.readLine()) != null) {
                line.append(tmp);

            }

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }

        } catch (NullPointerException ex) {
            System.out.println(ex);
        }

        return line.toString();
    }

}
