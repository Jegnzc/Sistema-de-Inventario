/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author JorgeG
 */
public class Registro extends javax.swing.JFrame {

    public CardLayout vista3;
    
    public Registro() {
        initComponents();
        vista3 = (CardLayout) panelInicio.getLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelInicio = new javax.swing.JPanel();
        panelIniciar = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIniciarUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIniciarPassword = new javax.swing.JPasswordField();
        panelRegistro = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmarPassword = new javax.swing.JPasswordField();
        btnRegistrarUsuario = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCorreoUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoUsuario = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnRegistroSalir = new javax.swing.JButton();
        panelIniciarAdministrador = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelInicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelInicio.setAutoscrolls(true);
        panelInicio.setMaximumSize(new java.awt.Dimension(292, 382));
        panelInicio.setPreferredSize(new java.awt.Dimension(292, 382));
        panelInicio.setLayout(new java.awt.CardLayout());

        panelIniciar.setMaximumSize(new java.awt.Dimension(292, 382));
        panelIniciar.setPreferredSize(new java.awt.Dimension(292, 382));

        btnIniciarSesion.setText("Iniciar sesión");

        btnRegistrarEntrar.setText("Registrar nuevo usuario");
        btnRegistrarEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEntrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        javax.swing.GroupLayout panelIniciarLayout = new javax.swing.GroupLayout(panelIniciar);
        panelIniciar.setLayout(panelIniciarLayout);
        panelIniciarLayout.setHorizontalGroup(
            panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIniciarLayout.createSequentialGroup()
                .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIniciarLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnIniciarSesion))
                    .addGroup(panelIniciarLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarEntrar)
                            .addGroup(panelIniciarLayout.createSequentialGroup()
                                .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIniciarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtIniciarPassword))))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelIniciarLayout.setVerticalGroup(
            panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIniciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIniciarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(btnIniciarSesion)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarEntrar)
                .addGap(75, 75, 75))
        );

        panelInicio.add(panelIniciar, "card3");

        panelRegistro.setMaximumSize(new java.awt.Dimension(292, 382));
        panelRegistro.setPreferredSize(new java.awt.Dimension(292, 382));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Contraseña:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("<html>Confirmar contraseña:</html>");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtConfirmarPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegistrarUsuario.setText("Registrar");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nombre:");

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Correo:");

        txtCorreoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registrar nuevo usuario");

        cbxTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empleado", "Administrador" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tipo de Usuario:");

        btnRegistroSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRegistroSalir.setText("Salir");

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addComponent(btnRegistrarUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistroSalir)
                                .addGap(8, 8, 8))
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtConfirmarPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTipoUsuario, 0, 1, Short.MAX_VALUE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtConfirmarPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistroSalir)
                    .addComponent(btnRegistrarUsuario))
                .addGap(19, 19, 19))
        );

        panelInicio.add(panelRegistro, "card2");

        panelIniciarAdministrador.setMaximumSize(new java.awt.Dimension(292, 382));
        panelIniciarAdministrador.setPreferredSize(new java.awt.Dimension(292, 382));

        javax.swing.GroupLayout panelIniciarAdministradorLayout = new javax.swing.GroupLayout(panelIniciarAdministrador);
        panelIniciarAdministrador.setLayout(panelIniciarAdministradorLayout);
        panelIniciarAdministradorLayout.setHorizontalGroup(
            panelIniciarAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        panelIniciarAdministradorLayout.setVerticalGroup(
            panelIniciarAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        panelInicio.add(panelIniciarAdministrador, "card4");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        getContentPane().add(panelInicio, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEntrarActionPerformed
        
    }//GEN-LAST:event_btnRegistrarEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnIniciarSesion;
    public javax.swing.JButton btnRegistrarEntrar;
    public javax.swing.JButton btnRegistrarUsuario;
    public javax.swing.JButton btnRegistroSalir;
    public javax.swing.JComboBox<String> cbxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel panelIniciar;
    private javax.swing.JPanel panelIniciarAdministrador;
    public javax.swing.JPanel panelInicio;
    public javax.swing.JPanel panelRegistro;
    public javax.swing.JPasswordField txtConfirmarPassword;
    public javax.swing.JTextField txtCorreoUsuario;
    public javax.swing.JPasswordField txtIniciarPassword;
    public javax.swing.JTextField txtIniciarUsuario;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
