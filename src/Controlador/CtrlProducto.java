/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmSupermercado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlProducto implements ActionListener {

    private final frmSupermercado frm;
    private final ConsultaProducto productoConsulta;
    
    private final CtrlMails mail;

    public final CtrlUtils productoUtils;

    public CtrlProducto(Producto producto, ConsultaProducto productoConsulta, frmSupermercado frm, CtrlMails mail) {
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
        this.productoUtils = new CtrlUtils(producto, productoConsulta, frm);
        //this.frm.tablaProductos.setModel(consultaProducto.model);
        //this.frm.btnRegresarProductos.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnRegistrar) {
            productoUtils.registrar();
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

            mail.enviarCorreoAdjunto();

        }

        if (e.getSource() == frm.btnEnviar) {
            mail.enviarCorreo();

        }

    }

}
