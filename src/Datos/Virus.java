package Datos;

public class Virus {

    private final String nombreVirus;
    private final byte[] secuenciaVirus;

    /* 
    Constructor para crear objetos de tipo virus, donde se le da el nombre
    y la secuencia de bytes
    */
    public Virus(String nombreVirus, byte[] secuenciaVirus) {
        this.nombreVirus = nombreVirus;
        this.secuenciaVirus = secuenciaVirus;
    }

    // getter para obtener secuencia de virus
    public byte[] getSecuenciaVirus() {
        return secuenciaVirus;
    }

    //getter para obtener el nombre del virus
    public String getNombreVirus() {
        return nombreVirus;
    }
}
