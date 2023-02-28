package Controladores;

import Datos.Virus;

public class Analizador {

    private byte[] bytesArchivo = null;
    private Virus[] listaVirus = null;
    private String estado = "";

    //Constructor de Analizador
    public Analizador() {
        cargarVirus();
    }

    /* 
    Cargar los virus de la base de datos, en este caso se crean variables de tipo Virus
    y se dice cuales son los bytes correspondientes a cada virus. Y esto se asigna a una lista de Virus.
    los archivos analizados estan en la carpeta otros, sin embargo la lista de bytes se puede modificar.
    */
    
    private void cargarVirus() {
        /* 
         Virus original, la maquina de estados esta basada en este, 
         la maquina la puede encontra en carpeta otros.
        
         Virus usama = new Virus("USAMA", new byte[]{15, 30,15,49});
         Virus amtrax = new Virus("AMTRAX", new byte[]{72, 72, 15, 29});
         Virus ebola = new Virus("EBOLA", new byte[]{29, 32, 53, 29});
         Virus ah1n1 = new Virus("AH1N1", new byte[]{72, 32, 32 , 20});
         Virus covid = new Virus("COVID", new byte[]{30, 25, 20, 19});
        */
        
        Virus usama = new Virus("USAMA", new byte[]{101, 114, 115, 105});
        Virus amtrax = new Virus("AMTRAX", new byte[]{32, 116, 104, 101});
        Virus ebola = new Virus("EBOLA", new byte[]{97, 108, 108, 121});
        Virus ah1n1 = new Virus("AH1N1", new byte[]{32, 108, 101, 97});
        Virus covid = new Virus("COVID", new byte[]{32, 115, 99, 114});
        listaVirus = new Virus[5];
        listaVirus[0] = usama;
        listaVirus[1] = amtrax;
        listaVirus[2] = ebola;
        listaVirus[3] = ah1n1;
        listaVirus[4] = covid;
    }

    /*
     Este metodo devuelve una cadena con los virus encontrados, si no encuentra virus, devuelve no encontrado
     adicinalmente se tiene la maquina de estados, que muestra cual es el estado, en que se encuentra
     para esto usamos una maquina de estados, que se puede ver en la carpeta otros
    */
    public String buscarVirus(byte[] contenidoBytes) {
        bytesArchivo = contenidoBytes;
        String mensaje = "";

        for (int i = 0; i < bytesArchivo.length - 3; i++) {

            //Usama
            if (bytesArchivo[i] == listaVirus[0].getSecuenciaVirus()[0]) {
                estado = "q1";
                if (bytesArchivo[i + 1] == listaVirus[0].getSecuenciaVirus()[1]) {
                    estado = "q2";
                    if (bytesArchivo[i + 2] == listaVirus[0].getSecuenciaVirus()[2]) {
                        estado = "q1";
                        if (bytesArchivo[i + 3] == listaVirus[0].getSecuenciaVirus()[3]) {
                            estado = "q3";
                            // System.out.println("Usama");//OK para usama
                            mensaje += "Usama ";
                        }
                    }
                }
            }
            //amtrax
            if (bytesArchivo[i] == listaVirus[1].getSecuenciaVirus()[0]) {
                estado = "q4";
                if (bytesArchivo[i + 1] == listaVirus[1].getSecuenciaVirus()[1]) {
                    estado = "q4";
                    if (bytesArchivo[i + 2] == listaVirus[1].getSecuenciaVirus()[2]) {
                        estado = "q1";
                        if (bytesArchivo[i + 3] == listaVirus[1].getSecuenciaVirus()[3]) {
                            estado = "q5";
                            // System.out.println("Amtrax");//OK para Amtrax
                            mensaje += "Amtrax ";
                        }
                    }
                }
            }
            //ebola
            if (bytesArchivo[i] == listaVirus[2].getSecuenciaVirus()[0]) {
                estado = "q5";
                if (bytesArchivo[i + 1] == listaVirus[2].getSecuenciaVirus()[1]) {
                    estado = "q6";
                    if (bytesArchivo[i + 2] == listaVirus[2].getSecuenciaVirus()[2]) {
                        estado = "q7";
                        if (bytesArchivo[i + 3] == listaVirus[2].getSecuenciaVirus()[3]) {
                            estado = "q5";
                            // System.out.println("ah1n1");//OK para ah1n1
                            mensaje += "Ah1n1 ";
                        }
                    }
                }
            }
            //ah1n1
            if (bytesArchivo[i] == listaVirus[3].getSecuenciaVirus()[0]) {
                estado = "q4";
                if (bytesArchivo[i + 1] == listaVirus[3].getSecuenciaVirus()[1]) {
                    estado = "q6";
                    if (bytesArchivo[i + 2] == listaVirus[3].getSecuenciaVirus()[2]) {
                        estado = "q6";
                        if (bytesArchivo[i + 3] == listaVirus[3].getSecuenciaVirus()[3]) {
                            estado = "q8";
                            // System.out.println("ebola");//OK para ebola
                            mensaje += "Ebola ";
                        }
                    }
                }
            }
            //Covid19
            if (bytesArchivo[i] == listaVirus[4].getSecuenciaVirus()[0]) {
                estado = "q2";
                if (bytesArchivo[i + 1] == listaVirus[4].getSecuenciaVirus()[1]) {
                    estado = "q10";
                    if (bytesArchivo[i + 2] == listaVirus[4].getSecuenciaVirus()[2]) {
                        estado = "q8";
                        if (bytesArchivo[i + 3] == listaVirus[4].getSecuenciaVirus()[3]) {
                            estado = "q9";
                            //System.out.println("Covid19");//OK para covid19
                            mensaje += "Covid19 ";
                        }
                    }
                }
            }

            /*
            
            #### este codigo refactoriza y hace que no se usen tantos ifs anidados
                   sin embargo lee mas de una vez el codigo, no se puede usar ####
            
            for (int j = 0; j < listaVirus.length; j++) {
                for (int i = 0; i < bytesArchivo.length; i++) {
                    if (bytesArchivo[i] == listaVirus[j].getSecuenciaVirus()[0]) {
                        if (bytesArchivo[i + 1] == listaVirus[j].getSecuenciaVirus()[1]) {
                            if (bytesArchivo[i + 2] == listaVirus[j].getSecuenciaVirus()[2]) {
                                if (bytesArchivo[i + 3] == listaVirus[j].getSecuenciaVirus()[3]) {
                                    System.out.println("Virus Encontrado");
                                }
                            }
                        }
                    }
                }
            }*/
            
        }
        if ("".equals(mensaje)) {
            mensaje = "No encontrado";
        }
        return mensaje;
    }

    // getter para obtener el estado final.
    public String getEstado() {
        return estado;
    }

}
