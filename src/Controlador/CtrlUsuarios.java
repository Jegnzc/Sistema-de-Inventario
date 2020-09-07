package Controlador;

import Modelo.ConsultaUsuarios;
import Modelo.Usuarios;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlUsuarios implements ActionListener {

    private final Registro frmRegistro;
    private final CtrlUtils usuarioUtils;

    public CtrlUsuarios(Usuarios usuario, ConsultaUsuarios consultaUsuario, Registro frmRegistro) {
        this.frmRegistro = frmRegistro;
        this.frmRegistro.btnRegistrarUsuario.addActionListener(this);
        this.frmRegistro.btnIniciarSesion.addActionListener(this);
        this.frmRegistro.btnRegistrarEntrar.addActionListener(this);
        this.frmRegistro.btnRegistroSalir.addActionListener(this);
        this.usuarioUtils = new CtrlUtils(usuario, consultaUsuario, frmRegistro);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmRegistro.btnRegistrarUsuario) {

            usuarioUtils.registrar("usuario");
        }

        if (e.getSource() == frmRegistro.btnIniciarSesion) {

            usuarioUtils.iniciarSesion();
        }

        if (e.getSource() == frmRegistro.btnRegistrarEntrar) {
            usuarioUtils.esAdministrador = 0;
            usuarioUtils.iniciarSesionAdministrador();
            if (usuarioUtils.esAdministrador == 1) {
                frmRegistro.panelInicio.add(frmRegistro.panelRegistro, "s");
                frmRegistro.vista3.show(frmRegistro.panelInicio, "s");
                SwingUtilities.updateComponentTreeUI(frmRegistro.btnRegistrarEntrar);
                frmRegistro.repaint();
            }
        }

        if (e.getSource() == frmRegistro.btnRegistroSalir) {

            frmRegistro.panelInicio.add(frmRegistro.panelIniciar, "s");
            frmRegistro.vista3.show(frmRegistro.panelInicio, "s");
            SwingUtilities.updateComponentTreeUI(frmRegistro.btnRegistroSalir);
            frmRegistro.repaint();

        }

    }

}
