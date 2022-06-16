/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package triqui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gamei
 */
public class Triquii extends javax.swing.JFrame {

    /**
     * Creates new form Triquii
     */
    //byte turno = 1;  //1 para jugador y 2 para máquina
    int turno = -1;
    char Jugador = 'O';
    char Jugador2 = 'X';
    int tablero[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    JButton[] botones;
    Fondo fondo = new Fondo();
    Icon cp = new ImageIcon(getClass().getResource("/img/REY.gif"));
    
    public Triquii() {
        this.setContentPane(fondo);
        initComponents();
        botones = new JButton[]{f0c0, f0c1, f0c2, f1c0, f1c1, f1c2, f2c0, f2c1, f2c2};
        Image Icon =new ImageIcon(getClass().getResource("/img/fav.png")).getImage();
        setIconImage(Icon);
        this.setLocationRelativeTo(null);
    }

    public void asignar(JButton btn, int x, int y) {
        if (turno == -1) {
            //btn.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Debes seleccionar 'X' ó 'O' ", "Triqui", JOptionPane.ERROR_MESSAGE);
        } else {
            if (turno == 2) {
                btn.setText(String.valueOf(Jugador2));
                tablero[x][y] = 2;
                turno = 1;
                lblJugadorTurno.setText("Jugador 1");
                if (verificarEjes(tablero, 1)) {
                    Resultado("¡Felicidades! Jugador 2 eres el ganador.");
                } else if (verificarEjes(tablero, 2)) {
                    Resultado("¡Felicidades! Jugador 2 eres el ganador.");
                } else if (verificarEmpate(tablero)) {
                    Resultado("¡Empate!");
                }
            } else {
                btn.setText(String.valueOf(Jugador));
                tablero[x][y] = 1;
                turno = 2;
                lblJugadorTurno.setText("Jugador 2");
                if (verificarEjes(tablero, 1)) {
                    Resultado("¡Felicidades! Jugador 1 eres el ganador.");                    
                } else if (verificarEjes(tablero, 2)) {
                    Resultado("¡Felicidades! Jugador 1 eres el ganador");                    
                } else if (verificarEmpate(tablero)) {
                    Resultado("¡Empate!");            
                }
            }
            btn.setEnabled(false);
        }
    }
    private void limpiarBotones() {
        for (JButton btn : botones) {
            btn.setText("");
        }

    }
    private void desbloquearBtn(boolean estado) {
        for (JButton btn : botones) {
            btn.setEnabled(estado);
        }
    }
    public boolean verificarEjes(int[][] partida, int s) {
        for (int i = 0; i < partida.length; i++) {
            if (partida[i][0] == s && partida[i][1] == s && partida[i][2] == s) {
                return true;
            } else if (partida[0][i] == s && partida[1][i] == s && partida[2][i] == s) {
                return true;
            }
        }
        //diagonales
        if ((partida[0][0] == s && partida[1][1] == s && partida[2][2] == s)) {
            return true;
        } else if ((partida[0][2] == s && partida[1][1] == s && partida[2][0] == s)) {
            return true;
        }
        return false;
    }
    public boolean verificarEmpate(int[][] partida) {
        for (int[] partida1 : partida) {
            for (int j = 0; j < partida1.length; j++) {
                if (partida1[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private void Resultado(String t1) {
        JOptionPane.showMessageDialog(null, t1, "Triqui", JOptionPane.INFORMATION_MESSAGE,cp);
        desbloquearBtn(false);
    }
    private void borrarTodo(){
        for (int[] tablero1 : tablero) {
            for (int j = 0; j < tablero1.length; j++) 
                tablero1[j] = 0;
        }
        limpiarBotones();
        desbloquearBtn(true);
        X.setEnabled(true);
        O.setEnabled(true);
        O.setSelected(false);
        X.setSelected(false);
        turno = -1;
        lblJugadorTurno.setText(" ");
    }
    class Fondo extends JPanel {
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/img/original.gif")).getImage();
            g.drawImage(imagen,0,0, getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
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

        O = new javax.swing.JRadioButton();
        X = new javax.swing.JRadioButton();
        f0c0 = new javax.swing.JButton();
        f0c1 = new javax.swing.JButton();
        f0c2 = new javax.swing.JButton();
        f1c0 = new javax.swing.JButton();
        f1c1 = new javax.swing.JButton();
        f1c2 = new javax.swing.JButton();
        f2c0 = new javax.swing.JButton();
        f2c1 = new javax.swing.JButton();
        f2c2 = new javax.swing.JButton();
        lblJugadorTurno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnreiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        O.setText("O");
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }
        });

        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });

        f0c0.setBackground(new java.awt.Color(0, 0, 0));
        f0c0.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f0c0.setMaximumSize(new java.awt.Dimension(80, 80));
        f0c0.setMinimumSize(new java.awt.Dimension(80, 80));
        f0c0.setPreferredSize(new java.awt.Dimension(80, 80));
        f0c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f0c0ActionPerformed(evt);
            }
        });

        f0c1.setBackground(new java.awt.Color(0, 0, 0));
        f0c1.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f0c1.setMaximumSize(new java.awt.Dimension(50, 50));
        f0c1.setMinimumSize(new java.awt.Dimension(50, 50));
        f0c1.setPreferredSize(new java.awt.Dimension(80, 80));
        f0c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f0c1ActionPerformed(evt);
            }
        });

        f0c2.setBackground(new java.awt.Color(0, 0, 0));
        f0c2.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f0c2.setPreferredSize(new java.awt.Dimension(80, 80));
        f0c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f0c2ActionPerformed(evt);
            }
        });

        f1c0.setBackground(new java.awt.Color(0, 0, 0));
        f1c0.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f1c0.setMaximumSize(new java.awt.Dimension(50, 50));
        f1c0.setMinimumSize(new java.awt.Dimension(50, 50));
        f1c0.setPreferredSize(new java.awt.Dimension(80, 80));
        f1c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1c0ActionPerformed(evt);
            }
        });

        f1c1.setBackground(new java.awt.Color(0, 0, 0));
        f1c1.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f1c1.setMaximumSize(new java.awt.Dimension(50, 50));
        f1c1.setMinimumSize(new java.awt.Dimension(50, 50));
        f1c1.setPreferredSize(new java.awt.Dimension(80, 80));
        f1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1c1ActionPerformed(evt);
            }
        });

        f1c2.setBackground(new java.awt.Color(0, 0, 0));
        f1c2.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f1c2.setMaximumSize(new java.awt.Dimension(50, 50));
        f1c2.setMinimumSize(new java.awt.Dimension(50, 50));
        f1c2.setPreferredSize(new java.awt.Dimension(80, 80));
        f1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1c2ActionPerformed(evt);
            }
        });

        f2c0.setBackground(new java.awt.Color(0, 0, 0));
        f2c0.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f2c0.setMaximumSize(new java.awt.Dimension(50, 50));
        f2c0.setMinimumSize(new java.awt.Dimension(50, 50));
        f2c0.setPreferredSize(new java.awt.Dimension(80, 80));
        f2c0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2c0ActionPerformed(evt);
            }
        });

        f2c1.setBackground(new java.awt.Color(0, 0, 0));
        f2c1.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f2c1.setMaximumSize(new java.awt.Dimension(50, 50));
        f2c1.setMinimumSize(new java.awt.Dimension(50, 50));
        f2c1.setPreferredSize(new java.awt.Dimension(80, 80));
        f2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2c1ActionPerformed(evt);
            }
        });

        f2c2.setBackground(new java.awt.Color(0, 0, 0));
        f2c2.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        f2c2.setToolTipText("");
        f2c2.setMaximumSize(new java.awt.Dimension(50, 50));
        f2c2.setMinimumSize(new java.awt.Dimension(50, 50));
        f2c2.setPreferredSize(new java.awt.Dimension(80, 80));
        f2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2c2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Turno Jugador :");

        btnreiniciar.setText("reiniciar");
        btnreiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJugadorTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(f2c0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(f1c0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(f0c0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(f0c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f0c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(f1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(f2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnreiniciar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(X)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(O)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJugadorTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f0c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f0c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f0c0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f1c0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f2c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2c0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X)
                    .addComponent(O))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreiniciar)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f0c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f0c0ActionPerformed
        asignar(f0c0, 0, 0);
    }//GEN-LAST:event_f0c0ActionPerformed

    private void f0c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f0c1ActionPerformed
        asignar(f0c1, 0, 1);
    }//GEN-LAST:event_f0c1ActionPerformed

    private void f0c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f0c2ActionPerformed
        asignar(f0c2, 0, 2);
    }//GEN-LAST:event_f0c2ActionPerformed

    private void f1c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1c0ActionPerformed
        asignar(f1c0, 1, 0);
    }//GEN-LAST:event_f1c0ActionPerformed

    private void f1c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1c1ActionPerformed
        asignar(f1c1, 1, 1);
    }//GEN-LAST:event_f1c1ActionPerformed

    private void f1c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1c2ActionPerformed
        asignar(f1c2, 1, 2);
    }//GEN-LAST:event_f1c2ActionPerformed

    private void f2c0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2c0ActionPerformed
        asignar(f2c0, 2, 0);
    }//GEN-LAST:event_f2c0ActionPerformed

    private void f2c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2c1ActionPerformed
        asignar(f2c1, 2, 1);
    }//GEN-LAST:event_f2c1ActionPerformed

    private void f2c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2c2ActionPerformed
        asignar(f2c2, 2, 2);
    }//GEN-LAST:event_f2c2ActionPerformed

    private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
        O.setSelected(false);
        turno = 1;
        Jugador = 'X';
        Jugador2 = 'O';
        O.setEnabled(false);
    }//GEN-LAST:event_XActionPerformed

    private void OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OActionPerformed
        X.setSelected(false);
        turno = 1;
        Jugador = 'O';
        Jugador2 = 'X';
        X.setEnabled(false);
    }//GEN-LAST:event_OActionPerformed

    private void btnreiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreiniciarActionPerformed
        borrarTodo();
    }//GEN-LAST:event_btnreiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Triquii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Triquii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Triquii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Triquii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Triquii().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton O;
    private javax.swing.JRadioButton X;
    private javax.swing.JButton btnreiniciar;
    private javax.swing.JButton f0c0;
    private javax.swing.JButton f0c1;
    private javax.swing.JButton f0c2;
    private javax.swing.JButton f1c0;
    private javax.swing.JButton f1c1;
    private javax.swing.JButton f1c2;
    private javax.swing.JButton f2c0;
    private javax.swing.JButton f2c1;
    private javax.swing.JButton f2c2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblJugadorTurno;
    // End of variables declaration//GEN-END:variables
}
