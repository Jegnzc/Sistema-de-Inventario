package Modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class consultaProducto extends ConexionSQL {
static boolean encontrado = false;
    JTable tabla;

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public void registrar(Producto producto) {
        Connection con = getConexion();
        PreparedStatement ps = null;
        String sql = "INSERT INTO producto (id_tipo_producto, nombre_producto, descripcion_producto, cantidad_producto, precio_producto) "
                + "VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getId_tipo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidad());
            ps.setDouble(5, producto.getPrecio());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto ingresado con éxito");
        } catch (SQLException e) {
            if(e instanceof SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Ese producto ya existe");
                }
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al ingresar producto");
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error con la base de datos");
                System.err.println(e);

            }
        }
    }

    public boolean buscar(Producto pro) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT a.id_producto, b.id_tipo_producto, b.tipo_nombre, a.nombre_producto,  a.descripcion_producto, "
                + "a.cantidad_producto, a.precio_producto FROM producto a JOIN tipo_producto b"
                + " ON a.id_tipo_producto=b.id_tipo_producto WHERE a.nombre_producto=?";

        try {
            encontrado = false;
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            rs = ps.executeQuery();

            setTabla(new JTable(buildTableModel(rs, pro, 0)));
            if (encontrado) {
                return true;
            }
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
    
    public boolean mostrar(Producto pro) {

        Connection con = getConexion();
        
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM producto";

        try {
            String idtipo = "2";
        new Modelo.Print(idtipo, con);
            encontrado = false;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            setTabla(new JTable(buildTableModel(rs, pro, 0)));

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
    

    public boolean eliminar(Producto pro) {

        PreparedStatement ps;
        Connection con = getConexion();

        String sql = "DELETE FROM producto WHERE id_producto=? OR nombre_producto=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.setString(2, pro.getNombre());
            if(ps.executeUpdate()==0){
                JOptionPane.showMessageDialog(null, "No se encontró el producto para eliminar");
            }else{
               JOptionPane.showMessageDialog(null, "Producto eliminado");
               
            }
            
            return true;
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            return false;
            
        } finally {
            try {
                
                con.close();
                
            } catch (SQLException e) {
                
                System.err.println(e);
                
            }
        }
    }
    
    public boolean modificar(Producto pro) {

        Connection con = getConexion();
        PreparedStatement ps;

        String sql = "UPDATE producto SET nombre_producto=?, descripcion_producto=?, cantidad_producto=?, precio_producto=? WHERE id_producto=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setDouble(4, pro.getPrecio());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();

            return true;

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

    public static DefaultTableModel buildTableModel(ResultSet rs, Producto pro, int columnaSaltada)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            if (column != columnaSaltada) {
                columnNames.add(metaData.getColumnName(column));
            }
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            encontrado = true;
            pro.setId(Integer.parseInt(rs.getString("id_producto")));
            pro.setId_tipo(Integer.parseInt(rs.getString("id_tipo_producto")));
            pro.setNombre(rs.getString("nombre_producto"));
            pro.setDescripcion(rs.getString("descripcion_producto"));
            pro.setCantidad(Integer.parseInt(rs.getString("cantidad_producto")));
            pro.setPrecio(Double.parseDouble(rs.getString("precio_producto")));
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                if (columnIndex != columnaSaltada) {
                    vector.add(rs.getObject(columnIndex));
                }
            }
            data.add(vector);
        };

        return new DefaultTableModel(data, columnNames);

    }

}
