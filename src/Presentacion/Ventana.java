package Presentacion;

import Controladores.Admin_Archivo;
import Controladores.Analizador;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Ventana extends javax.swing.JFrame {

    private byte[] contenidoBytes = null;

    // Constructor
    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelTitulo = new javax.swing.JLabel();
        jTextFieldRuta = new javax.swing.JTextField();
        jButtonExplorar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTextAreaContenido = new javax.swing.JTextArea();
        jButtonAnalizar = new javax.swing.JButton();
        jLabelVirus = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelEstadoFinal = new javax.swing.JLabel();
        jLabelVirusEncontrado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AntMan");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        JLabelTitulo.setFont(new java.awt.Font("Wide Latin", 2, 24)); // NOI18N
        JLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelTitulo.setText("AntMan");

        jTextFieldRuta.setText("Ruta");

        jButtonExplorar.setText("Explorar");
        jButtonExplorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExplorarActionPerformed(evt);
            }
        });

        jTextAreaContenido.setColumns(20);
        jTextAreaContenido.setLineWrap(true);
        jTextAreaContenido.setRows(5);
        jTextAreaContenido.setTabSize(5);
        jScrollPane.setViewportView(jTextAreaContenido);

        jButtonAnalizar.setText("Analizar");
        jButtonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalizarActionPerformed(evt);
            }
        });

        jLabelVirus.setText("Virus:");

        jLabelEstado.setText("Estado AF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane)
                    .addComponent(jTextFieldRuta)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVirus)
                        .addGap(51, 51, 51)
                        .addComponent(jLabelVirusEncontrado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAnalizar)
                    .addComponent(jLabelEstado)
                    .addComponent(jButtonExplorar)
                    .addComponent(jLabelEstadoFinal))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(JLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExplorar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelVirus)
                            .addComponent(jButtonAnalizar)
                            .addComponent(jLabelVirusEncontrado)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEstadoFinal)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Este es el boton para explorar archivos, addemas de esto, pasa el archivo a bytes, con la clase Admin_Archivo, 
    y lo vuelve una cadena de strings
    */
    private void jButtonExplorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExplorarActionPerformed

        JFileChooser explorador;
        explorador = new JFileChooser();
        explorador.showOpenDialog(this);
        File archivoSelecionado = explorador.getSelectedFile();
        jTextFieldRuta.setText(archivoSelecionado.toPath().toString());

        Admin_Archivo administrador;
        administrador = new Admin_Archivo();

        // Aqui busca el archivo, lo lee, si no lo encuentra manda error, si sale exitoso, lo pasa a una lista.
        try {
            //lee el archivo
            administrador.leerArchivo(archivoSelecionado);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lista
        contenidoBytes = administrador.getBytesArchivo();

        // Cadena
        String cadenaBytes = "";

        // pasa cada bytes a la cadena, dejando un espacio entre bytes
        for (int i = 0; i < contenidoBytes.length; i++) {
            cadenaBytes = cadenaBytes + " " + contenidoBytes[i];
        }

        //Aqui es donde se muestra en el area de texto.
        jTextAreaContenido.setText(cadenaBytes);
    }//GEN-LAST:event_jButtonExplorarActionPerformed

    // Boton analizador
    private void jButtonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalizarActionPerformed

        // se crea una variable de tipo Analizador
        Analizador detector = new Analizador();

        /* Se llama el metodo buscarVirus, que devuelve un String con los virus encontrados
        se muestra en un JLabel
        */
        jLabelVirusEncontrado.setText(detector.buscarVirus(contenidoBytes));

        // Se trae el ultimo estado de la maquina, y se muestra en un jLabel
        jLabelEstadoFinal.setText(detector.getEstado());
    }//GEN-LAST:event_jButtonAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelTitulo;
    private javax.swing.JButton jButtonAnalizar;
    private javax.swing.JButton jButtonExplorar;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelEstadoFinal;
    private javax.swing.JLabel jLabelVirus;
    private javax.swing.JLabel jLabelVirusEncontrado;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jTextAreaContenido;
    private javax.swing.JTextField jTextFieldRuta;
    // End of variables declaration//GEN-END:variables
}
