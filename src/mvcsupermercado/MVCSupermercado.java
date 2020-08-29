package mvcsupermercado;

import Controlador.ctrlProducto;
import Modelo.consultaProducto;
import Modelo.Print;
import Modelo.Producto;
import Vista.frmSupermercado;


public class MVCSupermercado {

    public static void main(String[] args) {

        frmSupermercado frm = new frmSupermercado();
        consultaProducto consultaProducto = new consultaProducto();
        Producto producto = new Producto();
        ctrlProducto ctrl = new ctrlProducto(producto, consultaProducto, frm);
        frm.pack();
        frm.setLocationByPlatform(true);
       
        
        frm.setVisible(true);
    }
    
}
