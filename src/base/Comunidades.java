package base;

/**
 * @author Daniel Migales Puertas
 */
public class Comunidades {
    
    String nombre;
    String url;
    String contagios;

    public Comunidades(String nombre, String url, String contagios) {
        this.nombre = nombre;
        this.url = url;
        this.contagios = contagios;
    }

    public Comunidades() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContagios() {
        return contagios;
    }

    public void setContagios(String contagios) {
        this.contagios = contagios;
    }

   
    
    
    
    
    
}
