/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoalphaupn;

import java.util.ArrayList;

/**
 *
 * @author AlanGer
 */

public class Integral{
    
  String funcion;
  int neg,pos;
    public String getFuncion() {
        
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Double getDesde() {
        return desde;
    }

    public void setDesde(Double desde) {
        this.desde = desde;
    }

    public Double getHasta() {
        return hasta;
    }

    public void setHasta(Double hasta) {
        this.hasta = hasta;
    }

    public int getParticiones() {
        return particiones;
    }

    public void setParticiones(int particiones) {
        this.particiones = particiones;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
    
  Double desde;
  Double hasta;
  int particiones;
  Double resultado;
    
    Integral(String funcion,Double desde,Double hasta,int particiones){
        this.funcion=funcion;
        neg = pos = 0;
        this.desde=desde;
        
        this.hasta=hasta;
        this.particiones=particiones;
        calcResultado();
    }

    
  void calcResultado(){
     
    ArrayList<Double> puntosX = new ArrayList<>();
    ArrayList<Double> puntosY = new ArrayList<>();
    double  temp =0;  //axumulador de  divisiones  anteriores
    double Area =0;
      
    double intervalo = (hasta-desde)/particiones*1.0;
            
    for(int i=0;i<=this.particiones;i++){
            if(i==0){
                puntosX.add(desde);//si es  el inicio
                String res = new Ecuacion(this.funcion,String.valueOf(desde)).getResultado();
                puntosY.add(Double.parseDouble(res));
                temp=puntosX.get(0)+intervalo;
            }else{ 
                if(i==this.particiones){
                    puntosX.add(hasta);//utimo punto
                }else{
                    puntosX.add(temp);//caulculo de  las  diviosones  intermedias
                    temp = (intervalo*1.0) + temp;
                }
            Double temp2;
            temp2 = puntosX.get(i);
            puntosY.add(Double.parseDouble(new Ecuacion(funcion,String.valueOf(temp2)).getResultado()));
            System.out.println(intervalo);
            Area = Area +  calularArea(puntosX.get(i-1),puntosY.get(i-1),puntosX.get(i),puntosY.get(i));
            }
     }
    this.resultado = Area;  
}
  
          
double calularArea(double x0,double y0,double x1,double y1){
    double base;
    double altura;
    base= Math.abs(x1-x0);    
    if(Math.abs(y0)<Math.abs(y1)){
      altura=y0; 
    }else{
        altura=y1;
        }
        if(altura<0){
            neg++;
        }else{
            pos++;
        }
    System.out.println("->>>base "+base+"alt "+altura+"-------"+y0+"-"+y1);
    return base*altura;

} 
 
  
}
