package Webservice.Services.Compra;

import Webservice.DataBase.Database;

public class CompraControl {
    public static int isValid(int idUser, int idExamen)
    {
        String query = "SELECT idcompra FROM bfkbonwrvl7atwiehbto.compra where compra.idUser = "+idUser+" and compra.idExamen = "+idExamen+";";
        Database db = new Database();
        db.conectar();
        if(db.existeEnColumna(query))
        {
            db.cerrarConexion();
            return 1;
        }
        else
        {
            db.cerrarConexion();
            return -1;
        }
    }
}
