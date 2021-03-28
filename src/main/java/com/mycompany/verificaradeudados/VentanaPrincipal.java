package com.mycompany.verificaradeudados;


import java.util.ArrayList;
import java.util.List;


public class VentanaPrincipal extends javax.swing.JFrame {
    List<List<Object>> values;    
    int filaEncabezadosImporte;
    List row;    
    int cantCeldas;    
    int cantFilas = 43;
    
    
    public VentanaPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputUltColumna = new javax.swing.JTextField();
        inputUltFila = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Verificar Adeudados");

        buttonVerificar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonVerificar.setText("VERIFICAR");
        buttonVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerificarActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtArea.setRows(100);
        txtArea.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jScrollPane1.setViewportView(txtArea);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Ingrese los campos solicitados para realizar una correcta operación de verificación");

        jLabel3.setText("Ultima fila de las Publicidades");

        jLabel4.setText("Última columna a analizar");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("de los meses no pagos por cada Publicidad");

        inputUltColumna.setForeground(new java.awt.Color(0, 0, 255));
        inputUltColumna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputUltColumna.setText("U");
        inputUltColumna.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        inputUltFila.setForeground(new java.awt.Color(0, 0, 255));
        inputUltFila.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputUltFila.setText("43");
        inputUltFila.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(buttonVerificar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(inputUltFila, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputUltColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUltFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputUltColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addComponent(buttonVerificar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerificarActionPerformed
        //se crea un array con todas las columnas de importe a examinar en cada fila
        List<Integer> columnasImporte = new ArrayList<Integer>();
        row = values.get(filaEncabezadosImporte);       
        cantCeldas = row.size();        
        for (int k = 0; k < cantCeldas; k++) {
            if (row.get(k).equals("Importe")) {
                columnasImporte.add(k);
            }
        }
        
        String texto = "LISTA DE DEUDORES:\n";
        Boolean debeAlMenos1 = true;
        
        //verificar que haya cumplido el Importe de todos los meses
        //i es fila actual y j columna actual
        for (int i = filaEncabezadosImporte +1; i < cantFilas; i++) {
            if (debeAlMenos1) {
                texto = texto + "_______________________________\n";
                debeAlMenos1 = false;
            }
            
            row = values.get(i);
            //completo las celdas que no se cargaron
            int faltantes = cantCeldas - row.size();
            for (int k = 0; k < faltantes; k++) {
                row.add("");
            }
                    
            if (row.isEmpty()) {
                break;
            } else {
                for (int j : columnasImporte) {  
                    if (row.get(j).equals("")) {
                        texto = texto + row.get(0) + " debe el mes de " + values.get(1).get(j-1) + "\n";
                        debeAlMenos1 = true;
                    }
                }
            }
        }
        
        txtArea.setText(texto);
    }//GEN-LAST:event_buttonVerificarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonVerificar;
    private javax.swing.JTextField inputUltColumna;
    private javax.swing.JTextField inputUltFila;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
