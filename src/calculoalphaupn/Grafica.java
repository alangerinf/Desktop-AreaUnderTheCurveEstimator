/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoalphaupn;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author AlanGer
 */


public class Grafica {
    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String etiquetaX;
    String etiquetaY;
    
    
    Grafica(String titulo, String x,String y){
        this.titulo=titulo;
        this.etiquetaX=x;
        this.etiquetaY=y;    
        grafica= ChartFactory.createXYLineChart(titulo, x, y, datos, PlotOrientation.VERTICAL, true, true, true);
    }
    Grafica(){
        this("Sin Titulo", "x","y");
    }
    public void agregarGrafica(String id, ArrayList<Double> x,ArrayList<Double> y){
        XYSeries series = new XYSeries(id);
        int n = x.size();
        System.out.println(n);
        for(int i=0; i<n;i++){
            series.add(x.get(i),y.get(i));
        }
        datos.addSeries(series);
    }
    public void crearGrafica(String id, ArrayList<Double> x,ArrayList<Double> y){
        datos.removeAllSeries();
        agregarGrafica(id,x,y);
    }
    
    
    public JPanel obtenerGrafica(){
        return new ChartPanel(grafica);
    }
    
}
