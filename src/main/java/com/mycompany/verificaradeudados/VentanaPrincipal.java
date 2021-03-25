package com.mycompany.verificaradeudados;

import java.util.ArrayList;
import java.util.List;


public class VentanaPrincipal extends javax.swing.JFrame {
    List<List<Object>> values;    
    int filaEncabezadosPago;
    List row;    
    int cantCeldas;
    List<Integer> columnasPago;
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
                                .addGap(226, 226, 226)
                                .addComponent(buttonVerificar)))
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(buttonVerificar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerificarActionPerformed
        List row = values.get(filaEncabezadosPago);     //obtengo la fila de encabezados
        List<Integer> columnasPago = new ArrayList<>();
        int cantCeldas = row.size();
        
        //listar las columnas de pago
        for (int i = 0; i < cantCeldas; i++) {
            //se verifica que sea la columna de pagos y de serlo se agrega a la lista
            if (row.get(i).equals("Pago")) {
                columnasPago.add(i);
            }
        }
        
        String texto = "LISTA DE DEUDORES:\n";
        Boolean debeAlMenos1 = true;
        
        //verificar que haya cumplido el pago de todos los meses
        //i es fila actual y j columna actual
        for (int i = filaEncabezadosPago +1; i < cantFilas; i++) {
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
                for (int j : columnasPago) {                  
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
