/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.formats.ris;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author italberto
 */
public class TempTeste {

    public static List<Type> PovoarType() {
        List<Type> retorno = new ArrayList<>();

        retorno.add(new Type("ABST", "Abstract"));
        retorno.add(new Type("ADVS", "Audiovisual material"));
        retorno.add(new Type("ART", "Art Work"));
        retorno.add(new Type("BILL", "Bill/Resolution"));
        retorno.add(new Type("BOOK", "Book, Whole"));
        retorno.add(new Type("CASE", "Case"));
        retorno.add(new Type("CHAP", "Book chapter"));
        retorno.add(new Type("COMP", "Computer program"));
        retorno.add(new Type("CONF", "Conference proceeding"));
        retorno.add(new Type("CTLG", "Catalog"));
        retorno.add(new Type("DATA", "Data file"));
        retorno.add(new Type("ELEC", "Electronic Citation"));
        retorno.add(new Type("GEN", "Generic"));
        retorno.add(new Type("HEAR", "Hearing"));
        retorno.add(new Type("ICOMM", "Internet Communication"));
        retorno.add(new Type("INPR", "In Press"));
        retorno.add(new Type("JFULL", "Journal (full)"));
        retorno.add(new Type("JOUR", "Journal"));
        retorno.add(new Type("MAP", "Map"));
        retorno.add(new Type("MGZN", "Magazine article"));
        retorno.add(new Type("MPCT", "Motion picture"));
        retorno.add(new Type("MUSIC", "Music score"));
        retorno.add(new Type("NEWS", "Newspaper"));
        retorno.add(new Type("PAMP", "Pamphlet"));
        retorno.add(new Type("PAT", "Patent"));
        retorno.add(new Type("PCOMM", "Personal communication"));
        retorno.add(new Type("RPRT", "Report"));
        retorno.add(new Type("SER", "Serial (Book, Monograph)"));
        retorno.add(new Type("SLIDE", "Slide"));
        retorno.add(new Type("SOUND", "Sound recording"));
        retorno.add(new Type("STAT", "Statute"));
        retorno.add(new Type("THES", "Thesis/Dissertation"));
        retorno.add(new Type("UNBILL", "Unenacted bill/resolution"));
        retorno.add(new Type("UNPB", "Unpublished work"));
        retorno.add(new Type("VIDEO", "Video recording"));

        return retorno;
    }
}
