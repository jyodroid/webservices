/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcalc;

import java.net.URL;
import ws.WsCalc1;
import ws.WsCalc1_Service;
import ws.WsCalc2;
import ws.WsCalc2_Service;

/**
 *
 * @author john
 */
public class RobotCalc {

    private String urlcalc1;
    private String urlcalc2;
    
    private WsCalc1 calc1 = null;
    private WsCalc2 calc2 = null;
    
    private WsCalc1_Service calc1_service = null;
    private WsCalc2_Service calc2_service = null;
    
    private static LectorXML lector = new LectorXML();
    public RobotCalc(){
        try {
            
            urlcalc1 = lector.traerInstrucciones("calcserver.xml")[0][0];
            urlcalc2 = lector.traerInstrucciones("calcserver.xml")[1][0];
            
            calc1_service = new WsCalc1_Service(new URL(urlcalc1));
            calc2_service = new WsCalc2_Service(new URL(urlcalc2));
            
            calc1 = calc1_service.getWsCalc1Port();
            calc2 = calc2_service.getWsCalc2Port();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int sumar(int a,int b){
        return calc1.sumar(a, b);
    }
    public int restar(int a,int b){
        return calc2.restar(a, b);
    }
    public int multiplicar(int a,int b){
        return calc1.multiplicar(a, b);
    }
    public int dividir(int a,int b){
        return calc2.dividir(a, b);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int result;
        RobotCalc calc = new RobotCalc();
        try {
            int [] results = new int[lector.traerInstrucciones("calcserver.xml").length];
            for (int i = 0; i < lector.traerInstrucciones("calcserver.xml").length; i++) {
                
                String op = lector.traerInstrucciones("calcserver.xml")[i][1];
                int par1 = 
                        Integer.parseInt(lector.traerInstrucciones("calcserver.xml")[i][2]);
                int par2 = 
                        Integer.parseInt(lector.traerInstrucciones("calcserver.xml")[i][3]);
                
                if (op.equalsIgnoreCase("sumar")){
                    result = calc.sumar(par1, par2);
                }else if(op.equalsIgnoreCase("restar")){
                    result = calc.restar(par1, par2);
                }else if(op.equalsIgnoreCase("multiplicar")){
                    result = calc.multiplicar(par1, par2);
                }else if(op.equalsIgnoreCase("dividir")){
                    result = calc.dividir(par1, par2);
                }else{
                    result = 0;
                }
                results[i]=result;
            }
            lector.guardarResultado(results, "calcserver.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
