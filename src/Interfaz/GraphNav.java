/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import javax.swing.JOptionPane;
import Clases.Arbol;
import Clases.Graficar;
import Clases.AlgDijkstra;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author esp15
 */
public class GraphNav extends javax.swing.JFrame {
    final static Graficar graficar = new Graficar();
    final static Arbol arbol = new Arbol();
    
    private static int tope = 0;
    private static int nodoFin;
    private static int permanente;
    private static int n=0,nn=0, id, id2;
    private static int nombre;
    
    
    
    

    /**
     * Creates new form GraphNav
     */
    public GraphNav() {
        initComponents();
        setTitle("GraphNav");
        setLocationRelativeTo(null);
        jTextPaneAcumulado.setEnabled(false);
        jTextPaneAcumulado.setText("El tiempo de viaje estimado");
        Ruta.setEnabled(false);
        Ruta.setText("Aqui se mostrara la ruta");
    }
    
    public static void R_repaint(int tope, Arbol arbol){
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if (arbol.getmAdyacencia(j, k) == 1) {
                    Graficar.trazarLinea(jPanel1.getGraphics(), arbol.getCordX(j), arbol.getCordY(j), arbol.getCordX(k), arbol.getCordY(k),arbol.getmCoeficiente(k, j) );
                }
            }
        }
        for (int j = 0; j < tope; j++) {
            Graficar.trazarCirculo(jPanel1.getGraphics(), arbol.getCordX(j), arbol.getCordY(j), String.valueOf(arbol.getNombre(j)));
        }
    }
    
    public static void MapaGraficado() {
        jPanel1.paint(jPanel1.getGraphics());
        n=0;
        id = -1;
        id2 = -1;
        
        int Matriz_Adyacencia[][] = { 
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0},
            {0,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0},//
            {0,0,1,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,1},
            {0,0,0,1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
            {1,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},
            {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0}
        };
        
        int Matriz_con_Coeficientes[][] = {
            {0,0,0,0,0,298,0,0,0,0,0,375,0,0,395,0,0,0,0,0,206,0,0,0},
            {0,0,0,0,0,0,0,0,280,0,0,296,0,355,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,572,339,0,172,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,572,0,610,0,401,0,0,530,0,0,0,0,0,0,192,0,0,242,0,0,0,0},
            {0,0,339,610,0,0,506,182,0,352,279,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {298,0,0,0,0,0,0,0,0,0,0,258,234,0,0,0,0,0,393,0,0,0,0,0},
            {0,0,172,401,506,0,0,0,0,0,810,0,0,0,0,689,0,0,0,345,0,0,0,0},
            {0,0,0,0,182,0,0,0,0,292,281,0,0,332,0,0,0,0,0,0,0,0,0,0},
            {0,280,0,0,0,0,0,0,0,0,0,515,0,353,0,0,0,104,0,0,704,0,0,433},
            {0,0,0,530,352,0,0,292,0,0,0,0,0,232,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,279,0,810,281,0,0,0,0,0,353,0,0,0,191,0,0,0,0,0,682},
            {375,296,0,0,0,258,0,0,515,0,0,0,190,0,0,0,0,0,0,0,690,0,0,0},
            {0,0,0,0,0,234,0,0,0,0,0,190,0,0,0,0,0,0,162,0,0,0,0,0},
            {0,355,0,0,0,0,0,332,353,232,353,0,0,0,0,0,0,282,0,0,0,0,0,0},
            {395,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,815,0,0,915},
            {0,0,0,0,0,0,689,0,0,0,0,0,0,0,0,0,0,0,0,626,0,0,0,0},
            {0,0,0,192,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,226,0,146,0,0},
            {0,0,0,0,0,0,0,0,104,0,191,0,0,282,0,0,0,0,0,0,0,0,0,536},
            {0,0,0,0,0,393,0,0,0,0,0,0,162,0,0,0,0,0,0,0,0,0,282,0},
            {0,0,0,242,0,0,345,0,0,0,0,0,0,0,0,626,226,0,0,0,0,323,0,0},//
            {206,0,0,0,0,0,0,0,704,0,0,690,0,0,815,0,0,0,0,0,0,0,0,805},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,146,0,0,323,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,282,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,433,0,682,0,0,0,915,0,0,536,0,0,805,0,0,0}
        };
        int pos_x1[] = {139,147,266,292,235,123,296,215,186,198,213,120,91,170,257,355,313,201,74,340,172,335,72,245};
        int pos_y1[] = {189,277,386,448,378,209,374,360,270,397,318,235,195,330,127,338,465,301,162,420,199,489,124,255};
        
        for (int i = 0; i < pos_x1.length; i++) {
            pos_x1[i] = pos_x1[i] -1;
            pos_y1[i] = pos_y1[i] +5;
        }
        
        int nombre[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        
        for(int j=0; j<24; j++){
            arbol.setCordX(j,pos_x1[j]);
            arbol.setCordY(j, pos_y1[j]);
            arbol.setNombre(j, nombre[j]);
        }
        for (int j = 0; j < 24; j++) {
            for (int k = 0; k < 24; k++) {
                arbol.setmAdyacencia(j, k, Matriz_Adyacencia[j][k]);
                arbol.setmCoeficiente(j, k, Matriz_con_Coeficientes[j][k]);
            }
        }
        tope = 24;
        R_repaint(tope, arbol);
        R_repaint(tope, arbol);
    }
    
    public void seleccionarNodo(int xx, int yy) {
        for (int j = 0; j < tope; j++) {
            if((xx+2)>arbol.getCordX(j) && xx < (arbol.getCordX(j)+13) && (yy+2)>arbol.getCordY(j) && yy<(arbol.getCordY(j)+13)){
                if(nn==0){
                    permanente = j;
                    R_repaint(tope, arbol);
                }else{
                    nodoFin = j;
                }
                nn++;
                n=0;
                id=-1;
                Graficar.seleccionarNodo(jPanel1.getGraphics(), arbol.getCordX(j), arbol.getCordY(j), null, Color.GREEN);
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ruta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneAcumulado = new javax.swing.JTextPane();
        Origen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Destino = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        GenerarRutaCorta = new javax.swing.JButton();
        jPanel2 = new Icon();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        Ruta.setColumns(20);
        Ruta.setRows(5);
        jScrollPane1.setViewportView(Ruta);

        jScrollPane3.setViewportView(jTextPaneAcumulado);

        Origen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amazonas", "Ancash","Apurimac","Arequipa","Ayacucho","Cajamarca","Cusco","Huancavelica","Huánuco","Ica","Junín","La Libertad","Lambayeque","Lima","Loreto","Madre de Dios","Moquegua","Pasco","Piura","Puno","San Martín","Tacna","Tumbes","Ucayali" }));

        jLabel1.setText("De:");

        jLabel2.setText("A:");

        Destino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amazonas", "Ancash","Apurimac","Arequipa","Ayacucho","Cajamarca","Cusco","Huancavelica","Huánuco","Ica","Junín","La Libertad","Lambayeque","Lima","Loreto","Madre de Dios","Moquegua","Pasco","Piura","Puno","San Martín","Tacna","Tumbes","Ucayali"  }));

        jLabel3.setText("Tiempo de Viaje(min)");

        GenerarRutaCorta.setText("Generar");
        GenerarRutaCorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarRutaCortaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        jLabel4.setText("Recorrido");

        jMenu1.setText("File");

        jMenuItem1.setText("Salir");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Destino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(GenerarRutaCorta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(GenerarRutaCorta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int xx,yy;
        xx = evt.getX();
        yy = evt.getY();
        if (evt.isMetaDown()) {
            
        }else{
            seleccionarNodo(xx, yy);
            if (nn==2) {
                nn=0;
                AlgDijkstra Dijkstra = new AlgDijkstra(arbol,tope,permanente,nodoFin);
                Dijkstra.dijkstra();
                jTextPaneAcumulado.setText(""+Dijkstra.getAcumulado());
            }else{
                JOptionPane.showMessageDialog(null, "Se deben crear mas nodos");
            }
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        //new Matrices(tope,arbol,2,this).setVisible(true);
    }//GEN-LAST:event_jPanel1MousePressed

    private void GenerarRutaCortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarRutaCortaActionPerformed
        if (tope >= 2) {
            permanente = Origen.getSelectedIndex();
            nodoFin = Destino.getSelectedIndex();
            AlgDijkstra Dijkstra = new AlgDijkstra(arbol,tope,permanente,nodoFin);
            Dijkstra.dijkstra();
            jTextPaneAcumulado.setText(""+Dijkstra.getAcumulado());
        }else{
            JOptionPane.showMessageDialog(null, "Se deben elegir mas nodos");
        }
    }//GEN-LAST:event_GenerarRutaCortaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(GraphNav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphNav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphNav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphNav.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphNav().setVisible(true);
                MapaGraficado();
                R_repaint(tope, arbol);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Destino;
    private javax.swing.JButton GenerarRutaCorta;
    private javax.swing.JComboBox<String> Origen;
    public static javax.swing.JTextArea Ruta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPaneAcumulado;
    // End of variables declaration//GEN-END:variables
    
    
    class FondoPanel extends JPanel {
        private Image imagen;
        
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/mapa/peru.png")).getImage();
            
            g.drawImage(imagen, 0,0,getWidth(),getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    class Icon extends JPanel {
        private Image imagen;
        
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/mapa/logo.jpeg")).getImage();
            
            g.drawImage(imagen, 0,0,getWidth(),getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }


}
