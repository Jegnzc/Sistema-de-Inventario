package Modelo;

import Controlador.BCrypt;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConsultaUsuarios extends ConexionSQL {

    public boolean registrar(Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (usuario, password, nombre, correo, idtipousuariofk)"
                + " VALUES (?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getCorreo());
            ps.setInt(5, usr.getIdtipousuario());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario ingresado con éxito");
            return true;

        } catch (SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ese nombre de usuario ya existe, ingrese otro");
                return false;
            }
            Logger.getLogger(ConsultaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al ingresar usuario");
            return false;
        }

    }

    public boolean iniciarSesion(Usuarios usr) {

        Connection con = getConexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT usuario, password FROM usuarios WHERE"
                + " usuario=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                
                if (BCrypt.checkpw(usr.getPassword(), rs.getString("password"))) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese usuario");
            }

            //setTabla(new JTable(buildTableModel(rs, pro, 0)));
            return false;
        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);

            }
        }

    }
    
        public boolean iniciarSesionAdministrador(Usuarios usr) {

        Connection con = getConexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT a.usuario, a.password, b.tipousuario "
                + "FROM usuarios a JOIN tipo_usuarios b"
                + " ON a.idtipousuariofk=b.idtipousuario WHERE a.usuario=?"
                + " AND b.tipousuario='Administrador'";
        
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                
                if (BCrypt.checkpw(usr.getPassword(), rs.getString("password"))) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese usuario");
            }

            //setTabla(new JTable(buildTableModel(rs, pro, 0)));
            return false;
        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);

            }
        }

    }

}
