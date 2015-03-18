package org.italberto.sugarreference.file.writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author italberto
 */
public class NormalFile extends File {

    private BufferedWriter buffWrite;

    public NormalFile(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    public Scanner openFileToRead() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(getCaminhoArquivo()));

        } catch (FileNotFoundException ex) {

        }

        return scanner;
    }

    @Override
    public void writeFile(String s) {

        try {

            buffWrite = new BufferedWriter(new FileWriter(getCaminhoArquivo()));
            buffWrite.append(s);
            buffWrite.close();

        } catch (IOException ex) {

        }

    }

}
