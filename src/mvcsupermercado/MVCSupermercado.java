package mvcsupermercado;

import Controlador.CtrlMails;
import Controlador.CtrlProducto;
import Controlador.CtrlUsuarios;
import Modelo.ConsultaProducto;
import Modelo.ConsultaUsuarios;
import Modelo.Producto;
import Modelo.Usuarios;
import Vista.Registro;
import Vista.FrmSupermercado;

public class MVCSupermercado {

    public static void main(String[] args) {
        
        //Registro frmRegistro = new Registro();
        //inicializarUsuario(frmRegistro);
        
        //frmRegistro.pack();
        //frmRegistro.setLocationByPlatform(true);
        //frmRegistro.setVisible(true);
        
        FrmSupermercado frm = new FrmSupermercado();
        inicializarProducto(frm);

        frm.pack();
        frm.setLocationByPlatform(true);
        frm.setVisible(true);
    }

    private static void inicializarProducto(FrmSupermercado frm) {

        ConsultaProducto initConsultaProducto = new ConsultaProducto();
        Producto initProducto = new Producto();

        CtrlMails initMail = new CtrlMails(frm);

        CtrlProducto initCtrlProducto = new CtrlProducto(initProducto, initConsultaProducto, frm, initMail);

        initCtrlProducto.productoUtils.actualizar();
        initCtrlProducto.productoUtils.actualizarComboBox();
    }
    
    private static void inicializarUsuario(Registro frmRegistro) {
        
        ConsultaUsuarios initConsultaUsuario = new ConsultaUsuarios();
        Usuarios initUsuario = new Usuarios();
        
        CtrlUsuarios initCtrlUsuario = new CtrlUsuarios(initUsuario, initConsultaUsuario, frmRegistro);
        
    }    

}
