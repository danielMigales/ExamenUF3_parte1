package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Text;

/**
 * @author Daniel Migales Puertas
 */
public class Jsoup {
    
    Comunidades comunidad =new Comunidades();
    ArrayList<Comunidades> listaComunidades = new ArrayList<>();

    public void scrappingHtml() {

        String filePath = "coronavirus.html";
        String ENCODING = "UTF-8";
        File inputFile = new File(filePath);
        Document document = null;

        try {
            document = org.jsoup.Jsoup.parse(inputFile, ENCODING);
            Elements tags = document.select("td"); 
            
            for (Element link : tags) {

                String fila = link.text();
                System.out.println(fila);
                String nombre = null;
                String url = null;
                String contagiados= null;
                
                comunidad = new Comunidades(nombre, url, contagiados);               
                //System.out.println(comunidad.toString());
 
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearXML() throws IOException, ParserConfigurationException, TransformerException {

        String nombreDocumento = "coronavirus2";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        org.w3c.dom.Document document = implementation.createDocument(null, nombreDocumento, null);
        document.setXmlVersion("1.0");

       
    }

    public static void CrearElemento(String dato, String valor, org.w3c.dom.Element raiz, org.w3c.dom.Document document) {

        org.w3c.dom.Element elem = document.createElement(dato);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}

