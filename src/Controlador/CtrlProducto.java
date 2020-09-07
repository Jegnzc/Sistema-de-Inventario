/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultaProducto;
import Modelo.ConsultaUsuarios;
import Modelo.Producto;
import Modelo.Usuarios;
import Vista.Registro;
import Vista.FrmSupermercado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener {

    private final FrmSupermercado frm;
    private final ConsultaProducto productoConsulta;

    private final CtrlMails mail;

    public final CtrlUtils productoUtils;

    public CtrlProducto(Producto producto, ConsultaProducto productoConsulta, FrmSupermercado frm, CtrlMails mail) {
        this.frm = frm;
        this.mail = mail;
        this.productoConsulta = productoConsulta;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        //this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnActualizar.addActionListener(this);
        this.frm.btnReporte.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnEnviar.addActionListener(this);
        this.frm.btnAdjunto.addActionListener(this);
        this.frm.btnMasivo.addActionListener(this);
        this.frm.btnSalirProductos.addActionListener(this);
        //this.frm.btnAdjuntar.addActionListener(this);
        this.productoUtils = new CtrlUtils(producto, productoConsulta, frm);
        //this.frm.tablaProductos.setModel(consultaProducto.model);
        //this.frm.btnRegresarProductos.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnRegistrar) {
            productoUtils.registrar("producto");
        }

        //  if (e.getSource() == frm.btnBuscar) {
        // buscar();
        // }
        if (e.getSource() == frm.btnModificar) {
            productoUtils.modificar();
        }

        if (e.getSource() == frm.btnEliminar) {
            productoUtils.eliminar();

        }

        if (e.getSource() == frm.btnActualizar) {
            productoUtils.actualizar();

        }

        if (e.getSource() == frm.btnReporte) {
            productoConsulta.reporte();

        }

        if (e.getSource() == frm.btnLimpiar) {

            productoUtils.gs.setTextFields("limpiar");

        }

        if (e.getSource() == frm.btnMasivo) {

            mail.enviarCorreoMasivo();

        }

        if (e.getSource() == frm.btnAdjunto) {
            mail.adjuntar();
            //if(mail.enviarCorreoAdjunto()){
              //  JOptionPane.showMessageDialog(null, "Correo enviado");
            //}else{
            //}

        }

        if (e.getSource() == frm.btnEnviar) {
            mail.enviarCorreoAdjunto();

        }
        
       // if (e.getSource() == frm.btnAdjuntar){
            
         //   mail.adjuntar();
            
        //}

 

        if (e.getSource() == frm.btnSalirProductos) {

            frm.dispose();
            Registro frmRegistro = new Registro();
            inicializarUsuario(frmRegistro);

            frmRegistro.pack();
            frmRegistro.setLocationByPlatform(true);
            frmRegistro.setVisible(true);

        }

    }

    private static void inicializarUsuario(Registro frmRegistro) {

        ConsultaUsuarios initConsultaUsuario = new ConsultaUsuarios();
        Usuarios initUsuario = new Usuarios();

        CtrlUsuarios initCtrlUsuario = new CtrlUsuarios(initUsuario, initConsultaUsuario, frmRegistro);

    }

}
