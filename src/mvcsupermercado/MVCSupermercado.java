package mvcsupermercado;

import Controlador.CtrlMails;
import Controlador.CtrlProducto;
import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.frmSupermercado;

public class MVCSupermercado {

    public static void main(String[] args) {

        frmSupermercado frm = new frmSupermercado();

        inicializarProducto(frm);

        frm.pack();
        frm.setLocationByPlatform(true);
        frm.setVisible(true);
    }

    private static void inicializarProducto(frmSupermercado frm) {

        ConsultaProducto initConsultaProducto = new ConsultaProducto();
        Producto initProducto = new Producto();

        CtrlMails initMail = new CtrlMails(frm);

        CtrlProducto initCtrlProducto = new CtrlProducto(initProducto, initConsultaProducto, frm, initMail);

        initCtrlProducto.productoUtils.actualizar();
        initCtrlProducto.productoUtils.actualizarComboBox();
    }

}
