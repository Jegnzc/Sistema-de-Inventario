/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ConsultaProducto;
import static Modelo.ConsultaProducto.model;
import Vista.frmSupermercado;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author JorgeG
 */
public class CtrlUtils {

    private final frmSupermercado frm;
    private Producto producto;
    private ConsultaProducto productoConsulta;
    public CtrlGetterSetter gs;
    private String[] comboTipoProducto;

    //ejemplo constructor para usar en otra clase
    //public ctrlUtils(Cliente cliente, ConsultaCliente clienteConsulta, frmSupermercado frm) {
    //    this.frm = frm;
    //    this.productoConsulta = productoConsulta;
    //this.frm.tablaProductos.setModel(consultaProducto.model);
    //this.frm.btnRegresarProductos.addActionListener(this);
    // }
    public CtrlUtils(Producto producto, ConsultaProducto productoConsulta, frmSupermercado frm) {
        this.frm = frm;

        this.producto = producto;
        this.productoConsulta = productoConsulta;
        this.gs = new CtrlGetterSetter(frm, productoConsulta, producto);
        //this.frm.tablaProductos.setModel(consultaProducto.model);
        //this.frm.btnRegresarProductos.addActionListener(this);
    }

    public String[] getComboTipoProducto() {
        return comboTipoProducto;
    }

    public void setComboTipoProducto(String[] comboTipoProducto) {
        this.comboTipoProducto = comboTipoProducto;
    }

    public void actualizarComboBox() {

        productoConsulta.actualizarTipoProductos();
        setComboTipoProducto(productoConsulta.getTipo_producto());
        frm.setDml(getComboTipoProducto());
        frm.cbxTipo.setModel(frm.getDml());
    }

    public void actualizar() {
        productoConsulta.actualizarTabla();

        productoConsulta.actualizarTipoProductos();

        setComboTipoProducto(productoConsulta.getTipo_producto());

        frm.setDml(getComboTipoProducto());

        int[] anchos = {8, 8, 75, 50, 25};

        for (int x = 0; x < 5; x++) {
            frm.tablaProductos.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
        }
        //showTable("Lista de productos");

        frm.tablaProductos.setModel(ConsultaProducto.model);

        frm.tablaProductos.removeColumn(frm.tablaProductos.getColumnModel().getColumn(0));//quita columna id
        gs.setTextFields("limpiar");
    }

    public void registrar() {
        if (notEmpty((gs.getTextField("idtipo"))) && notEmpty(gs.getTextField("nombre"))
                && notEmpty(gs.getTextField("descripcion")) && notEmpty(gs.getTextField("cantidad"))
                && notEmpty(gs.getTextField("precio"))) {

            gs.setValues("registrar");

            if (productoConsulta.registrar(producto)) {
                int cantColumnas = model.getColumnCount();
                String[] nuevaFila = new String[cantColumnas];

                nuevaFila[0] = gs.getTextField("idtipo");
                nuevaFila[1] = gs.getTextField("tipo");
                nuevaFila[2] = gs.getTextField("nombre");
                nuevaFila[3] = gs.getTextField("descripcion");
                nuevaFila[4] = gs.getTextField("cantidad");
                nuevaFila[5] = gs.getTextField("precio");

                model.addRow(nuevaFila);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos, intente de nuevo");
        }
    }

    public void modificar() {
        if (notEmpty(gs.getTextField("id"))) {
            gs.setValues("modificar");
            if (productoConsulta.modificar(producto)) {

                JOptionPane.showMessageDialog(null, "Producto modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe de ingresar el ID");
        }
    }

    public void eliminar() {
        if (notEmpty(gs.getTextField("id")) && notEmpty(gs.getTextField("nombre"))) {
            producto.setId(Integer.parseInt(frm.txtIdProducto.getText()));
            producto.setNombre(frm.txtNombreProducto.getText());

            if (productoConsulta.eliminar(producto)) {
                int fila = frm.tablaProductos.convertRowIndexToModel(
                        frm.tablaProductos.getSelectedRow());

                model.removeRow(fila);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe de ingresar el ID o el nombre    ");
        }
    }



    public static boolean notEmpty(final String textField) {
        // Null-safe, short-circuit evaluation.
        return !textField.trim().isEmpty();
    }

    public static boolean Empty(final String textField) {
        // Null-safe, short-circuit evaluation.
        return textField.trim().isEmpty();
    }

    //private void buscar() {
    //    if (notEmpty(getTextField("nombre"))) {
    //       producto.setId(0);
    //       producto.setNombre(frm.txtNombreProducto.getText());
    //      if (productoConsulta.buscar(producto)) {
    //          setTextFields("todo");
    //          TableRowSorter<TableModel> sorter
    //                 = new TableRowSorter<TableModel>(frm.tablaProductos.getModel());
    //         frm.tablaProductos.setRowSorter(sorter);
    //          String text = getTextField("nombre");
    //         if (text.trim().length() == 0) {
    //              sorter.setRowFilter(null);
    //          } else {
    //            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
    //          }
    //frm.tablaProductos.setModel(consultaProducto.model);
    //      } else {
    //          JOptionPane.showMessageDialog(null, "No existe ese producto");
    //      }
    //  } else {
    //     JOptionPane.showMessageDialog(null, "Debe de ingresar el dato para la busqueda");
    //   }
    // }

    public void showTable(String tituloTabla) {

        JOptionPane.showMessageDialog(null, new JScrollPane(productoConsulta.getTabla()), tituloTabla, JOptionPane.INFORMATION_MESSAGE);
    }

}
