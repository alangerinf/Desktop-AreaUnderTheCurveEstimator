/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoalphaupn;

import org.lsmp.djep.djep.*;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.*;
import org.nfunk.jep.*;


/**
 *
 * @author AlanGer
 */
public class Funcion {

    private String fun;
    private String der;

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getDer() {
        return der;
    }

    public void setDer(String der) {
        this.der = der;
    }

    public String getInte() {
        return inte;
    }

    public void setInte(String inte) {
        this.inte = inte;
    }
    private String inte;
    public Funcion(String funcion) throws ParseException {
        fun = funcion;
        
      //  JEP xpar = new JEP();
        
        DJep derivar = new DJep();
        derivar.addStandardFunctions();
        derivar.addStandardConstants();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true);
        derivar.addStandardDiffRules();
        
    //    Integral inte =  new Integral();
        
        
        try{
          Node node = derivar.parse(fun);
          node = derivar.simplify(node);
          Node diff = derivar.differentiate(node, "x");
          Node sim = derivar.simplify(diff);
          //Node sim = diff;
          der = derivar.toString(sim);
          
        }catch(ParseException e){
            e.printStackTrace();
        }
        
    }
    
    
    
    
    
    
    
}
