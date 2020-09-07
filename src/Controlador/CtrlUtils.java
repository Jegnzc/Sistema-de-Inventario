/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ConsultaProducto;
import static Modelo.ConsultaProducto.model;
import Modelo.ConsultaUsuarios;
import Modelo.Usuarios;
import Vista.Registro;
import Vista.FrmSupermercado;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
/**
 *
 * @author JorgeG
 */
public class CtrlUtils {

    private FrmSupermercado frm;
    private Producto producto;
    private ConsultaProducto productoConsulta;

    private Registro frmRegistro;
    private Usuarios usuario;
    private ConsultaUsuarios consultaUsuario;

    public CtrlGetterSetter gs;
    private String[] comboTipoProducto;
    
    public int esAdministrador;
    //ejemplo constructor para usar en otra clase
    //public ctrlUtils(Cliente cliente, ConsultaCliente clienteConsulta, frmSupermercado frm) {
    //    this.frm = frm;
    //    this.productoConsulta = productoConsulta;
    //this.frm.tablaProductos.setModel(consultaProducto.model);
    //this.frm.btnRegresarProductos.addActionListener(this);
    // }
    public CtrlUtils(Usuarios usuario, ConsultaUsuarios consultaUsuario, Registro frmRegistro) {
        this.frmRegistro = frmRegistro;
        this.usuario = usuario;
        this.consultaUsuario = consultaUsuario;
        
        this.gs = new CtrlGetterSetter(frmRegistro, consultaUsuario, usuario);
    }

    public CtrlUtils(Producto producto, ConsultaProducto productoConsulta, FrmSupermercado frm) {
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

    public void registrar(String opcion) {
        switch (opcion) {
            case "producto":

                if (allNotEmpty("registrarProducto")) {

                    gs.setValues("producto", "registrar");

                    if (productoConsulta.registrar(producto)) {
                        int cantColumnas = model.getColumnCount();
                        String[] nuevaFila = new String[cantColumnas];

                        nuevaFila[0] = gs.getTextField("producto", "idtipo");
                        nuevaFila[1] = gs.getTextField("producto", "tipo");
                        nuevaFila[2] = gs.getTextField("producto", "nombre");
                        nuevaFila[3] = gs.getTextField("producto", "descripcion");
                        nuevaFila[4] = gs.getTextField("producto", "cantidad");
                        nuevaFila[5] = gs.getTextField("producto", "precio");

                        model.addRow(nuevaFila);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos, intente de nuevo");
                }

                break;
            case "usuario":

                if (allNotEmpty("registrarUsuario")) {
                    if (gs.getTextField("usuario", "confirmarcontraseña").equals(gs.getTextField("usuario", "contraseña"))) {

                        if (gs.esEmail(gs.getTextField("usuario", "correo"))) {
                            gs.setValues("usuario", "registrar");

                            if (consultaUsuario.registrar(usuario)) {
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe de ingresar una dirección de correo válida");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas deben de ser iguales");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos, intente de nuevo");
                }

                break;

        }

    }

    public void modificar() {
        if (notEmpty(gs.getTextField("producto", "id"))) {
            gs.setValues("producto", "modificar");
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
        if (notEmpty(gs.getTextField("producto", "id")) && notEmpty(gs.getTextField("producto", "nombre"))) {
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

    public void iniciarSesion() {

        if (allNotEmpty("iniciarSesion")) {
            gs.setValues("usuario", "iniciarSesion");
            if (consultaUsuario.iniciarSesion(usuario)) {

                FrmSupermercado frm = new FrmSupermercado();
                frmRegistro.dispose();
                inicializarProducto(frm);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos");
        }

    }

    public void iniciarSesionAdministrador() {
        esAdministrador = 0;
        if (allNotEmpty("iniciarSesion")) {
            gs.setValues("usuario", "iniciarSesion");

            if (consultaUsuario.iniciarSesionAdministrador(usuario)) {

                esAdministrador = 1;
            }else{
                esAdministrador = 0;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe de llenar todos los datos");
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

    public boolean allNotEmpty(String opcion) {

        switch (opcion) {
            case "registrarProducto":
                if (notEmpty((gs.getTextField("producto", "idtipo"))) && notEmpty(gs.getTextField("producto", "nombre"))
                        && notEmpty(gs.getTextField("producto", "descripcion")) && notEmpty(gs.getTextField("producto", "cantidad"))
                        && notEmpty(gs.getTextField("producto", "precio"))) {
                    return true;
                }

                break;

            case "registrarUsuario":
                if (notEmpty(gs.getTextField("usuario", "usuario")) && notEmpty(gs.getTextField("usuario", "contraseña"))
                        && notEmpty(gs.getTextField("usuario", "confirmarcontraseña")) && notEmpty(gs.getTextField("usuario", "nombre"))
                        && notEmpty(gs.getTextField("usuario", "correo"))) {
                    return true;
                }
                break;

            case "iniciarSesion":
                if (notEmpty(gs.getTextField("usuario", "iniciocontraseña")) && notEmpty(gs.getTextField("usuario", "iniciousuario"))) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static void inicializarProducto(FrmSupermercado frm) {

        ConsultaProducto initConsultaProducto = new ConsultaProducto();
        Producto initProducto = new Producto();

        CtrlMails initMail = new CtrlMails(frm);

        CtrlProducto initCtrlProducto = new CtrlProducto(initProducto, initConsultaProducto, frm, initMail);

        initCtrlProducto.productoUtils.actualizar();
        initCtrlProducto.productoUtils.actualizarComboBox();

        frm.pack();
        frm.setLocationByPlatform(true);
        frm.setVisible(true);
    }

}
