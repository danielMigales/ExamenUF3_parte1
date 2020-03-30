package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel
 */
public class Html {

    public static void crearHTML(ArrayList<Comunidades> comunidades) {

        File fichero = new File("coronavirus.html");
        FileWriter salidaFile;

        try {
            salidaFile = new FileWriter(fichero);
            salidaFile.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title>Comunidades afectadas por coronavirus</title>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Lista de comunidades afectadas</h1>\n"
                    + "<dl>\n");
            salidaFile.write("<table>\n");
            for (Comunidades comunidad : comunidades) {
                salidaFile.write(
                        "<tr>\n"
                        + "<td>" + comunidad.getNombre() + "</td>\n"
                        + "<td>" + comunidad.getUrl() + "</td>\n"
                        + "<td>" + comunidad.getContagios() + "</td>\n"
                        + "</tr>\n");
            }
            salidaFile.write("</table>\n");
            salidaFile.write("</body>\n"
                    + "</html>");

            salidaFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
