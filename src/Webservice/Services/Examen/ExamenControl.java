package Webservice.Services.Examen;

import Webservice.DataBase.Database;

public class ExamenControl
{
    public static String getLink(String TituloExamen)
    {
        String respuesta;
        try
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery("SELECT Examen.link FROM bfkbonwrvl7atwiehbto.Examen where Examen.titulo = "+TituloExamen+";");
            String[][] stringExamen = db.obtenerDatosTabla();
            db.cerrarConexion();
            respuesta = stringExamen[0][0];
        }
        catch (Exception ex)
        {
            respuesta = "ID_NO_Valido";
        }

        return respuesta;
    }

    public static void setExamenFinish(int idUser, int idExamen)
    {
        String insert =
                "update bfkbonwrvl7atwiehbto.Asignacion set estado = 1 " +
                        "where idUser = "+idUser+" and idExamen = "+idExamen+";";
        Database db = new Database();
        db.conectar();
        db.executeInsert(insert);
        db.cerrarConexion();
    }
}
