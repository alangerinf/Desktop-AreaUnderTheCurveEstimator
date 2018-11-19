/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoalphaupn;

import org.nfunk.jep.JEP;
/**
 *
 * @author AlanGer
 */
public final class Ecuacion { 
    private String ecuacion;
    private String var;
    private JEP myParser;
    private String resultado;
    
    Ecuacion(String ecuacion,String var){
        this.ecuacion=ecuacion;
        this.var=var;
        resultado="";
        inicializar();
        
        parseExpression();
        calcular();
    }
    
    void inicializar(){
        // Set up the parser (more initialization in parseExpression()) 
		myParser = new JEP();
		myParser.initFunTab(); // clear the contents of the function table
		myParser.addStandardFunctions();
		myParser.setTraverse(true);
                myParser.setImplicitMul(true);
		myParser.setAllowUndeclared(true);
		
    }
    
    private void parseExpression() {
		myParser.initSymTab(); // clear the contents of the symbol table
		myParser.addStandardConstants();
		myParser.addComplex(); // among other things adds i to the symbol table
		
                
		Double xValue = Double.parseDouble(var);
                myParser.addVariable("x", xValue);
                System.out.println("->>>>>>"+xValue);            
		myParser.parseExpression(this.getEcuacion());
	}
    void calcular(){
        Object result;
	String errorInfo;
		
	// Get the value
	result = myParser.getValueAsObject();
        
        if (result!=null) {
            this.setResultado(result.toString());
	}
        else {
                this.setResultado("Error");
	}
        if ((errorInfo = myParser.getErrorInfo()) != null) {
			         System.out.println(errorInfo);
		} else {
			
		}

        
    }

    /**
     * @return the ecuacion
     */
    public String getEcuacion() {
        return ecuacion;
    }

    /**
     * @param ecuacion the ecuacion to set
     */
    public void setEcuacion(String ecuacion) {
        this.ecuacion = ecuacion;
    }

    /**
     * @return the var
     */
    public String getVar() {
        return var;
    }

    /**
     * @param var the var to set
     */
    public void setVar(String var) {
        this.var = var;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**1111
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
