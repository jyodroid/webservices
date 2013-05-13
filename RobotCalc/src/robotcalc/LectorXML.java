/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcalc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author john
 */
public class LectorXML {
    
    public final String[][] traerInstrucciones(String xml) throws Exception{
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlFile = docBuilder.parse (new File(xml));
        xmlFile.getDocumentElement ().normalize ();
        
        Element raiz = xmlFile.getDocumentElement();
        
        Element childElement = xmlFile.createElement("number");
        
        childElement.setAttribute("id", "no ma");
        raiz.appendChild(childElement);
        
        NodeList webserviceList = raiz.getElementsByTagName("webservice");
        
        String[][] instrucciones = 
                new String[webserviceList.getLength()][4];
        
        for(int i = 0; i < webserviceList.getLength(); i++){
            Element webservice = (Element) webserviceList.item(i);
            String url = 
                    webservice.getElementsByTagName("url").item(0).getTextContent();
            String metodo = 
                    webservice.getElementsByTagName("method").item(0).getTextContent();
            String p1 =
                    webservice.getElementsByTagName("p1").item(0).getTextContent();
            String p2 =
                    webservice.getElementsByTagName("p2").item(0).getTextContent();
            
            instrucciones[i][0]=url;
            instrucciones[i][1]=metodo;
            instrucciones[i][2]=p1;
            instrucciones[i][3]=p2;
        }
        return instrucciones;
    }
    public void guardarResultado(int[] resultado, String xml) 
            throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException{
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlFile = docBuilder.parse (new File(xml));
        xmlFile.getDocumentElement ().normalize ();
        
        Element raiz = xmlFile.getDocumentElement();
        
        NodeList webserviceList = raiz.getElementsByTagName("webservice");
        
        for(int i = 0; i < webserviceList.getLength(); i++){
            Element webservice = (Element) webserviceList.item(i);
            Element result = (Element) webservice.getElementsByTagName("result").item(0);
            result.setTextContent(String.valueOf(resultado[i]));
            webservice.appendChild(result);
        }
        
        //setting up a transformer
        TransformerFactory transfac = TransformerFactory.newInstance();
        Transformer trans = transfac.newTransformer();

        //generating string from xml tree
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        DOMSource source = new DOMSource(xmlFile);
        trans.transform(source, result);
        String xmlString = sw.toString();

        //Saving the XML content to File
        OutputStream f0;
        byte buf[] = xmlString.getBytes();
        f0 = new FileOutputStream(xml);
        for(int i=0;i<buf .length;i++) {
            f0.write(buf[i]);
        }
            f0.close();
            buf = null;
    }
}
