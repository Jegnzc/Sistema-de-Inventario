/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ConsultaProducto;
import Vista.frmSupermercado;
import javax.swing.JOptionPane;

public class CtrlGetterSetter {
        frmSupermercado frm;
        ConsultaProducto consultaProducto;
        Producto producto;
        
        public CtrlGetterSetter(frmSupermercado frm, ConsultaProducto consultaProducto, Producto producto){
            this.consultaProducto = consultaProducto;
            this.frm = frm;
            this.producto = producto;
        }
    
        public String getTextField(String field) {
        String text = "";
        switch (field) {

            case "id":
                text = frm.txtIdProducto.getText();
                break;
            //case "idtipo":
            //  text = frm.txtIdTipo.getText();
            //break;
            case "idtipo":
                text = String.valueOf(frm.cbxTipo.getSelectedItem());

                String[] tipoid = consultaProducto.getTipo_id();
                String[] tiponombre = consultaProducto.getTipo_producto();

                int indiceMax = tipoid.length;
                int indice = 0;

                while (indice < indiceMax) {

                    if (frm.cbxTipo.getSelectedItem() == tiponombre[indice]) {
                        text = tipoid[indice];

                        indice = indiceMax - 1;

                    }
                    indice++;
                }
                break;
            case "tipo":
                text = String.valueOf(frm.cbxTipo.getSelectedItem());
                break;

            case "nombre":
                text = frm.txtNombreProducto.getText();
                break;
            case "descripcion":
                text = frm.txtDesc.getText();
                break;
            case "precio":
                text = frm.txtPrecio.getText();
                break;
            case "cantidad":
                text = frm.txtCantidad.getText();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error al obtener texto");
                break;
            case "correo":
                text = frm.txtCorreo.getText();
                break;
        }

        return text;

    }

    public void setTextFields(String tipo) {

        switch (tipo) {
            case "todo":
                frm.txtIdProducto.setText(String.valueOf(producto.getId()));
                frm.txtNombreProducto.setText(producto.getNombre());
                frm.txtDesc.setText(producto.getDescripcion());
                frm.txtCantidad.setText(String.valueOf(producto.getCantidad()));
                frm.txtPrecio.setText(String.valueOf(producto.getPrecio()));
                break;
            case "limpiar":
                frm.txtIdProducto.setText("");
                frm.txtNombreProducto.setText("");
                frm.txtDesc.setText("");
                frm.txtCantidad.setText("");
                frm.txtPrecio.setText("");
                break;
        }

    }

    public void setValues(String tipo) {

        switch (tipo) {
            case "modificar":
                producto.setId(Integer.parseInt(getTextField("id")));
                producto.setId_tipo(Integer.parseInt(getTextField("idtipo")));
                producto.setNombre(getTextField("nombre"));
                producto.setDescripcion(getTextField("descripcion"));
                producto.setCantidad(Integer.parseInt(getTextField("cantidad")));
                producto.setPrecio(Double.parseDouble(getTextField("precio")));
                break;
            case "registrar":
                producto.setId_tipo(Integer.parseInt(getTextField("idtipo")));
                producto.setNombre(getTextField("nombre"));
                producto.setDescripcion(getTextField("descripcion"));
                producto.setCantidad(Integer.parseInt(getTextField("cantidad")));
                producto.setPrecio(Double.parseDouble(getTextField("precio")));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error al settear texto");
                break;
        }

    }
    
}
