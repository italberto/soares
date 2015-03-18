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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italberto
 */
public class DBRisFeeder implements Feeder<List<String>> {

    private String conteudo = "";

    public DBRisFeeder(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public List<List<String>> getData() {
        List<String> linhas = new ArrayList<>();

        linhas.addAll(Arrays.asList(conteudo.split("TY  - ")));

        for (String linha : linhas) {
            System.out.println(linha);
        }

        List<List<String>> document = new ArrayList<>();

        return document;
    }

}
