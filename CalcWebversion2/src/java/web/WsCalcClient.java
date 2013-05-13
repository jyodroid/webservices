/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ws.WsCalc1;
import ws.WsCalc1_Service;
import ws.WsCalc2;
import ws.WsCalc2_Service;

/**
 *
 * @author john
 * Composicion de webservices
 * Esta clase funciona como un proxy que permite conectar a una aplicacion 
 * cliente a diferentes webservices.
 */
public class WsCalcClient{
    
    private String urlcalc1;
    private String urlcalc2;
    
    private WsCalc1 calc1 = null;
    private WsCalc2 calc2 = null;
    
    private WsCalc1_Service calc1_service = null;
    private WsCalc2_Service calc2_service = null;
    
    public WsCalcClient(){
        try {
            
            urlcalc1 = traerURLS()[0];
            urlcalc2 = traerURLS()[1];
            
            calc1_service = new WsCalc1_Service(new URL(urlcalc1));
            calc2_service = new WsCalc2_Service(new URL(urlcalc2));
            
            calc1 = calc1_service.getWsCalc1Port();
            calc2 = calc2_service.getWsCalc2Port();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(WsCalcClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WsCalcClient.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //Lee del archivo xml las direcciones url de los webservices
    public final String[] traerURLS() throws Exception{
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlFile = docBuilder.parse (new File("/home/john/NetBeansProjects/CalcWebversion2/calcserver.xml"));
        xmlFile.getDocumentElement ().normalize ();
 
        NodeList listaURL = xmlFile.getElementsByTagName("url");
        
        //Lista que se retorna
        String urls[] = new String[listaURL.getLength()];
        
        for (int i = 0; i < listaURL.getLength() ; i ++) {
            Node url = listaURL.item(i);
            urls[i]=url.getTextContent();
        }
     
        return urls;
    }
}