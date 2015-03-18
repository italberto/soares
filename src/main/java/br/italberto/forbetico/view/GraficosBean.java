/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.facade.FacadeEstudo;
import br.italberto.forbetico.persistence.facade.FacadeKeyword;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "graficosBean")
public class GraficosBean extends BeanPadrao {

    private BarChartModel ano;
    private HorizontalBarChartModel autor;
    private PieChartModel keyword;
    private PieChartModel pais;
    private PieChartModel engine;
    private LineChartModel dateChart;

    @PostConstruct
    public void init() {
        this.povoarGraficoAnos();
        this.povoarGraficoKeywords();
        this.povoarGraficoPaises();
        this.povoarGraficoAutores();
        this.povoarGraficoEngine();
        this.povoarGraficoData();

    }

    private void povoarGraficoData() {
        this.dateChart = new LineChartModel();
        FacadeKeyword facade = new FacadeKeyword();
        List<List<Object>> count = facade.getCountKeywordsPorAno();

        for (List<Object> linha : count) {
            LineChartSeries serie = new LineChartSeries();

            serie.setLabel(linha.get(0).toString());

            serie.set(linha.get(0).toString(), new Integer(linha.get(2).toString()));

            this.dateChart.addSeries(serie);

        }

        this.dateChart.setTitle("Keywords por ano");
        this.dateChart.getAxis(AxisType.Y).setLabel("Keywords");
        DateAxis axis = new DateAxis("Anos");
        axis.setTickAngle(-50);
        axis.setMax("2016");
        axis.setTickFormat("%y");

        this.dateChart.getAxes().put(AxisType.X, axis);

        facade.closeSession();
    }

    private void povoarGraficoAnos() {

        this.ano = new BarChartModel();
        FacadeEstudo facade = new FacadeEstudo();

        try {
            List<Map<String, Integer>> count = facade.countPublicacoesPorAno();

            ChartSeries publicacoes = new BarChartSeries();

            for (Map<String, Integer> element : count) {

                String key = (String) element.keySet().iterator().next();
                Integer value = element.get(key);

                publicacoes.set(key, value);
            }

            this.ano.addSeries(publicacoes);
            this.ano.setTitle("Publicações por ano");
            this.ano.setShowPointLabels(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            facade.closeSession();
        };

    }

    private void povoarGraficoAutores() {
        this.autor = new HorizontalBarChartModel();
        FacadeEstudo facade = new FacadeEstudo();
        HashMap<String, Integer> count = facade.countPublicacoesPorAutor();

        ChartSeries publicacoes = new BarChartSeries();

        Iterator itr = count.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Integer value = count.get(key);

            publicacoes.set(key, value);
        }

        //this.autor.setLegendPosition("w");
        this.autor.addSeries(publicacoes);
        this.autor.setTitle("Publicações por autor");
        this.autor.setShowPointLabels(true);
        //model.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        //this.autor.setLegendPlacement(LegendPlacement.OUTSIDE);

        facade.closeSession();
    }

    private void povoarGraficoKeywords() {
        this.keyword = new PieChartModel();
        FacadeKeyword facade = new FacadeKeyword();
        HashMap<String, Integer> count = facade.getCountEstudosPorKeyword();

        Iterator itr = count.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Integer value = count.get(key);

            keyword.set(key, value);
        }

        this.keyword.setLegendPosition("w");
        this.keyword.setShowDataLabels(true);
        this.keyword.setFill(true);
        this.keyword.setTitle("Palavras-Chave mais comuns");

        facade.closeSession();
    }

    private void povoarGraficoPaises() {
        this.pais = new PieChartModel();
        FacadeEstudo facade = new FacadeEstudo();
        Map<String, Integer> count = facade.countPublicacoesPorPais();

        Iterator itr = count.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            Integer value = count.get(key);

            pais.set(key, value);
        }

        this.pais.setLegendPosition("w");
        this.pais.setShowDataLabels(true);
        this.pais.setFill(true);
        this.pais.setTitle("Estudos por país de publicação");

        facade.closeSession();
    }

    private void povoarGraficoEngine() {
        this.engine = new PieChartModel();
        FacadeEstudo facade = new FacadeEstudo();
        Map<String, Integer> count = facade.countPublicacoesPorEngine();

        Iterator itr = count.keySet().iterator();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            Integer value = count.get(key);

            engine.set(key, value);
        }

        this.engine.setLegendPosition("w");
        this.engine.setShowDataLabels(true);
        this.engine.setFill(true);
        this.engine.setTitle("Estudos por engine de publicação");

        facade.closeSession();
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

    public String exibir() {
        return "graficos";
    }

    public BarChartModel getAno() {
        return ano;
    }

    public void setAno(BarChartModel ano) {
        this.ano = ano;
    }

    public PieChartModel getKeyword() {
        return keyword;
    }

    public void setKeyword(PieChartModel keyword) {
        this.keyword = keyword;
    }

    public PieChartModel getPais() {
        return pais;
    }

    public void setPais(PieChartModel pais) {
        this.pais = pais;
    }

    public String salvar() {
        return null;
    }

    public BarChartModel getAutor() {
        return autor;
    }

    public void setAutor(HorizontalBarChartModel autor) {
        this.autor = autor;
    }

    public PieChartModel getEngine() {
        return engine;
    }

    public void setEngine(PieChartModel engine) {
        this.engine = engine;
    }

    public LineChartModel getDateChart() {
        return dateChart;
    }

    public void setDateChart(LineChartModel dateChart) {
        this.dateChart = dateChart;
    }

}
