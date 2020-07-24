package Webservice.Services.ExamenService;

import Webservice.DataBase.Database;

public class ExamenControl
{
    public static String getLink(int idExamen)
    {
        Database db = new Database();
        db.conectar();
        db.sentenciaQuery("SELECT Examen.link FROM bfkbonwrvl7atwiehbto.Examen where Examen.idExamen = "+idExamen+";");
        String[][] stringExamen = db.obtenerDatosTabla();
        db.cerrarConexion();
        return stringExamen[0][0];
    }
}
