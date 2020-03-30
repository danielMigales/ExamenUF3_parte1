package base;

import java.io.IOException;
import java.util.Scanner;
import org.xml.sax.SAXException;

/**
 * @author Daniel Migales Puertas
 */
public class Main {

    public static void main(String[] args) throws SAXException, IOException {

        Scanner teclado = new Scanner(System.in);
        boolean salir = true;

        do {
            System.out.println("\n----------------MENU PRINCIPAL-------------\n");
            System.out.println("1. Mostrar en pantalla documento xml (leer con SAX el archivo coronavirus.xml y crear uno nuevo llamado coronavirus.html)");
            System.out.println("2. Leer archivo coronavirus.html con Jsoup. ");
            System.out.println("3. Salir del programa.");

            System.out.println("\n" + "Elija una opcion.");
            int opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    Sax.leerXml();
                    break;
                    
                    
                    
                case 3:
                    System.out.println("Adios, no olvide lavarse las manos con jabon.");
                    salir = false;
                    break;
            }
        } while (salir);

        

    }

}
