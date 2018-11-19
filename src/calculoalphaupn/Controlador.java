/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoalphaupn;

/**
 *
 * @author AlanGer
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcMousePanel.jcMousePanel;
public class Controlador {
    
     private Timer tiempo;
      private TimerTask task;
          private int indice = 0;
           private int speed = 600;
      jcMousePanel panel=null;     
         public  Controlador (jcMousePanel p){
             this.panel=p;
             startAnimation();
         
         }
     

    void animar() throws AWTException {
     ///this.setTitle(texto().substring(0, i));
     //Robot r;
    // r = new Robot();
     //r.delay(500);
     panel.repaint();
    }

    public void startAnimation() {
        tiempo = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
           
                try {
                    animar();
                } catch (AWTException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        tiempo.schedule(task, 0, speed);
    }
    
}