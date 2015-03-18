/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.datafeed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
public class RisFileFeeder implements Feeder<List<String>> {

    private String fileLocation = "";

    public RisFileFeeder(String fileLocation) {
        this.fileLocation = fileLocation;        
    }
    
    
    
    @Override
    public List<List<String>> getData() {
        List<String> linhas = null;
        
        try {
            linhas = getFile();
        } catch (IOException ex) {
            Logger.getLogger(RisFileFeeder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<List<String>> document = new ArrayList<>();

        List<String> record = new ArrayList<String>();

        for (String str : linhas) {

            if (str.matches("^TY  - .+")) {

                if (!record.isEmpty()) {
                    document.add(record);
                    record = new ArrayList<String>();
                }

                record.add(str);

            } else {
                record.add(str);
            }
        }

        
        
        return document;
    }
    
     private List<String> getFile() throws FileNotFoundException, IOException {
        
         System.out.println(">>>>>>>" + this.fileLocation);
         
        BufferedReader br = new BufferedReader(new FileReader(this.fileLocation));

        List<String> retorno = new ArrayList<String>();

        String line = "";

        while ((line = br.readLine()) != null) {
            retorno.add(line);
        }

        br.close();

        return retorno;

    }

}
