/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Arquivo;
import br.italberto.forbetico.persistence.domain.Engine;
import br.italberto.forbetico.persistence.facade.FacadeArquivo;
import br.italberto.forbetico.persistence.facade.FacadeEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.transform.TransformerException;
import org.italberto.sugarreference.starter.Processador;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "IO")
public class IOBean extends BeanPadrao{

    private UploadedFile file;
    private List<Arquivo> arquivos;

    private List<Engine> engines;
    private Engine engine;
    private Long engineId;
    private Date dataExportacao;
    
    private FacadeEngine fe = new FacadeEngine();

    @PostConstruct
    public void init() {
        FacadeArquivo f = new FacadeArquivo();

        engines = fe.findAll();

        engine = new Engine();

        arquivos = f.findAll();

        f.closeSession();
        
        if (engines.size()<1){
            setMensagem("Aviso!", "É necessário cadastrar primeiro uma engine de busca para poder importar arquivos.");
        }
    }

    public IOBean() {
        init();
    }

    private static String getSystemUserFolder() {
        return System.getProperty("user.home");
    }

    public void upload() {

        if (file != null) {

            Engine tmp = fe.findById(engineId);
            
            String fileName = file.getFileName().split("\\.")[0];
            long fileSize = file.getSize();
            String extensao = file.getFileName().split("\\.")[1];

            String filePath = getSystemUserFolder() + "/Dropbox/Mestrado/Dissertação/protocol_test/files/";

            FacadeArquivo f = new FacadeArquivo();
            Arquivo arquivo = new Arquivo();

            arquivo.setDataExportacao(dataExportacao);
            
            arquivo.setEngine(tmp);

            arquivo.setTipo(extensao);

            arquivo.setTamanho((file.getSize() / 1024) + "");

            arquivo.setDescricao(fileName);

            arquivo.setConteudo(filePath + fileName + "." + extensao);

            f.create(arquivo);

            try {
                criarArquivo(file, filePath, fileName, extensao);
            } catch (IOException ex) {
                Logger.getLogger(IOBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            StringBuilder info = new StringBuilder("O arquivo ").append(fileName).append(" foi recebido corretamente");

            setMensagem("UPLOAD", info.toString());

            this.engines = fe.findAll();
            this.arquivos = f.findAll();

            f.closeSession();
            fe.closeSession();
        }

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Operação realizada", "O arquivo foi processado corretamente."));

    }

    public void criarArquivo(UploadedFile upload, String folderPath, String fileName, String fileExtension) throws IOException {
        File folder = new File(folderPath);
        String filename = fileName;
        String extension = fileExtension;

        File fileArquivo = File.createTempFile(filename, extension, folder);

        File consolid = new File(folderPath + "/" + filename + "." + extension);

        InputStream is = upload.getInputstream();

        OutputStream out = new FileOutputStream(fileArquivo);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        is.close();
        out.close();

        fileArquivo.renameTo(consolid);

    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    private String lerConteudoArquivo(UploadedFile file) {

        String retorno = "";

        try {
            InputStream stream = file.getInputstream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            retorno = out.toString();

        } catch (IOException ex) {
            Logger.getLogger(IOBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public void excluir(Arquivo arquivo) {
        FacadeArquivo f = new FacadeArquivo();

        f.delete(arquivo);

        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("O arquivo foi excluído!"));

        this.arquivos = f.findAll();

        f.closeSession();

    }

    public void processar(Arquivo arq) {
        FacadeArquivo fa = new FacadeArquivo();

        Arquivo arqx = fa.findById(arq.getId());

        try {
            Processador.Processar(arq.getConteudo(), arq.getEngine());
            arqx.setProcessado(true);
        } catch (IOException ex) {
            Logger.getLogger(IOBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(IOBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        fa.save(arqx);

        fa.closeSession();

        setMensagem("Arquivo processado", "O arquivo "  + arq.getDescricao() + " foi processado.");
        
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public Date getDataExportacao() {
        return dataExportacao;
    }

    public void setDataExportacao(Date dataExportacao) {
        this.dataExportacao = dataExportacao;
    }
    
    

}
