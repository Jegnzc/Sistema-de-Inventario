package Modelo;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaProducto extends ConexionSQL {

    static boolean encontrado = false;
    JTable tabla;
    public String[] tipo_producto;
    public String[] tipo_id;

    public String[] getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String[] tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String[] getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String[] tipo_id) {
        this.tipo_id = tipo_id;
    }

    public static DefaultTableModel model;

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public boolean registrar(Producto producto) {
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
            return true;
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ese producto ya existe");
                return false;
            }
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al ingresar producto");
            return false;
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
                + " ON a.id_tipo_producto=b.id_tipo_producto WHERE a.nombre_producto=? OR a.id_producto=?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getId());
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id_producto")));
                pro.setId_tipo(Integer.parseInt(rs.getString("id_tipo_producto")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad_producto")));
                pro.setDescripcion(rs.getString("descripcion_producto"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio_producto")));

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

    public boolean actualizarTabla() {

        Connection con = getConexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT a.id_producto, b.tipo_nombre, a.nombre_producto,  a.descripcion_producto, "
                + "a.cantidad_producto, a.precio_producto FROM producto a JOIN tipo_producto b"
                + " ON a.id_tipo_producto=b.id_tipo_producto";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //setTabla(new JTable(buildTableModel(rs, pro, 0)));
            model = buildTableModel(rs, 0);
            
            
           

            setTabla(new JTable(model));
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

    public void actualizarTipoProductos() {

        Connection con = getConexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM tipo_producto";

        try {
            ps = con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            int filas = 0;

            while (rs.next()) {
                ++filas;

            }//ESTOY HACIENDO ESTO PARA HACER LO DE HARDWARE Y TODO ESO DE LA LISTITA EN IDTIPO


            tipo_producto = new String[filas];
            tipo_id = new String[filas];
            

            int indice = 0;
            rs.beforeFirst();
            while (rs.next()) {
                tipo_producto[indice] = rs.getString("tipo_nombre");
                indice++;
            }

            indice = 0;
            rs.beforeFirst();
            while (rs.next()) {
                tipo_id[indice] = rs.getString("id_tipo_producto");
                indice++;
            }

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {

                con.close();

            } catch (SQLException e) {

                System.err.println(e);

            }
        }
    }

    public boolean reporte() {

        Connection con = getConexion();

        try {
            String idtipo = "6";
            Print print = new Modelo.Print(idtipo, con);
            return true;
        } catch (Exception e) {
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
            if (ps.executeUpdate() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró el producto para eliminar");
            } else {
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

        String sql = "UPDATE producto SET nombre_producto=?, id_tipo_producto=?, descripcion_producto=?, cantidad_producto=?, precio_producto=? WHERE id_producto=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getId_tipo());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getCantidad());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId());
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

    public String[] masivo() {
        Connection con = getConexion();

        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT * FROM producto";
        String[] correos_destinos = null;

        try {
            ps = con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            int filas = 0;

            int indice = 0;
            while (rs.next()) {
                ++filas;

            }//ESTOY HACIENDO ESTO PARA HACER LO DE HARDWARE Y TODO ESO DE LA LISTITA EN IDTIPO

            correos_destinos = new String[filas];

            rs.beforeFirst();
            while (rs.next()) {
                correos_destinos[indice] = rs.getString("nombre_producto");
                indice++;
            }

            return correos_destinos;

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {

                con.close();

            } catch (SQLException e) {

                System.err.println(e);

            }
        }
        return correos_destinos;
    }

    public static DefaultTableModel buildTableModel(ResultSet rs, int columnaSaltada)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();

        //for (int column = 1; column <= columnCount; column++) {
           // if (column != columnaSaltada) {
            //    columnNames.add(metaData.getColumnName(column));
          //  }
        //}
        columnNames.add("ID");
        columnNames.add("Tipo");
        columnNames.add("Producto");
        columnNames.add("Descripción");
        columnNames.add("Cantidad");
        columnNames.add("Precio");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
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
