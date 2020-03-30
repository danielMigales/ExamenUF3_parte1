package base;

import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Daniel
 */
public class Sax extends DefaultHandler {

    Comunidades comunidad = new Comunidades();
    ArrayList<Comunidades> listaComunidades = new ArrayList<>();

    boolean tagNombre = false;
    boolean tagUrl = false;
    boolean tagContagios = false;

    public Sax() {
        super();
    }

    @Override
    public void startDocument() {
        System.out.println("Comienzo del Documento XML.");
    }

    @Override
    public void endDocument() {
        System.out.println("Final del Documento XML.");
        Html.crearHTML(listaComunidades);
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
        System.out.printf("\t Principio Elemento: %s %n", nombre);

        //CUANDO ENCUENTRA UN ELEMENTO DE UN TIPO ACTIVA UNA BANDERA
        if (nombre.equals("nombre")) {
            tagNombre = true;
        }
        if (nombre.equals("url")) {
            tagUrl = true;
        }
        if (nombre.equals("contagios")) {
            tagContagios = true;
        }
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) throws SAXException {

        String car = new String(ch, inicio, longitud);
        //quitar saltos de linea
        car = car.replaceAll("[\t\n]", "");
        System.out.printf("\t Caracteres: %s %n", car);

        if (tagNombre) {
            tagNombre = false;
            comunidad.setNombre(car);
        }
        if (tagUrl) {
            tagUrl = false;
            comunidad.setUrl(car);
        }
        if (tagContagios) {
            tagContagios = false;
            comunidad.setContagios(car);
        }
    }

    public void endElement(String uri, String nombre, String nombreC) {
        System.out.printf("\t Fin Elemento: %s %n", nombre);

        if (nombre.equals("comunidad")) {
            listaComunidades.add(comunidad);
            comunidad = new Comunidades();
        }

    }

    public static void leerXml() throws SAXException, IOException {

        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        Sax lector = new Sax();
        procesadorXML.setContentHandler(lector);
        InputSource fileXML = new InputSource("coronavirus.xml");
        procesadorXML.parse(fileXML);
    }

}
