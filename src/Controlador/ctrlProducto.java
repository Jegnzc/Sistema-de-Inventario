/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.consultaProducto;
import Modelo.Producto;
import Vista.frmSupermercado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JorgeG
 */
public class ctrlProducto implements ActionListener {

    private frmSupermercado frm;
    private Producto producto;
    private consultaProducto productoConsulta;

    public ctrlProducto(Producto producto, consultaProducto productoConsulta, frmSupermercado frm) {
        this.frm = frm;
        this.producto = producto;
        this.productoConsulta = productoConsulta;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnMostrar.addActionListener(this);
        this.frm.btnReporte.addActionListener(this);
        //this.frm.btnRegresarProductos.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frm.btnRegistrar) {

            if (!"".equals(frm.txtIdTipo.getText()) && !"".equals(frm.txtNombreProducto.getText())
                    && !"".equals(frm.txtDesc.getText()) && !"".equals(frm.txtCantidad.getText())
                    && !"".equals(frm.txtPrecio.getText())) {

                producto.setId_tipo(Integer.parseInt(frm.txtIdTipo.getText()));
                producto.setNombre(frm.txtNombreProducto.getText());
                producto.setDescripcion(frm.txtDesc.getText());
                producto.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                producto.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
                productoConsulta.registrar(producto);

            } else {
                JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos, intente de nuevo");
            }

        }

        if (e.getSource() == frm.btnBuscar) {
            if (!"".equals(frm.txtNombreProducto.getText())) {
                producto.setNombre(frm.txtNombreProducto.getText());

                if (productoConsulta.buscar(producto)) {
                    frm.txtIdProducto.setText(String.valueOf(producto.getId()));
                    frm.txtIdTipo.setText(String.valueOf(producto.getId_tipo()));
                    frm.txtDesc.setText(producto.getDescripcion());
                    frm.txtCantidad.setText(String.valueOf(producto.getCantidad()));
                    frm.txtPrecio.setText(String.valueOf(producto.getPrecio()));
                    JOptionPane.showMessageDialog(null, new JScrollPane(productoConsulta.getTabla()));

                    JOptionPane.showMessageDialog(null, "Producto encontrado");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese producto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe de ingresar el nombre del producto");
            }
        }

        if (e.getSource() == frm.btnModificar) {
            if (!"".equals(frm.txtIdTipo.getText())) {
                producto.setId(Integer.parseInt(frm.txtIdProducto.getText()));
                producto.setNombre(frm.txtNombreProducto.getText());
                producto.setDescripcion(frm.txtDesc.getText());
                producto.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                producto.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
                if (productoConsulta.modificar(producto)) {

                    JOptionPane.showMessageDialog(null, "Producto modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe de ingresar el ID");
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            if (!"".equals(frm.txtIdTipo.getText()) || !"".equals(frm.txtNombreProducto.getText())) {
                if ("".equals(frm.txtIdProducto.getText())) {
                    producto.setId(0);
                    producto.setNombre(frm.txtNombreProducto.getText());
                }

                productoConsulta.eliminar(producto);

            } else {
                JOptionPane.showMessageDialog(null, "Debe de ingresar el ID o el nombre    ");
            }
        }

        if (e.getSource() == frm.btnMostrar) {
            productoConsulta.mostrar(producto);
            
           
            JOptionPane.showMessageDialog(null, new JScrollPane(productoConsulta.getTabla()), "Lista de Productos", JOptionPane.INFORMATION_MESSAGE);
             DefaultTableModel model = (DefaultTableModel) productoConsulta.getTabla().getModel();
            int selectedRowIndex = productoConsulta.getTabla().getSelectedRow();
            frm.txtIdProducto.setText(model.getValueAt(selectedRowIndex, 0).toString());
            frm.txtIdTipo.setText(model.getValueAt(selectedRowIndex, 1).toString());
        frm.txtNombreProducto.setText(model.getValueAt(selectedRowIndex, 2).toString());
        frm.txtDesc.setText(model.getValueAt(selectedRowIndex, 3).toString());
        frm.txtCantidad.setText(model.getValueAt(selectedRowIndex, 4).toString());
        frm.txtPrecio.setText(model.getValueAt(selectedRowIndex, 5).toString());
            
        }

    }
}
