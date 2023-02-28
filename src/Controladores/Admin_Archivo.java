package Controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Admin_Archivo {
    
    private byte [] bytesArchivo = null;

    /* 
    Este metodo nos permite traer el archivo y anadirlo al path
    para pasarlo a bytes, se usa readAllBytes, de la clase Files
    */
    public void leerArchivo(File archivo) throws IOException{
        bytesArchivo = Files.readAllBytes(archivo.toPath());
    }
    
    //este metodo devuelve la lista de bytes
    public byte[] getBytesArchivo() {
        return bytesArchivo;
    }
        
}