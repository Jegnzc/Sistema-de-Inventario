/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ConsultaProducto;
import Modelo.ConsultaUsuarios;
import Modelo.Usuarios;
import Vista.Registro;
import Vista.FrmSupermercado;
import javax.swing.JOptionPane;

public class CtrlGetterSetter {

    FrmSupermercado frm;
    ConsultaProducto consultaProducto;
    Producto producto;

    Registro frmRegistro;
    ConsultaUsuarios consultaUsuarios;
    Usuarios usuario;

    public CtrlGetterSetter(Registro frmRegistro, ConsultaUsuarios consultaUsuarios, Usuarios usuario) {
        this.consultaUsuarios = consultaUsuarios;
        this.usuario = usuario;
        this.frmRegistro = frmRegistro;
    }

    public CtrlGetterSetter(FrmSupermercado frm, ConsultaProducto consultaProducto, Producto producto) {
        this.consultaProducto = consultaProducto;
        this.frm = frm;
        this.producto = producto;
    }

    public String getTextField(String tipo, String field) {
        String text = "";

        switch (tipo) {
            case "producto":
                text = getFieldProducto(field);
                break;
            case "usuario":
                text = getFieldUsuario(field);
                break;
        }

        return text;

    }

    public String getFieldProducto(String field) {
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
            case "asunto":
                text = frm.txtAsunto.getText();
                break;
        }
        return text;
    }

    public String getFieldUsuario(String field) {
        String text = "";
        switch (field) {

            case "usuario":
                text = frmRegistro.txtUsuario.getText();
                break;
            case "contraseña":
                text = frmRegistro.txtPassword.getText();
                break;
            case "confirmarcontraseña":
                text = frmRegistro.txtConfirmarPassword.getText();
                break;

            case "nombre":
                text = frmRegistro.txtNombreUsuario.getText();
                break;
            case "correo":
                text = frmRegistro.txtCorreoUsuario.getText();
                break;
                
            case "tipo":
                text = String.valueOf(frmRegistro.cbxTipoUsuario.getSelectedItem());
                break;
                
            case "iniciousuario":
                text = frmRegistro.txtIniciarUsuario.getText();
                break;
            case "iniciocontraseña":
                text = frmRegistro.txtIniciarPassword.getText();
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

    public void setValues(String tipo, String field) {

        switch (tipo) {

            case "producto":
                setProducto(field);
                break;

            case "usuario":
                setUsuario(field);
                break;

        }

    }

    public void setProducto(String field) {

        switch (field) {
            case "modificar":
                producto.setId(Integer.parseInt(getTextField("producto", "id")));
                producto.setId_tipo(Integer.parseInt(getTextField("producto", "idtipo")));
                producto.setNombre(getTextField("producto", "nombre"));
                producto.setDescripcion(getTextField("producto", "descripcion"));
                producto.setCantidad(Integer.parseInt(getTextField("producto", "cantidad")));
                producto.setPrecio(Double.parseDouble(getTextField("producto", "precio")));
                break;
            case "registrar":
                producto.setId_tipo(Integer.parseInt(getTextField("producto", "idtipo")));
                producto.setNombre(getTextField("producto", "nombre"));
                producto.setDescripcion(getTextField("producto", "descripcion"));
                producto.setCantidad(Integer.parseInt(getTextField("producto", "cantidad")));
                producto.setPrecio(Double.parseDouble(getTextField("producto", "precio")));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error al settear texto");
                break;
        }

    }

    public void setUsuario(String field) {

        switch (field) {
            case "registrar":
                usuario.setUsuario(getTextField("usuario", "usuario"));
                
                String pwhashed = BCrypt.hashpw(getTextField("usuario", "contraseña"), BCrypt.gensalt());
                usuario.setPassword(pwhashed);
                usuario.setNombre(getTextField("usuario", "nombre"));
                usuario.setCorreo(getTextField("usuario", "correo"));
                
                if(getTextField("usuario", "tipo").equals("Administrador")){
                    usuario.setIdtipousuario(1);
                }else{
                    usuario.setIdtipousuario(2);
                }
                
                break;
                
            case "iniciarSesion":
                usuario.setPassword(getTextField("usuario", "iniciocontraseña"));
                usuario.setUsuario(getTextField("usuario", "iniciousuario"));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error al settear texto");
                break;
        }

    }
    
    static boolean esEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }

}
