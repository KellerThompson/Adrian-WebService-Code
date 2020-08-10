package Webservice.Services.Examen;

import Webservice.DataBase.Database;

public class ExamenControl
{
    public static String getLink(String tituloExamen)
    {
        String respuesta;
        try
        {
            Database db = new Database();
            db.conectar();
            db.sentenciaQuery(
                    "SELECT Examen.link " +
                    "FROM bfkbonwrvl7atwiehbto.Examen " +
                    "where Examen.titulo = '"+tituloExamen+"';");
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

    public static void setExamenFinish(int idUser, String tituloExamen)
    {
        Database db = new Database();
        db.conectar();
        int idExamen = db.getIntegerAt("idExamen", "Examen", "titulo", tituloExamen);
        String insert =
                "update bfkbonwrvl7atwiehbto.Asignacion set estado = 1 " +
                        "where idUser = "+idUser+" and idExamen = "+idExamen+";";
        db.executeInsert(insert);
        db.cerrarConexion();
    }
}
